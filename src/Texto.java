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

	  /*El objeto mapper es un "traductor" entre archivos JSON y objetos java.
		en caso de tener una instancia de una clase al usar el mapper para escribir, esta escribe en un archivo .json los atributos
		del objeto y sus valores. Si se usa para leer, entonces lee el JSON y retorna un objeto de la clase con la que se creo el JSON.
		(Es una forma de rapidamente serializar y deserializar datos)
	  */
	  ObjectMapper mapper;

	  /*El objeto root de la clase JsonNode se encarga de convertir un archivo .JSON en una estrcutura de datos dinamica, en este
		caso JsonNode trata un archivo .JSON como un arbol de modo que los datos o atributos del .JSON estan anidados uno dentro del otro
		, cuando se carga el objeto root, entonces se puede acceder a su informacion con metodos como root.get("instrucciones"), lo que
		retorna el valor de la llave(Key) instrucciones (Similar a un HashMap)
	  */
	  JsonNode root;
	  //HashMap de contexto y de preguntas, tienen como proposito cargar el .JSON en memoria como un mapa que relaciona los biomas 
	  // con sus contextos, preguntas y respuestas.
	  Map<String, String> contextMap;
	  Map<String,List<String>> questionsMap;


	  public Texto(){
	  	 this.mapper = new ObjectMapper();
	  	 try{
	  	 	//Leemos gamedata.json y lo tratamos como un arbol.
	  	 	this.root = mapper.readTree(new File("gamedata.json"));
	  	 }catch(IOException e){
	  	 	System.out.println("Ha ocurrido un error al intentar leer el fichero!");
	  	 }
	  	 
	  	 this.contextMap = new HashMap<>();
	  	 this.questionsMap = new HashMap<>();

		 //Asignamos a fieldnames todos las llaves(keys) del arbol, estas claves nos llevan a los contextos, preguntas y respuestas.
	  	 Iterator<String> fieldNames = root.fieldNames();
	  	 while(fieldNames.hasNext()){
	  	 	//Iteramos en cada key una por una
	  	 	String key = fieldNames.next();
	  	 	//hacemos get del valor de la clave.
	  	 	JsonNode value = root.get(key);

	  	 	if(value.isTextual()){
	  	 		//.isTextual() es similar a .IsString(), en caso de ser de tipo String, sabemos que es un contexto de un bioma
	  	 		//asignamos el contexto al HashMap de contextos.
	  	 		contextMap.put(key,value.asText());
	  	 		
	  	 	}else if(value.isArray()){
	  	 		//.isArray() es para determinar si es de tipo array o lista (Conjunto de valores), en caso de serlo
	  	 		//iteramos sobre los items del arreglo con un foreach para agregarlo a una lista
	  	 		//ponemos la lista junto a su key en el HashMap de las preguntas (junto a la pregunta tambien van las respuestas en la lista)
	  	 		
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

	  //getters, retornan los valores de las keys en el hashmap.
	  public String getContext(String contextName){
	  	return this.contextMap.get(contextName);
	  }

	  public String[] getQuestions(String questionName){
	  	return this.questionsMap.get(questionName).toArray(new String[0]);
	  }
}
