package com.example.ex01.mappers;

import org.apache.ibatis.annotations.Select;

public interface annotationMapperTest {
	
	@Select("select now()")
	public String getTime();
	
	public String getTime2();
}
