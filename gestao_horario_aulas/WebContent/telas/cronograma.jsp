<%@page import="br.com.gestao_horario_aulas.model.Aula"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cronograma</title>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="../materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<jsp:useBean id="coordenador" scope="session"
		class="br.com.gestao_horario_aulas.model.Coordenador"></jsp:useBean>
	<%
		String semestre = request.getParameter("semestre");
		if (semestre == null) {
			response.sendRedirect("selecao_semestre.jsp");
		}

		List<Aula> aulas = (List) request.getAttribute("aulas");
		if (aulas == null) {
			request.getRequestDispatcher("../cronograma").forward(request, response);
		} else {
	%>
	<nav>
	<div style="background: #3a3a3a;" class="nav-wrapper">
		<img style="height: 100%; margin-left: 25px; margin-right: 25px;"
			class="logo"
			src="https://vestibular.ucsal.br/wp-content/themes/theme_vestibular_2018/assets/images/logo.png">
		<a href="#!" class="brand-logo">Aulas UCSAL</a>
		<%
			if (coordenador.getNome() != null) {
		%>
		<ul class="right hide-on-med-and-down">
			<!-- Dropdown Trigger -->
			<li><a href="#"><%=coordenador.getNome()%></a></li>
		</ul>
		<%
			}
		%>
	</div>
	</nav>
	<nav style="background: #3a3a3a;">
	<div class="nav-wrapper" style="margin-left: 50px;">
		<div class="col s12">
			<a href="selecao_curso.jsp" class="breadcrumb">Inicio</a><a
				href="selecao_semestre.jsp" class="breadcrumb">Seleção Semestre</a>
			<a href="#!" class="breadcrumb"><%=semestre%>º Semestre</a>
		</div>
	</div>
	</nav>

	<div id="calendar" style="margin: 50px;">
		<div class="fc-toolbar">

			<div class="fc-center">
				<h2><%=request.getParameter("semestre")%>º Semestre
				</h2>
			</div>
		</div>
		<div>
			<table>
				<tr>
					<td><div>
							<table>
								<tr>
									<th>Horário</th>
									<th>Sábado</th>
									<th>Segunda-Feira</th>
									<th>Terça-Feira</th>
									<th>Quarta-Feira</th>
									<th>Quinta-Feira</th>
									<th>Sexta-Feira</th>
								</tr>
								<tr>
									<td>07:00 às 08:15</td>
									<td><%=aulas.get(2).getMateria()%></td>
									<td></td>
									<td><%=aulas.get(2).getMateria()%></td>
									<td></td>
									<td></td>
									<td><%=aulas.get(4).getMateria()%></td>
								</tr>
								<tr>
									<td>08:25 às 09:40</td>
									<td></td>
									<td><%=aulas.get(1).getMateria()%></td>
									<td><%=aulas.get(1).getMateria()%></td>
									<td><%=aulas.get(2).getMateria()%></td>
									<td><%=aulas.get(2).getMateria()%></td>
									<td></td>
								</tr>
								<tr>
									<td>09:50 às 11:05</td>
									<td></td>
									<td><%=aulas.get(3).getMateria()%></td>
									<td></td>
									<td><%=aulas.get(4).getMateria()%></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>11:15 às 12:30</td>
									<td></td>
									<td><%=aulas.get(5).getMateria()%></td>
									<td><%=aulas.get(1).getMateria()%></td>
									<td><%=aulas.get(0).getMateria()%></td>
									<td><%=aulas.get(0).getMateria()%></td>
									<td><%=aulas.get(4).getMateria()%></td>
								</tr>
							</table>
						</div></td>
				</tr>
			</table>
		</div>
		<%
			if (coordenador.getNome() != null) {
		%>
		<div class="row">
			<button style="float: right; width: 150px; height: 45px;"
				class="btn waves-effect waves-light" type="submit" name="action">Salvar</button>
		</div>
		<%
			}
			}
		%>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript"
		src="../materialize/js/materialize.min.js"></script>
</body>
</html>