package ru.grusha.factory;

import ru.grusha.model.Document;

/**
 * 
 * @author Admin
 * абстрактный фабричный класс для создания документов
 */
public abstract class Factory {
	
	/**
	 * абстрактный фабричный метод, создающий доумент
	 * @return созданный документ
	 */
	public abstract Document createDocument();
}
