<%@page import="ar.com.eduit.curso.java.web.colegio.enums.Dia"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	for(Dia dia: Dia.values()){
		out.println("<option value='"+dia+"'>"+dia+"</option>");
	}
%>