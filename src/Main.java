import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {

    	//Objeto texto para comunicarse entre el programa y el texto del archivo gamedata.json
    	Texto t = new Texto();
        Scanner leer = new Scanner(System.in);
        Arbol arbol = generarArbol(t);

        // Asignacion hoja de sostenibilidad
        ArbolTools.assignSustainabilityLeaf(arbol.getRaiz(),t);

        // Runnable corresponde a una tarea que se le asignara al hilo.
        Runnable tareaTexto = new Runnable() {
            @Override
            public void run() {
                jugar(arbol, leer);
            }
        };
        
		//Uso del hilo para mantener separado la logica del programa en texto
        Thread hiloTexto = new Thread(tareaTexto);
        hiloTexto.start();
    }

    	public static void jugar(Arbol arbol, Scanner leer) {
    	        String entrada = "";
    	        Nodo actual = arbol.getRaiz();
    			//Se repite mientras que la entrada no sea salir
    	        while (!entrada.equalsIgnoreCase("salir")) {

    	        	//Print al nombre del nodo que en este caso seria el nombre del bioma
    	            if (!(actual == arbol.getRaiz())) {
    	                System.out.println("Bienvenido al Ecosistema " + actual.getNombre());
    	            }

					//El contexto es un resumen o descripcion del bioma y/o sus problematicas
    	            System.out.println(actual.getContexto());
    	
    	            if (!(actual == arbol.getRaiz())) {
    	            	/*Si ya se visito el nodo, entonces no se hace pregunta, por el contrario nada mas se escoge la direccion
    	            	del jugador.*/
    	                if (actual.isVisitado()) {
    	                    System.out.print("Ingrese 'izquierda', 'derecha', 'regresar' o 'salir': ");
    	                    entrada = leer.nextLine();
    	                    if (entrada.equalsIgnoreCase("izquierda")) {
    	                        if (actual.getIzq() != null) {
    	                            actual = actual.getIzq();
    	                        } else {
    	                            System.out.println("No hay nodo a la izquierda.");
    	                        }
    	                    } else if (entrada.equalsIgnoreCase("derecha")) {
    	                        if (actual.getDer() != null) {
    	                            actual = actual.getDer();
    	                        } else {
    	                            System.out.println("No hay nodo a la derecha.");
    	                        }
    	                    } else if (entrada.equalsIgnoreCase("regresar")) {
    	                        if (actual != arbol.getRaiz()) {
    	                            actual = actual.getPadre();
    	                        } else {
    	                            System.out.println("Est├ís en la ra├¡z, no puedes regresar.");
    	                        }
    	                    }   
    	                } else {
							//En el caso contrario se le hacen preguntas al jugador.
    	                    boolean correcto = false;
    	                    int pregunta = 0;
    	                    while (!correcto) {
    	                    	//En el nodo esta guardado la pregunta
    	                        System.out.println(actual.getTrivia()[pregunta]);
    	                        String respuesta = leer.nextLine();
    	                        //Cada pregunta tiene su respuesta en el indice que le sigue
    	                        //[Pregunta 1, Respuesta 1, Pregunta 2, Respuesta 2, Pregunta 3, Respuesta 3]
    	                        if (respuesta.equalsIgnoreCase(actual.getTrivia()[pregunta + 1])) {
    	                            System.out.println("┬íAcertaste!");
    	                            correcto = true;
    	                            //Consideramos el nodo como visitado.
    	                            actual.setVisitadoTrue();

									/*Para dar pista al jugador se muestra el mapa si se llega y acierta una respuesta en
								      un nodo hoja (ArbolTools.isLeaf())
									*/
									if(ArbolTools.isLeaf(actual) && !(actual.getNombre().equalsIgnoreCase("Sostenibilidad")) ){
										mostrarMapa(arbol);
									}

									
									//Si se acerto y es el nodo sostenibilidad entonces se gana y sale del juego.
									if(actual.getNombre().equalsIgnoreCase("Sostenibilidad")){
										System.out.println("FELICIDADES! GANASTES EL JUEGO!!!");
										System.exit(0);
									}
									//Se escoge la direccion.
    	                            System.out.print("Ingrese 'izquierda', 'derecha', 'regresar' o 'salir': ");
    	                            entrada = leer.nextLine();
    	                            if (entrada.equalsIgnoreCase("izquierda")) {
    	                                if (actual.getIzq() != null) {
    	                                    actual = actual.getIzq();
    	                                } else {
    	                                    System.out.println("No hay nodo a la izquierda.");
    	                                }
    	                            } else if (entrada.equalsIgnoreCase("derecha")) {
    	                                if (actual.getDer() != null) {
    	                                    actual = actual.getDer();
    	                                } else {
    	                                    System.out.println("No hay nodo a la derecha.");
    	                                }
    	                            } else if (entrada.equalsIgnoreCase("regresar")) {
    	                                if (actual != arbol.getRaiz()) {
    	                                    actual = actual.getPadre();
    	                                } else {
    	                                    System.out.println("Est├ís en la ra├¡z, no puedes regresar.");
    	                                }
    	                            }
    	                        } else {
    	                            System.out.println("Incorrecto... Aqu├¡ est├í otra pregunta:");
    	                            //Se pasa a la siguiente pregunta en caso de no acertar la primera.
    	                            pregunta += 2;
    	                            //Si se llega a la ultima pregunta y el jugador falla entonces se devuelve a la primera pregunta.
    	                            if (pregunta > 5) {
    	                                pregunta = 0;
    	                            }
    	                        }
    	                    }
    	                }
    	            } else {

    	            	//Se es coge la direccion.
    	                System.out.print("Ingrese 'izquierda', 'derecha', 'regresar' o 'salir': ");
    	                entrada = leer.nextLine();
    	                if (entrada.equalsIgnoreCase("izquierda")) {
    	                    if (actual.getIzq() != null) {
    	                        actual = actual.getIzq();
    	                    } else {
    	                        System.out.println("No hay nodo a la izquierda.");
    	                    }
    	                } else if (entrada.equalsIgnoreCase("derecha")) {
    	                    if (actual.getDer() != null) {
    	                        actual = actual.getDer();
    	                    } else {
    	                        System.out.println("No hay nodo a la derecha.");
    	                    }
    	                } else if (entrada.equalsIgnoreCase("regresar")) {
    	                    if (actual != arbol.getRaiz()) {
    	                        actual = actual.getPadre();
    	                    } else {
    	                        System.out.println("Est├ís en la ra├¡z, no puedes regresar.");
    	                    }
    	                }
    	            }
    	        }
    	    }
    	
    	    private static Arbol generarArbol(Texto t) {

    	            Arbol arbol = new Arbol();
    	        	//Añadimos los contextos de los biomas a los nodos. Añadimos las preguntas a los nodos. Añadimos padres a los nodos.
    	            Nodo nodo0 = new Nodo(0, "Bienvenido", t.getContext("instrucciones"), null, null);
    	            Nodo nodo1 = new Nodo(-4, "Terrestre", t.getContext("contextoTerrestre"), t.getQuestions("triviaTerrestre"), nodo0);
    	            Nodo nodo2 = new Nodo(4, "Acuatico", t.getContext("contextoAcuatico"), t.getQuestions("triviaAcuatico"), nodo0);
    	            Nodo nodo3 = new Nodo(-6, "Bosque", t.getContext("contextoBosque"), t.getQuestions("triviaBosque"), nodo1);
    	            Nodo nodo4 = new Nodo(-2, "Pradera", t.getContext("contextoPradera"), t.getQuestions("triviaPradera"), nodo1);
    	            Nodo nodo5 = new Nodo(2, "Agua Dulce", t.getContext("contextoAguaDulce"), t.getQuestions("triviaAguaDulce"), nodo2);
    	            Nodo nodo6 = new Nodo(6, "Agua Salada", t.getContext("contextoAguaSalada"), t.getQuestions("triviaAguaSalada"), nodo2);
    	            Nodo nodo7 = new Nodo(-7, "Selva Tropical", t.getContext("contextoSelvaTropical"), t.getQuestions("triviaSelvaTropical"), nodo3);
    	            Nodo nodo8 = new Nodo(-5, "Bosque Templado", t.getContext("contextoBosqueTemplado"), t.getQuestions("triviaBosqueTemplado"), nodo3);
    	            Nodo nodo9 = new Nodo(-3, "Sabana", t.getContext("contextoSabana"), t.getQuestions("triviaSabana"), nodo4);
    	            Nodo nodo10 = new Nodo(-1, "Estepa", t.getContext("contextoEstepa"), t.getQuestions("triviaEstepa"), nodo4);
    	            Nodo nodo11 = new Nodo(1, "Rio", t.getContext("contextoRio"), t.getQuestions("triviaRio"), nodo5);
    	            Nodo nodo12 = new Nodo(3, "Lago", t.getContext("contextoLago"), t.getQuestions("triviaLago"), nodo5);
    	            Nodo nodo13 = new Nodo(5, "Oceano", t.getContext("contextoOceano"), t.getQuestions("triviaOceano"), nodo6);
    	            Nodo nodo14 = new Nodo(7, "Arrecife", t.getContext("contextoArrecife"), t.getQuestions("triviaArrecife"), nodo6);
    	        
    	            arbol.insertar(nodo0);
    	            arbol.insertar(nodo1);
    	            arbol.insertar(nodo2);
    	            arbol.insertar(nodo3);
    	            arbol.insertar(nodo4);
    	            arbol.insertar(nodo5);
    	            arbol.insertar(nodo6);
    	            arbol.insertar(nodo7);
    	            arbol.insertar(nodo8);
    	            arbol.insertar(nodo9);
    	            arbol.insertar(nodo10);
    	            arbol.insertar(nodo11);
    	            arbol.insertar(nodo12);
    	            arbol.insertar(nodo13);
    	            arbol.insertar(nodo14);
    	        
    	            return arbol;
    	        }
    	    
			//SwingUtilites.invokeLater() es una forma de invocar un hilo que tiene como proposito renderizar graficos.
			private static void mostrarMapa(Arbol arbol){

					SwingUtilities.invokeLater(() -> {
						 //Le pasamos el arbol a Interfaz para que lo dibuje
 		   				 Interfaz gui = new Interfaz(arbol);
 		   				 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		   				 gui.setVisible(true);
 					});
				
			}
    	    
    	}
    	

   
    
