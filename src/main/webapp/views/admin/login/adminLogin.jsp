
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url value ="/template/admin/login" var="url"/>
<html>
<head>
    <title>Admin Web Toeic</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
    <link rel="icon" href="<c:url value='/template/icon/icon.png'/>" type="shortcut icon/png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${url}/css/style.css">
    <style>
        body {
            background-image: url("<c:url value = '/template/admin/login/background.png'/>");!important;
        }
    </style>

</head>
<body>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    <div class="icon d-flex align-items-center justify-content-center">
                        <span class="fa fa-user-o"></span>
                    </div>
                    <h3 class="text-center mb-4">Admin Login</h3>
                    <form action="#" class="login-form">
                        <div class="form-group">
                            <input type="text" class="form-control rounded-left" placeholder="Username" required>
                        </div>
                        <div class="form-group d-flex">
                            <input type="password" class="form-control rounded-left" placeholder="Password" required>
                        </div>
                        <br>
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary rounded submit px-3">Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="${url}/js/jquery.min.js"></script>
<script src="${url}/js/popper.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/main.js"></script>

</body>
</html>