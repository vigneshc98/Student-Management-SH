<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
     
    
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/student-list.css" />

</head>
<body>
   <div id="container">
   
		   <div id="headingDiv"> 
		      <h1>Student List</h1> 
		   </div>
			
			<div id="div2">
				<button onclick="window.location.href='addStudentForm'; return false;" class="btn">Add Student</button>
				
				<form:form action="searchStudent" method="get">
					<input type="text" name="searchStudentName" placeholder="search student" class="inputForm"/>
					<input type="submit" value="search" class="SearchBtn" /> 
				</form:form>
				
				<form action="${pageContext.request.contextPath }/perform_logout" method="post">
					<input type="submit" value="logut" class="btn" style="	background-color:#626262;color: #d8d8d8;"/>
				</form>
			   
   		</div>
			
			
			
			<div id="divTable">
				<table id="mainTable">
				
					<tr class="looptr1">
						<th>FirstName</th>
						<th>LastName</th>
						<th>Id-No</th>
						<th>PhoneNo</th>
						<th>Place</th>
						<th>Course</th>
					</tr>

                          <c:forEach var="temp" items="${student}" >
						
						       <c:url var="updateStudentlink" value="/studentController/updateStudent">
						       	     <c:param name="studentId" value="${temp.id}"></c:param>
						       </c:url>
						       
						       <c:url var="deleteStudentlink" value="/studentController/deleteStudent">
						       		<c:param name="studentId" value="${temp.id }"></c:param>
						       </c:url>
						       
						       <c:url var="addCourse" value="/studentController/addCourseForm">
						            <c:param name="studentid" value="${temp.id }" ></c:param>
						       </c:url>
						       <c:url var="deleteCourse" value="/studentController/deleteCourseForm">
						       		<c:param name="studentid" value="${temp.id }"></c:param>
						       </c:url>
							
							   <tr class="looptr2">
							   		<td>${temp.firstName }</td>
							   		<td>${temp.lastName }</td>
							   		<td class="spclLeft">${temp.studentid }</td>
							   		<td class="spclLeft">${temp.phno }</td>
							   		<td >${temp.place }</td>
							   		
							   		<td>
							   		<c:forEach var="hold" items="${temp.theCourses }" >
							   		    <ul style="position:relative; left:0.7rem;"><li>${hold.courseName}</li></ul>
							   		</c:forEach>
							   		</td>
							   		<td id="spcltd"> 
							   		   <a href="${updateStudentlink}" ><button class="stBtn" >Update</button></a>
							   		    
							   	        <a href="${addCourse}" ><button class="stBtn" style="width:5.5rem" >Add Course</button></a>
							   	        
							   	        <a href="${deleteCourse }" ><button class="stBtn" style="width:6.5rem; background-color:#ff7777; color:white;">Delete Course</button></a>
							   	        
							   	        <a href="${deleteStudentlink}" onclick="if(!(confirm('Are you sure you want to delete this Student?'))) return false;"><button class="stBtn" style="width:6.6rem; background-color:#ff7777; color:white; position:relative; right:0.8rem;">Delete Student</button></a> 	        
							   	    </td> 
							   </tr>
				       </c:forEach>
				      
				</table>
			</div>

	</div>
	<script type="text/javascript">
	    
	</script>
</body>
</html>