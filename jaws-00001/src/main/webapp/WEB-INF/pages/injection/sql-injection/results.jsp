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
                <td><esapi:encodeForHTML>${goodFish.id}</esapi:encodeForHTML></td>
                <td><esapi:encodeForHTML>${goodFish.breed}</esapi:encodeForHTML></td>
                <td><esapi:encodeForHTML>${goodFish.price}</esapi:encodeForHTML></td>
            </tr>
    </c:if>
    <c:if test="${not empty badFishList}">
        <c:forEach var="badFish" items="${badFishList}">
            <tr>
                <td><esapi:encodeForHTML>${badFish.id}</esapi:encodeForHTML></td>
                <td><esapi:encodeForHTML>${badFish.breed}</esapi:encodeForHTML></td>
                <td><esapi:encodeForHTML>${badFish.price}</esapi:encodeForHTML></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
