package com.mark.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mark.util.WebUtil;

@Controller
public class BackBoneController {

	@RequestMapping(value="/backbone/list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/backbone/list");
		return mv;
		
//		try{
//			String book=" this is book";
//			PrintWriter pw = response.getWriter();
//			pw.write(book);
//			pw.flush();
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
	}	
	
	@RequestMapping(value="/backbone/get")
	public void get(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String,String> map1 = WebUtil.parseRequestData(request);
			map1.put("AA", "aaaa");
			map1.put("BB", "bbbb");
			String book=" this is book";
			PrintWriter pw = response.getWriter();
			pw.write((new Gson()).toJson(map1));
			System.out.println(map1.toString());
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@RequestMapping(value="/backbone/save")
	public void save(@RequestBody String json,HttpServletRequest request,HttpServletResponse response){
		try{
			String f = request.getParameter("firstname");
			String f2 = String.valueOf(request.getAttribute("firstname"));
			Map<String,String> map1 = WebUtil.parseRequestData(request);
//			map1.put("AA", "aaaa");
//			map1.put("BB", "bbbb");
			String book=" this is book";
			PrintWriter pw = response.getWriter();
			System.out.println(json);
			pw.write(json);
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@RequestMapping(value="/backbone/add")
	public void add(@RequestBody String json,HttpServletRequest request,HttpServletResponse response){
		try{
			String f = request.getParameter("firstname");
			String f2 = String.valueOf(request.getAttribute("firstname"));
			Map<String,String> map1 = WebUtil.parseRequestData(request);
			
			map1= (new Gson()).fromJson(json, new TypeToken<Map<String, String>>(){}.getType());
			
			map1.put("AA", "aaaa");
			map1.put("BB", "bbbb");
			String book=" this is book";
			PrintWriter pw = response.getWriter();
			pw.write((new Gson()).toJson(map1));
			System.out.println(map1.toString());
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
