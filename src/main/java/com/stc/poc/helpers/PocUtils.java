package com.stc.poc.helpers;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

public class PocUtils {

	/**
	 * Retrieve the AuthId of connected user.
	 * @param request
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static String getUserAuthId(RenderRequest request) throws PortalException, SystemException {
		
		User currentUser = PortalUtil.getUser(request);
		
		return (String) currentUser.getExpandoBridge().getAttribute("authId");
		
	}

}
