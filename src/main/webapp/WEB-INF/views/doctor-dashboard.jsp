<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Doctor Dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <!-- Optional Custom CSS -->
    <style>
        body {
            background-color: #f5f7fa;
        }
        .dashboard-card {
            background: white;
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            margin-top: 30px;
        }
        h2 {
            color: #333;
        }
        .btn-approve {
            background-color: #28a745;
            color: white;
        }
        .btn-reject {
            background-color: #dc3545;
            color: white;
        }
        .btn-edit {
            background-color: #ffc107;
            color: black;
        }
        .btn-delete {
            background-color: #6c757d;
            color: white;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Welcome, Doctor!</h2>

    <div class="dashboard-card">
        <h4>Your Appointments:</h4>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Patient</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appt" items="${appointments}">
                    <tr>
                        <td>${appt.patientUsername}</td>
                        <td>${appt.appointmentDate}</td>
                        <td>${appt.appointmentTime}</td>
                        <td>${appt.status}</td>
                        <td>
                            <form method="post" action="/doctor/update-status" style="display:inline;">
                                <input type="hidden" name="appointmentId" value="${appt.id}" />
                                <input type="hidden" name="status" value="APPROVED" />
                                <button type="submit" class="btn btn-sm btn-approve">Approve</button>
                            </form>
                            <form method="post" action="/doctor/update-status" style="display:inline;">
                                <input type="hidden" name="appointmentId" value="${appt.id}" />
                                <input type="hidden" name="status" value="REJECTED" />
                                <button type="submit" class="btn btn-sm btn-reject">Reject</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="dashboard-card">
        <h4>Manage Medical Records:</h4>
        <table class="table table-bordered">
            <thead class="table-light">
                <tr>
                    <th>Patient</th>
                    <th>Diagnosis</th>
                    <th>Treatment</th>
                    <th>Notes</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="rec" items="${records}">
                    <tr>
                        <td>${rec.patientUsername}</td>
                        <td>${rec.diagnosis}</td>
                        <td>${rec.treatment}</td>
                        <td>${rec.notes}</td>
                        <td>
                            <a href="/doctor/edit-medical-record?id=${rec.id}" class="btn btn-sm btn-edit">Edit</a>
                            <a href="/doctor/delete-medical-record?id=${rec.id}" class="btn btn-sm btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/doctor/add-medical-record" class="btn btn-primary">Add Medical Record</a>
    </div>
</div>

</body>
</html>
