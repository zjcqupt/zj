<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>不使用bootstrap实现分页</title>
<script src="/ssmprojectEg/js/jquery-2.1.4.js"></script>
<script src="/ssmprojectEg/js/func.js"></script>
</head>
<body>

<div class="row" id="deviceRecordList">
    <div class="col-lg-12" style="height: 15px;top:700px" id="paging">
        <div class="panel">
            <div class="panel-heading bk-bg-primary">
                <h6><i class="fa fa-table red"></i><span class="break"></span>查询的用户列表</h6>
            </div>
            <div class="panel-body" style="height: 900px;">
            
                <div class="table-responsive">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>邮箱账户</th>
                        </tr>
                        </thead>
                        <tbody>
                       
                        <c:forEach items="${userlist}" var="user" varStatus="status">
                            <tr>
                                <td>${status.index+1 }</td>
                                <td>${user.userName }</td>
                                <td>${user.userPassword }</td>
                                <td>
                                    <span class="label label-warning">${user.userEmail }</span>
                                </td>
                            </tr>
                        </c:forEach>
                    
                        </tbody>
                    </table>
                    <!-- 分页 -->
                    <div class="message">
                        共<i class="blue">${pagehelper.total}</i>条记录，当前显示第&nbsp;<i
                            class="blue">${pagehelper.pageNo}/${pagehelper.pages}</i>&nbsp;页
                    </div>
                    
                    <div style="text-align:center;">
                        <ul class="pagination">
                            <c:if test="${!pagehelper.isfirstPage}">
                                <li><a href="Pagelist2?page=${pagehelper.firstPage}&name=${canshu}">首页</a></li>
                            </c:if>
                         <!-- 最简单判断上下页利用pageinfo中的逻辑 -->
                            <c:if test="${pagehelper.prePage>0}">
                             <li><a id="pre" href="Pagelist2?page=${pagehelper.prePage}&name=${canshu}">上一页</a></li>
                             </c:if>
                             
                            <c:forEach items="${pagehelper.navigatepageNums}" var="navigatepageNum">
                            <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                                <c:if test="${navigatepageNum==pagehelper.pageNo}">
                                    <li class="active"><a href="Pagelist2?page=${navigatepageNum}&name=${canshu}">${navigatepageNum}</a></li>
                                </c:if>
                                <c:if test="${navigatepageNum!=pagehelper.pageNo}">
                                    <li><a href="Pagelist2?page=${navigatepageNum}&name=${canshu}">${navigatepageNum}</a></li>
                                </c:if>
                            </c:forEach>
                            
                            <c:if test="${pagehelper.nextPage<=pagehelper.pages}">
                            <li><a id="next" href="Pagelist2?page=${pagehelper.nextPage}&name=${canshu}">下一页</a></li>
                            </c:if>
                            
                            <c:if test="${!pagehelper.islastPage}">
                                <li><a href="Pagelist2?page=${pagehelper.lastPage}&name=${canshu}">最后一页</a></li>
                            </c:if>
                        </ul>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>