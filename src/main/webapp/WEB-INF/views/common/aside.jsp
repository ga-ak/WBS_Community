<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="resources/css/aside.css">
</head>
<body>
<div class="memberInfo">
  <c:choose>
    <c:when test="${memberInfo == null}">
      <div class="login_wrapper">
        <form action="login.do" method="post">
          <input type="text" name="member_id">
          <br>
          <input type="password" name="member_pw">
          <br>
          <input type="checkbox">자동로그인
          <input type="submit" value="로그인">
          <a href="joinForm.do"><input type="button" value="회원가입"></a>
        </form>
      </div>
    </c:when>
    <c:otherwise>
      ${memberInfo.member_nick} 님 환영합니다!
    </c:otherwise>
  </c:choose>

</div>
</body>
</html>