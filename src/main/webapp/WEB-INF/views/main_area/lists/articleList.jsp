<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" href="/demo/resources/css/articleList.css">
    <%
        String uri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String lastUri = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
//    System.out.println("uri : "+uri);
//    System.out.println("lastUri : "+lastUri);
        String boardName_ko;
        if (lastUri.equals("free")) {
            boardName_ko = "자유게시판";
        } else {
            boardName_ko = "이런이름이 나오면 안되는 게시판";
        }
    %>
</head>
<body>
<div class="board_name">
    <h3><%=boardName_ko%>
    </h3>
</div>
<div class="board_nav">

</div>
<div class="article_wrapper">
    <table>
        <tr>
            <th>article_no</th>
            <th>article_name</th>
            <th>article_recommends</th>
            <th>article_views</th>
            <th>article_images</th>
            <th>article_ip</th>
            <th>article_reports</th>
            <th>article_created_time</th>
            <th>article_changed_time</th>
        </tr>
        <c:forEach var="article" items="${articleList}">
            <tr>
                <td><a href="<%=uri%>?an=${article.article_no}">${article.article_no}</a></td>
                <td>${article.article_name}</td>
                <td>${article.article_recommends}</td>
                <td>${article.article_views}</td>
                <td>${article.article_images}</td>
                <td>${article.article_ip}</td>
                <td>${article.article_reports}</td>
                <td>${article.article_created_time}</td>
                <td>${article.article_changed_time}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="board_footer">
    <form action="/demo/board/<%=lastUri%>/article.form">
        <input type="submit" value="글쓰기(submit)">
    </form>
    <button id="btn_writeArticle">
        글쓰기(js)
    </button>
</div>
<script>

</script>
</body>
</html>