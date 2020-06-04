<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <title>Calender 클래스 사용</title>
</head>
<body>
    <%
        Calendar cal = Calendar.getInstance();
    %>
    오늘은 <%=cal.get(Calendar.YEAR) %>년
    <%= cal.get(Calendar.MONTH) + 1 %>월
    <%= cal.get(Calendar.DATE) %>일
</body>
</html>
