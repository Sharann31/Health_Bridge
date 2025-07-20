<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Patient Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="mb-4 text-center">Welcome, Patient!</h3>
        <h5 class="mb-3">Your Medical Records:</h5>
        <table class="table table-bordered">
            <tr><th>Diagnosis</th><th>Treatment</th><th>Notes</th></tr>
            <c:forEach var="record" items="${records}">
                <tr>
                    <td>${record.diagnosis}</td>
                    <td>${record.treatment}</td>
                    <td>${record.notes}</td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <h5 class="mb-3">Book Appointment</h5>
        <form method="post" action="/patient/book-appointment">
            <div class="mb-3"><input type="text" name="doctorUsername" class="form-control" placeholder="Doctor Username" required></div>
            <div class="mb-3"><input type="date" name="appointmentDate" class="form-control" required></div>
            <div class="mb-3"><input type="time" name="appointmentTime" class="form-control" required></div>
            <button type="submit" class="btn btn-primary w-100">Book Appointment</button>
        </form>
    </div>
</div>
</body>
</html>
