<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
</head>
<body>

<form method="POST" action="Auth" class="vh-100" style="background-color: #E8E8E8;">

  <div class="container py-5 h-100 shadow-3-strong" >
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(25px);
        box-shadow: rgba(17, 17, 26, 0.05) 0px 1px 0px, rgba(17, 17, 26, 0.1) 0px 0px 8px;">
          <div class="card-body p-5 text-center">
            <h3 class="md-5">Sign in</h3>
            <div class="form-outline mb-4">
              <input type="email" id="typeEmai	lX-2" class="form-control form-control-lg" name="email"  placeholder="Email..."/>
            </div>
            <div class="form-outline mb-4">
              <input type="password" id="typePasswordX-2" class="form-control form-control-lg" name="password"  placeholder="Password..."/>
            </div>
            <button class="btn btn-lg btn-secondary " type="submit">Login</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>