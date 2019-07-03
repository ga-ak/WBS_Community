<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<form action="join.do" method="post">
  <table>
    <tr>
      <td>아이디</td>
      <td><input type="text" name="member_id"></td>
    </tr>
    <tr>
      <td>비밀번호</td>
      <td><input type="password" name="member_pw"></td>
    </tr>
    <tr>
      <td>이름</td>
      <td><input type="text" name="member_name"></td>
    </tr>
    <tr>
      <td>닉네임</td>
      <td><input type="text" name="member_nick"></td>
    </tr>
    <tr>
      <td>이메일</td>
      <td><input type="email" name="member_email"></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><input type="text" name="member_phone"></td>
    </tr>
    <tr>
      <td>성별</td>
      <td><input type="radio" name="member_gender" value="1">남
        <input type="radio" name="member_gender" value="0">여</td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="회원가입">
        <input type="reset" value="내용 지우기">
      </td>
    </tr>
  </table>
</form>
</body>
</html>