<%@page
	import="ru.grusha.storage.DocumentStorage,  
    ru.grusha.model.documents.Document,
    ru.grusha.model.documents.Incoming,
    ru.grusha.model.documents.Outgoing,
    ru.grusha.model.documents.Task"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Документ</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%--
		Данный фрагмент кода извлекает из массива, хрянящего документы, документ с полученным id и выводит поля документа,
		записывает id автора для возврата
	--%>
	<%
		String authorId = "";
		int documentId = Integer.parseInt((String) request.getAttribute("chosenDocumentId"));
		for (Document documentFromStorage : DocumentStorage.data) {
			if (documentFromStorage.getId() == documentId) {
				out.write(documentFromStorage.toString());
				authorId = documentFromStorage.getAuthor().getId() + "";
			}
		}
	%>
	<br>
	<!-- Форма, содержащая скрытое поле ввода для передачи id выбранного автора -->
	<form method="get" action="GetAuthorById" id="myform">
		<INPUT type="hidden" id="authorInputId" name="authorId" value="">
	</form>
	<div onclick='setParameter(this)'>Назад</div>
</body>
<!-- Функция записывает id автора в поле ввода, отправляет форму на обработку -->
<script type="text/javascript">
	function setParameter(x) {
		document.getElementById('authorInputId').value = <%=authorId%>;
		//alert(document.getElementById('authorInputId').value);
		var form = document.getElementById('myform');
		form.submit();
	}
</script>
</html>