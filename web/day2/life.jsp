<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private int numOne = 0;
    public void jspInit(){
        System.out.println("jspInit()호출됨");
    }
    public void jspDestroy(){
        System.out.println("jspDestroy()호출됨");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
 int numTwo = 0;
 numOne++;
 numTwo++;
%>
<ul>
    <li>Number one : <%=numOne%></li>
    <li>Number two : <%=numTwo%></li>
</ul>

</body>
</html>
