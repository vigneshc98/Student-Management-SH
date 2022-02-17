<%@ page language="java" contentType="text/html;  charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
     
    
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/welcome.css" />" />

</head>
<body>
   <div id="container">
   
		    <div id="headingDiv" >
		            <h1>Student List</h1>
		     </div>
			
			<div id="div2">
					
					<form:form action="searchWelcomeStudent" method="post">
						<input type="text" name="searchStudentName" placeholder="search student" class="inputForm" />
						<input type="submit" value="search" class="SearchBtn" /> 
					</form:form>
					
					<button onclick="window.location.href='list'; return false;" class="btn" id="adminbtn" >Admin View</button>
			</div>
			
			<div id="divTable">
				<table id="mainTable">
				
					<tr class="looptr" id="looptrid">
						<th>FirstName</th>
						<th>lastName</th>
						<th>Id-No</th>
						<th>PhoneNo</th>
						<th>Place</th>
						<th >Course</th>
					</tr>

						
					<c:forEach var="temp" items="${student}" >		
					           <tr class="looptr">
							   		<td>${temp.firstName }</td>
							   		<td>${temp.lastName }</td>
							   		<td>${temp.studentid }</td>
							   		<td>${temp.phno }</td>
							   		<td>${temp.place }</td>
							   		
							   		<td>
								   		<c:forEach var="hold" items="${temp.theCourses }" >
								   		    <ul class="courseid"><li>${hold.courseName}</li></ul>
								   		</c:forEach>
							   		</td>
					           </tr>  
					 </c:forEach>
				
				</table>
			</div>

	</div>
	
</body>
</html>