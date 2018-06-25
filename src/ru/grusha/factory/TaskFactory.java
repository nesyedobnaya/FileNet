package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Task;

public class TaskFactory extends Factory{	
	
	public static Document createTask() {
		Task task = new Task();
		FactoryUtil.makeDeliveryDate(task);
		FactoryUtil.makeDueDate(task);
		FactoryUtil.makeExecutor(task);
		FactoryUtil.makeController(task);
		FactoryUtil.makeControleAttribute(task);    	
		return task;   			
	}	    
}
