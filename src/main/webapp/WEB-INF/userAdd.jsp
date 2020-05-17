<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-4">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title text-center">
						<strong>Registration Form</strong>
					</div>
				</div>
				<div class="card-body">
					<form:form action="login" method="post" modelAttribute="user"
						class="form-horizontal">
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="firstName" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="lastName" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="userName" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:password path="password" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="email" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="mobile" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="street" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="apt" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="city" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:select path="state" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="zip" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="country" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="activeFlag" class="form-control" />
								</div>
							</div>
						</div>
						<form:button value="Login" />
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jspf"%>