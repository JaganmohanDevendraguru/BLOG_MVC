<%@ include file="include/meta.jspf" %>
<%@ include file="include/nav_outer.jspf" %>
<div class="container">
	<c:choose>
		<c:when test="${comments != null}">
			<c:forEach items="${comments}" var="comment">
				${comment.commentTitle}<br>
				${comment.comment}<br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			${error}
		</c:otherwise>
	</c:choose>

</div>
<%@ include file="include/footer.jspf" %>