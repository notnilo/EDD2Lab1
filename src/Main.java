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
    	Texto t = new Texto();
        Scanner leer = new Scanner(System.in);
        Arbol arbol = generarArbol(t);

        // Asignacion hoja de sostenibilidad
        ArbolTools.assignSustainabilityLeaf(arbol.getRaiz(),t);

        // Hilo del CLI
        Runnable tareaTexto = new Runnable() {
            @Override
            public void run() {
                jugar(arbol, leer);
            }
        };

        Thread hiloTexto = new Thread(tareaTexto);
        hiloTexto.start();
    }

    	public static void jugar(Arbol arbol, Scanner leer) {
    	        String entrada = "";
    	        Nodo actual = arbol.getRaiz();
    	
    	        while (!entrada.equalsIgnoreCase("salir")) {
    	            if (!(actual == arbol.getRaiz())) {
    	                System.out.println("Bienvenido al Ecosistema " + actual.getNombre());

    	                
    	            }
    	            System.out.println(actual.getContexto());
    	
    	            if (!(actual == arbol.getRaiz())) {
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
    	                    boolean correcto = false;
    	                    int pregunta = 0;
    	                    while (!correcto) {
    	                        System.out.println(actual.getTrivia()[pregunta]);
    	                        String respuesta = leer.nextLine();
    	                        if (respuesta.equalsIgnoreCase(actual.getTrivia()[pregunta + 1])) {
    	                            System.out.println("┬íAcertaste!");
    	                            correcto = true;
    	                            actual.setVisitadoTrue();

									if(ArbolTools.isLeaf(actual) && !(actual.getNombre().equalsIgnoreCase("Sostenibilidad")) ){
										mostrarMapa(arbol);
									}

									if(actual.getNombre().equalsIgnoreCase("Sostenibilidad")){
										System.out.println("FELICIDADES! GANASTES EL JUEGO!!!");
										System.exit(0);
									}
    	                            
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
    	                            pregunta += 2;
    	                            if (pregunta > 5) {
    	                                pregunta = 0;
    	                            }
    	                        }
    	                    }
    	                }
    	            } else {
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
    	    

    	    private static void toJSON(){
    	    	try{

					ObjectMapper mapper = new ObjectMapper();
					Texto t = new Texto();
					mapper.writeValue(new File("gamedata.json"),t);
    	    	
    	    		
    	    	}catch(StreamWriteException e){
    	    		
    	    		System.out.println("Ha ocurrido un error al crear y escribir el JSON");

    	    		e.printStackTrace();
    	    		
    	    	}catch(DatabindException e){
    	   
    	    		System.out.println("Ha ocurrido un error al mapear el objeto");

    	    		e.printStackTrace();
    	    		
    	    	}catch(IOException e){
    	    		System.out.println("Ha ocurrido un error de archivos... :(");
    	    		e.printStackTrace();
    	    	}
    	    }

			private static void mostrarMapa(Arbol arbol){

					SwingUtilities.invokeLater(() -> {
 		   				 Interfaz gui = new Interfaz(arbol);
 		   				 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		   				 gui.setVisible(true);
 					});
				
			}
    	    
    	}
    	

   
    
