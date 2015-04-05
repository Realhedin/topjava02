<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmitrii
  Date: 2/28/15
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MealList</title>
</head>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <table cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Description</th>
                <th>Datetime</th>
                <th>Calories</th>
            </tr>
        </thead>
        <c:forEach var="meal" items="${allMeals}">
            <jsp:useBean id="meal" class="ru.javawebinar.topjava.model.UserMeal"/>

            <tr>
                <td><c:out value="${meal.description}"/></td>
                <td>${meal.dateTime}</td>
                <td><%= meal.getCalories()%> </td>
            </tr>
        </c:forEach>
    </table>
</section>
<hr>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
