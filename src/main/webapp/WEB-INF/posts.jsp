<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container" style="min-height:83vh">
	<div class="card bg-light">
		<div class="card-header">
			<div class="card-title">
				<strong>Posts List</strong>
			</div>
		</div>
		<div class="card-body">
			<c:choose>
				<c:when test="${postList.size() > 0}">
					<table class="table table-hover table-striped table-bordered">
						<thead>
							<tr>
								<th scope="col" class="bg-primary">Post Id</th>
								<th scope="col" class="bg-primary">Post Title</th>
								<th scope="col" class="bg-primary">Last Update On</th>
								<th scope="col" class="bg-primary">Status</th>
								<th scope="col" class="bg-primary">Delete</th>
							</tr>
							<c:forEach var="post" items="${postList}">
								<tr>
									<td>${post.postId}</td>
									<td><a href="${context}/user/posts/edit?id=${post.postId}">${post.postTitle}</a></td>
									<td>${post.lastUpdateTime}</td>
									<td>${post.postStatus}</td>
									<td><a
										href="${context}/user/posts/delete?id=${post.postId}"></a></td>
								</tr>
							</c:forEach>
						</thead>
					</table>
				</c:when>
				<c:otherwise>
					<h2>No Post found!</h2>
				</c:otherwise>
			</c:choose>
			<div class="row">
				<a class="btn btn-primary ml-auto" href="${context}/user/posts/create">Add new</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jspf"%>