
package pe.edu.unmsm.sistemas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.unmsm.sistemas.util.Carrito;
import pe.edu.unmsm.sistemas.model.Item;
import pe.edu.unmsm.sistemas.service.ICarritoService;
import pe.edu.unmsm.sistemas.service.impl.CarritoService;

/**
 * @author Claudio Andree Ampuero Ramos
 * @author Vieri Enrique Garcia Moreno
 * @author Cristhian Richard Alvarez Caicedo
 * @author Cristhian Waldir De La Cruz Sanchez
 */
public class agregar extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Carrito carrito =(Carrito)s.getAttribute("carrito");
        if(carrito == null){
            System.out.println("Construye carrito");
            s.setAttribute("carrito", new Carrito());
            carrito =(Carrito)s.getAttribute("carrito");
        }   
        // crear el item
        Item item = new Item();
        item.setiCantidad(1);
        item.setiProduct_id(Integer.valueOf(request.getParameter("id")));
        item.setiPrecio(Float.valueOf(request.getParameter("precio")));
        //añadir el item al carrito 
        ICarritoService carritoService=  new CarritoService();
        carritoService.agregarItems(carrito, item);
        //ahora hacemos perdurar el carrito en la sesion
        s.setAttribute("carrito", carrito);
        System.out.println(carrito.toString());
        response.sendRedirect(request.getContextPath()+"/index.jsp#productos");
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
