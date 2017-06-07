package com.mark.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mark.dao.BookDao;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	public String getBooks(){
		try{
			List<Map<String,Object>> list = bookDao.getBooks();
			Gson gson = new Gson();
			return gson.toJson(list);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
	public int addBook(Map<String,String> map){
		return bookDao.addBook(map);
	}
	public int delBook(Map<String,String> map){
		return bookDao.delBook(map);
	}
	public int editBook(Map<String, String> map) {
		return bookDao.editBook(map);
	}
}
