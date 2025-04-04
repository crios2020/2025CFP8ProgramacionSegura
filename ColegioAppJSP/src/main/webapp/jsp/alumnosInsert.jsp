<%@page import="ar.com.eduit.curso.java.web.colegio.entities.Alumno"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.AlumnoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_AlumnoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		int edad=Integer.parseInt(request.getParameter("edad"));
		int id_curso=Integer.parseInt(request.getParameter("idCurso"));
		if(	nombre!=null && !nombre.isEmpty() &&
			apellido!=null && !apellido.isEmpty()){
			I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection());
			Alumno alumno = new Alumno(nombre, apellido, edad, id_curso);
			ar.save(alumno);
			if(alumno.getId()>0){
				out.print("Se guardo el alumno id: "+alumno.getId());
			}else{
				out.print("No se pudo guardar el alumno!");
			}
		}else{
			out.print("Falta ingresar datos!");
		}
			
	}catch(Exception e){
		out.print("Ingrese un nuevo alumno!");
		System.out.println("****************************************************");
		System.out.println(e);
		System.out.println("****************************************************");
	}
%>