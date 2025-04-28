<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.AlumnoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_AlumnoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		int id=Integer.parseInt(request.getParameter("id"));
		I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection());
		ar.remove(ar.getById(id));
		response.sendRedirect("/alumnos.jsp");
	}catch(Exception e){
		System.out.println("****************************************************");
		System.out.println(e);
		System.out.println("****************************************************");
	}
%>