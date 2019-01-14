package org.fangsoft.testcenter.dao.array;

import java.util.ArrayList;
import java.util.List;

import org.fangsoft.testcenter.dao.TestDao;
import org.hzp.testcenter.data.TestData;
import org.hzp.testcenter.model.Test;

public class TestArrayDao implements TestDao {
	
	private static final TestDao tdao = new TestArrayDao(); 
	
	private static final TestDao getInstance(){
		return tdao;
	}
  
	private TestArrayDao(){};
	
	@Override
	public Test findTestByName(String testName) {
		
		for(String[][] data:TestData.allTest){
			if(data[0][0].equals(testName)){
				return TestData.newTest(data);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> findAllTest() {
		
		ArrayList<Test> tests = new ArrayList<Test>(TestData.allTest.length);
		for(String[][] data:TestData.allTest){
			tests.add(TestData.newTest(data));
		}
		tests.trimToSize();
		return tests;
	}

}
