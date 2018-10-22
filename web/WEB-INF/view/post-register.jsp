<!DOCTYPE html>
<html>



<head>
    <title>Library</title>
</head>


<body>

    Welcome ${theUser.username}
<p>
    <a href="${pageContext.request.contextPath }/book/withdraw">Withdraw book</a>
</p>

<p>
    <a href="${pageContext.request.contextPath }/book/deposit">Deposit</a>
</p>


</body>
</html>