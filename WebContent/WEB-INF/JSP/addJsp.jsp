<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add">
起飞城市：<select name="city.cityID">
<option value="">---请选择起飞城市--</option>
<c:forEach items="${cl}" var="c">
<option value="${c.cityID}">${c.cityName}</option>
</c:forEach>
   </select>
   到达城市：<select name="city1.cityID">
<option value="">---请选择起飞城市--</option>
<c:forEach items="${cl}" var="c">
<option value="${c.cityID}">${c.cityName}</option>
</c:forEach>
   </select>
  起飞日期：<input type="date" name="starTime">  
   <input type="submit" value="保存">
</form>
</body>
</html>