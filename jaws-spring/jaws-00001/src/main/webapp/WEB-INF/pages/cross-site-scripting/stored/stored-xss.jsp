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
    <c:if test="${not empty goodFishList}">
        <c:forEach var="goodFish" items="${goodFishList}">
            <tr>
                <td><esapi:encodeForHTML>${goodFish.id}</esapi:encodeForHTML></td>
                <td><esapi:encodeForHTML>${goodFish.breed}</esapi:encodeForHTML></td>
                <td><esapi:encodeForHTML>${goodFish.price}</esapi:encodeForHTML></td>
            </tr>
        </c:forEach>
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
