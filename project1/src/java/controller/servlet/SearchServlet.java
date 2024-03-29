/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DiaPhuongDAO;
import model.dao.DiaPhuong_TieuChiDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.TieuChiDAO;
import model.dao.VanBanDAO;
import model.dao.service.DPTCDAOService;
import model.dao.service.DiaPhuongDAOService;
import model.dao.service.NguoiPhuTrachDAOService;
import model.dao.service.TieuChiDAOService;
import model.dao.service.VanBanDAOService;
import model.entities.DiaPhuong;
import model.entities.DiaPhuong_TieuChi;
import model.entities.NguoiPhuTrach;
import model.entities.TieuChi;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public class SearchServlet extends HttpServlet {

    private final DiaPhuongDAOService DP_SERVICE = DiaPhuongDAO.getInstance();
    private final NguoiPhuTrachDAOService NPT_SERVICE = NguoiPhuTrachDAO.getInstance();
    private final VanBanDAOService VB_SERVICE = VanBanDAO.getInstance();
    private final TieuChiDAOService TC_SERVICE = TieuChiDAO.getInstance();
    private final DPTCDAOService DPTC_SERVICE = DiaPhuong_TieuChiDAO.getInstance();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maVB = Integer.parseInt(request.getParameter("maVB"));
        if (maVB > 0) {
            showVB(request, response);
        }
    }

    private void searchDP_CB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenDP = request.getParameter("diaphuong");
        DiaPhuong dp = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
        List<NguoiPhuTrach> nptList = dp.getNptList();
        request.setAttribute("dp", dp);
        List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
        List<DiaPhuong_TieuChi> dptcList = DPTC_SERVICE.getDPTCByDP(dp.getMaDP());
        request.setAttribute("nptList", nptList);
        request.setAttribute("dptcList", dptcList);
        request.setAttribute(util.Constants.DP_LIST, dpList);
        request.setAttribute(util.Constants.PAGE, "search-cb-dp");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }

    private void searchDP_NC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenDP = request.getParameter("diaPhuong");
        String hotenNPT = request.getParameter("nguoiPhuTrach");
        String tenTC = request.getParameter("tieuChi");
        DiaPhuong dp = null;
        TieuChi tc;
        NguoiPhuTrach npt;
        DiaPhuong_TieuChi dptc = null;
        List<NguoiPhuTrach> nptList = null;
        List<DiaPhuong_TieuChi> tcList = null;
        if (!hotenNPT.equals("")) {
            if (!tenDP.equals("")) {
                dp = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
            } else {
                nptList = NPT_SERVICE.getNPTListByName(hotenNPT);
            }
        } else {
            npt = null;
        }
        if (!tenDP.equals("") && hotenNPT.equals("")) {
            dp = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
            if (tenTC.equals("")) {
                tcList = DPTC_SERVICE.getDPTCByDP(dp.getMaDP());
            } else {
                tc = TC_SERVICE.getTCByName(tenTC);
                if (tc.getMaTC() > 0) {
                    dptc = DPTC_SERVICE.getDPTCByDPTC(dp.getMaDP(), tc.getMaTC());
                }
            }
        }
        List<DiaPhuong_TieuChi> dptcAllList = null;
        if(tenDP.equals("") && hotenNPT.equals("") && !tenTC.equals("")){
            TieuChi tc1 = TC_SERVICE.getTCByName(tenTC);
            dptcAllList = DPTC_SERVICE.getDPTCByTC(tc1.getMaTC());
        }
        request.setAttribute("dptc", dptc);
        request.setAttribute("dp", dp);
        request.setAttribute("nptList", nptList);
        request.setAttribute("tcList", tcList);
        request.setAttribute("dptcAllList", dptcAllList);
        request.setAttribute(util.Constants.PAGE, "search-nc-dp");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }

    private void searchVB_CB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenVB = request.getParameter("tenVB");
        List<VanBan> vbList = VB_SERVICE.getVanBanByTenVB(tenVB);
        request.setAttribute("vbList", vbList);
        request.setAttribute(util.Constants.PAGE, "search-cb-vb");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }

    private void searchVB_NC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenVB = request.getParameter("tenVB");
        String loaiVB = request.getParameter("loaiVB");
        String noiBanHanh = request.getParameter("noiBanHanh");
        String ngayBanHanh = request.getParameter("ngayBanHanh");
        String noiNhan = request.getParameter("noiNhan");
        List<VanBan> vbList = VB_SERVICE.findVanBanAdvance(tenVB, loaiVB, noiBanHanh, null, noiNhan);
        request.setAttribute("vbListNC", vbList);
        request.setAttribute(util.Constants.PAGE, "search-nc-vb");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }

    private void showVB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int maVB = Integer.parseInt(request.getParameter("maVB"));
        String type = request.getParameter("type");
        VanBan vb = VB_SERVICE.getVanBanByID(maVB);
        request.setAttribute("currentVB", vb);
        request.removeAttribute("vbList");
        if (type.equals("vbnc")) {
            request.setAttribute(util.Constants.PAGE, "search-nc-vb");
        } else {
            request.setAttribute(util.Constants.PAGE, "search-cb-vb");
        }
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("do");
        switch (action) {
            case "tk-dp-cb":
                searchDP_CB(request, response);
                break;
            case "tk-dp-nc":
                searchDP_NC(request, response);
                break;
            case "tk-vb-cb":
                searchVB_CB(request, response);
                break;
            case "tk-vb-nc":
                searchVB_NC(request, response);
                break;

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
