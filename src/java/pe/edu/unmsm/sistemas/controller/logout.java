
package pe.edu.unmsm.sistemas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.unmsm.sistemas.model.Usuario;

/**
 *
 * @author Claudio Andree Ampuero Ramos
 * @author Vieri Enrique Garcia Moreno
 * @author Cristhian Richard Alvarez Caicedo
 * @author Cristhian Waldir De La Cruz Sanchez
 */
public class logout extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Usuario usuario =(Usuario)s.getAttribute("usuario");
        if(usuario != null){
            usuario =null;
        }   
        //ahora hacemos perdurar el carrito en la sesion
        s.setAttribute("usuario", usuario);
            s.setAttribute("nonTested",null);
            s.setAttribute("medioPago",null);
            s.setAttribute("habilitarPagar",null);
            s.setAttribute("carrito",null);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
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

