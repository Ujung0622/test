<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<title>JSP AJAX</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<script>
	var request = new XMLHTTPrquest();
	function searchFunction(){
		request.open("Post", "./JsonServlet1?userName="+encodeURIComponent(document.getElementByID("J_ID").value), true);
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	function searchProcess(){
		var table = document.getElementById("outbput");
		table.innerHTML = "";
		if(request.readyState == 4 && request.status == 200){
			var object = eval('('+request.responseText+')');
			var result = object.result;
			for(var i=0; i<result.length;i++){
				var row = table.insertRow(0);
				for(var j=0; j<result[i].length; j++){
					var cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
				}
			}
		}
	}
	</script>
<meta charset="UTF-8">
</head>
<body>
	<input type="text" id="J_ID" onkeyup="fn_myFunction()">
	<input type="button" style="cursor: pointer" value="조회"
		onclick="fn_myFunction()">
	<br>
	<div id="output"></div>
	<script>
	function fn_myFunction() {
		var data = { J_ID : $("#J_ID").val()};
		
		if (data == '') {
			alert("ID입력하세요")
			return;
		}
		$.ajax({
			type : "post",
			url : "${contextPath}/json", 
			data : data,
			success : function(data, textStatus) {
				let jsonStr = data;
				let jsonInfo = JSON.parse(jsonStr);
				let memberInfo = "<table border = '1px'><tr bgcolor='lightgrey'><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입날</th></tr>"
				for ( var i in jsonInfo.members) {
					memberInfo += "<tr><td>" + jsonInfo.members[i].ID
							+ "</td></tr>";
					memberInfo += "<td> " + jsonInfo.members[i].PWD
							+ "</td>";
					memberInfo += "<td> " + jsonInfo.members[i].NAME
							+ "</td>";
					memberInfo += "<td> " + jsonInfo.members[i].EMAIL
							+ "</td>";
					memberInfo += "<td> " + jsonInfo.members[i].JOINDATE
							+ "</td></tr>";
				}
				$("#output").html(memberInfo + "<br>");
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
			},
			complete : function(data, textStatus) {
			}
		});
	};
</script>
</body>
</html>