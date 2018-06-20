package consoleApplication;

import java.util.Random;

public class TaskGenerator extends Generator{
	
	public static String[] controleAttribute = {"Выдано", "В процессе", "Исполнено"};
	
	public static Document createTask() {
		Task task = new Task();
		makeDeliveryDate(task);
		makeDueDate(task);
		makeExecutor(task);
		makeController(task);
		makeControleAttribute(task);    	
		return task;   			
	}
    
	//генерация даты выдачи/
	public static void makeDeliveryDate(Task task){
		task.deliveryDate=RandomDate();
	}
    
	//генерация срока исполнения задания/
	public static void makeDueDate(Task task){
		task.dueDate=task.deliveryDate;//срок исполнения не может быть раньше даты выдачи    	
	}
    
	//случайный выбор исполнителя получения
	public static void makeExecutor(Task task){    	
		task.executor=NameStorage.executor[new Random().nextInt(5)];;
	}
    
	//случайный выбор контролера
	public static void makeController(Task task){    	
		task.controller=NameStorage.controller[new Random().nextInt(5)];
	}
    
	//генерация признака контрольности
	public static void makeControleAttribute(Task task){
		task.controleAttribute=controleAttribute[new Random().nextInt(3)];
	}      
}
