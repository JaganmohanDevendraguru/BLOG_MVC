<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-4">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title text-center">
						<strong>Registration Form</strong>
					</div>
				</div>
				<div class="card-body">
					<form:form action="login" method="post" modelAttribute="user"
						class="form-horizontal">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>First Name:</label>
								<div class="input-group input-group-md">
									<form:input path="firstName" class="form-control" />
								</div>
							</div>
							<div class="form-group col-md-6">
								<label>Last Name:</label>
								<div class="input-group input-group-md">
									<form:input path="lastName" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>User Name:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="userName" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Password:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:password path="password" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Email:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="email" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Mobile:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="mobile" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Address:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="street" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Apt/Suite:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="apt" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>City:</label>
								<div class="input-group input-group-md">
									<form:input path="city" class="form-control" />
								</div>
							</div>
							<div class="form-group col-md-4">
								<label>State:</label>
								<div class="input-group input-group-md">
									<form:select path="state" class="form-control custom-select">
										<option selected>Open this select menu</option>
										<option value="1">NH</option>
									</form:select>
								</div>
							</div>
							<div class="form-group col-md-2">
								<label>Zip code:</label>
								<div class="input-group input-group-md">
									<form:input path="zip" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Country:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="country" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Active:</label>
							<div class="col-md-12">
								<div class="input-group input-group-md">
									<form:input path="activeFlag" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
						<div class="col-md-2">
							<div class="input-group input-group-md">
								<form:button value="Login" class="form-control btn btn-primary">Login</form:button>
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