/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author notnilo
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Texto {

	  ObjectMapper mapper;
	  JsonNode root;
	  Map<String, String> contextMap;
	  Map<String,List<String>> questionsMap;


	  public Texto(){
	  	 this.mapper = new ObjectMapper();
	  	 try{
	  	 	this.root = mapper.readTree(new File("gamedata.json"));
	  	 }catch(IOException e){
	  	 	System.out.println("Ha ocurrido un error al intentar leer el fichero!");
	  	 }
	  	 
	  	 this.contextMap = new HashMap<>();
	  	 this.questionsMap = new HashMap<>();

	  	 Iterator<String> fieldNames = root.fieldNames();
	  	 while(fieldNames.hasNext()){
	  	 	String key = fieldNames.next();
	  	 	JsonNode value = root.get(key);

	  	 	if(value.isTextual()){
	  	 		contextMap.put(key,value.asText());
	  	 		
	  	 	}else if(value.isArray()){
	  	 		List<String> list = new ArrayList<>();
	  	 		for(JsonNode item : value){
	  	 			if(item.isTextual()){
	  	 				list.add(item.asText());
	  	 			}
	  	 		}
	  	 		questionsMap.put(key,list);
	  	 	}
	  	 }
	  	 
	  }  

	  public String getContext(String contextName){
	  	return this.contextMap.get(contextName);
	  }

	  public String[] getQuestions(String questionName){
	  	return this.questionsMap.get(questionName).toArray(new String[0]);
	  }
}
