<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>



<head>
    <title>Books List</title>
</head>


<body>

<h2>Our books</h2>
<input type="button" value="Add Book"
        onclick="window.location.href='addBook'; return false;"
        class="add-button"/>


    <tr>
        <th>Title</th>
        <th>Book Author</th>
        <th>Quantity</th>
    </tr>

    <c:forEach var="books" items="${books}">

    <tr>
        <td>${tempBook.title}</td>
        <td>${tempBook.bookAuthor}</td>
        <td>${tempBook.bookQuantity}</td>
    </tr>

</table>
</c:forEach>
</body>
</html>