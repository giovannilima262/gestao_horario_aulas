package br.com.gestao_horario_aulas.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadTables {

	public void creatScherma(Connection c) throws SQLException {

		Statement stmt = c.createStatement();

		StringBuilder query = new StringBuilder();

		query.append("CREATE DATABASE GerenciadorAulas; ");

		query.append("CREATE TABLE coordenador (id SERIAL PRIMARY KEY, ");
		query.append(" nome VARCHAR(100) NOT NULL); ");

		query.append("CREATE TABLE curso (id SERIAL PRIMARY KEY, ");
		query.append(" nome VARCHAR(100) NOT NULL, ");
		query.append(" id_coordenador INT REFERENCES coordenador(id) NOT NULL); ");

		query.append("CREATE TABLE professor (id SERIAL PRIMARY KEY, ");
		query.append(" cpf VARCHAR(11) NOT NULL, ");
		query.append(" nome VARCHAR(100)); ");

		query.append("CREATE TABLE materia (id SERIAL PRIMARY KEY,  ");
		query.append(" nome VARCHAR(100) NOT NULL, ");
		query.append(" id_curso INT REFERENCES curso(id) NOT NULL, ");
		query.append(" semestre INT NOT NULL, ");
		query.append(" id_professor INT REFERENCES professor(id) NOT NULL); ");

		query.append("CREATE TABLE sala (id SERIAL PRIMARY KEY, ");
		query.append(" bloco VARCHAR(100) NOT NULL, ");
		query.append(" nome VARCHAR(5) NOT NULL, ");
		query.append(" tipo_sala INT NOT NULL, ");
		query.append(" CHECK (tipo_sala IN(1,2,3)));      ");

		query.append("CREATE TABLE aula (id SERIAL PRIMARY KEY, ");
		query.append(" id_materia INT REFERENCES materia(id) NOT NULL, ");
		query.append(" id_professor INT REFERENCES professor(id) NOT NULL, ");
		query.append(" id_sala INT REFERENCES sala(id) NOT NULL, ");
		query.append(" dia INT NOT NULL, ");
		query.append(" horario INT NOT NULL); ");

		stmt.execute(query.toString());

	}
}