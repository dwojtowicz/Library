<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <title>Books List</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}web/resources/css/style.css"
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

        <table>
            <tr>
                <th>Book Detail</th>
            </tr>

            <c:forEach var="tempBook" items="${books}">


                <tr>
                    <td>${tempBook.bookDetail}</td>
                </tr>
            </c:forEach>
        </table>


    </div>
</div>
</body>
</html>