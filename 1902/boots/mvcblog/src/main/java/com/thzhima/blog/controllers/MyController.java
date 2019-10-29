package com.thzhima.blog.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thzhima.blog.service.UserService;





@RestController
public class MyController {
	
	@Autowired
	private UserService userService;

    @RequestMapping("/findName")
    public Map findName(String name) {
    	boolean ok = this.userService.canUse(name);
    	Map m = new HashMap();
    	if(ok) {
    		m.put("can", "ok");
    	}else {
    		m.put("can", "nook");
    	}
        return m;
    }
	
}
