<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP FILE</title>
</head>
<body>
    <h2>JSP Script 예제</h2>
    <%
        String scriptlet = "스크립트 릿 입니다.";
        String comment = "주석문 입니다.";
        out.println("내장객체를 이용한 출력 : " + declation + "<br>");
    %>
    선언문 출력(변수) : <%=declation%><br>
    선언문 출력(메소드) : <%=declationMethod()%><br>
    스크립트릿 출력하기 : <%=scriptlet%><br>

    <%! //declation 변수선언
        String declation = "선언문 입니다.";
    // %>

    <%! //declation 메소드 선언
        public String declationMethod(){
            return declation;
        }
    %>


</body>
</html>
