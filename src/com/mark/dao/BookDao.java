package com.mark.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDao {
	@Autowired
	private DataSource dataSource;

	public List<Map<String,Object>> getBooks(){
		try{
			QueryRunner queryRunner = new QueryRunner();
			Connection conn = dataSource.getConnection(); 
			List<Map<String, Object>> list = queryRunner.query(conn,  
	                "select * from users", new MapListHandler(),  
	                (Object[]) null);
			conn.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	public int addBook(Map<String, String> map) {
		try{
			Connection conn = dataSource.getConnection(); 
			QueryRunner queryRunner = new QueryRunner();
			String sql="insert into users(firstname,lastname,phone,email)"
					+" values(?,?,?,?)";
			queryRunner.update(conn,sql,map.get("FIRSTNAME"),map.get("LASTNAME"),map.get("PHONE"),map.get("EMAIL"));
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	public int delBook(Map<String, String> map) {
		try{
			Connection conn = dataSource.getConnection(); 
			QueryRunner queryRunner = new QueryRunner();
			String sql="delete from users where firstname=?";
			queryRunner.update(conn,sql,map.get("FIRSTNAME"));
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	public int editBook(Map<String, String> map) {
		try{
			Connection conn = dataSource.getConnection(); 
			QueryRunner queryRunner = new QueryRunner();
			String sql="update users set lastname=?,phone=?,email=? where firstname=?";
			queryRunner.update(conn,sql,map.get("LASTNAME"),map.get("PHONE"),map.get("EMAIL"),map.get("FIRSTNAME"));
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
}
