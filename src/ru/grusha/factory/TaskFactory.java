package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Task;
import ru.grusha.utils.FactoryUtil;

public class TaskFactory extends Factory{	
	
	public static Document createTask() {
		Task task = new Task();
		task.setDeliveryDate(FactoryUtil.getRandomDate(10000));
		task.setDueDate(FactoryUtil.getRandomDate(10000));
		task.setExecutor(FactoryUtil.randomPerson());  
		task.setController(FactoryUtil.randomPerson());
		task.setControleAttribute(Math.random() < 0.5);    	
		return task;   			
	}	   
}
