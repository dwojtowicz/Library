<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add book</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath }/resources/css/style.css"
    />
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath }/resources/css/add-book-style.css"
    />
    <style>
        .error{color:red}
    </style>
</head>
<body>
<div id="wrapper">
     <div id="header">
<h2>Please add book</h2>
     </div>
</div>

<div id="container">

<form:form action="saveBook" modelAttribute="book" method="POST">
<form:hidden path="id"/>


    <table>
        <tbody>

        <tr>
            <td>Name of Book:</td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Author</td>
            <td><form:input path="bookAuthor"/></td>
            <td><form:errors path="bookAuthor" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Quantity</td>
            <td><form:input path="quantity"/></td>
        </tr>

        <tr>
            <td>Book Details</td>
            <td><form:input path="bookDetail"/></td>
            <td><form:errors path="bookDetail" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>

        </tbody>
    </table>
</form:form>
    <div style="clear; both;"></div>

<p>
    <a href="${pageContext.request.contextPath}/admin/menu">Back to List</a>
</p>

</div>

</body>
</html>
