<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
         
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>${taskName }-course</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/add-course.css" />
</head>

<body>
    
    <div id="container">
	 
	 		<div id="headingDiv">
			   <h2>${taskName } Courses for ${studentName}</h2>
			 </div>
			 
			 <form:form  action="${taskName=='Add' ? 'addCourse' : 'deleteCourse'}" modelAttribute="student" method="post">
			 	<form:hidden path="id" value="${studentid }"/>
			 	<div id="form">
			 		<div class="inputDiv">			
			 			JavaFullStack<form:checkbox path="coursesSelected" value="javafullstack" class="checkbox" />
			 		</div>
			 		<div class="inputDiv">
			 			PythonFullStack<form:checkbox path="coursesSelected" value="pythonfullstack" class="checkbox" />
			 		</div>
			 		<div class="inputDiv">					
			 		    MernStack<form:checkbox path="coursesSelected" value="mernstack" class="checkbox" />
			 		</div>
				 	<input type="submit" value="${taskName }"  class="btn" style="background-color:${taskName=='Add'? '#29ef42':'#ff7777'}; color:white;" />
			 	</div>
			 </form:form>
	
	</div>

</body>
</html>