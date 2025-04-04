<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.entities.Curso"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.entities.Alumno"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.AlumnoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_AlumnoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection());
	I_CursoRepository cr2=new CursoRepository(Connector.getConnection());
	String buscar="";
	if(request.getParameter("buscar")!=null) buscar=request.getParameter("buscar");
	for(Alumno alumno:ar.getLikeApellidoNombre(buscar,buscar)){
		Curso curso=cr2.getById(alumno.getId_curso());
		out.print("<tr>");
		out.print("<th scope='row'>"+alumno.getId()+"</th>");
		out.print("<td>"+alumno.getNombre()+", "+alumno.getApellido()+"</td>");
		out.print("<td>"+alumno.getEdad()+"</td>");
		out.print("<td>"+curso.getId()+", "+curso.getTitulo()+", "+curso.getProfesor()+", "+
						 curso.getDia()+", "+curso.getTurno()+"</td>");
		%>
		<td>
			<a href="<% out.print("/jsp/alumnosDelete.jsp?id="+alumno.getId()); %>" 
				onclick="return confirmarEliminacion()">
				<img src="/icons/trash.svg">
			</a>
		</td>
		<%
		out.print("</tr>");
	}
%>