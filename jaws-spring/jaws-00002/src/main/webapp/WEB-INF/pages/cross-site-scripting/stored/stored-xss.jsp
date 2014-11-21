<%@ page import="java.util.List" %>
<%@ page import="org.owasp.jaws.good.bean.Fish" %>
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
    <%
        List<Fish> badFishList = (List<Fish>) request.getAttribute("badFishList");
        List<Fish> goodFishList = (List<Fish>) request.getAttribute("goodFishList");
    %>
    <%
        if (goodFishList != null && goodFishList.size() > 0) {
            for (Fish goodFish: goodFishList) {
    %>
                <tr>
                    <td><esapi:encodeForHTML><%=goodFish.getId() %></esapi:encodeForHTML></td>
                    <td><esapi:encodeForHTML><%=goodFish.getBreed() %></esapi:encodeForHTML></td>
                    <td><esapi:encodeForHTML><%=goodFish.getPrice() %></esapi:encodeForHTML></td>
                </tr>
    <%
            }
        }
    %>
    <%
        if (badFishList != null && badFishList.size() > 0) {
            for (Fish badFish: badFishList) {
    %>
                <tr>
                    <td><%=badFish.getId() %></td>
                    <td><%=badFish.getBreed() %></td>
                    <td><%=badFish.getPrice() %></td>
                </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
