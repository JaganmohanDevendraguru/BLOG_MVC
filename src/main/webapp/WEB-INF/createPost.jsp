<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_inner.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-4">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title">
						<strong>Create a New Post</strong>
					</div>
				</div>
				<div class="card-body">
				<c:if test="${error != null}"><p class="text-danger">${error}</p></c:if>
					<form:form action="/user/posts/create" method="post"
						modelAttribute="p" class="form-horizontal">
						<div class="form-row">
							<div class="form-group col-md-12">
								<label>Post Title:</label>
								<div class="input-group input-group-md">
									<form:input path="postTitle" class="form-control" />
									<form:errors path="postTitle"></form:errors>
									<form:errors path="post"></form:errors>
								</div>
							</div>
							<div class="form-group">
								<label>Post Body:</label>
								<div class="input-group input-group-md">
									<form:textarea path="post" class="form-control" id="editor1"
										onclick="eraseText()" />
								</div>
							</div>
							<div class="form-group">
								<label>Post Status:</label>
								<div class="input-group input-group-md">
									<form:select path="postStatus" class="form-control">
									<form:option value="NULL">Select Status</form:option>
									<form:options items="${postStatus}" itemLabel="display" itemValue="code" />
									</form:select>
									<form:errors path="postStatus"></form:errors>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group input-group-md">
									<form:button class="btn btn-primary"
										name="publish" value="P" role="button">Submit</form:button>
									<a href="${context}/user/posts" class="btn btn-primary ml-2">Cancel</a>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jspf"%>
<script>
	CKEDITOR.replace('editor1');
	function eraseText() {
		document.getElementById("editor1").value = "";
	}
</script>