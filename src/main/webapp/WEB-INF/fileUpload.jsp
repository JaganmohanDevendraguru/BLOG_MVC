<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row" style="height:69vh">
		<div class="col-md-4 offset-md-4">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title text-center">
						<strong>Upload Test</strong>
					</div>
				</div>
				<div class="card-body">
					<form action="upload" method="post" class="form-horizontal" enctype="multipart/form-data">
					<c:if test="${not empty error}">
						<div class="form-group">
							<div class="col-md-12">
								<p class="alert alert-danger">${error}</p>
							</div>
						</div>
						</c:if>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<input type="file" name="image" class="form-control"
										placeholder="Upload" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<input type="submit" value="Login" class="btn btn-lg btn-block btn-primary" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${files}" var="file">
				<img alt="${file.name}" src="uploads/${file.name}" style="height:200px; width:200px">
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="include/footer.jspf"%>