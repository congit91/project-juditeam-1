/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DiaPhuongDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.TaiKhoanDAO;
import model.dao.TieuChiDAO;
import model.dao.service.DiaPhuongDAOService;
import model.dao.service.NguoiPhuTrachDAOService;
import model.dao.service.TaiKhoanDAOService;
import model.dao.service.TieuChiDAOService;
import model.entities.DiaPhuong;
import model.entities.NguoiPhuTrach;
import model.entities.TaiKhoan;
import model.entities.TieuChi;

/**
 *
 * @author Welcomes
 */
public class Page extends HttpServlet {

    private final TaiKhoanDAOService TK_SERVICE = TaiKhoanDAO.getInstance();
    private final DiaPhuongDAOService DP_SERVICE = DiaPhuongDAO.getInstance();
    private final TieuChiDAOService TC_SERVICE = TieuChiDAO.getInstance();
    private final NguoiPhuTrachDAOService NPT_SERVICE = NguoiPhuTrachDAO.getInstance();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("p");
        switch (page) {
            case "contact":
                request.setAttribute(util.Constants.PAGE, "contact");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
                break;
            case "search-cb-vb":
                request.setAttribute(util.Constants.PAGE, "search-cb-vb");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
                break;
            case "search-nc-vb":
                request.setAttribute(util.Constants.PAGE, "search-nc-vb");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
                break;
            case "search-cb-dp":
                List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
                request.setAttribute(util.Constants.DP_LIST, dpList);
                request.setAttribute(util.Constants.PAGE, "search-cb-dp");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
                break;
            case "search-nc-dp":
                List<DiaPhuong> dpListNC = DP_SERVICE.getDiaPhuongAll();
                List<TieuChi> tcListNC = TC_SERVICE.getTCList();
                List<NguoiPhuTrach> nptListNC = NPT_SERVICE.getNPTList();
                request.setAttribute(util.Constants.DP_LIST, dpListNC);
                request.setAttribute(util.Constants.TC_LIST, tcListNC);
                request.setAttribute(util.Constants.NPT_LIST, nptListNC);
                request.setAttribute(util.Constants.PAGE, "search-nc-dp");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
                break;
            case "about":
                request.setAttribute(util.Constants.PAGE, "about");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
                break;
            case "manage-user":
                List<TaiKhoan> tkList = TK_SERVICE.getTaiKhoanAll();
                request.setAttribute(util.Constants.TK_LIST, tkList);
                request.setAttribute(util.Constants.PAGE, "manage-user");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                break;
            case "manage-diaphuong":
                List<DiaPhuong> dpListManage = DP_SERVICE.getDiaPhuongAll();
                request.setAttribute(util.Constants.DP_LIST, dpListManage);
                request.setAttribute(util.Constants.PAGE, "manage-diaphuong");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                break;
            case "nav-admin":
                request.setAttribute(util.Constants.PAGE, "nav-admin");
                request.removeAttribute(util.Constants.MSG_RESULT);
                request.getRequestDispatcher(util.Constants.URL_ADMIN).forward(request, response);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
