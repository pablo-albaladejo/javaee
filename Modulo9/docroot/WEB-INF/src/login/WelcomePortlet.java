package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

public class WelcomePortlet extends MVCPortlet{

	@Override
	public void processEvent(EventRequest request, EventResponse response)
			throws PortletException, IOException {
		
		String userName = (String)request.getEvent().getValue();
		response.setRenderParameter("userName", userName);
		
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		String userName = request.getParameter("userName");
		
		if(userName != null && !userName.isEmpty()){
			PrintWriter pw = response.getWriter();
			pw.write("Welcome "+userName+"!!");
		}
	}
	
}
