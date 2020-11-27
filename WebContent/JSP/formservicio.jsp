<%@page import="dto.Tienda"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nuestra tienda virtual</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="../CSS/registro.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row no-gutter">
			<div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
			<div class="col-md-8 col-lg-6">
				<div class="login d-flex align-items-center py-5">
					<div class="container">
						<div class="row">
							<div class="col-md-9 col-lg-8 mx-auto">
								<h3 class="login-heading mb-4">Registro de Servicio</h3>
								<%
								Tienda tienda = (Tienda) (request.getSession().getAttribute("tienda"));
								request.getSession().setAttribute("tienda", tienda);
								%>
								<form action="../TiendaController" method="POST">
									<div class="form-label-group">
										<input type="text" id="inputNombre" name="nombre"
											class="form-control" placeholder="Nombre" required autofocus>
										<label for="inputNombre">Nombre</label>
									</div>
									<div class="form-label-group">
									<textarea id="inputDescripcion" name="descripcion"
										class="form-control" placeholder="Descripcion" required
										autofocus></textarea>
									<label for="inputDescripcion">Descripción</label>
									</div>
									<input type="hidden" name="idTienda" value="${tienda.getId()}">

							<button value="registrarServicio" name="accion"
								class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
								type="submit">Registrar</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>