<%@ include file="include/meta.jspf" %>
<div>
	<form:form action="login" method="post" modelAttribute="user">
		First Name: <form:input path="firstName"/>
		Last Name: <form:input path="lastName"/>
		User Name: <form:input path="userName"/>
		Password: <form:password path="password"/>
		Email: <form:input path="email"/>
		Mobile: <form:input path="mobile"/>
		Street: <form:input path="street"/>
		Apt/Suite: <form:input path="apt"/>
		City: <form:input path="city"/>
		State: <form:select path="state"/>
		Zip code: <form:input path="zip"/>
		Country: <form:input path="country"/>
		Active Status: <form:input path="activeFlag"/>
		<form:button value="Login" />
	</form:form>
</div>
<%@ include file="include/footer.jspf" %>