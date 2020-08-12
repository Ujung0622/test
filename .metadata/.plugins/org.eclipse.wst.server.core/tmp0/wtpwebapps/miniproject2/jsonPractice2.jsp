<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
function fn_process(){
    var _id = $("#id").val(); 
    $.ajax({
            type: "post",
            dataType: "text",
            async: "true",
            url: "${contextPath}/jsonPractice",
            data: {id: _id},
            success: function(data, textStatus){
            	console.log(data);
            	var jsonInfo = JSON.parse(data);
            	var memberInfo="<tr bgcolor='lightgreen'><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th></tr>";
            	for(var i in jsonInfo.members){
            		memberInfo += "<tr>"
            		memberInfo += "<td>"+jsonInfo.members[i].id+"</td>";
            		memberInfo += "<td>"+jsonInfo.members[i].pwd+"</td>";
            		memberInfo += "<td>"+jsonInfo.members[i].name+"</td>";
            		memberInfo += "<td>"+jsonInfo.members[i].email+"</td>";
            		memberInfo += "<td>"+jsonInfo.members[i].joinDate+"</td>";
            		memberInfo += "</tr>";
            	}
            	
            	$("#output").html(memberInfo);
            },
            error: function(data, textStatus){
                console.log(data.readyState);
                console.log(data.status);
                console.log(data.responseText);
            },
            complete: function(data, textStatus){
            	//console.log(data.readyState);
                //console.log(data.status);
                //console.log(data.responseText);
            }
        });
}
</script>
</head>
<body>
    <input type="text" id="id">
    <button onclick="fn_process()">조회</button><br><br>
    <table id="output" border='1'>
    </table>
</body>
</html>