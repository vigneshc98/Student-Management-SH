<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>${taskName } student </title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/add-student-form.css" />

</head>
<body>

   <div id="container">
		<div id="headingDiv">
		     <h1>${taskName }  Student ${studentName}</h1>
		</div>
		<form:form action="addStudent" modelAttribute="student" method="POST">
		
			<form:hidden path="id"/>
		 
		    <div id="form">
				<form:input path="firstName" placeholder="enter student firstName"  class="inputForm" />
				<form:input path="lastName" placeholder="enter student lastName"  class="inputForm" />
				<form:input path="studentid" placeholder="enter student usn"  class="inputForm" />
				<form:input path="phno" placeholder="enter student phone number"  class="inputForm" />
				<form:input path="place" placeholder="enter student place"  class="inputForm" />
				<div id="divbtn">
						<input type="submit" class="SaveBtn" value="${taskName }" />
						<input type="reset" value="clear" class="SaveBtn" style="background-color:red" />
				</div>
			</div>
		</form:form>
	
	</div>
</body>
</html>