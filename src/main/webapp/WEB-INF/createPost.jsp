<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-4">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title text-center">
						<strong>Create a New Post</strong>
					</div>
				</div>
				<div class="card-body">
					<form:form action="/user/posts/create" method="post"
						modelAttribute="p" class="form-horizontal">
						<div class="form-row">
							<div class="form-group col-md-12">
								<label>Post Title:</label>
								<div class="input-group input-group-md">
									<form:input path="postTitle" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label>Post Body:</label>
								<div class="input-group input-group-md">
									<form:textarea path="post" class="form-control" id="editor1" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group input-group-md">
									<form:button path="status" class="form-control" name="publish" value="P">Publish</form:button>
									<form:button path="status" class="form-control" name="save" value="DR">Save & Exit</form:button>
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
</script>