<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page buffer="1kb" autoFlush="true" %>
<html>
<head>
    <title>Autoflush</title>
</head>
<body>
<%
    for(int i = 0 ; i < 1000; i++){
%>
    1234
    <%
    }
    %>

</body>
</html>
