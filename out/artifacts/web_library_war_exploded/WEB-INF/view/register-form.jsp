<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <title>Register User</title>
</head>

<body>

<form:form action="saveUser" modelAttribute="user" method="POST">
<form:hidden path="id"/>
<table>
    <tbody>

<tr>
    <td><label>Username:</label></td>
    <td><form:input path="username"/></td>
</tr>

<tr>
    <td><label>Password:</label></td>
    <td><form:input path="password"/></td>
</tr>

<tr>
    <td><label></label></td>
    <td><input type="submit" value="Register" class="save"></td>
</tr>

    </tbody>
</table>

</form:form>

</body>


</html>