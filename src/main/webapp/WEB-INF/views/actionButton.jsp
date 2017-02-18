
<%@page import="com.stc.poc.model.beans.DeductionDTO"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%      
    ResultRow row = (ResultRow)   request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW); 
	DeductionDTO deduction = (DeductionDTO)row.getParameter("deduction");
  %>
  
 <portlet:actionURL var="cancelDeduction" windowState="normal" name="cancelDeduction">
  <portlet:param name="idDeduction" value="<%=deduction.getId() %>" />
  
</portlet:actionURL>

<portlet:actionURL var="editDeduction" windowState="normal" name="editDeduction">
	<portlet:param name="state" value="<%=deduction.getState() %>" />
</portlet:actionURL>
 
 <liferay-ui:icon-menu>
  <liferay-ui:icon image="edit" message="EDIT"
   url="<%=editDeduction  %>" />
 
 <liferay-ui:icon image="delete" message="CANCEL"
  url="<%= cancelDeduction %>" />
</liferay-ui:icon-menu>



