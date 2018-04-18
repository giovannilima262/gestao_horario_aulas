<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seleção de Curso</title>
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
			<a href="selecao_curso.jsp" class="breadcrumb">Inicio</a>
		</div>
	</div>
	</nav>
	<h3 style="margin-left: 80px;" class="header">Cursos</h3>
	<div class="row" style="width: 90%;">
		<div class="col s12 m2">
			<div class="card">
				<div class="card-content">
					<p>Engenharia de software</p>
				</div>

				<div class="card-image">
					<a href="./selecao_semestre.jsp"
						style="right: -12px; bottom: -13px;"
						class="btn-floating halfway-fab waves-effect waves-light red"><i
						class="material-icons">add</i></a>
				</div>
			</div>
		</div>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript"
		src="../materialize/js/materialize.min.js"></script>

</body>
</html>