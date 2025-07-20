<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Medical Record</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow">
        <h2 class="mb-4 text-center">Edit Medical Record</h2>

        <form method="post" action="/doctor/edit-medical-record">
            <input type="hidden" name="id" value="${record.id}" />

            <div class="mb-3">
                <label class="form-label">Diagnosis:</label>
                <input type="text" name="diagnosis" class="form-control" value="${record.diagnosis}" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Treatment:</label>
                <input type="text" name="treatment" class="form-control" value="${record.treatment}" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Notes:</label>
                <textarea name="notes" class="form-control" rows="4">${record.notes}</textarea>
            </div>

            <button type="submit" class="btn btn-primary w-100">Update Record</button>
        </form>
    </div>
</div>

</body>
</html>
