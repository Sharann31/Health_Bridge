<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Appointments</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow-lg">
        <h3 class="mb-4 text-center">All Appointments</h3>

        <form method="get" action="/admin/appointments" class="row g-3 mb-4">
            <div class="col-md-8">
                <label for="status" class="form-label">Filter by status:</label>
                <select name="status" id="status" class="form-select">
                    <option value="">-- All --</option>
                    <option value="PENDING" ${selectedStatus == 'PENDING' ? 'selected' : ''}>Pending</option>
                    <option value="APPROVED" ${selectedStatus == 'APPROVED' ? 'selected' : ''}>Approved</option>
                    <option value="REJECTED" ${selectedStatus == 'REJECTED' ? 'selected' : ''}>Rejected</option>
                </select>
            </div>
            <div class="col-md-4 d-flex align-items-end">
                <button type="submit" class="btn btn-primary w-100">Filter</button>
            </div>
        </form>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Patient</th>
                    <th>Doctor</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appt" items="${appointments}">
                    <tr>
                        <td>${appt.id}</td>
                        <td>${appt.patientUsername}</td>
                        <td>${appt.doctorUsername}</td>
                        <td>${appt.appointmentDate}</td>
                        <td>${appt.appointmentTime}</td>
                        <td>${appt.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-center mt-3">
            <a href="/admin/dashboard" class="btn btn-secondary">Back to Admin Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>
