<%@page import="pe.edu.unmsm.sistemas.dao.impl.ItemDAO"%>
<%@page import="pe.edu.unmsm.sistemas.dao.IItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.unmsm.sistemas.model.ParametrosSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="pe.edu.unmsm.sistemas.configuracion.Conexion"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="pe.edu.unmsm.sistemas.util.Carrito"%>
<%@page import="pe.edu.unmsm.sistemas.model.Item"%>
<%@page import="pe.edu.unmsm.sistemas.model.ParametrosSistema"%>
<%@page import="pe.edu.unmsm.sistemas.model.Usuario"%>
<%@page import="java.sql.ResultSet"%>


<%
    Conexion con = Conexion.getConexion(ParametrosSistema.DRIVER, ParametrosSistema.URL, ParametrosSistema.CONECTION_USER, ParametrosSistema.CONECTION_PASS);
    //Consulta para obtener los productos
//    String sql="SELECT * FROM APP.PRODUCT FETCH FIRST 10 ROWS ONLY";
//    ResultSet res= con.ejecutarQuery(sql);
    IItemDAO itemDAO = new ItemDAO();
    List<Item> items = itemDAO.buscarTodos();
    HttpSession s = request.getSession(false);
    Usuario usuario = (Usuario) s.getAttribute("usuario");
    
    System.out.println("usuario:" + usuario);
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">-->
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="Recursos/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <!-- Theme CSS -->
        <link href="Recursos/css/freelancer.min.css" rel="stylesheet">

    </head>
    <!--<a href="/tienda/verCarrito.do?">Ver carrito</a>-->
    <body id="page-top">
        <!-- Barra de Navegación  -->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">Tienda Virtual</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#productos">Productos</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#carrito">Carrito de Compras</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">Contactanos</a>
                        </li>
                        <%if (usuario == null) {%>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#login">Iniciar Sesion</a>
                        </li>
                        <%} else {%>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/tienda/logout.do" >Cerrar Sesion</a>
                        </li>
                        <%}%>
                    </ul>
                </div>         
            </div>
        </nav>
        <!-- Masthead -->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">

                <!-- Masthead Avatar Image -->
                <img class="masthead-avatar mb-5" src="Recursos/img/avataaars.svg" alt="">
                <!-- Masthead Heading -->
                <h1 class="masthead-heading text-uppercase mb-0">Fisi Store</h1>

                <!-- Icon Divider -->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon">
                        <i class="fas fa-star"></i>
                    </div>
                    <div class="divider-custom-line"></div>
                </div>
                <%if (usuario != null && usuario.getSesionActiva()) {%>
                <h3 class="masthead-heading text-uppercase mb-0">Bienvenido <%=usuario.getUsername()%></h3>
                <%}%>
                <!-- Masthead Subheading -->
                <p class="masthead-subheading font-weight-light mb-0">Graphic Artist - Web Designer - Illustrator</p>

            </div>
        </header>

        <!-- Productos Section -->
        <section class="page-section portfolio" id="productos">
            <div class="container">
                <br>
                <!-- Portfolio Section Heading -->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Productos</h2>

                <!-- Icon Divider -->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon">
                        <i class="fas fa-star"></i>
                    </div>
                    <div class="divider-custom-line"></div>
                </div>
                <!--Tabla de Productos-->
                <table class="table">
                    <tr>
                        <th >Codigo</th>
                        <th >Nombre</th>
                        <th >Precio</th>
                        <th >Cantidad</th>
                            <%if (usuario != null && usuario.getSesionActiva()) {%>
                        <th >Agregar</th>
                            <% } %>
                    </tr>
                    <% for (Item item : items) {%> 
                    <tr>
                        <td ><%=item.getProductCode()%></td>
                        <td><%=item.getDescripcion()%></td>
                        <td>S/.<%=item.getiPrecio()%></td>
                        <td><%=item.getiCantidad()%></td>
                        <%String id = "id=" + item.getiProduct_id();
                            String cantidad = "cantidad=" + String.valueOf(item.getiCantidad());
                            String precio = "precio=" + String.valueOf(item.getiPrecio());%>
                        <%if (usuario != null && usuario.getSesionActiva()) {%>
                        <td ><a href="/tienda/agregar.do?<%=id + "&" + cantidad + "&" + precio%>"><img src="Recursos/img/buttons/addShopcar.svg" alt="" width="10%" height="10%"/></a></td>
                                <% } %>
                    </tr>
                    <% } %>
                </table>
            </div>
        </section>


        <!-- Carrito Section -->
        <section class="page-section portfolio" id="carrito">
        <% Carrito carrito = (Carrito) s.getAttribute("carrito");
        if (carrito != null && carrito.getCarrito().size() > 0) {%>
            <div class="container">
                <br>
                <!-- Portfolio Section Heading -->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Carrito de Compras</h2>

                <!-- Icon Divider -->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon">
                        <i class="fas fa-star"></i>
                    </div>
                    <div class="divider-custom-line"></div>
                </div>
                <!--Items del carrito-->
                <table class="table">
                    <tr>
                        <th >Codigo</th>
                        <th >Precio</th>
                        <th >Cantidad</th>
                        <th> Monto Parcial</th>
                        <th> Quitar Item</th>
                    </tr>
                    <% double montoTotal = 0;
                        DecimalFormat df = new DecimalFormat("#.00");
                        for (Item i : carrito.getCarrito()) {%> 
                    <tr>
                        <td ><%=i.getiProduct_id()%></td>
                        <td>S/.<%=i.getiPrecio()%></td>
                        <td> <%=i.getiCantidad()%></td>
                        <td>S/.<%=i.getiPrecio() * i.getiCantidad()%></td>
                        <td ><a href="/tienda/eliminar.do?id=<%=i.getiProduct_id()%>">Quitar</a></td>
                    </tr>
                    <%  montoTotal = montoTotal + i.getiPrecio() * i.getiCantidad();
                        
                        }%>
                    <%s.setAttribute("monto",montoTotal);%>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><b>Monto Total</b></td>
                        <td>S/.<%=df.format(montoTotal)%></td>
                        <td></td>
                    </tr>
                    <%if (s.getAttribute("habilitarPagar") != null && s.getAttribute("nonTested") == null) {%>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><a href="/tienda/pagar.do?modal=si" class="btn btn-primary a-btn-slide-text">Pagar</a</td>
                        <td><a href="/tienda/validarDatos.do?cancelar=si" class="btn btn-danger a-btn-slide-text" >Cancelar</a></td>
                        <td></td>
                    </tr>
                    <%}%>
                </table>
            </div>
            <%if (s.getAttribute("habilitarPagar") == null) {%>
            <!-----------------------INTERFAZ DE ENVIO-------------------------------->
                <div class="container" style="width: 70%">
                    <!-- Extended material form grid -->
                    <form class="needs-validation" action="/tienda/validarDatos.do" novalidate>
                        <div class="form-row">
                            <div class="col-md-6 mb-3">
                                <label for="inputNombre">Nombre</label>
                                <input type="text" class="form-control" name ="nombres" id="inputNombre" placeholder="Nombre" required>
                                <div class="valid-feedback">
                                    Se ve bien!
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="inputApellido">Apellido</label>
                                <input type="text" class="form-control" name="apellidos" id="inputApellido" placeholder="Apellido" required>
                                <div class="valid-feedback">
                                    Se ve bien!
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-12 mb-3">
                                <label for="inputDireccion">Direccion</label>
                                <input type="text" class="form-control" name="direccion" id="inputDireccion" placeholder="Direccion" required>
                                <div class="valid-feedback">
                                    Se ve bien!
                                </div>
                                <div class="invalid-feedback">
                                    Por favor ingrese una Direccion
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-6 mb-3">
                                <label for="inputCiudad">Ciudad</label>
                                <input type="text" class="form-control" name="ciudad" id="inputCiudad" placeholder="Ciudad" required>
                                <div class="invalid-feedback">
                                    Por favor ingrese una ciudad de destino
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="inputDepartamento">Departamento</label>
                                <input type="text" class="form-control" name="departamento" id="inputDepartamento" placeholder="Departamento" required>
                                <div class="invalid-feedback">
                                    Por favor ingrese un Departamento
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="inputZip">Zip</label>
                                <input type="text" class="form-control" name="zip" id="inputZip" placeholder="Zip" required>
                                <div class="invalid-feedback">
                                    Por favor ingrese un zip valido
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-6 mb-3">
                                <label for="inputCorreo">Correo Electronico</label>
                                <input type="email" class="form-control" name="correoelectronico" id="inputCorreo" placeholder="Correo Electronio" required>
                                <div class="invalid-feedback">
                                    Por favor ingrese un correo electronico
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="inputCorreoConf">Confirme Correo Electronico</label>
                                <input type="email" class="form-control" name="correoelectronicoconf" id="inputCorreoConf" placeholder="Confirme Correo Electronio" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                                <label class="form-check-label" for="invalidCheck">
                                    Estoy de acuerdo con los terminos y condiciones
                                </label>
                                <div class="invalid-feedback">
                                    Debe de estar de acuerdo antes de continuar
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-primary" type="submit">Listo</button>
                    </form>

                    <script>
                        (function () {
                            'use strict';
                            window.addEventListener('load', function () {
                                var forms = document.getElementsByClassName('needs-validation');
                                var validation = Array.prototype.filter.call(forms, function (form) {
                                    form.addEventListener('submit', function (event) {
                                        if (form.checkValidity() === false) {
                                            event.preventDefault();
                                            event.stopPropagation();
                                        }
                                        form.classList.add('was-validated');
                                    }, false);
                                });
                            }, false);
                        })();
                    </script>
                </div>
            <!-----------------FIN DE LA SECCION DE ENVIO------------------->
            <%} else if (s.getAttribute("nonTested") != null) {%>
            <!-- View Pago Section -->
                <% if (s.getAttribute("medioPago") == null) {%>
                <!--------------------INTERFAZ PARA LA SELECCIÓN DE MEDIO DE PAGO---------------------->
                <div class="container">
                    <div class="d-flex justify-content-center">
                        <div class="user_card">
                            <center><div class="h3 mb-0 text-gray-800">Medio de Pagos.</div></center>

                            <div class="d-flex justify-content-center">
                                <input type="radio" name="medioPago" onclick="javascript:window.location.href = '/tienda/pagar.do?medioPago=tarjeta'; return false;" value="tarjeta"> Tarjeta<br>
                                <input type="radio" name="medioPago" onclick="javascript:window.location.href = '/tienda/pagar.do?medioPago=paypal'; return false;" value="paypal"> Paypal<br>
                            </div>
                        </div>
                    </div>
                </div>
                <!---------------FIN DE LA INTERFAZ PARA LA SELECCIÓN DE MEDIO DE PAGO------------------>
                <%} else {%>
                    <% if (((String) s.getAttribute("medioPago")).equalsIgnoreCase("paypal")) {%>
                    <!--------------------INTERFAZ PARA EL MEDIO DE PAGO DE PAYPAL---------------------->
                        <div class="container" style="width: 30%" class="border border-secondary">
                            <div class="card">
                                <article class="card-body">
                                    <h4 class="card-title mb-4 mt-1">Pago por PayPal</h4>
                                    <form action="/tienda/pagar.do?pago=si">
                                        <div class="form-group">
                                            <label>Ingrese su correo</label>
                                            <input name="correo" class="form-control" placeholder="Email" type="email">
                                        </div> 
                                        <div class="form-group">
                                            <label>Ingrese su contraseña</label>
                                            <input name="contrasenia" class="form-control" placeholder="******" type="password">
                                        </div> 
                                        <div class="form-group"> 
                                            <div class="checkbox">
                                                <label> <input type="checkbox"> Guardar contraseña </label>
                                            </div> 
                                        </div>  
                                        <div class="form-group">
                                            <button
                                                onclick="javascript:window.location.href = '/tienda/pagar.do?pago=si&medioPago=paypal&tipoTarjeta=debito' ; return false;"
                                                type="submit"  class="btn btn-primary btn-block"> Ingresar  </button>
                                            <button onclick="javascript:window.location.href = '/tienda/pagar.do?select=si'; return false;" class="btn btn-primary btn-block"> Volver  </button>
                                        </div>                                                        
                                    </form>
                                </article>
                            </div>
                        </div>
                    <!--------------------FIN DE LA INTERFAZ DE MEDIO DE PAGO DE PAYPAL---------------------->
                    <%} else {%>
                    <!--------------------INTERFAZ PARA LA SELECCIÓN DE MEDIO DE TARJETA---------------------->
                        <div class="container" style="width: 40%" class="border border-secondary">
                            <%System.out.println("El mdeio de pago es tarjeta");%>
                            <form action="/tienda/pagar.do?pago=si">
                                <fieldset class="form-group">
                                    <div class="row">
                                        <legend class="col-form-label col-sm-2 pt-0">Membresia</legend>
                                        <div class="col-sm-4">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="membresia" id="gridRadios1" value="visa">
                                                <label class="form-check-label" for="gridRadios1">
                                                    Visa
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="membresia" id="gridRadios2" value="mastercard">
                                                <label class="form-check-label" for="gridRadios2">
                                                    MasterCard
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="membresia" id="gridRadios3" value="dinners">
                                                <label class="form-check-label" for="gridRadios3">
                                                    Dinners
                                                </label>
                                            </div>
                                        </div>
                                        <legend class="col-form-label col-sm-2 pt-0">Tipo de Tarjeta</legend>
                                        <div class="col-sm-4">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="tipoTarjeta" id="debito" value="visa">
                                                <label class="form-check-label" for="gridRadios1">
                                                    Credito
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="tipoTarjeta" id="debito" value="mastercard">
                                                <label class="form-check-label" for="debito">
                                                    Debito
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="form-group row">
                                    <label for="inputNroTarjeta" class="col-sm-2 col-form-label">Numero de Tarjeta</label>
                                    <div class="col-sm-10">
                                        <input type="text" name ="numeroTarjeta" class="form-control" id="inputEmail3" placeholder="Numero de Tarjeta">
                                    </div>
                                </div>

                                <div class="form-group" id="expiration-date">
                                    <label style="margin: 2.5%">Fecha de Vencimiento</label>
                                    <select style="margin: 2.5%" name = "mesVencimiento">
                                        <option value="01">Enero</option>
                                        <option value="02">Febrero </option>
                                        <option value="03">Marzo</option>
                                        <option value="04">Abril</option>
                                        <option value="05">Mayo</option>
                                        <option value="06">Junio</option>
                                        <option value="07">Julio</option>
                                        <option value="08">Agosto</option>
                                        <option value="09">Septiembre</option>
                                        <option value="10">Octubre</option>
                                        <option value="11">Noviembre</option>
                                        <option value="12">Deciembre</option>
                                    </select>
                                    <select style="margin: 2.5%" name = "anioVencimiento">
                                        <option value="16"> 2016</option>
                                        <option value="17"> 2017</option>
                                        <option value="18"> 2018</option>
                                        <option value="19"> 2019</option>
                                        <option value="20"> 2020</option>
                                        <option value="21"> 2021</option>
                                        <option value="16"> 2022</option>
                                        <option value="17"> 2023</option>
                                        <option value="18"> 2024</option>
                                        <option value="19"> 2025</option>
                                        <option value="20"> 2026</option>
                                        <option value="21"> 2027</option>
                                    </select>
                                </div>

                                <div class="form-group row">
                                    <label for="inputCVV" class="col-sm-2 col-form-label">CVV</label>
                                    <div class="col-sm-10">
                                        <input type="text" name = "cvv" class="form-control" id="inputCVV" placeholder="CVV">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <button
                                            onclick="javascript:window.location.href = '/tienda/pagar.do?pago=si&medioPago=tarjeta&tipoTarjeta=debito'; return false;"
                                            type="submit" class="btn btn-primary">Realizar Pago</button>
                                        <button  onclick="javascript:window.location.href = '/tienda/pagar.do?select=si'; return false;" class="btn btn-primary">Volver</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    <!--------------------FIN DE LA INTERFAZ PARA LA SELECCIÓN DE MEDIO DE PAGO----------------->
                    <%}%>
                <%}%>
            <%}%>
        <% } else { %>
        <!-- INTERFAZ DE MENSAJE DE CARRITO VACIO -->
            <div class="page-section bg-primary text-white mb-0">
                <div class="container " >
                    <h2 class="page-section-heading text-center text-uppercase text-white">Carrito Vacio!!</h2>

                    <!-- Icon Divider -->
                    <div class="divider-custom divider-light">
                        <div class="divider-custom-line"></div>
                        <div class="divider-custom-icon">
                            <i class="fas fa-star"></i>
                        </div>
                        <div class="divider-custom-line"></div>
                    </div>

                    <!-- About Section Content -->
                    <div class="row">
                        <div class="col-lg-12 ml-auto">
                            <p class="lead"> Usted no ha elegido ninguno de los artículos que le ofrece nuestra tienda o no ha iniciado sesión , por favor revisa la sección de productos de nuestra web y elige aquellos que más se ajusten a ti.</p>
                        </div>
                    </div>
                </div>
            </div>
        <!-- FIN DE LA INTERFAZ DE MENSAJE DE CARRITO VACIO -->
        <% }%>
        </section>

        <link href="Recursos/css/login.css" rel="stylesheet" type="text/css"/>
        <!-- Login Section -->
        <%if (usuario == null) {%>
        <section class="page-section portfolio" id="login">
            <% ;%>
            <div class="container">
                <br>
                <!-- Login Section Heading -->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Iniciar Sesion</h2>

                <!-- Icon Divider -->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon">
                        <i class="fas fa-star"></i>
                    </div>
                    <div class="divider-custom-line"></div>
                </div>
                <!--Formulario-->

                <div class="container h-100 ">
                    <div class="d-flex justify-content-center h-100">
                        <div class="user_card">

                            <div class="d-flex justify-content-center form_container">
                                <form action="/tienda/logear.do">
                                    <div class="input-group mb-3">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                                        </div>
                                        <input type="text" name="user" class="form-control input_user" value="" placeholder="Usuario">
                                    </div>
                                    <div class="input-group mb-2">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                                        </div>
                                        <input type="password" name="pass" class="form-control input_pass" value="" placeholder="Contraseña">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customControlInline">
                                            <label class="custom-control-label" for="customControlInline">Recordarme</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mt-3 login_container">
                                        <input type="submit" class="btn login_btn" value="Iniciar Sesion">
                                    </div>
                                </form>
                            </div>

                            <div class="mt-4">
                                <div class="d-flex justify-content-center links">
                                    ¿No tienes una cuenta? <a href="#" class="ml-2" style="color:#FFFFFF">Registrarme</a>
                                </div>
                                <div class="d-flex justify-content-center links">
                                    <a href="#"style="color:#FFFFFF" >¿Olvidaste tu contraseña?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        <%}%>
        <!-- Bootstrap core JavaScript -->
        <script src="Recursos/vendor/jquery/jquery.min.js"></script>
        <script src="Recursos/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="Recursos/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="Recursos/js/jqBootstrapValidation.js"></script>
        <script src="Recursos/js/contact_me.js"></script>

        <!-- Custom scripts for this template -->
        <script src="Recursos/js/freelancer.min.js"></script>
    </body>
</html>
