/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Darkness
 */
@WebServlet(name = "validarDatos", urlPatterns = {"/validarDatos.do"})
public class validarDatos extends HttpServlet {

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
        HttpSession s = request.getSession(false);
        String nombres = (String) request.getParameter("nombres");
        String apellidos = (String) request.getParameter("apellidos");
        String direccion = (String) request.getParameter("direccion");
        System.out.println("NAD : "+nombres+apellidos+direccion);
        String cancelar = (String) request.getParameter("cancelar");
        if(cancelar==null)
            cancelar="no";
        System.out.println("C : "+cancelar);
        if (!cancelar.equalsIgnoreCase("si")) {
            if (nombres != null) {
                s.setAttribute("habilitarPagar", "Habilitado");
                System.out.println("Paso por el habilitado");
                      
            } 
        } else {
            s.setAttribute("habilitarPagar", null);
            System.out.println("Paso por el no habbilitado");
        }
        System.out.println((String)s.getAttribute("habilitarPagar"));
        response.sendRedirect(request.getContextPath()+"/index.jsp#carrito"); 
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