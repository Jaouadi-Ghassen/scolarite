<%@page import="dao.entities.Student"%>
<%@page import="dao.entities.Groupe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<%@ include file="navbar.html" %>
<body style="background-color: #E8E8E8;" >
<%response.setHeader("Cache-Control","no-cache,no-store,no-revalidate"); %>
<h1 style="text-align:center; margin-top:30px">Bienvenue  ${username} </h1>
<br><br>
	<form method="get" action="Controlleur" style="margin-left:550px;" >
		<div class="input-group">
	  <div class="form-outline" style="width:350px;">
	    <input id="search-focus" type="search" id="form1" class="form-control" placeholder="search here ..." name="mc" style=" padding:10px;"/>
	  </div>	
	  <button type="submit" name="action" value="research" class="btn btn-primary" style=" margin-left:10px;">
	    <span class="fa fa-search"></span> 
	  </button>
	</div>
	</form>

<br><br>
<br><br>
<table class="table " style="background-color: #ffff; margin:0px 10px 20px;">
  <thead>
    <tr> 	
      <th scope="col">Id</th>
      <th scope="col">Full name</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">Group</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listeStudent}" var="s">
      <tr> 
        <td>${s.id}</td>
        <td>${s.username}</td>
        <td>${s.email}</td>
        <td>${s.password}</td>
        <td>${s.group.nom}</td>
        <td>
          <a href="Controlleur?action=DetaiStd&id=${s.id}" class="btn btn-primary">
            <span class="fa fa-info-circle"></span> plus d'info
          </a>
          <a href="Controlleur?action=delete&id=${s.id}" class="btn btn-danger" onclick="return confirm('Voulez vous vraiment supprimer cette etudiant?')">
            <span class="fa fa-trash"></span> Delete
          </a>
          <a href="Controlleur?action=edit&id=${s.id}" class="btn btn-warning">
            <span class="fa fa-edit"></span> Edit
          </a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<!-- Add previous page button -->
<c:if test="${currentPage > 1}">
  <a href="Controlleur?page=${currentPage - 1}" class="btn btn-primary">
    <span class="fa fa-angle-double-left"></span> Previous
  </a>
</c:if>

<!-- Add next page button -->
<c:if test="${currentPage < totalPages}">
  <a href="Controlleur?page=${currentPage + 1}" class="btn btn-primary">
    Next <span class="fa fa-angle-double-right"></span>
  </a>
</c:if>

</body>
</html>