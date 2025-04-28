<%@page import="ar.com.eduit.curso.java.web.colegio.enums.Turno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	for(Turno turno: Turno.values()){
		out.println("<option value='"+turno+"'>"+turno+"</option>");
	}
%>