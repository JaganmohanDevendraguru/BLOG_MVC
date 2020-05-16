<%@ include file="include/meta.jspf" %>
<div class="container">
<c:choose>
  <c:when test="${list > 0}">
   <c:forEach var="user" items="list">
   	${user}
   </c:forEach>
  </c:when>
  <c:otherwise>
    <h2>No Users found!</h2>
  </c:otherwise>
</c:choose>
</div>
<%@ include file="include/footer.jspf" %>