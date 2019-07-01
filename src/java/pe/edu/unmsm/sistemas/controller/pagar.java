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
@WebServlet(name = "pagar", urlPatterns = {"/pagar.do"})
public class pagar extends HttpServlet {

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
        String nombres = (String) request.getParameter("nombresMedio");
        String apellidos = (String) request.getParameter("apellidosMedio");
        String direccion = (String) request.getParameter("emailMedio");
        String habilitar = (String) request.getParameter("modal");
        String medioPago = (String) request.getParameter("medioPago");
        String pago = (String) request.getParameter("pago");
        String select = (String) request.getParameter("select");
        //do Something
        if (habilitar != null) {
            s.setAttribute("nonTested", "habilitado");
            s.setAttribute("medioPago", null);
        }
        if (medioPago != null) {
            s.setAttribute("medioPago", medioPago);
        }
        if (pago != null) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Pago correcto, pulse aceptar para continuar.');");
            out.println("location.href = \"index.jsp\";");
            out.println("</script>");
            s.setAttribute("nonTested", null);
            s.setAttribute("medioPago", null);
            s.setAttribute("habilitarPagar", null);
        }
        if (select != null) {
            s.setAttribute("select", null);
            s.setAttribute("medioPago", null);
        }
        if (medioPago != null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp#carrito");
        } else {
            if (pago == null) {
                response.sendRedirect(request.getContextPath() + "/index.jsp#carrito");
            }
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
