<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Admin Authentication</title>

<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/admin-auth.css" />" />

</head>
<body>
     <div id="mainContainer">

		<form:form action="${pageContext.request.contextPath }/perform_login" modelAttribute="admins" method="post">
		    <div id="container">
					<form:input path="username" placeholder="enter username" required="required" class="inputForm" />
					<form:input path="password" placeholder="enter password" required="required" type="password" class="inputForm" />
					<p style="color:red">${errorMsg }</p>
					<div id="divbtn">
						<input type="submit" class="SearchBtn"  />
						<input type="reset" value="clear" class="SearchBtn" style="background-color:red" />
					</div>
					<button onclick="window.location.href='${pageContext.request.contextPath }/studentController/welcomelist'; return false;" class="btn" id="adminbtn" >Home Page</button>
			</div>
			<div id="div2">
					
			</div>
		</form:form>
    </div>	
</body>
</html>