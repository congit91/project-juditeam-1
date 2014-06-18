/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.TaiKhoanDAO;
import model.dao.service.TaiKhoanDAOService;
import model.entities.TaiKhoan;
import util.DataFile;

/**
 *
 * @author Admin
 */
public class Authentication extends HttpServlet {

    TaiKhoanDAOService TK_SERVICE = TaiKhoanDAO.getInstance();

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        String realPath = getServletContext().getRealPath("/");
        String absolutePath = realPath.replace("build\\web", "");
        ServletContext context = getServletContext();
        boolean isLoaded = false;
        if (context.getAttribute("loaded") != null) {
            isLoaded = (boolean) context.getAttribute("loaded");
        }
        if (!isLoaded) {
            DataFile.loadFile(absolutePath);
            context.setAttribute("loaded", true);
            System.out.println(DataFile.db_name);
        }
    }

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
        String action = request.getParameter("do");
        switch (action) {
            case "logout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect(util.Constants.URL_ADMIN);
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
        String tenTK = request.getParameter("tenTK");
        String matkhau = request.getParameter("matkhau");
        if (TK_SERVICE.checkDangNhap(tenTK, matkhau)) {
            TaiKhoan tk = TK_SERVICE.getTaiKhoanByTenTK(tenTK);
            HttpSession session = request.getSession();
            session.setAttribute(util.Constants.CURRENT_USER, tk);
            session.setMaxInactiveInterval(30 * 60);
            request.setAttribute(util.Constants.PAGE, "manage");
            request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
        } else {
            request.setAttribute(util.Constants.PAGE, "login");
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
