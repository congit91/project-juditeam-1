/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DiaPhuongDAO;
import model.dao.DiaPhuong_TieuChiDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.TieuChiDAO;
import model.dao.service.DPTCDAOService;
import model.dao.service.DiaPhuongDAOService;
import model.dao.service.NguoiPhuTrachDAOService;
import model.dao.service.TieuChiDAOService;
import model.entities.DiaPhuong;
import model.entities.DiaPhuong_TieuChi;
import model.entities.NguoiPhuTrach;
import model.entities.TieuChi;
import model.entities.VanBan;
import util.DataFile;

/**
 *
 * @author Admin
 */
public class DPManagement extends HttpServlet {

    private final DiaPhuongDAOService DP_SERVICE = DiaPhuongDAO.getInstance();
    private final NguoiPhuTrachDAOService NPT_SERVICE = NguoiPhuTrachDAO.getInstance();
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
        String p = request.getParameter("p");

        if (p != null) {
            switch (p) {
                case "manage-diaphuong":
                    List<DiaPhuong> dpListEditTT = DP_SERVICE.getDiaPhuongAll();
                    request.setAttribute(util.Constants.DP_LIST, dpListEditTT);
                    List<TieuChi> tcListDP = TC_SERVICE.getTCList();
                    List<NguoiPhuTrach> nptListDP = NPT_SERVICE.getNPTList();
                    request.setAttribute(util.Constants.TC_LIST, tcListDP);
                    request.setAttribute(util.Constants.NPT_LIST, nptListDP);
                    request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                    break;
                case "edit":
                    int maDP = Integer.parseInt(request.getParameter("id"));
                    DiaPhuong dp = DP_SERVICE.getDiaPhuongByID(maDP);
                    request.setAttribute(util.Constants.PAGE, "adddp");
                    request.setAttribute("dp", dp);
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                    break;
                case "del":
                    doDel(request, response);
                    break;
            }
        }
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
        String submit = request.getParameter("submit");
        switch (submit) {
            case "Thêm thông tin":
                addInfo(request, response);
                break;
            case "Thêm mới":
                addNew(request, response);
                break;
            case "Sửa":
                editNew(request, response);
                break;
            case "Tìm kiếm":
                search(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tenDP = request.getParameter("tenDP");
        List<DiaPhuong> dpList = DP_SERVICE.fintDiaPhuongByTen(tenDP);
        request.setAttribute(util.Constants.DP_LIST, dpList);
        request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void addNew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tenDP = request.getParameter("tenDP");
        String SDT = request.getParameter("SDT");
        String noiNhan = request.getParameter("noiNhan");
        float dienTich = Float.parseFloat(request.getParameter("dienTich"));
        float soDan = Float.parseFloat(request.getParameter("soDan"));

        DiaPhuong dp = new DiaPhuong(1, tenDP, SDT, noiNhan, dienTich, soDan, 1);
        if (!DP_SERVICE.checkNewDP(tenDP)) {
            if (DP_SERVICE.createDiaPhuong(dp)) {
                request.setAttribute(util.Constants.MSG_RESULT, "Bạn đã thêm địa phương thành công!");
            } else {
                request.setAttribute(util.Constants.MSG_RESULT, "Có lỗi, thêm địa phương thất bại!");
            }
        } else {
            request.setAttribute(util.Constants.MSG_RESULT, "Địa phương này đã tồn tại!");
        }
        List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
        request.setAttribute(util.Constants.DP_LIST, dpList);
        request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void editNew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maDP = request.getParameter("id");
        int ma = Integer.valueOf(maDP);
        String tenDP = request.getParameter("tenDP");
        String SDT = request.getParameter("SDT");
        String noiNhan = request.getParameter("noiNhan");
        float dienTich = Float.parseFloat(request.getParameter("dienTich"));
        float soDan = Float.parseFloat(request.getParameter("soDan"));

        DiaPhuong dp = new DiaPhuong(ma, tenDP, SDT, noiNhan, dienTich, soDan, 1);

        if (DP_SERVICE.updateDiaPhuong(dp)) {
            request.setAttribute(util.Constants.MSG_RESULT, "Bạn đã Sửa địa phương thành công!");
        } else {
            request.setAttribute(util.Constants.MSG_RESULT, "Có lỗi, Sửa địa phương thất bại!");
        }

        List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
        request.setAttribute(util.Constants.DP_LIST, dpList);
        request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void addInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenDP = request.getParameter("diaPhuong");
        String infoNPT = request.getParameter("nguoiPhuTrach");
        int maNPT = 0;
        if (infoNPT != null) {
            String[] arr = infoNPT.split("-");
            maNPT = Integer.parseInt(arr[0]);
        }
        String tenTC = request.getParameter("tieuChi");
        String noiDung = request.getParameter("noiDung");
        TieuChi tc = TieuChiDAO.getInstance().getTCByName(tenTC);
        DiaPhuong dp = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
        if (maNPT > 0) {
            //NPT_SERVICE.updateNPT_DP(maNPT, dp.getMaDP());
        }
        if (!tenTC.isEmpty() && !noiDung.isEmpty()) {
            if (DPTC_SERVICE.checkCreate(dp.getMaDP(), tc.getMaTC())) {
                DiaPhuong_TieuChi dp_tc = DPTC_SERVICE.getDPTCByDPTC(dp.getMaDP(), tc.getMaTC());
                DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi(dp_tc.getMaDPTC(), dp, tc, noiDung);
                if (DPTC_SERVICE.update(dptc)) {
                    request.setAttribute("msgResult", "Tiêu chí này đã có và bạn đã sửa thành công!");
                } else {
                    request.setAttribute("msgResult", "Tiêu chí này đã có và bạn đã sửa thất bại!");
                }
            } else {
                DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi(1, dp, tc, noiDung);
                if (DPTC_SERVICE.create(dptc)) {
                    request.setAttribute("msgResult", "Thêm thông tin thành công!");
                } else {
                    request.setAttribute("msgResult", "Có lỗi xảy ra, thêm thông tin thất bại!");
                }
            }
        }
        List<DiaPhuong> dpListEditTT = DP_SERVICE.getDiaPhuongAll();
        request.setAttribute(util.Constants.DP_LIST, dpListEditTT);
        List<TieuChi> tcListDP = TC_SERVICE.getTCList();
        List<NguoiPhuTrach> nptListDP = NPT_SERVICE.getNPTList();
        request.setAttribute(util.Constants.TC_LIST, tcListDP);
        request.setAttribute(util.Constants.NPT_LIST, nptListDP);
        request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maDP = Integer.parseInt(request.getParameter("id"));
        if (DP_SERVICE.deleteDiaPhuong(maDP)) {
            request.setAttribute("msgResult", "Xóa địa phương thành công!");
        } else {
            request.setAttribute("msgResult", "Xóa địa phương thất bại!");
        }
        List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
        request.setAttribute(util.Constants.DP_LIST, dpList);
        request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
