package ru.grusha.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.grusha.model.Document;
import ru.grusha.staff.Person;

public class JsonFileWriter {
	
	public void reportToAFile(Person author, List<Document> documentsOfAuthor){
		
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try (FileWriter writer = new FileWriter("D://XML/"+author.getLastName()+".json")){						
			String json = gson.toJson(documentsOfAuthor);
			writer.write(json);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}