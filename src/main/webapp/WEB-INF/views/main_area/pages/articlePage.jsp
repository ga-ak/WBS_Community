<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="/demo/resources/css/articlePage.css">
  <script src="https://cdn.ckeditor.com/ckeditor5/12.2.0/classic/ckeditor.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/12.2.0/classic/translations/ko.js"></script>

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
    <span>댓글 - ${replySize}개</span>
    <span>{아이콘}을 클릭하면 간단한 회원메모를 할 수 있습니다.</span>
  </div>

  <c:forEach var="replyModel" items="${replyList}">
    <div class="reply_wrapper" id="reply_${replyModel.reply_no}">
      <div class="reply_info">
        <div>${replyModel.member_nick}님</div>
        <div class="reply_btn">
          <div class="reply_ip">ip : ${replyModel.reply_ip}</div>
          <div class="reply_time">time : ${replyModel.reply_created_time}</div>
          <div class="reply_rereply">대댓글</div>
          <div class="recommend">reco : ${replyModel.reply_recommends}</div>
          <div class="report">repo : ${replyModel.reply_reports}</div>
        </div>
      </div>
      <div class="reply_content">
          ${replyModel.reply_content}
      </div>
    </div>
  </c:forEach>


  <div class="reply_post">

    <form action="/demo/board/${articlePageModel.board_name}/postRep.do" method="post">
      <textarea name="content" id="reply_editor"></textarea>
      <input type="hidden" name="board_no" value="${articlePageModel.board_no}" }>
      <input type="hidden" name="article_no" value="${articlePageModel.article_no}" }>
      <input type="hidden" name="member_no" value="${loginMember.member_no}" }>
      <input type="hidden" name="reply_ip" value="<%=request.getRemoteAddr()%>" }>
      <%--      <input type="hidden" name="reply_pno" value="" }>--%>
      <input type="submit" value="댓글 달기">
    </form>
  </div>
  <script>
    let myEditor;
    let thisEvent;
    ClassicEditor
        .create(document.querySelector('#reply_editor'), {
          language: 'ko'
        })
        .then(editor => {
          thisEditor = editor;
          console.log(editor);
        })
        .catch(error => {
          console.error(error);
        });

    $('.reply_rereply').on('click', () => {
      // todo : 클릭한 후에 wrapper의 아이디 출력하기
    })

  </script>
</div>
</body>
</html>