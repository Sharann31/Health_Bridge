<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="mb-4 text-center">Register</h3>
        <form action="/register" method="post">
            <div class="mb-3"><label>Username</label><input type="text" name="username" class="form-control" required></div>
            <div class="mb-3"><label>Password</label><input type="password" name="password" class="form-control" required></div>
            <div class="mb-3"><label>Email</label><input type="email" name="email" class="form-control" required></div>
            <div class="mb-3"><label>Phone</label><input type="text" name="phone" class="form-control" required></div>
            <div class="mb-3">
                <label>Role</label>
                <select name="role" class="form-control" required>
                    <option value="">Select</option>
                    <option value="PATIENT">Patient</option>
                    <option value="DOCTOR">Doctor</option>
                </select>
            </div>
            <button class="btn btn-success w-100">Register</button>
        </form>
        <p class="text-center mt-3"><a href="/login">Back to Login</a></p>
    </div>
</div>
</body>
</html>
