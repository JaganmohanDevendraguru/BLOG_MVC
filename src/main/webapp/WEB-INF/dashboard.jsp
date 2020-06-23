<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row" style="height: 69vh">
		<div class="col-md-8 offset-md-1">
			<h3 class="text-secondary">Recent Drafted Posts</h3>
			<c:choose>
				<c:when test="${draftPosts.size() > 0}">
				<ul>
					<c:forEach var="dp" items="${draftPosts}">
						<li><a href="${context}/user/posts/edit?id=${dp.post_id}">${dp.title}</a></li>
					</c:forEach>
				</ul>
				</c:when>
				<c:otherwise>
					<p class="text-secondary">You don't have draft posts yet!
				</c:otherwise>
			</c:choose>
			<h3 class="text-secondary">Recent Published Posts</h3>
			<c:choose>
				<c:when test="${recentPosts.size() > 0}">
				<ul>
					<c:forEach var="rp" items="${recentPosts}">
						<li><a href="${rp.post_id}">${rp.title}</a></li>
					</c:forEach>
				</ul>
				</c:when>
				<c:otherwise>
					<p class="text-secondary">You don't have published posts yet!
				</c:otherwise>
			</c:choose>
			<h3 class="text-secondary">Recent Comments</h3>
							<c:choose>
				<c:when test="${recentComments.size() > 0}">
				<ul>
					<c:forEach var="cm" items="${recentComments}">
						<li><a href="${rm.comment_id}">${rm.comment_title}</a></li>
					</c:forEach>
				</ul>
				</c:when>
				<c:otherwise>
					<p class="text-secondary">You did not commented yet!
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-md-2 border-left bg-light">
			<h3 class="text-secondary">Shortcuts</h3>
			<img src="/images/avatar.png" class="img-fluid" alt="user profile" style="heaight:200px; width:200px"/>
			<ul>
				<li><a href="">Create a post</a></li>
				<li><a href="">Go to Profile page</a></li>
			</ul>
		</div>
	</div>
</div>
<%@ include file="include/footer.jspf"%>