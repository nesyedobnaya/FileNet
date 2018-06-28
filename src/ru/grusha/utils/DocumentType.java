package ru.grusha.utils;

import ru.grusha.factory.Factory;
import ru.grusha.factory.IncomingFactory;
import ru.grusha.factory.OutgoingFactory;
import ru.grusha.factory.TaskFactory;

/**
 * 
 * @author nesyedobnaya
 * перечень типов документов
 */
public enum DocumentType {
	
	INCOMING(new IncomingFactory()), TASK(new TaskFactory()), OUTGOING(new OutgoingFactory());
	
	private final Factory factory;
	
	DocumentType(Factory factory) {
		this.factory = factory;
	}

	public Factory getFactory() {
		return factory;
	} 
}
