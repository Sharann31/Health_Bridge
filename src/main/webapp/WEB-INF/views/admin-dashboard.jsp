<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="mb-4 text-center">Admin Dashboard</h3>
        <h5 class="mb-3">All Appointments</h5>
        <table class="table table-bordered">
            <tr><th>Patient</th><th>Doctor</th><th>Date</th><th>Time</th><th>Status</th></tr>
            <c:forEach var="appt" items="${appointments}">
                <tr>
                    <td>${appt.patientUsername}</td>
                    <td>${appt.doctorUsername}</td>
                    <td>${appt.appointmentDate}</td>
                    <td>${appt.appointmentTime}</td>
                    <td>${appt.status}</td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <h5 class="mb-3">All Users</h5>
        <table class="table table-bordered">
            <tr><th>Username</th><th>Email</th><th>Role</th><th>Action</th></tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td><a href="/admin/delete-user?id=${user.id}" class="btn btn-danger btn-sm">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
