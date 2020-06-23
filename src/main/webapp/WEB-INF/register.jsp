<%@ include file="include/meta.jspf"%>
<%@ include file="include/nav_outer.jspf"%>
<div class="container">
	<div class="row">
 		<div class="col-md-10 offset-md-1">
			<div class="card bg-light">
				<div class="card-header">
					<div class="card-title text-primary">
						<h4><strong>Registration Form</strong></h4>
					</div>
				</div>
				<div class="card-body">
					<form:form action="${context}/register" method="post" modelAttribute="user"
						class="form-horizontal">
						<div class="form-row">
							<div class="form-group col-md-6">
								<span class="text-danger">* </span><label>First Name:</label>
								<div class="input-group input-group-md">
									<form:input path="firstName" class="form-control" />
								</div>
								<form:errors path="firstName" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group col-md-6">
								<span class="text-danger">* </span><label>Last Name:</label>
								<div class="input-group input-group-md">
									<form:input path="lastName" class="form-control" />
								</div>
								<form:errors path="lastName" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group col-md-6">
								<span class="text-danger">* </span><label>User Name:</label>
								<div class="input-group input-group-md">
									<form:input path="userName" class="form-control" />
								</div>
								<form:errors path="userName" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group col-md-6">
								<span class="text-danger">* </span><label>Password:</label>
								<div class="input-group input-group-md">
									<form:password path="password" class="form-control" />
								</div>
								<form:errors path="password" cssClass="text-danger"></form:errors>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<span class="text-danger">* </span><label>Email:</label>
								<div class="input-group input-group-md">
									<form:input path="email" type="email" class="form-control" />
								</div>
								<form:errors path="email" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group col-md-6">
								<label>Mobile:</label>
								<div class="input-group input-group-md">
									<form:input path="mobile" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Address:</label>
								<div class="input-group input-group-md">
									<form:input path="street" class="form-control" />
								</div>
						</div>
						<div class="form-row">
						<div class="form-group col-md-5">
							<label>Apt/Suite:</label>
							<div class="input-group input-group-md">
								<form:input path="apt" class="form-control" />
							</div>
						</div>
						<div class="form-group col-md-5 offset-md-1">
							<label>Active:</label>
							<div class="input-group input-group-md">
								<form:select path="activeFlag" class="form-control custom-select">
								<form:option value="null" label="--Please select--"/>
								<form:options items="${status}"/>
								</form:select>
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
										<form:option value="NULL">Select State</form:option>
										<form:options items="${USStates}"/>
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
								<div class="input-group input-group-md">
									<form:input path="country" class="form-control" />
								</div>
						</div>
						<div class="form-group">
							<div class="col-md-2">
								<div class="input-group input-group-md">
									<form:button value="Login" class="form-control btn btn-primary float-right">Login</form:button>
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