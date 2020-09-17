package com.spring.demo;

import java.util.List;
import java.util.Map;

public class Test3 {
	private String aaa;
	
	private List<String> testList;
	private Map<String , String> testMap;
	private Map<String , Info> testMapObj;
	
	
	public String getAaa() {
		return aaa;
	}
	public void setAaa(String val) {
		this.aaa = val;
	}
	public List<String> getTestList() {
		return testList;
	}
	public void setTestList(List<String> testList) {
		this.testList = testList;
	}
	public Map<String, String> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
	public Map<String, Info> getTestMapObj() {
		return testMapObj;
	}
	public void setTestMapObj(Map<String, Info> testMapObj) {
		this.testMapObj = testMapObj;
	}
	
}
