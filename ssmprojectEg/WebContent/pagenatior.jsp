<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap分页实例</title>
<!-- min为压缩版，bootstrap只支持jquery>1.9.0版本 -->
<!-- 一些基本控件格式可以通过class直接引用 -->
<link href="/ssmprojectEg/js/bootstrap.min.css" rel="stylesheet">
<script src="/ssmprojectEg/js/jquery-2.1.4.js"></script>
<!-- <script src="/ssmprojectEg/js/bootstrap.min.js"></script> -->
<script src="/ssmprojectEg/js/bootstrap-paginator.min.js"></script>
<style type="text/css">
#queryDiv {
 margin-right: auto;
 margin-left: auto;
 width:600px;
}
#textInput {
 margin-top: 10px;
}
#tableResult {
 margin-right: auto;
 margin-left: auto;
 width:600px;
}
td {
 width:150px
}
</style>
</head>
<body>
	<div id = "queryDiv">
		<input id = "textInput" type="text" placeholder="请输入用户名" >
		<button id = "queryButton" class="btn btn-primary" type="button">查询</button>
	</div>
	<form id="form1">
		<table class="table table-bordered table-hover" id = 'tableResult'>
			<caption>查询用户结果</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>密码</th>
					<th>用户邮箱</th>
				</tr>
			</thead>
			<tbody id="tableBody">
			</tbody>
		</table>
	<!-- 底部分页按钮 -->
		<div id="bottomTab"></div>
	</form>
	<script type="text/javascript">
	//渲染完就执行，还是通过按钮更科学
	$(function() {
	function buildTable(userName){
    $.ajax({
      url: "/ssmprojectEg/MVC/Pagelist",
      data:{
        userName:$("#textInput").val(),
        pageSize:5,
        pageNumber:1
      },
      type: "Post",
      dataType:"json",
       error: function(e){
            alert("查询失败:" + e);
      },
      success: function (data) {
       var dataList = data.dataList;
        if (data != null) {
          $(dataList).each(function () { //遍历返回的json,或者不传参数用this实现
           $("#tableBody").append('<tr>');
                    $("#tableBody").append('<td>' + this.userId + '</td>');
                    $("#tableBody").append('<td>' + this.userName + '</td>');
                    $("#tableBody").append('<td>' + this.userPassword + '</td>');
                    $("#tableBody").append('<td>' + this.userEmail + '</td>');
                    $("#tableBody").append('</tr>');
          });
          var pageCount = data.pages; //取到pageCount的值(把返回数据转成object类型)
          var currentPage =data.pageNo; //得到currentPage
          var options = {
            currentPage: currentPage, //当前页数
            totalPages: pageCount, //总页数
            itemTexts: function (type, page, current) {
              switch (type) {
                case "first":
                  return "首页";
                case "prev":
                  return "上一页";
                case "next":
                  return "下一页";
                case "last":
                  return "末页";
                case "page":
                  return page;
              }
            },
            //点击事件，用于通过Ajax来刷新整个list列表
            onPageClicked: function (event, originalEvent, type, page) {
              $.ajax({
                url: "/ssmprojectEg/MVC/Pagelist",
                type: "post",
                 dataType:"json",
                data: {
                  userName:$("#textInput").val(),
                  pageSize:5,
                  pageNumber:page
                },
                success: function (data) {
                var dataList = data.dataList;
                //重设option逻辑：            
//             var newoptions = {
//             currentPage: data.pageNo, //当前页数
//             totalPages: data.pages, //总页数
//             itemTexts: function (type, page, current) {
//               switch (type) {
//                 case "first":
//                   return "首页";
//                 case "prev":
//                   return "上一页";
//                 case "next":
//                   return "下一页";
//                 case "last":
//                   return "末页";
//                 case "page":
//                   return page;
//               }
//             }}
             //$('#bottomTab').bootstrapPaginator(newoptions); //重新设置总页面数        
         		$("#tableBody").empty();//清空表格内容
                  $(dataList).each(function () { //遍历返回的json,或者不传参数用this实现
           		  $("#tableBody").append('<tr>');
                  $("#tableBody").append('<td>' + this.userId + '</td>');
                  $("#tableBody").append('<td>' + this.userName + '</td>');
                  $("#tableBody").append('<td>' + this.userPassword + '</td>');
                  $("#tableBody").append('<td>' + this.userEmail + '</td>');
                  $("#tableBody").append('</tr>');
          });					
                }
              });
            }          
          };
          $('#bottomTab').bootstrapPaginator(options);
        }
      }      
    });  
}		
		            //创建结算规则
            $("#queryButton").bind("click",function(){
            	var userName = $("#textInput").val();	
            	buildTable(userName);
            });
            
  });		
	</script>
</body>
</html>