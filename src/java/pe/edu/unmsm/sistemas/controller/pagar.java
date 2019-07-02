
package pe.edu.unmsm.sistemas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.unmsm.sistemas.model.CredencialesPaypal;
import pe.edu.unmsm.sistemas.model.Tarjeta;
import pe.edu.unmsm.sistemas.model.TarjetaCredito;
import pe.edu.unmsm.sistemas.model.Usuario;
import pe.edu.unmsm.sistemas.service.IPagoService;
import pe.edu.unmsm.sistemas.service.impl.PagoPaypalService;
import pe.edu.unmsm.sistemas.service.impl.PagoTarjetaService;

/**
 *
 * @author Claudio Andree Ampuero Ramos
 * @author Vieri Enrique Garcia Moreno
 * @author Cristhian Richard Alvarez Caicedo
 * @author Cristhian Waldir De La Cruz Sanchez
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
        System.out.println("ESTOY EN LA CLASE PAGAR");
        System.out.println("Esto me llego en pago: " + pago);
        //do Something
        if (habilitar != null) {
            s.setAttribute("nonTested", "habilitado");
            s.setAttribute("medioPago", null);
        }
        if (medioPago != null) {
            s.setAttribute("medioPago", medioPago);
        }
        if (pago != null) {
            IPagoService pagoService;
            System.out.println("El pago fue distinto de null");
            //verificar el medio de pago. Usaer variable "medioPago" -> tarjeta y paypal
            if(medioPago.compareToIgnoreCase("tarjeta")==0){
                System.out.println("Entro a pago por tarjeta");
                String membresia = (String) request.getParameter("membresia");
                String numeroTarjeta = (String) request.getParameter("numeroTarjeta");
                String mesVencimiento = (String) request.getParameter("mesVencimiento");
                String anioVencimiento = (String) request.getParameter("anioVencimiento");
                String CVV = (String) request.getParameter("cvv");
                String tipoTarjeta = (String) request.getParameter("tipoTarjeta");
                Tarjeta tarjeta = null;
                if(tipoTarjeta.equals("credito"))
                    tarjeta = new TarjetaCredito();
                else if(tipoTarjeta.equals("debito"))
                    tarjeta = new Tarjeta();
                tarjeta.setNumeroTarjeta(numeroTarjeta);
                tarjeta.setMembresia(membresia);
                tarjeta.setFechaExpiracion(mesVencimiento+"/"+anioVencimiento);
                tarjeta.setCvv(CVV != null ? Integer.parseInt(CVV) : 0);
                pagoService = new PagoTarjetaService(tarjeta);
                pagoService.pagar((Double)s.getAttribute("monto"));
                
                
            } else if(medioPago.compareToIgnoreCase("paypal")==0){
                System.out.println("Entro a pago por paypal");
                String correo = (String) request.getParameter("correo");
                String contrasenia = (String) request.getParameter("contrasenia");
                Usuario usuario = (Usuario)s.getAttribute("usuario");
                CredencialesPaypal credencialesPaypal = new CredencialesPaypal();
                credencialesPaypal.setEmail(correo);
                credencialesPaypal.setNombreUsuario(usuario.getUsername());
                credencialesPaypal.setPass(contrasenia);
                pagoService = new PagoPaypalService(credencialesPaypal);
                pagoService.pagar((Double)s.getAttribute("monto"));
            }
            //
            
            
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Pago correcto, pulse aceptar para continuar.');");
            out.println("location.href = \"index.jsp\";");
            out.println("</script>");
            s.setAttribute("nonTested", null);
            s.setAttribute("medioPago", null);
            s.setAttribute("habilitarPagar", null);
            s.setAttribute("carrito",null);
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
