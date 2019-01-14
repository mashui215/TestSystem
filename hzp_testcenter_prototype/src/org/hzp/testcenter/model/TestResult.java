package org.hzp.testcenter.model;

import java.util.List;
import org.hzp.testcenter.model.QuestionResult;

public class TestResult {
	private Customer customer;
	// private int score;
	private Test test;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private List<QuestionResult> questionResult;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public java.util.Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public List<QuestionResult> getQuestionResult() {
		return questionResult;
	}

	public void setQuestionResult(List<QuestionResult> questionResult) {
		this.questionResult = questionResult;
	}

	private static final int UNKNOW_SCORE = 0;
	private static final int UNKNOW_PASS = -1;
	private static final int PASS_SUCCESS = 1;
	private static final int PASS_FAILURE = 0;
	private int score = UNKNOW_SCORE; // 新建,考试得分未知
	private int pass = UNKNOW_PASS; // 新建,考试通过结果未知

	protected int computeScore() {
		if (this.score != UNKNOW_SCORE)
			return this.score;
		if (this.score == UNKNOW_SCORE)
			this.score = 0;
		for (QuestionResult qr : this.questionResult) {
			this.score += qr.computeAnswer();
		}
		return this.score;
	}

	protected boolean computePass() {
		if (this.pass != UNKNOW_PASS) {
			return this.pass == PASS_SUCCESS ? true : false;
		}
		int rights = 0;
		for (QuestionResult qr : this.questionResult) {
			if (qr.isResult()) {
				rights++;
			}
		}
		if (100 * rights >= 70 * this.getQuestionResult().size()) {
			this.pass = PASS_SUCCESS;
			return true;
		} else {
			this.pass = PASS_FAILURE;
			return false;
		}
	}
	
	public boolean commitTest(){
		this.computeScore();
		return this.computePass();
	}


}
