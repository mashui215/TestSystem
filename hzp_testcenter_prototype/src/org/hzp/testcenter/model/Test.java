package org.hzp.testcenter.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
	private String name;
	private String description;
	private int score;
	private List<Question> question;
	private int timeLimitMin;
	private int numQuestion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public int getTimeLimitMin() {
		return timeLimitMin;
	}

	public void setTimeLimitMin(int timeLimitMin) {
		this.timeLimitMin = timeLimitMin;
	}

	public int getNumQuestion() {
		return numQuestion;
	}

	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}

	public Test() {
		//this.numQuestion = numQuestion;
		question = new ArrayList<Question>();
	}
	
	 
	public void addQuestion(Question q){
		 this.question.add(q);
	}
	

}
