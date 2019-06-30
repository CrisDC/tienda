<%@page import="pe.edu.unmsm.sistemas.util.ParametrosSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="pe.edu.unmsm.sistemas.util.Conexion"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="pe.edu.unmsm.sistemas.util.Carrito"%>
<%@page import="pe.edu.unmsm.sistemas.util.Item"%>
<%@page import="pe.edu.unmsm.sistemas.util.ParametrosSistema"%>
<%@page import="pe.edu.unmsm.sistemas.util.Usuario"%>
<%@page import="java.sql.ResultSet"%>


<% 
    Conexion con= Conexion.getConexion(ParametrosSistema.DRIVER, ParametrosSistema.URL,ParametrosSistema.CONECTION_USER,ParametrosSistema.CONECTION_PASS);
    //Consulta para obtener los productos
    String sql="SELECT * FROM APP.PRODUCT FETCH FIRST 10 ROWS ONLY";
    ResultSet res= con.ejecutarQuery(sql);
    HttpSession s = request.getSession(false); 
    Usuario usuario =(Usuario)s.getAttribute("usuario");
    System.out.println("usuario:"+usuario);
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
                <%if(usuario==null){%>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#login">Iniciar Sesion</a>
                </li>
                 <%}else{%>
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
            <%if(usuario!=null&&usuario.getSesionActiva()){%>
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
                    <%if(usuario!=null&&usuario.getSesionActiva()){%>
                    <th >Agregar</th>
                    <% } %>
                </tr>
                <% while(res.next()) { %> 
                <tr>
                    <td ><%=res.getString("PRODUCT_CODE")%></td>
                    <td><%=res.getString("DESCRIPTION")%></td>
                    <td>S/.<%=res.getFloat("PURCHASE_COST")%></td>
                    <td><%=res.getInt("QUANTITY_ON_HAND")%></td>
                    <%String id="id="+res.getString("PRODUCT_ID");
                      String cantidad="cantidad="+String.valueOf(res.getInt("QUANTITY_ON_HAND"));
                      String precio="precio="+String.valueOf(res.getFloat("PURCHASE_COST"));%>
                      <%if(usuario!=null&&usuario.getSesionActiva()){%>
                      <td ><a href="/tienda/agregar.do?<%=id+"&"+cantidad+"&"+precio%>"><img src="Recursos/img/buttons/addShopcar.svg" alt="" width="10%" height="10%"/></a></td>
                      <% } %>
                    <!--<td><button id="newButton" onclick="dd(this);">Click</button></td>-->
                </tr>
                <% } %>
            </table>
          </div>
        </section>
        <%
        res.close();
        %>
            
        <!-- Carrito Section -->
        <section class="page-section portfolio" id="carrito">
          <% Carrito carrito =(Carrito)s.getAttribute("carrito");
            if(carrito!=null && carrito.getCarrito().size()>0){%>
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
                <% double montoTotal=0;
                   DecimalFormat df = new DecimalFormat("#.00");
                   for(Item i : carrito.getCarrito()){ %> 
                <tr>
                    <td ><%=i.getiProduct_id()%></td>
                    <td>S/.<%=i.getiPrecio()%></td>
                    <td> <%=i.getiCantidad()%></td>
                    <td>S/.<%=i.getiPrecio()*i.getiCantidad()%></td>
                    <td ><a href="/tienda/eliminar.do?id=<%=i.getiProduct_id()%>">Quitar</a></td>
                </tr>
                <%  montoTotal=montoTotal+i.getiPrecio()*i.getiCantidad();} %>
                <tr>
                    <td></td>
                    <td></td>
                    <td><b>Monto Total</b></td>
                    <td>S/.<%=df.format(montoTotal)%></td>
                    <td></td>
                </tr>
            </table>
          </div>
          <% } else{ %>
          <!-- Mensaje Carrito vacio -->
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
             <% }%>
        </section>
        <link href="Recursos/css/login.css" rel="stylesheet" type="text/css"/>
         <!-- Login Section -->
         <%if(usuario==null){%>
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
