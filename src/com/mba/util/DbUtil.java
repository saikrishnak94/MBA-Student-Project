package com.mba.util;

import org.springframework.jdbc.core.JdbcTemplate;

public class DbUtil {
	static private JdbcTemplate jdbcTemplate;
	public static JdbcTemplate getTemplate(){
		if(jdbcTemplate!=null){
			jdbcTemplate = new JdbcTemplate();
		}
		return jdbcTemplate;
	}
}
