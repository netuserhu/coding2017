package com.github.Ven13.coding2017.litestruts;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;





public class StrutsTest {

	@Test
	public void testLoginActionSuccess() {
		
		String actionName = "login";
        
		Map<String,String> params = new HashMap<String,String>();
        params.put("name","test");
        params.put("password","1234");
        
        
        View view  = Struts.runAction(actionName,params);        
        
        Assert.assertEquals("/jsp/homepage.jsp", view.getJsp());
        Assert.assertEquals("login successful", view.getParameters().get("message"));
	}

	@Test
	public void testLoginActionFailed() {
		String actionName = "login";
		Map<String,String> params = new HashMap<String,String>();
        params.put("name","test");
        params.put("password","123456"); //瀵嗙爜鍜岄璁剧殑涓嶄竴鑷�
        
        View view  = Struts.runAction(actionName,params);        
        
        Assert.assertEquals("/jsp/showLogin.jsp", view.getJsp());
        Assert.assertEquals("login failed,please check your user/pwd", view.getParameters().get("message"));
	}
}