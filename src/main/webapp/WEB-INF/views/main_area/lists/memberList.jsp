<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <link rel="stylesheet" href="/demo/resources/css/memberList.css">
</head>
<body>
<table class="memberTable">
  <tr>
    <th>member_no</th>
    <th>member_id</th>
    <th>member_pw</th>
    <th>member_name</th>
    <th>member_nick</th>
    <th>member_email</th>
    <th>member_phone</th>
    <th>member_gender</th>
    <th>member_isDeleted</th>
    <th>member_created_date</th>
    <th>member_changed_date</th>
  </tr>
  <c:forEach var="member" items="${memberList}">
    <tr>
      <td>${member.member_no}</td>
      <td>${member.member_id}</td>
      <td>${member.member_pw}</td>
      <td>${member.member_name}</td>
      <td>${member.member_nick}</td>
      <td>${member.member_email}</td>
      <td>${member.member_phone}</td>
      <td>${member.member_gender}</td>
      <td>${member.member_isDeleted}</td>
      <td>${member.member_created_date}</td>
      <td>${member.member_changed_date}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>