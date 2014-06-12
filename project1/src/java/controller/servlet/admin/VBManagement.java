/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.VanBanDAO;
import model.dao.service.VanBanDAOService;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public class VBManagement extends HttpServlet {

    private final VanBanDAOService VB_SERVICE = VanBanDAO.getInstance();

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
                case "manage-document":
                    List<VanBan> vbList = VB_SERVICE.getVanBanAll();
                    request.setAttribute("vbList", vbList);
                    request.setAttribute(util.Constants.PAGE, "manage-document");
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                    break;
                case "add":
                    request.setAttribute(util.Constants.PAGE, "adddoc");
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                    break;
                case "edit":
                    int maVB = Integer.parseInt(request.getParameter("id"));
                    VanBan vb = VB_SERVICE.getVanBanByID(maVB);
                    request.setAttribute(util.Constants.PAGE, "adddoc");
                    request.setAttribute("vb", vb);
                    request.removeAttribute(util.Constants.MSG_RESULT);
                    request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
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
                updateVB(request, response);
                break;
            case "Thêm mới":
                addNew(request, response);
                break;
//            case "Tìm kiếm":
//                search(request, response);
//                break;
        }
    }

    private void addNew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenVB = request.getParameter("tenVB");
        String loaiVB = request.getParameter("loaiVB");
        String noiBanHanh = request.getParameter("noiBanHanh");
        String ngay = request.getParameter("ngayBanHanh");
        String noiNhan = request.getParameter("noiNhan");
        String noiDung = request.getParameter("noiDung");
        String[] date = ngay.split("/");
        java.sql.Date ngayBanHanh = util.Support.convertToDate(date[0], date[1], date[2]);
        VanBan vb = new VanBan(1, tenVB, loaiVB, noiBanHanh, ngayBanHanh, noiNhan, noiDung, 1);
        if (VB_SERVICE.createVanBan(vb)) {
            request.setAttribute("msgResult", "Bạn vừa tạo mới một văn bản thành công!");
        } else {
            request.setAttribute("msgResult", "Tạo mới văn bản thất bại!");
        }
        List<VanBan> vbList = VB_SERVICE.getVanBanAll();
        request.setAttribute("vbList", vbList);
        request.setAttribute(util.Constants.PAGE, "manage-document");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void updateVB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int maVB = Integer.parseInt(request.getParameter("id"));
        String tenVB = request.getParameter("tenVB");
        String loaiVB = request.getParameter("loaiVB");
        String noiBanHanh = request.getParameter("noiBanHanh");
        String ngay = request.getParameter("ngayBanHanh");
        String noiNhan = request.getParameter("noiNhan");
        String noiDung = request.getParameter("noiDung");
        String[] date = ngay.split("-");
        java.sql.Date ngayBanHanh = util.Support.convertToDate(date[0], date[1], date[2]);
        VanBan vb = new VanBan(maVB, tenVB, loaiVB, noiBanHanh, ngayBanHanh, noiNhan, noiDung, 1);
        if (VB_SERVICE.updateVanBan(vb)) {
            request.setAttribute("msgResult", "Bạn vừa sửa văn bản thành công!");
        } else {
            request.setAttribute("msgResult", "Sửa văn bản thất bại!");
        }
        List<VanBan> vbList = VB_SERVICE.getVanBanAll();
        request.setAttribute("vbList", vbList);
        request.setAttribute(util.Constants.PAGE, "manage-document");
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
