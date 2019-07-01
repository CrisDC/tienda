/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.unmsm.sistemas.util.Carrito;
import pe.edu.unmsm.sistemas.model.Item;
import pe.edu.unmsm.sistemas.model.Usuario;

/**
 *
 * @author LaboratorioFISI
 */
public class logear extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Usuario usuario =(Usuario)s.getAttribute("usuario");
        if(usuario == null){
            System.out.println("Construye usuario");
            s.setAttribute("usuario", new Usuario());
            usuario =(Usuario)s.getAttribute("usuario");
        }   
        usuario.setUsername(request.getParameter("user"));
        usuario.setPassword(request.getParameter("pass"));
        if(usuario.getUsername().compareTo("vieri.garcia")==0&&usuario.getPassword().compareTo("12345")==0){
            usuario.setSesionActiva(true);
        }
        //ahora hacemos perdurar el carrito en la sesion
        s.setAttribute("usuario", usuario);
        System.out.println(usuario);
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