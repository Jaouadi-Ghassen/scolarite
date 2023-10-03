<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
</head>
<%@ include file="navbar.html" %>
<body class="vh-100" style="background-color: #E8E8E8;">
<section class="section about-section gray-bg" id="about" style="background-color: #ffff;
margin:100px">
            <div class="container">
                <div class="row align-items-center flex-row-reverse">
                    <div class="col-lg-6">
                        <div class="about-text go-to">
                            <h3 class="dark-color">Plus d'information</h3>
                            <h6 class="theme-color lead">${student.username}</h6>
                            <div class="row about-list">
                                <div class="col-md-6">
 									  <div class="media">
                                        <label>Inscrit dans :</label>
                                        <p>${student.group.nom}</p>
                                    </div>
                                    <div class="media">
                                        <label>E-mail :</label>
                                        <p>${student.email}</p>
                                    </div>
                                    <div class="media">
                                        <label>Telephone :</label>
                                        <p>${student.phone}</p>
                                    </div>
                                </div>
                                 <div class="col-md-6">
                                    <div class="media">
                                        <label>Birthday :</label>
                                        <p>${student.datens}</p>
                                    </div>
                                    <div class="media">
                                        <label>Addresse :</label>
                                        <p>${student.adresse}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                     <div class="about-avatar" >
                        <img src="${pageContext.request.contextPath}/student_photos/${student.file}" width="300px" height="300px" style="padding : 20px;">
                    </div>
                </div>
                </div>
            </div>
        </section>
</body>
</html>