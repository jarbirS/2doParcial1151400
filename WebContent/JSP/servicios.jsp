<%@page import="dto.Tienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Servicio"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nuestra tienda virtual</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/card.css">
    </head>
    <body>

        <section id="team" class="pb-5">
		<div class="container">
			<%
				Tienda tienda = (Tienda) (request.getSession().getAttribute("tienda"));
			request.getSession().setAttribute("tienda", tienda);
			System.out.println(tienda.getDescripcion() + " AAAAAAAAA");
			%>
			<h5 class="section-title h1">SERVICIOS DE ${tienda.getNombre()}</h5>
			<a class="btn btn-primary" href="JSP/formservicio.jsp">Agregar Servicio</a></br>
			<jsp:useBean id="sDao" class="dao.ServicioDao" scope="request"></jsp:useBean>

			<div class="row">
				<c:forEach var="s" items="${sDao.list()}">
					<c:choose>
						<c:when test="${s.getTiendaBean() == tienda}">
							<div class="col-lg-3 col-md-4 col-sm-6 mb-4">
								<div class="card h-100">
									<a href="#"><img class="card-img-top"
										src="${tienda.getImagen()}" alt=""></a>
									<div class="card-body">
										<h4 class="card-title">
											<a href="#"><c:out value="${s.getNombre()}" /></a>
										</h4>
										<p class="card-text">
											<c:out value="${s.getDescripcion()}" />
										</p>
									</div>
								</div>
							</div>
						</c:when>
					</c:choose>
				</c:forEach>
			</div>

			<!-- /.row -->

			<!-- Pagination -->
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Anterior</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Siguiente</span>
				</a></li>
			</ul>

		</div>
	</section>
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