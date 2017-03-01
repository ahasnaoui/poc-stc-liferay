
<%@ include file="init.jsp" %>
<%@page import="com.stc.poc.model.beans.DeductionDTO"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%      
    ResultRow row = (ResultRow)   request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW); 
	DeductionDTO deduction = (DeductionDTO)row.getParameter("deduction");
  %>
  
 <portlet:renderURL var="cancelDeduction">
  <portlet:param name="idDeduction" value="<%=deduction.getId() %>" />
  <portlet:param name="action" value="cancelDeduction"></portlet:param>
  
</portlet:renderURL>

<portlet:renderURL var="editDeduction">
	<portlet:param name="idDeduction" value="<%=deduction.getId() %>" />
	<portlet:param name="action" value="EditDeduction"></portlet:param>
</portlet:renderURL>
 
 <liferay-ui:icon-menu>
  <liferay-ui:icon image="edit" message="EDIT"
   url="<%=editDeduction %>" />
 
 <liferay-ui:icon image="delete" message="CANCEL"
  url="<%=cancelDeduction %>" />
</liferay-ui:icon-menu>



