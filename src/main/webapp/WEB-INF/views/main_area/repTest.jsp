<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="resources/css/repTest.css">
</head>
<body>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td>_id</td>--%>
<%--        <td>_pid</td>--%>
<%--        <td>_content</td>--%>
<%--        <td>_createTime</td>--%>
<%--    </tr>--%>
<%--    <c:forEach var="rep" items="${repList}">--%>
<%--        <tr>--%>
<%--            <td>${rep.rep_id}</td>--%>
<%--            <td>${rep.rep_pid}</td>--%>
<%--            <td>${rep.rep_content}</td>--%>
<%--            <td>${rep.rep_createTime}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<div class="reply_area">
  <c:forEach var="rep" items="${repList}">
    <div class="reply_wrapper">
      <div class="reply_info">
        <div class="reply_id">${rep.rep_id}</div>
        <div class="reply_pid">${rep.rep_pid}</div>
        <div class="reply_createTime">${rep.rep_createTime}</div>
      </div>
      <div class="reply_content">${rep.rep_content}</div>
    </div>
  </c:forEach>

</div>

<form action="/demo/insert_test.do">
  <table>
    <tr>
      <td>_pid</td>
      <td><input type="text" name="rep_pid"/></td>
    </tr>
    <tr>
      <td>_content</td>
      <td><input type="text" name="rep_content"/></td>
    </tr>
    <tr>
      <td>_member_id</td>
      <td><input type="text" name="member_id"/></td>
    </tr>
  </table>
  <input type="submit" value="제출"/>
</form>

<div></div>

</body>
</html>