<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.entities.Curso"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	I_CursoRepository cr=new CursoRepository(Connector.getConnection());
	String buscar="";
	if(request.getParameter("buscar")!=null) buscar=request.getParameter("buscar");
	for(Curso curso:cr.getLikeTituloProfesor(buscar, buscar)){
		out.print("<tr>");
		out.print("<th scope='row'>"+curso.getId()+"</th>");
		out.print("<td>"+curso.getTitulo()+"</td>");
		out.print("<td>"+curso.getProfesor()+"</td>");
		out.print("<td>"+curso.getDia()+"</td>");
		out.print("<td>"+curso.getTurno()+"</td>");
		%>
		<td>
			<a href="<% out.print("/jsp/cursosDelete.jsp?id="+curso.getId()); %>" 
				onclick="return confirmarEliminacion()">
				<img src="/icons/trash.svg">
			</a>
		</td>
		<%
		out.print("</tr>");
	}
%>