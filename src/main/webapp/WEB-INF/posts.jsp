<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_inner.jspf"%>
<div class="container">
	<c:choose>
		<c:when test="${postList.size() > 0}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col" class="bg-primary">Post Id</th>
						<th scope="col" class="bg-primary">Post Title</th>
						<th scope="col" class="bg-primary">Last Update On</th>
						<th scope="col" class="bg-primary">Status</th>
					</tr>
					<c:forEach var="post" items="${postList}">
						<tr>
							<td>${post.postId}</td>
							<td><a href="${context}/user/posts/edit?id=${post.postId}">${post.postTitle}</a></td>
							<td>${post.lastUpdateTime}</td>
							<td>${post.status}</td>
						</tr>
   </c:forEach>
				</thead>
			</table>
		</c:when>
		<c:otherwise>
			<h2>No Post found!</h2>
		</c:otherwise>
	</c:choose>
</div>
<%@ include file="include/footer.jspf"%>