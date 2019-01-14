package org.hzp.testcenter.application;

import static org.hzp.util.Console.output;
import static org.hzp.util.Console.prompt;
import static org.hzp.util.Console.promptYesNo;

import java.util.ArrayList;
import java.util.Date;

import org.hzp.testcenter.config.Configuration;
import org.hzp.testcenter.data.CustomerData;
import org.hzp.testcenter.data.TestData;
import org.hzp.testcenter.model.ChoiceItem;
import org.hzp.testcenter.model.Customer;
import org.hzp.testcenter.model.Question;
import org.hzp.testcenter.model.QuestionResult;
import org.hzp.testcenter.model.Test;
import org.hzp.testcenter.model.TestResult;
import org.hzp.util.Console;

public class TestCenter {
	
	public static void welcome() {
		output("�����ǣ�" + Configuration.getDateFormat().format(new Date()));
		output("��Ĳ���ϵͳ�ǣ�" + System.getProperty("os.name"));
	}

	private static Customer findCustomer(String userId, String password) {
		Customer[] customers = CustomerData.getCustomer();
		for (int i = 0; i < customers.length; i++) {
			Customer c = customers[i];
			if (c.getUserId().equals(userId) && c.getPassword().equals(password)) {
				return customers[i];
			}
		}
		return null;
	}

	public static Customer login() {
		output("�μӿ���ǰ���ȵ�¼,������ɺ�enterȷ��:");
		for (int i = 0; i < Configuration.MAX_LOGIN; i++) {
			String userId = prompt("�����û����ƣ�");
			String password = prompt("�����û����룺");
			Customer customer = findCustomer(userId, password);
			if (customer != null) {
				output("��ӭ" + customer.getUserId() + "����java��������!");
				return customer;
			}
			output("�û�������������ܵ�¼,���µ�¼." + "��¼" + Configuration.MAX_LOGIN + "�β��ɹ���ϵͳ���˳�." + "����" + (i + 1) + "��");
		}
		return null;
	}

	private static void exit(Object msg) {
		output(msg);
		System.exit(1);
	}

	private static TestResult newTestResult(Customer c, Test test) {
		TestResult tr = new TestResult();
		tr.setCustomer(c);
		tr.setTest(test);
		tr.setStartTime(new Date());
		tr.setQuestionResult(new ArrayList<QuestionResult>());
		for (Question q : test.getQuestion()) {
			q.assignLabel(Configuration.CHOICE_LABEL);
			QuestionResult qr = new QuestionResult();
			qr.setQuestion(q);
			tr.getQuestionResult().add(qr);
		}
		return tr;
	}

	public static String presentQuestion(int pos, Question q) {
		Console.output("%1$s. %2$s%n", pos, q.getName());
		for (ChoiceItem item : q.getChoiceItem()) {
			Console.output("   %1$s. %2$s%n", item.getLable(), item.getName());
		}
		Console.output("����𰸣�");
		return Console.read();
	}

	public static TestResult takeTest(Test test, Customer customer) {
		output("==========��ʼ����===========");
		output("�������ƣ�%1$5s%n" + "���Լ�����%2$5s%n" + "�������⣺%3$5s%n" + "����ʱ�䣺%4$5s����%n", test.getName(),
				test.getDescription(), test.getNumQuestion(), test.getTimeLimitMin());
		long start = System.currentTimeMillis();
		output("ע������%1$s���Ӵ��⣬����ʱ���ǣ�%2$tT%n", test.getTimeLimitMin(), start);
		TestResult tr = newTestResult(customer, test);
		int count = 0;
		for (QuestionResult qr : tr.getQuestionResult()) {
			String answer = presentQuestion(++count, qr.getQuestion());
			qr.setAnswer(answer);
		}
		long end = System.currentTimeMillis();
		tr.setEndTime(new Date(end));
		tr.commitTest();
		output("���Խ���������ʱ���ǣ�%1$tT%n", end);
		return tr;
	}

	public static void reportTestResult(TestResult tr) {
		output("==========���Ա���===========");
		long duration = (tr.getEndTime().getTime() - tr.getStartTime().getTime()) / (1000 * 60);
		output("�㻨��%1$s���ӿ���%n", duration);
		output("%1$-6s%2$-6s%3$-6s%4$-6s%n", "���", "��Ĵ�", "��ȷ��", "�Դ�");
		int count = 0;
		for (QuestionResult qr : tr.getQuestionResult()) {
			output("%1$-8s%2$-8s%3$-8s%4$-8s%n", ++count, qr.getAnswer(), qr.getQuestion().getAnswer(),
					qr.isResult() ? "right" : "wrong");
		}
		boolean pass = tr.getScore() > 0 ? true : false;
		String displayPass = "";
		if (pass)
			displayPass = "��ϲ����ͨ���˿���";
		else
			displayPass = "���ź�����û��ͨ������";
		output("�㿼�Եĵ÷��ǣ�" + tr.getScore() + "," + displayPass);
	}

	public static void main(String[] args) {
		welcome();
		Customer customer = login();
		if (customer == null) {
			exit("�û������������ܵ�¼��ϵͳ�˳�");
		}
		boolean response = promptYesNo("ȷ�ϲμӿ�����", "y", "�ǣ�y", "��,�˳���n");
		if (!response)
			exit("ϵͳ�˳�");
		Test test = TestData.produceTest();
		TestResult tr = takeTest(test, customer);
		reportTestResult(tr);
	}

}
