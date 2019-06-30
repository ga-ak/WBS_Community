<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>_id</td>
        <td>_pid</td>
        <td>_depth</td>
    </tr>
    <c:forEach var="rep" items="${repList}">
        <tr>
            <td>${rep.rep_id}</td>
            <td>${rep.rep_parent}</td>
            <td>${rep.depth}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>