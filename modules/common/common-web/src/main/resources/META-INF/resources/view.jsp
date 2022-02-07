<%@ page import="hr.crosig.common.cache.management.constants.ClearCacheMVCActionConstants" %>
<%@ include file="init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-view">
	<portlet:actionURL name="<%= CacheManagementCommandNames.ACTION_CLEAR_CACHE %>" var="clearCacheURL" />

	<aui:form action="${clearCacheURL}" method="post" name="clearCacheFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "clearCache('" + renderResponse.getNamespace() + "clearCacheFm');" %>'>
		<aui:input id="cacheName" name="cacheName" type="hidden" value="<%= ClearCacheMVCActionConstants.CLEAR_CACHE_ALL %>" />
		<div class="row">
			<div class="col-md-2">
				<button class="btn btn-primary gsdc-btn-action" type="submit" onClick="<%= renderResponse.getNamespace() + "setCacheName('" + ClearCacheMVCActionConstants.CLEAR_CACHE_ALL + "');" %>">
						<span class="gsdc-btn-text"><liferay-ui:message key="clear-all-cache" /></span>
				</button>
			</div>
			<div class="col-md-2">
				<aui:input id="cityName" name="cityName" type="text" label="city-name"/>
				<button class="btn btn-primary gsdc-btn-action" type="submit" onClick="<%= renderResponse.getNamespace() + "setCacheName('" + ClearCacheMVCActionConstants.CLEAR_CACHE_CITY + "');" %>">
					<span class="gsdc-btn-text"><liferay-ui:message key="clear-cities-cache" /></span>
				</button>
			</div>
			<div class="col-md-2">
				<button class="btn btn-primary gsdc-btn-action" type="submit" onClick="<%= renderResponse.getNamespace() + "setCacheName('" + ClearCacheMVCActionConstants.CLEAR_CACHE_STREET + "');" %>">
					<span class="gsdc-btn-text"><liferay-ui:message key="clear-streets-cache" /></span>
				</button>
			</div>
		</div>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />clearCache(formName) {
		var form = document.getElementById(formName);
		var cacheName = document.getElementById('<%= renderResponse.getNamespace()%>' + 'cacheName').value;

        if (cacheName === '<%= ClearCacheMVCActionConstants.CLEAR_CACHE_ALL %>') {
			if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-clear-all-cache") %>')) {
				submitForm(form);
			}
		} else if (cacheName === '<%= ClearCacheMVCActionConstants.CLEAR_CACHE_CITY %>') {
			if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-clear-cities-cache") %>')) {
				submitForm(form);
			}
		} else if (cacheName === '<%= ClearCacheMVCActionConstants.CLEAR_CACHE_STREET %>') {
			if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-clear-streets-cache") %>')) {
				submitForm(form);
			}
		}
	}

	function <portlet:namespace />setCacheName(value) {
		document.getElementById('<%= renderResponse.getNamespace()%>' + 'cacheName').value = value;
	}
</aui:script>