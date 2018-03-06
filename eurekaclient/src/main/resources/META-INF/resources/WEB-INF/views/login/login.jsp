<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@ include file="/include.jsp"%>
</head>
<style>
    body{
        font-size:12px;
        font-family:Verdana, Geneva, sans-serif;
        line-height:28px;
        margin:0;
        padding:0;
        background:url(../../../static/images/login/login_bg.jpg);
        color:#3b6e81;
    }
    .second_body{
        margin:0 auto;
        width:330px;
        height:243px;
        margin-top:10%;
        padding-left:300px;
        padding-top:110px;
        background:url(../../../static/images/login/login_panel.png) no-repeat;
        position:relative;
    }
</style>
<body>
<div class="second_body">
    <form id="loginForm" method="post" action="" >
        <table border="0" style="width:300px;">
            <tr>
                <td style="padding-bottom: 13px;width:55px;">用户名：</td>
                <td colspan="2">
                    <input class="easyui-textbox" name="username" value="" id="username" data-options="prompt:'登陆用户名',iconCls:'icon-man',iconWidth:37">
                </td>
            </tr>
            <br>
            <tr>
                <td class="lable" style="letter-spacing: 0.5em; vertical-align: middle">密码：</td>
                <td colspan="2">
                    <input class="easyui-textbox" name="password"  value="" id="password" type="password" data-options="prompt:'登陆密码',iconCls:'tk-icon-lock',iconWidth:37">
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2" style="padding: 3px;padding-bottom: 10px;">
                    <input type="checkbox" id="remember" style="float: left;"/><span>系统记住我</span>
                </td>
                <input type="hidden" name="rememberMe" id="rememberMe" >
            </tr>
            <tr>
                <td colspan="3" style="text-align:center">
                    <input type="submit" value="登录" class="login_button" id="login" onclick=""/>
                    <input type="button" value="重置" class="reset_botton" onclick=""/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>