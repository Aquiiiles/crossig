<%@ include file="init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<portlet:actionURL name="<%= CacheManagementCommandNames.ACTION_CLEAR_ALL_CACHE %>" var="clearAllCacheURL" />
		<portlet:actionURL name="<%= CacheManagementCommandNames.ACTION_CLEAR_SINGLE_CACHE %>" var="clearSingleCacheURL" />

		<div class="col-md-2">
			<aui:form action="${clearAllCacheURL}" method="post" name="clearAllCacheFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "clearAllCache('" + renderResponse.getNamespace() + "clearAllCacheFm');" %>'>
				<button class="btn btn-primary gsdc-btn-action" type="submit">
					<span class="gsdc-btn-text"><liferay-ui:message key="clear-all-cache" /></span>
				</button>
			</aui:form>
		</div>

		<div class="col-md-2">
			<aui:form action="${clearSingleCacheURL}" method="post" name="clearCitiesCacheFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "clearCitiesCache('" + renderResponse.getNamespace() + "clearCitiesCacheFm');" %>'>
				<aui:input name="cacheName" type="hidden" value="city" />
				<button class="btn btn-primary gsdc-btn-action" type="submit">
					<span class="gsdc-btn-text"><liferay-ui:message key="clear-cities-cache" /></span>
				</button>
			</aui:form>
		</div>

		<div class="col-md-2">
			<aui:form action="${clearSingleCacheURL}" method="post" name="clearStreetsCacheFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "clearStreetsCache('" + renderResponse.getNamespace() + "clearStreetsCacheFm');" %>'>
				<aui:input name="cacheName" type="hidden" value="street" />
				<button class="btn btn-primary gsdc-btn-action" type="submit">
					<span class="gsdc-btn-text"><liferay-ui:message key="clear-streets-cache" /></span>
				</button>
			</aui:form>
		</div>
	</div>

</div>

<aui:script>
	function <portlet:namespace />clearAllCache(formName) {
		var form = document.getElementById(formName);

		if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-clear-all-cache") %>')) {
			submitForm(form);
		}
	}

	function <portlet:namespace />clearCitiesCache(formName) {
    	var form = document.getElementById(formName);

		if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-clear-cities-cache") %>')) {
			submitForm(form);
		}
	}

	function <portlet:namespace />clearStreetsCache(formName) {
		var form = document.getElementById(formName);

		if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-clear-streets-cache") %>')) {
			submitForm(form);
		}
	}
</aui:script>