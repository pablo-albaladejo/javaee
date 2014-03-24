package login;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import com.liferay.util.bridges.mvc.MVCPortlet;



public class LoginPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String userName = actionRequest.getParameter("userName");
		if(userName != null && !userName.isEmpty()){
			actionResponse.setEvent(new QName("http://localhost:8080/web/guest/module-9-test-page", "userName"), userName);
		}
		
	}
}
