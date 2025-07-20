<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>User Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Username:</label> <input type="text" name="username" required /><br/>
        <label>Password:</label> <input type="password" name="password" required /><br/>
        <button type="submit">Login</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register</a></p>
</body>
</html>
