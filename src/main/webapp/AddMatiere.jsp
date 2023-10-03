<%@page import="dao.entities.Groupe"%>
<%@page import="dao.entities.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="navbar.html" %>

<form method="post" action="Controlleur?action=addMatiere" class="vh-100" style="background-color: #E8E8E8;
 margin-top: 80px ;">
  <div class="container py-5 h-100 shadow-3-strong" >
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(25px);
        box-shadow: rgba(17, 17, 26, 0.05) 0px 1px 0px, rgba(17, 17, 26, 0.1) 0px 0px 8px;">
          <div class="card-body p-5 text-center">
            
            <div class="mb-3 mt-3">
  <div class="form-outline mb-4">
              <input type="text" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Course name"  name="course" >
            </div>
</div>
<div>
</div>
            <button class="btn btn-lg btn-secondary " type="submit">
            	Ajouter
  			</button>
  		
          </div>
          
          <div class="card-body p-5 text-center">
            
            <div class="mb-3 mt-3">
<table class="table">
	<tr> 	
	 	<th scope="col">Id</th>
	 	<th scope="col">Nom de la matiere</th>
	 	<th>Action</th>
	 </tr>	
	 <c:forEach items="${listCourse}" var="c">
	 	<tr> 
	 		<td>${c.id}</td>
	 		<td>${c.name}</td>
	 		
	 		<td>
	 		<a href="Controlleur?action=deleteCr&id=${c.id}" class="btn btn-danger" onclick="return confirm('Voulez vous vraiment supprimer cette matiere?')">
	 		<span class="fa fa-trash"></span>
	 		</a>
	 		<a href="Controlleur?action=deleteCourse&id=${c.id}" class="btn btn-primary">
	 		<span class="fa fa-info-circle"></span>
	 		</a>
	 		</td>
	 		</tr>
	 	</c:forEach>
	</table>
	</div>
	
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>