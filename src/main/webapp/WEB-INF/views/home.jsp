<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow-lg text-center">
        <h2 class="mb-3">Welcome, ${username}!</h2>
        <p class="fs-5 text-success">You have successfully logged in.</p>
        <a href="/logout" class="btn btn-danger mt-3">Logout</a>
    </div>
</div>

</body>
</html>
