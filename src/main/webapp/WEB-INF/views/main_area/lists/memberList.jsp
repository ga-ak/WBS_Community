<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="resources/css/memberList.css">
</head>
<body>
<table class="memberTable">
    <tr>
        <td>member_no</td>
        <td>member_id</td>
        <td>member_pw</td>
        <td>member_nick</td>
        <td>member_email</td>
        <td>member_phone</td>
        <td>member_gender</td>
        <td>member_isDeleted</td>
        <td>member_created_date</td>
        <td>member_changed_date</td>
    </tr>
    <c:forEach var="member" items="${memberList}">
        <tr>
            <td>${member.member_no}</td>
            <td>${member.member_id}</td>
            <td>${member.member_pw}</td>
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