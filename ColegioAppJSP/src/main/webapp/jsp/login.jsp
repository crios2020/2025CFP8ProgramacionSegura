<%
	if(	session.getAttribute("login")==null ||
		((boolean)session.getAttribute("login"))!=true
	) {
		response.sendRedirect("error.html");
	}	
%>