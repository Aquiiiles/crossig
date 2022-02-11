<%@ page import="hr.crosig.sample.data.generator.web.constants.CreateUserMVCActionConstants" %><%@
page import="hr.crosig.sample.data.generator.web.enums.UserAttributeEnum" %>

<%@ include file="/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-view">
	<portlet:actionURL name="<%= SampleDataGeneratorWebCommandNames.ACTION_CREATE_USER %>" var="createUserURL" />

	<aui:form
		action="${createUserURL}"
		method="post"
		name="createUserFm"
		onSubmit='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "createUsers('" + liferayPortletResponse.getNamespace() + "createUserFm');" %>'
	>
		<aui:input id="action" name="action" type="hidden" value="<%= CreateUserMVCActionConstants.CREATE_USERS %>" />

		<aui:input
			name="<%= CreateUserMVCActionConstants.USERS_JSON %>"
			type="hidden"
			value='<%=
				"[" + "{" + UserAttributeEnum.FIRST_NAME + ":'John', " + UserAttributeEnum.LAST_NAME + ":'Agent', " + UserAttributeEnum.EMAIL_ADDRESS + ":'john.agent@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_AGENT + "}," + "{" + UserAttributeEnum.FIRST_NAME + ":'Jack', " + UserAttributeEnum.LAST_NAME + ":'Manager', " + UserAttributeEnum.EMAIL_ADDRESS + ":'jack.manager@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_MANAGER + "}" + "]"
			%>'
		/>

		<div class="row">
			<div class="col-md-2">
				<button
					class="btn btn-primary gsdc-btn-action"
					onClick="<%= liferayPortletResponse.getNamespace() + "setAction('" + CreateUserMVCActionConstants.CREATE_USERS + "');" %>"
					type="submit"
				>
					<span class="gsdc-btn-text"><liferay-ui:message key="create-users" /></span>
				</button>
			</div>
		</div>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />createUsers(formName) {
		var form = document.getElementById(formName);
		var action = document.getElementById('<%= liferayPortletResponse.getNamespace() %>' + 'action').value;

		if (action === '<%= CreateUserMVCActionConstants.CREATE_USERS %>') {
			if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-create-users") %>')) {
				submitForm(form);
			}
		}
	}

	function <portlet:namespace />setAction(value) {
		document.getElementById('<%= liferayPortletResponse.getNamespace() %>' + 'action').value = value;
	}

</aui:script>