/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DiaPhuongDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.service.DiaPhuongDAOService;
import model.dao.service.NguoiPhuTrachDAOService;
import model.entities.DiaPhuong;
import model.entities.NguoiPhuTrach;

/**
 *
 * @author Cong Pham Dinh
 */
public class NPTManagement extends HttpServlet {

    private final NguoiPhuTrachDAOService NPT_SERVICE = NguoiPhuTrachDAO.getInstance();
    private final DiaPhuongDAOService DP_SERVICE = DiaPhuongDAO.getInstance();

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String p = request.getParameter("p");
        if (p != null) {
            switch (p) {
                case "manage-npt":
                    List<NguoiPhuTrach> nptList = NPT_SERVICE.getNPTList();
                    request.setAttribute("nptList", nptList);
                    request.setAttribute(util.Constants.PAGE, "manage-npt");
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                    break;
                case "add":
                    List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
                    request.setAttribute("dpList", dpList);
                    request.setAttribute(util.Constants.PAGE, "add-npt");
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                    break;
                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    NguoiPhuTrach npt = NPT_SERVICE.getNPTByID(id);
                    List<DiaPhuong> dpListEdit = DP_SERVICE.getDiaPhuongAll();
                    request.setAttribute("dpList", dpListEdit);
                    request.setAttribute("npt", npt);
                    request.setAttribute(util.Constants.PAGE, "add-npt");
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
            case "Sửa":
                updateNPT(request, response);
                break;
            case "Thêm mới":
                addNew(request, response);
                break;
        }
    }

    private void addNew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String hoTen = request.getParameter("hoTen");
        String namSinh = request.getParameter("namSinh");
        String queQuan = request.getParameter("queQuan");
        String hocVi = request.getParameter("hocVi");
        String chucVu = request.getParameter("chucVu");
        String SDT = request.getParameter("SDT");
        String email = request.getParameter("email");
        String tenDP = request.getParameter("diaPhuong");
        String[] date = namSinh.split("-");
        java.sql.Date ngaySinh = util.Support.convertToDate(date[0], date[1], date[2]);
        DiaPhuong diaPhuong = DP_SERVICE.getDiaPhuongByTenDP(tenDP);

        NguoiPhuTrach npt = new NguoiPhuTrach(1, hoTen, ngaySinh, queQuan, hocVi, chucVu, SDT, email, diaPhuong, 1);
        if (NPT_SERVICE.createNPT(npt)) {
            request.setAttribute("msgResult", "Bạn vừa tạo mới một người phụ trách thành công!");
        } else {
            request.setAttribute("msgResult", "Tạo mới người phụ trách thất bại!");
        }
        List<NguoiPhuTrach> nptList = NPT_SERVICE.getNPTList();
        request.setAttribute("nptList", nptList);
        request.setAttribute(util.Constants.PAGE, "manage-npt");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void updateNPT(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int maNPT = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String namSinh = request.getParameter("namSinh");
        String queQuan = request.getParameter("queQuan");
        String hocVi = request.getParameter("hocVi");
        String chucVu = request.getParameter("chucVu");
        String SDT = request.getParameter("SDT");
        String email = request.getParameter("email");
        String tenDP = request.getParameter("diaPhuong");
        String[] date = namSinh.split("-");
        java.sql.Date ngaySinh = util.Support.convertToDate(date[0], date[1], date[2]);
        DiaPhuong diaPhuong = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
        NguoiPhuTrach npt = new NguoiPhuTrach(maNPT, hoTen, ngaySinh, queQuan, hocVi, chucVu, SDT, email, diaPhuong, 1);
        if (NPT_SERVICE.updateNPT(npt)) {
            request.setAttribute("msgResult", "Bạn vừa sửa người phụ trách thành công!");
        } else {
            request.setAttribute("msgResult", "Sửa người phụ trách thất bại!");
        }
        List<NguoiPhuTrach> nptList = NPT_SERVICE.getNPTList();
        request.setAttribute("nptList", nptList);
        request.setAttribute(util.Constants.PAGE, "manage-npt");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maNPT = Integer.parseInt(request.getParameter("id"));
        if (NPT_SERVICE.deteleNPT(maNPT)) {
            request.setAttribute("msgResult", "Bạn đã xóa người phụ trách thành công");
        } else {
            request.setAttribute("msgResult", "Bạn đã xóa người phụ trách thất bại thất bại");
        }
        List<NguoiPhuTrach> nptList = NPT_SERVICE.getNPTList();
        request.setAttribute("nptList", nptList);
        request.setAttribute(util.Constants.PAGE, "manage-npt");
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
    }// </editor-fold>

}
