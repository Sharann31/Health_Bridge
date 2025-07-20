<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Medical Record</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="mb-4 text-center">Add Medical Record</h3>

        <form method="post" action="/doctor/add-medical-record">
            <div class="mb-3">
                <label>Patient Username</label>
                <input type="text" name="patientUsername" class="form-control" required />
            </div>

            <div class="mb-3">
                <label>Diagnosis</label>
                <input type="text" name="diagnosis" class="form-control" required />
            </div>

            <div class="mb-3">
                <label>Treatment</label>
                <input type="text" name="treatment" class="form-control" required />
            </div>

            <div class="mb-3">
                <label>Notes</label>
                <textarea name="notes" rows="4" class="form-control"></textarea>
            </div>

            <button type="submit" class="btn btn-primary w-100">Save Record</button>
        </form>

        <p class="text-success text-center mt-3">${message}</p>
    </div>
</div>
</body>
</html>
