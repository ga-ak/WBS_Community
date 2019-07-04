<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>
    <tiles:insertAttribute name="title"/>
  </title>
  <link rel="stylesheet" href="/demo/resources/css/layout.css">
  <script
      src="https://code.jquery.com/jquery-3.4.1.min.js"
      integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
      crossorigin="anonymous"></script>
</head>
<body>
<nav class="header_wrap">header_wrap</nav>
<div class="main_wrap">
  <div class="side_nav">
    <tiles:insertAttribute name="side_nav"/>
  </div>
  <div class="main_area">
    <tiles:insertAttribute name="main_area"/>
  </div>
  <div class="aside">
    <tiles:insertAttribute name="aside"/>
  </div>
</div>
<div class="footer_wrap">
  <tiles:insertAttribute name="footer_wrap"/>
</div>
</body>
</html>