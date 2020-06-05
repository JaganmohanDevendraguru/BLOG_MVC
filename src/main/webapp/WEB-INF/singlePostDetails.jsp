<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="blog-post">
		<h2 class="blog-post-title">${pd.postTitle}</h2>
		<p class="blog-post-meta">
			Posted ${pd.postDate} by <a href="#">${pd.userName}</a>
		</p>
		<p>${pd.postContent}</p>
	</div>
	<c:if test="${sessionScope.USERSESSION != null}">
	<%@ include file="commentForm.jspf"%>
	</c:if>
	<c:choose>
		<c:when test="${comments != null}">
			<c:forEach items="${comments}" var="comment">
				<div class="card">
					<div class="card-header">${comment.commentTitle}</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<p>${comment.commentContent}</p>
							<footer class="blockquote-footer">
								Posted by ${comment.userName}<cite title="Source Title"> on ${comment.commentedDate}</cite>
							</footer>
						</blockquote>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p class="text-success">${error}</p>
		</c:otherwise>
	</c:choose>






</div>
<%@ include file="include/footer.jspf"%>