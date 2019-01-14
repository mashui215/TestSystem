package org.hzp.testcenter.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String name;
	private String answer;
	private int score;
/*	private ChoiceItem[] choiceItem;*/
	private List<ChoiceItem> choiceItem;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<ChoiceItem> getChoiceItem() {
		return this.choiceItem;
	}

	public void setChoiceItem(List<ChoiceItem> choiceItem) {
		this.choiceItem = choiceItem;
	}

	public Question() {
		choiceItem = new ArrayList<ChoiceItem>();
	}


	public void addChoiceItem(ChoiceItem itme) {
		 this.choiceItem.add(itme);
	}

	public void assignLabel(String[] label) {
		int count = 0;
		StringBuffer rightAnswer = new StringBuffer();
		if (this.choiceItem != null) {
			for (ChoiceItem item : choiceItem) {
				item.setLable(label[count++]);
				if (item.isCorrect()){
					rightAnswer.append(label[count - 1]);
				}
			}
		}
		this.setAnswer(rightAnswer.toString());
	}

}
