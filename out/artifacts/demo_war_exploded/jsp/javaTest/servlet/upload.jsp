<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 2018/3/29
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/pub/plugin/jquery/jquery-1.8.3.js" ></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/pub/js/json2.js" ></script>
</head>
<body>

    <form action="/demo/uploadFile" method="post" enctype="multipart/form-data" >
        <table>
            <tr>
                <td>
                    <label>用户名：</label>
                </td>
                <td>
                    <input type="text" name="username" value="wangshangyu" />
                </td>
            </tr>
            <tr>
                <td>
                    <label>myFile：</label>
                </td>
                <td>
                    <input type="file" name="myFile" />
                </td>
            </tr>
            <tr>
                <td>
                    <label>myPhoto1：</label>
                </td>
                <td>
                    <input type="file" name="myPhoto1" />
                </td>
            </tr>
            <!--<tr>
                <td>
                    <label>myPhoto2：</label>
                </td>
                <td>
                    <input type="file" name="myPhoto2" />
                </td>
            </tr>-->
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交" />
                </td>
            </tr>
        </table>
    </form>


</body>
</html>
<script type="text/javascript">
$(document).ready(function(){


});

</script>
