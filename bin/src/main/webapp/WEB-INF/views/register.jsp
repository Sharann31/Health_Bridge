<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label>Username:</label> <input type="text" name="username" required /><br/>
        <label>Email:</label> <input type="email" name="email" required /><br/>
        <label>Password:</label> <input type="password" name="password" required /><br/>
        <button type="submit">Register</button>
    </form>
    <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
</body>
</html>
