package myCommunity.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import myCommunity.entity.User;

@SuppressWarnings("serial")
public class SecurityInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("loginUser");
		if(user!=null) {
			return ai.invoke();
		}else {
			return "login";
		}
	}

}
