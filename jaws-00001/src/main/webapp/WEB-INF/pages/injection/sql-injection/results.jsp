<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Breed</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty goodFish}">
    <tr>
        <td>${goodFish.id}</td>
        <td>${goodFish.breed}</td>
        <td>${goodFish.price}</td>
    </tr>
    </c:if>
    <c:if test="${not empty badFishList}">
        <c:forEach var="badFish" items="${badFishList}">
            <tr>
                <td>${badFish.id}</td>
                <td>${badFish.breed}</td>
                <td>${badFish.price}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<c:if test="${empty goodFish and empty badFishList}">
<div>No data selected</div>
</c:if>
