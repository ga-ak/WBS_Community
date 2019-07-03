<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <script src="https://cdn.ckeditor.com/ckeditor5/12.2.0/classic/ckeditor.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/12.2.0/classic/translations/ko.js"></script>
</head>
<body>
<form action="writeArticle.do" method="post">
  <textarea id="editor" name="content">
    <p>여기에 게시글을 작성하세요!</p>
  </textarea>
  <input type="button" value="전송">
</form>
<script>
  let myEditor;
  ClassicEditor
    .create(document.querySelector('#editor'), {
      language: 'ko'
      //        toolbar: [ 'heading', '|', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote' ]
      //        options: [{
      //            model: 'paragraph',
      //            title: 'Paragraph',
      //            class: 'ck-heading_paragraph'
      //          },
      //          {
      //            model: 'heading1',
      //            view: 'h1',
      //            title: 'Heading 1',
      //            class: 'ck-heading_heading1'
      //          },
      //          {
      //            model: 'heading2',
      //            view: 'h2',
      //            title: 'Heading 2',
      //            class: 'ck-heading_heading2'
      //          }
      //        ]
    })
    .then(editor => {
      thisEditor = editor;
      console.log(editor);
    })
    .catch(error => {
      console.error(error);
    });

</script>
</body>
</html>