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
import model.dao.TaiKhoanDAO;
import model.dao.service.TaiKhoanDAOService;
import model.entities.TaiKhoan;

/**
 *
 * @author Admin
 */
public class UserManagement extends HttpServlet {

    TaiKhoanDAOService TK_SERVICE = TaiKhoanDAO.getInstance();

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
        String action = request.getParameter("do");
        switch (action) {
            case "edit":
                doEdit(request, response);
                break;
            case "add":
                doAddnew(request, response);
                break;
            case "del":
                doDel(request, response);
                break;
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
                editUser(request, response);
                break;
            case "Thêm mới":
                addUser(request, response);
                break;
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maTK = Integer.parseInt(request.getParameter("id"));
        TaiKhoan tk = TK_SERVICE.getTaiKhoanByID(maTK);
        request.setAttribute(util.Constants.TK, tk);
        request.setAttribute(util.Constants.PAGE, "adduser");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maTK = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String sdt = request.getParameter("SDT");
        boolean trangThaiHD = true;
        TaiKhoan tk = new TaiKhoan(maTK, "", "", hoTen, email, sdt, trangThaiHD);
        if (TK_SERVICE.updateTaiKhoan(tk)) {
            List<TaiKhoan> tkList = TK_SERVICE.getTaiKhoanAll();
            request.setAttribute(util.Constants.TK_LIST, tkList);
            request.setAttribute(util.Constants.PAGE, "manage");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
        } else {
            request.setAttribute(util.Constants.PAGE, "adduser");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
        }
    }

    private void doAddnew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(util.Constants.PAGE, "adduser");
        request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tenTK = request.getParameter("tenTK");
        String hoTen = request.getParameter("hoTen");
        String matkhau = request.getParameter("matkhau");
        String email = request.getParameter("email");
        String sdt = request.getParameter("SDT");
        boolean trangThaiHD = true;
        TaiKhoan tk = new TaiKhoan(1, tenTK, matkhau, hoTen, email, sdt, trangThaiHD);
        if (TK_SERVICE.createTaiKhoan(tk)) {
            List<TaiKhoan> tkList = TK_SERVICE.getTaiKhoanAll();
            request.setAttribute(util.Constants.TK_LIST, tkList);
            request.setAttribute(util.Constants.PAGE, "manage");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
        } else {
            request.setAttribute(util.Constants.PAGE, "adduser");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
        }
    }
    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maTK = Integer.parseInt(request.getParameter("id"));
        if (TK_SERVICE.deleteTaiKhoan(maTK)) {
            List<TaiKhoan> tkList = TK_SERVICE.getTaiKhoanAll();
            request.setAttribute(util.Constants.TK_LIST, tkList);
            request.setAttribute(util.Constants.PAGE, "manage");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
        } else {
            request.setAttribute(util.Constants.PAGE, "manage");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
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
