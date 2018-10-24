<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>No Detail</title>
</head>

Ooops it's seems there is no detail, do you want add some?

<form:form action="/saveDetail" modelAttribute="bookDetail" method="POST">
<form:hidden path="id"/>

<table>
    <tbody>
    <tr>
        <td><label>Detail:</label></td>
        <td><form:input path="description"/></td>
    </tr>

    </tbody>
</table>
    <input type="submit" value="Save" class="save"></tb>
</form:form>

<a href="${pageContext.request.contextPath}/book/menu">Back to menu</a>

</body>
</html>
