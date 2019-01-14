package org.fangsoft.testcenter.dao;

import java.util.List;

import org.hzp.testcenter.model.Test;

public interface TestDao {
	public Test findTestByName(String testName);
	public List<Test> findAllTest();
}
