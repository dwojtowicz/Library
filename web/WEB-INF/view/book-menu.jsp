<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>



<head>
    <title>Books List</title>
</head>


<body>

<h2>Our books</h2>
<input type="button" value="Add Book"
        onclick="window.location.href='addBook'; return false;"
        class="add-button"/>

<table>
    <tr>
        <th>Title</th>
        <th>Book Author</th>
        <th>Quantity</th>
        <th>Detail</th>
        <th>Action</th>

    </tr>

    <c:forEach var="tempBook" items="${books}">

    <c:url var="detailLink" value="/user/book/detail" >
        <c:param name="bookId" value="${tempBook.id}"/>
    </c:url>

    <c:url var="withdrawLink" value="/user/book/withdraw">
        <c:param name="bookId" value="${tempBook.id}"/>
    </c:url>

    <c:url var="depositLink" value="/user/book/deposit">
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

</body>
</html>