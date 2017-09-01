package interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("½øÈëÀ¹½ØÆ÷");
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		Object obj = session.getAttribute("existEmployee");
		if(obj!=null) {
			
			return invocation.invoke();
		}else{
			
		return "input";	
		
		}
	}
	

}
