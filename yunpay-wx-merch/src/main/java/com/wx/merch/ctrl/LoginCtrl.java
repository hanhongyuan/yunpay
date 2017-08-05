package com.wx.merch.ctrl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wx.merch.rep.Message;


@RestController
@RequestMapping("/rest")
public class LoginCtrl {
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
    public Object get(String loginName,String loginPwd){
        System.out.println("get"+loginName);
        System.out.println("get"+loginPwd);
        return new Message("哈哈");
    }
    
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public Object post(HttpServletRequest req){
    	System.out.println("post"+req.getParameter("loginName"));
        System.out.println("post"+req.getParameter("loginPwd"));
        return new Message("哈哈");
    }
    
    @RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id){
        System.out.println("put"+id);
        return "/hello";
    }
    
    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete"+id);
        return "/hello";
    }
}
