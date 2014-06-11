/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DiaPhuongDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.TieuChiDAO;
import model.dao.service.DiaPhuongDAOService;
import model.dao.service.NguoiPhuTrachDAOService;
import model.dao.service.TieuChiDAOService;
import model.entities.DiaPhuong;
import model.entities.TieuChi;

/**
 *
 * @author Admin
 */
public class DPManagement extends HttpServlet {

    private final DiaPhuongDAOService DP_SERVICE = DiaPhuongDAO.getInstance();
    private final NguoiPhuTrachDAOService NPT_SERVICE = NguoiPhuTrachDAO.getInstance();
    private final TieuChiDAOService TC_SERVICE = TieuChiDAO.getInstance();

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
        addInfo(request, response);
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
        String tenTC = request.getParameter("tenTC");
        String noiDung = request.getParameter("noiDung");

        DiaPhuong dp = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
        if (maNPT > 0) {
            NPT_SERVICE.updateNPT_DP(maNPT, dp.getMaDP());
        }
        if (!tenTC.isEmpty() && !noiDung.isEmpty()) {
            
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
    }

}
