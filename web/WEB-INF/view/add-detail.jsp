<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>No Detail</title>
</head>

Ooops it's seems there is no detail, do you want add some?

<form:form action="/user/saveDetail" modelAttribute="detail" method="POST">
<form:hidden path="id"/>

<table>
    <tbody>
    <tr>
        <td><label>Detail:</label></td>
        <td><form:input path="description"/></td>
    </tr>

    <tr>
        <td><label></label></td>
        <tb><input type="submit" value="Save" class="save"></tb>
    </tr>
    </tbody>
</table>

</form:form>

<a href="${pageContext.request.contextPath}/user/book/menu">Back to menu</a>

</body>
</html>
