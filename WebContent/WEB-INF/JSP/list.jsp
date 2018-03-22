<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/css/bootstrap.css"/>

<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<%--    ${page}  --%>
<form action="list">
模糊查询：起飞城市：<select name="city.cityID">
<option value="">---请选择起飞城市--</option>
<c:forEach items="${page.cArr}" var="c">
<option value="${c.cityID}">${c.cityName}</option>
</c:forEach>
   </select>
   到达城市：<select name="city1.cityID">
<option value="">---请选择起飞城市--</option>
<c:forEach items="${page.cArr}" var="c">
<option value="${c.cityID}">${c.cityName}</option>
</c:forEach>
   </select>
 起飞日期：<input type="date" name="starTime"> 
   <input type="submit" value="提交">
</form>

<button onclick="fun()">添加</button>

   

<table class="table table-bordered"  >
<tr>
<td>选择(全选<input type="checkbox" name="" id="allSelect"  value="">)</td>
<td>航班号</td>
<td>起飞城市</td>
<td>到达城市</td>
<td>起飞时间</td>
<td>操作</td>
</tr>

<!-- <input type="checkbox" value="${user.id }" name="id"> -->
<c:forEach items="${page.fArr}" var="f">
<tr>
<td><input type="checkbox" name="id"  value="${f.flightID}" >
</td>
<td>${f.flightID}</td>
<td>${f.city.cityName}</td>
<td>${f.city1.cityName}</td>
<td>${f.starTime}</td>
<td><button onclick="del(${f.flightID})" class="btn btn-danger" >删除</button></td>
</tr>
</c:forEach>
<tr>
<td colspan="5" style="border: none">${page.fArr=="[]"?"  没有查出您要的数据！":""}</td>
</tr>
<tr>
<td><button onclick="delSome()" class="btn btn-danger" >批量删除</button></td>
<td><a href="list?curPage=1&curSize=${page.curSize}">首页</a></td>
<td><a href="list?curPage=${page.curPage-1<1?page.curPage:page.curPage-1}&curSize=${page.curSize}">上一页</a></td>
<td><a href="list?curPage=${page.curPage+1>page.totalPage?page.totalPage:page.curPage+1}&curSize=${page.curSize}">下一页</a></td>
<td><a href="list?curPage=${page.totalPage}&curSize=${page.curSize}">尾页</a></td>
<td width="300">
 <form action="list" id="page" >
 <input type="hidden" name="curSize" value="${page.curSize}">
 第<select name="curPage" onchange="page.submit()">
 	 <c:forEach  begin="1" end="${page.totalPage}" varStatus="s">
 	 <option value="${s.index}" ${s.index==page.curPage?"selected":""}>${s.index}</option>
 	 </c:forEach>
					</select>
 页 
 </form>

 <form action="list" id="page1">
   每页显示<select name="curSize" onchange="page1.submit()">
 	 <option value="3" ${3==page.curSize?"selected":""}>3</option>
 	 <option value="5" ${5==page.curSize?"selected":""}>5</option>
 	 <option value="10" ${10==page.curSize?"selected":""}>10</option>
 	 <option value="15" ${15==page.curSize?"selected":""}>15</option>
					</select>
 行
 </form>
 
</td>
</tr>
</table>

<script type="text/javascript">

$(function(){
	
   /*在做复选框全选按钮的时候，出现了一个问题，使用语句$.attr('checked',true)，将复选框的属性改为被选中，
         在chrome浏览器中第一次点击有效后面就不行了，IE8倒是没有问题。
	百度了很久找到原因是HTML的属性分为attribute和property，暂且将后者称为特性。
	checked属性即分为attribute->checked，和property->true,false。
	对于一个checkbox，若未定义checked="checked"，alert($.attr("checked")) 的结果是undefined。
	若已定义则结果是checked。attribute并不随着checkbox的状态变化而改变。
	使用prop($.attr("checked"))的话输出则分别为false和true。property则随其变化而变化。
	所以在修改checked属性时要使用prop()。prop()在jQuery1.6版本后新增。 */
	
	/* 点击全选checkbox,选中所有的checkbox,再次点击时能取消全选 */
	 $("#allSelect").on("click",function(){
		 var allChecked = $("#allSelect").prop("checked");
        if(allChecked){
        	 $("input[name='id']").prop("checked","true"); 
        }else {
       	 $("input[name='id']").removeAttr("checked");
		}
		
	 }); 
});

function fun(){
	location="addController";
}

function del(flightID){
	location="del?flightID="+flightID;
}

//删除所选中的航班
function delSome(){
  //	alert(123);
    // 获取所有选中的checked框  
    var option = $(":checked");  
    var checkedId = "";  
    var boo=true;  
    //拼接除全选框外,所有选中的id,  
    for (var i = 0, len = option.length; i < len; i++) {  
        if (boo) { 
        	
            if (option[i].id=='allSelect') {  
                boo=true;  
            }else {  
                boo=false;  
                checkedId += option[i].value;  
            } 
            
        }else{  
            checkedId += ","+option[i].value;  
        }  
    } 
    location="delAll?checkedId="+checkedId;
  
}  


</script>

</body>
</html>