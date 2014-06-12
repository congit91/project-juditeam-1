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
        String p = request.getParameter("p");
        switch (p) {
            case "manage-document":
                List<VanBan> vbList = VB_SERVICE.getVanBanAll();
                request.setAttribute("vbList", vbList);
                request.setAttribute(util.Constants.PAGE, "manage-document");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
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
