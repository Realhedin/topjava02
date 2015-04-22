<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page import="ru.javawebinar.topjava.model.UserMeal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>

<html>
<dandelion:bundle includes="topjavaDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="meals.title"/></h3>

            <div class="view-box">
                <a class="btn btn-sm btn-info" id="add">Add Meal</a>

                <datatables:table id="datatable" data="${mealList}" row="meal" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">
                    <datatables:column title="Date">
                        <fmt:formatDate value="<%=TimeUtil.toDate(((UserMeal)meal).getDateTime())%>" pattern="dd-MMMM-yyyy hh:mm"/>
                    </datatables:column>
                    <datatables:column title="Description" property="description"/>
                    <datatables:column title="Calories" property="calories"/>

                    <datatables:column filterable="false" sortable="false">
                        <a class="btn btn-xs btn-danger delete" id="${meal.id}">Delete</a>
                    </datatables:column>
                </datatables:table>
            </div>
        </div>
    </div>
</div>
<%--<section>--%>
    <%--<table border="1" cellpadding="8" cellspacing="0">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Date</th>--%>
            <%--<th>Description</th>--%>
            <%--<th>Calories</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<c:forEach items="${mealList}" var="meal">--%>
            <%--<jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.UserMeal"/>--%>

            <%--<tr>--%>
                <%--<td><%=TimeUtil.toString(meal.getDateTime())%></td>--%>
                <%--<td>${meal.description}</td>--%>
                <%--<td>${meal.calories}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%--</section>--%>
<%--<hr>--%>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
