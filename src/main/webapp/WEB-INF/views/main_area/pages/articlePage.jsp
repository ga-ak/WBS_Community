<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="/demo/resources/css/articlePage.css">
</head>
<body>
<div class="content_area">
  <p>content_area</p>
  <div class="info">
    <table class="articleInfoTable">
      <tr>
        <th>article_no</th>
        <th>article_name</th>
        <th>board_name</th>
        <th>member_nick</th>
        <th>article_images</th>
        <th>article_views</th>
        <th>article_recommends</th>
        <th>article_reports</th>
        <th>article_isDeleted</th>
        <th>article_created_time</th>
        <th>article_changed_time</th>
      </tr>
      <tr>
        <td>${articlePageModel.article_no}</td>
        <td>${articlePageModel.article_name}</td>
        <td>${articlePageModel.board_name}</td>
        <td>${articlePageModel.member_nick}</td>
        <td>${articlePageModel.article_images}</td>
        <td>${articlePageModel.article_views}</td>
        <td>${articlePageModel.article_recommends}</td>
        <td>${articlePageModel.article_reports}</td>
        <td>${articlePageModel.article_isDeleted}</td>
        <td>${articlePageModel.article_created_time}</td>
        <td>${articlePageModel.article_changed_time}</td>
      </tr>
    </table>
  </div>

  <div class="content">${articlePageModel.article_content}</div>
</div>
<div class="reply_area">
  <p>reply_area</p>
  <div class="reply_area_info">
    <span>댓글 - {댓글수}</span>
    <span>{아이콘}을 클릭하면 간단한 회원메모를 할 수 있습니다.</span>
  </div>
  <div class="reply_wrapper">
    <div class="reply_info">
      <div>{댓작성자}님</div>
      <div class="reply_btn">
        <div class="reply_ip">ip</div>
        <div class="reply_time">time</div>
        <div class="reply_rereply">대댓글</div>
        <div class="recommend">공감</div>
        <div class="report">신고</div>
      </div>
    </div>
    <div class="reply_content">
      {reply_content}
    </div>
  </div>
  <textarea name="content" id="reply_editor"></textarea>
</div>
</body>
</html>