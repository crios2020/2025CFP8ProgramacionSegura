<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		int id=Integer.parseInt(request.getParameter("id"));
		I_CursoRepository cr=new CursoRepository(Connector.getConnection());
		cr.remove(cr.getById(id));
		response.sendRedirect("/cursos.jsp");
	}catch(Exception e){
		System.out.println("****************************************************");
		System.out.println(e);
		System.out.println("****************************************************");
	}
%>