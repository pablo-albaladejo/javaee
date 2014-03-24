<%

%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<form action='<portlet:actionURL/>' method='post'>
	Name <input type='text' name='userName'><br/>
	<button type="submit">send</button>
</form>