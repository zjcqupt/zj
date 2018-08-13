<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BootStrap Table使用</title>
<link href="/ssmprojectEg/js/bootstrap.min.css" rel="stylesheet">
<script src="/ssmprojectEg/js/jquery-2.1.4.js"></script>
<script src="/ssmprojectEg/js/bootstrap.min.js"></script>
<!-- bootstrap table组件及中文包引用 -->
<script src="/ssmprojectEg/js/bootstrap-table.js"></script>
<link href="/ssmprojectEg/js/bootstrap-table.css" rel="stylesheet" />
<script src="/ssmprojectEg/js/bootstrap-table-zh-CN.js"></script>
<script src="/ssmprojectEg/js/Index.js"></script>
</head>
<!-- 全部加载数据,然后在js中分页和查询；
本例通过后台分页,通过后台加载一页的数据；后台发送json格式的数据到前台，前台通过js处理，生成table等，页面显示  -->
<body>
<!-- 封装好的控件布局格式通过class名引用 -->
<div class="panel-body" style="padding-bottom:0px;">
	<div class="panel panel-default">
	 		 <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
            <div class="form-group" style="margin-top:15px">
            <label class="control-label col-sm-1" id="txt_search_departmentname" for="txt_search_departmentname">用户名称</label>
             			<div class="col-sm-3">
                            <input type="text" class="form-control" id="search" name="search">
            			</div>
            <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_statu">
                        </div>
            <div class="col-sm-4" style="text-align:left;">
            <!-- onClick="location.href='MVC/Pagelist3'" -->
                        <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary" >查询</button>
            </div>
            </div>
            </form>
            </div>
            </div>
     
     		
     		<div id="toolbar" class="btn-group">
     		<button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
     		</div>
     		<!-- 放入一个空的body -->
      		<table id="tb_departments"></table>
	</div>
</div>



</body>
</html>