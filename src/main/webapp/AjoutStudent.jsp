<%@page import="dao.entities.Groupe"%>
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
<br><br>

<form method="POST" action="Controlleur?action=Ajoutstd" class="vh-100" style="background-color: #E8E8E8;" enctype="multipart/form-data">
  <div class="container py-5 h-100 shadow-3-strong" >
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(25px);
        box-shadow: rgba(17, 17, 26, 0.05) 0px 1px 0px, rgba(17, 17, 26, 0.1) 0px 0px 8px;">
          <div class="card-body p-5 text-center">
            <div class="form-outline mb-4">
              <input type="text" id="typeEmai	lX-2" class="form-control form-control-lg" placeholder="User Name..." name="username" >
            </div>
            <div class="form-outline mb-4">
              <input type="email" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Email..." name="email" >
            </div>
             <div class="form-outline mb-4">
              <input type="text" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Password..." name="password" >			</div>
			 <div class="form-outline mb-4">
              <input type="text" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Date de ns..." name="datens" >
			</div>
			 <div class="form-outline mb-4">
              <input type="text" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Adresse..." name="adresse" >
			</div>
			 <div class="form-outline mb-4">
              <input type="text" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Telephone..." name="phone" >
			</div>
         
  			<div>
  				<select class="form-select" aria-label="Default select example"  name="gid">
  					<option selected>Open this select menu</option>
  							<c:forEach items="${listgr}" var="s">
    							<option value="${s.id}" >${s.nom}</option>
    						</c:forEach>
				</select>
  				</div>
			<div>
 				<div class="mb-3">
				<br>
					<input type="file" id="typeFileX-2" class="form-control form-control-lg" name="photo" width="500px" height="500px">
				</div>	
			</div>
            <button class="btn btn-lg btn-secondary " type="submit"  name="action" value="Ajoutstd" >
            	Ajouter
  			</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>