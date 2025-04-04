<%@page import="ar.com.eduit.curso.java.web.colegio.entities.Curso"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	I_CursoRepository cr=new CursoRepository(Connector.getConnection());
	for(Curso curso : cr.getAll()){
		out.println("<option value='"+curso.getId()+"'>"+
				curso.getId()+", "+curso.getTitulo()+", "+curso.getProfesor()+", "+
				curso.getDia()+", "+curso.getTurno()
				+"</option>");
	}
%>