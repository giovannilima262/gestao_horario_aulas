<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gerenciar Sala</title>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>
<body style="overflow: hidden;">
	<div
		style="position: absolute; top: 50%; left: 50%; transform: translate(-25%, -50%); width: 800px;">
		<div class="row">
			<form class="col s12" action="login" method="POST">
				<div class="row">
					<div class="input-field col s6">
						<input name="usuario" id="first_name" type="text" class="validate"> <label
							for="first_name">Usuário</label>
					</div>
				</div>

				<div class="row">
					<div class="input-field col s6">
						<input name="senha" id="password" type="password" class="validate"> <label
							for="password">Senha</label>
					</div>
				</div>
				<div class="row">
					<button style="width: 50%; height: 45px;"
						class="btn waves-effect waves-light" type="submit" name="action">
						Entrar</button>
				</div>
				<p>${mensagem}</p>
			</form>
		</div>
	</div>
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
</body>
</html>