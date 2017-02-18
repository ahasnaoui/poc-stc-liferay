package com.stc.poc.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import java.util.List;

import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

public abstract class BaseController {
	
	private static Log _log = LogFactoryUtil.getLog(BaseController.class);
	
	/**
	 * Permet de naviguer � partir d'une action
	 * @param response
	 * @param jspId
	 */
	public void navigate(ActionResponse response, String jspId) {
		response.setRenderParameter("navigation", jspId);
		
	}
	
	/**
	 * Permet de setter l'onglet sur lequel naviguer
	 * @param response
	 * @param tabId
	 */
	public void setOnglet(ActionResponse response, String tabId) {
		response.setRenderParameter("tabs", tabId);
	}
	
	/**
	 * Affiche une message de confirmation
	 * @param messageKey
	 * @param request
	 */
	public void displayConfirm(String messageKey, PortletRequest request) {
		displayMessage(messageKey, request, false);
	}
	
	/**
	 * Affiche une message de confirmation
	 * @param messageKey
	 * @param request
	 */
	public void displayError(String messageKey, PortletRequest request) {
		displayMessage(messageKey, request, true);
	}
	
	/**
	 * Affiche tous les messages de la liste
	 * @param messageKeys
	 * @param request
	 */
	public void displayErrors(List<String> messageKeys, PortletRequest request) {
		
		if (messageKeys != null) {
			
			for (String key : messageKeys) {
				
				displayError(key, request);
				
			}
 			
		} else {
			_log.warn("Param messageKeys is null");
		}
		
	}
	
	/**
	 * Permet d'afficher un message
	 * @param messageKey
	 * @param request
	 * @param isError
	 */
	private void displayMessage(String messageKey, PortletRequest request, boolean isError) {
		
		if (messageKey == null) {
			_log.warn("Message key is null");
			return;
		}

		if (isError) {
			SessionErrors.add(request, messageKey);
		} else {
			SessionMessages.add(request, messageKey);
		}
		
	}

}
