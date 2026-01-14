<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 13/01/2026
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h3>
    <%= request.getAttribute("message") != null
            ? request.getAttribute("message")
            : request.getAttribute("error") %>
</h3>
<a href="availability">Booking History</a>
</body>
</html>

