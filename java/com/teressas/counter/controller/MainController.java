package com.teressas.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController {
	
	
	@GetMapping("/counter")
	public String setCount(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			// if session is available, cast the session count as integer, then add 1
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count",count+1);
		}
		return "setCount.jsp";
	}
	
	@GetMapping("/{addCount}")
	public String setCount(HttpSession session, @PathVariable("addCount") Integer addCount) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", addCount);
		} else {
			
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count",count+addCount);
		}
		return "setCount.jsp";
	}
	
	@GetMapping("")
	public String getCount() {
		return "index.jsp";
	}

	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		
		return "redirect:/your_server/counter";
	}
}
