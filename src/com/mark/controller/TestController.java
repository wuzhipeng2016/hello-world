package com.mark.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mark.service.BookService;
import com.mark.util.WebUtil;

@Controller
public class TestController {
	@Autowired
	private BookService bookService;
	
	private static final Log logger = LogFactory.getLog(TestController.class);
	
	@RequestMapping(value="/bb",method = RequestMethod.GET)
	public ModelAndView bb(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/book/booklist");
		return mv;
	}
	
	@RequestMapping(value="/book/getbook")
	public void getbook(HttpServletRequest request,HttpServletResponse response){
		try{
			String book = bookService.getBooks();
			PrintWriter pw = response.getWriter();
			pw.write(book);
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
	@RequestMapping(value="/book/addbook")
	public void addbook(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String,String> map = WebUtil.parseRequestData(request);
			int i = bookService.addBook(map);
			JsonObject json = new JsonObject();
			if(i<1){
				json.addProperty("errorMsg", "test errorMsg");
			}
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@RequestMapping(value="/book/delbook")
	public void delbook(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String,String> map = WebUtil.parseRequestData(request);
			int i = bookService.delBook(map);
			JsonObject json = new JsonObject();
			if(i<1){
				json.addProperty("errorMsg", "test errorMsg");
			}else{
				json.addProperty("success", "ok");
			}
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
	
	@RequestMapping(value="/book/editbook")
	public void editbook(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String,String> map = WebUtil.parseRequestData(request);
			int i = bookService.editBook(map);
			JsonObject json = new JsonObject();
			if(i<1){
				json.addProperty("errorMsg", "test errorMsg");
			}else{
				json.addProperty("success", "ok");
			}
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	

}