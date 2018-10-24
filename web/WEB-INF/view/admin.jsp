<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>



<head>
    <title>Admin Panel</title>
</head>


<body>

<h2>Admin Panel</h2>

<input type="button" value="Add Book"
       onclick="window.location.href='addBook'; return false;"
       class="add-button"/>

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

        <c:url var="detailLink" value="/admin/detail" >
            <c:param name="bookId" value="${tempBook.id}"/>
        </c:url>

        <c:url var="updateLink" value="/admin/update">
            <c:param name="bookId" value="${tempBook.id}"/>
        </c:url>

        <c:url var="deleteLink" value="/admin/delete">
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
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                onclick="if(!(confirm('Are you sure you want delete this book?')))return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<p>
    <a href="${pageContext.request.contextPath}/admin/menu">Show all</a>
</p>

<p>
    <a href="${pageContext.request.contextPath}/book/menu">Go to user menu</a>
</p>
</body>
</html>