<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge; chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<script type = "text/javascript">

</script>
<style>
header {
  position: fixed;
  top: 0;
  /* width: 100% */
  left: 0;
  right: 0;

}
.navbar-brand { position: relative; z-index: 2; }

.navbar-nav.navbar-right .btn { position: relative; z-index: 2; padding: 4px 20px; margin: 10px auto; }

.navbar .navbar-collapse { position: relative; }
.navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 22px; }

.navbar .nav-collapse { position: absolute; z-index: 1; top: 0; left: 0; right: 0; bottom: 0; margin: 0; padding-right: 120px; padding-left: 80px; width: 100%; }
.navbar.navbar-default .nav-collapse { background-color: #f8f8f8; }
.navbar.navbar-inverse .nav-collapse { background-color: #222; }
.navbar .nav-collapse .navbar-form { border-width: 0; box-shadow: none; }
.nav-collapse>li { float: right; }

.btn.btn-circle { border-radius: 50px; }
.btn.btn-outline { background-color: transparent; }

@media screen and (max-width: 767px) {
    .navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 15px; padding-right: 15px; } 
    
    .navbar .nav-collapse { margin: 7.5px auto; padding: 0; }
    .navbar .nav-collapse .navbar-form { margin: 0; }
    .nav-collapse>li { float: none; }
}
</style>
<title>Insert title here</title>
</head>
<header>
       <!-- Second navbar for sign in -->
    <nav class="navbar navbar-default">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Chung Ba Chi</a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Works</a></li>
            <li><a href="#">News</a></li>
            <li><a href="#">Contact</a></li>
            <li>
              <a class="btn btn-default btn-outline btn-circle"  data-toggle="collapse" href="#nav-collapse2" aria-expanded="false" aria-controls="nav-collapse2">Sign in</a>
            </li>
          </ul>
          <div class="collapse nav navbar-nav nav-collapse" id="nav-collapse2">
            <form class="navbar-form navbar-right form-inline" role="form">
              <div class="form-group">
                <label class="sr-only" for="Email">Email</label>
                <input type="email" class="form-control" id="Email" placeholder="Email" autofocus required />
              </div>
              <div class="form-group">
                <label class="sr-only" for="Password">Password</label>
                <input type="password" class="form-control" id="Password" placeholder="Password" required />
              </div>
              <button type="submit" class="btn btn-success">Sign in</button>
            </form>
          </div>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
</header>
        <script type="text/javascript" src="/resources/jquery.min.js"></script>

        <!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</html>