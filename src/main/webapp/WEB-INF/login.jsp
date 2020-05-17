<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title text-center">
						<strong>Login To Your Account</strong>
					</div>
				</div>
				<div class="card-body">
					<form action="login" method="post" class="form-horizontal">
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<input type="text" name="userName" class="form-control" placeholder="Username" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<input type="password" name="password" class="form-control" placeholder="Password" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<input type="submit" value="Login" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jspf"%>