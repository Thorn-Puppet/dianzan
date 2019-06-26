<%--
  Created by IntelliJ IDEA.
  User: Mr_Thorn
  Date: 2019/6/24 0024
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <base href="<%=request.getContextPath()%>/">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>商品展示</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<caption>商品信息</caption>
<table class="table table-hover">
    <thead>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="productList">
    <tr>
        <th scope="row">${productList.product_Id}</th>
        <td>${productList.product_Name}</td>
        <td>${productList.product_Min_Price}</td>
        <td>
            <c:if test="${productList.zan}">
            <span id="zan-${productList.product_Id}" class="glyphicon glyphicon-heart" aria-hidden="true" onclick="dianzan('zan-${productList.product_Id}',${productList.product_Id})"></span>
            </c:if>

            <c:if test="${productList.zan}">
                <span id="zan-${productList.product_Id}" class="glyphicon glyphicon-heart-empty" aria-hidden="true" onclick="dianzan('zan-${productList.product_Id}',${productList.product_Id})"></span>
            </c:if>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<script type="text/javascript">
    function dianzan(tagid,productid) {
        var classval = $("#"+tagid).attr("class");

        if(classval.indexOf("empty") > 0){
            //将id为zan1 的标签中的class属性改为glyphicon glyphicon-heart
            $("#"+tagid).attr("class","glyphicon glyphicon-heart");
        }else{
            $("#"+tagid).attr("class","glyphicon glyphicon-heart-empty");
        }

        //数据传递用post,数据查询用get
        /**
         * 参数1:URL
         * 参数2:参数
         * 参数3:回调函数
         * data:后台controller层返回的结果
         */
        $.post("dianzan",{goodsId:productid},function (data) {
            if(data.code==0){
                alert("点赞成功");
            }else{
                alert("点赞失败");
            }
        });
    }

</script>

<script src="js/jquery-3.1.1.js"></script>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<%--<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>--%>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
</body>
</html>
