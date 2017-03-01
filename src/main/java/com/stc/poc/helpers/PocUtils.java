package com.stc.poc.helpers;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

public class PocUtils {

	/**
	 * Retrieve the AuthId of connected user.
	 * @param actionRequest
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static String getUserAuthId(PortletRequest actionRequest) throws PortalException, SystemException {
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		return (String) currentUser.getExpandoBridge().getAttribute("authId");
		
	}

}
