<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>注册</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>

<body>
<form name="frm1" action="${pageContext.request.contextPath}/admin?method=register" method="post" >
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="userName"/>
                ${requestScope.message}
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="亲，点我注册！">
            </td>
        </tr>
    </table>

</form>
</body>
</html>

