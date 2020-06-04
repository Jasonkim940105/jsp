<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<% response.setStatus(HttpServletResponse.SC_OK); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
요청 처리과정에서 예외발셍<br>
빠른 시간내에 문제를 해결하도록 하겠습니다.<br>


<%= exception.getClass().getName() %>

</body>
</html>
