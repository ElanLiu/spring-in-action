package com.springinaction.di.impl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.springinaction.di.HolyGrail;
import com.springinaction.di.service.Knight;
import com.springinaction.di.service.Quest;

public class KnightOfTheRoundTable implements Knight{
	
	@SuppressWarnings("unused")
	private String name;
	private Quest quest;
	
	public KnightOfTheRoundTable(){}
	
	public KnightOfTheRoundTable(String name){
		this.name = name;
		System.out.println("My name is: " + name);
	}

	@Override
	public HolyGrail embarkOnQuest() throws Exception {
		return quest.embark();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}
	
	public String getName() {
		return name;
	}

	public Quest getQuest() {
		return quest;
	}

	public static class inner{
		public static void main(String[] args) throws Exception{
			/*BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring/di/knight.xml"));
			Knight knight = (Knight) factory.getBean("knightOfTheRoundTable");
			knight.embarkOnQuest();*/
			
			ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/knight.xml");
			Knight knight = (Knight) context.getBean("knightOfTheRoundTable");
			knight.embarkOnQuest();
			
		}
	}

}
