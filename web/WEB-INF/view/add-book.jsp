<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>

<h2>Please add book</h2>

<form:form action="saveBook" modelAttribute="book" method="POST">
<form:hidden path="id"/>


    <table>
        <tbody>

        <tr>
            <td>Name of Book:</td>
            <td><form:input path="title"/></td>
        </tr>

        <tr>
            <td>Author</td>
            <td><form:input path="bookAuthor"/></td>
        </tr>

        <tr>
            <td>Quantity</td>
            <td><form:input path="quantity"/></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>

        </tbody>
    </table>
</form:form>

<p>
    <a href="${pageContext.request.contextPath}/book/menu">Back to List</a>
</p>



</body>
</html>
