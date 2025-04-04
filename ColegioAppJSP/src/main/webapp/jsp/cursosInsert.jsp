<%@page import="ar.com.eduit.curso.java.web.colegio.entities.Curso"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.enums.Turno"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.enums.Dia"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		String titulo=request.getParameter("titulo");
		String profesor=request.getParameter("profesor");
		Dia dia=Dia.valueOf(request.getParameter("dia"));
		Turno turno=Turno.valueOf(request.getParameter("turno"));
		if(	titulo!=null && !titulo.isEmpty() &&
			profesor!=null && !profesor.isEmpty()){
			I_CursoRepository cr=new CursoRepository(Connector.getConnection());
			Curso curso=new Curso(titulo,profesor,dia,turno);
			cr.save(curso);
			if(curso.getId()>0){
				out.print("Se guardo el curso id: "+curso.getId());
			}else{
				out.print("No se pudo guardar el curso!");
			}
		}else{
			out.print("Falta ingresar datos!");
		}
			
	}catch(Exception e){
		out.print("Ingrese un nuevo curso!");
		System.out.println("****************************************************");
		System.out.println(e);
		System.out.println("****************************************************");
	}
%>