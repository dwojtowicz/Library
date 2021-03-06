<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <title>Books List</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"
    />
</head>


<body>


<div id="wrapper">
    <div id="header">
<h2>Books list</h2>
    </div>
</div>

        <div id="container">
            <div id="content">

<form:form action="search" method="POST">
    Search book:<input type="text" name="theSearchName"/>
   <input type="submit" value="Search" class="add-button"/>
</form:form>

<table>
    <tr>
        <th>Title</th>
        <th>Book Author</th>
        <th>Quantity</th>
        <th>Detail</th>
        <th>Action</th>

    </tr>

    <c:forEach var="tempBook" items="${books}">

    <c:url var="detailLink" value="/book/detail" >
        <c:param name="bookId" value="${tempBook.id}"/>
    </c:url>

    <c:url var="withdrawLink" value="/book/withdraw">
        <c:param name="bookId" value="${tempBook.id}"/>
    </c:url>

    <c:url var="depositLink" value="/book/deposit">
        <c:param name="bookId" value="${tempBook.id}"/>
    </c:url>

    <tr>
        <td>${tempBook.title}</td>
        <td>${tempBook.bookAuthor}</td>
        <td>${tempBook.quantity}</td>
        <td>
            <a href="${detailLink}">Detail</a>
        </td>
        <td>
            <a href="${withdrawLink}">Withdraw</a>
            |
            <a href="${depositLink}">Deposit</a>
        </td>
    </tr>
    </c:forEach>
</table>


<p>
    <a href="${pageContext.request.contextPath}/menu">Main menu</a>
</p>

            </div>
        </div>
</body>
</html>