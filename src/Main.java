
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author notnilo
 */
public class Main {

    public static void main(String[] args) {
        //Se instancia scanner

        Scanner leer = new Scanner(System.in);

        //Se genera arbol
        Arbol arbol = generarArbol();
        String entrada = "";
        Nodo actual = arbol.getRaiz();

        //Se inicia Juego
        while (!entrada.equalsIgnoreCase("salir")) {
            if (!(actual == arbol.getRaiz())) {
                System.out.println("Bienvenido al Ecosistema " + actual.getNombre());
            }
            System.out.println(actual.getContexto());
            if (!(actual == arbol.getRaiz())) {
                //Si ya fue visitado, no se hacen las preguntas
                if (actual.isVisitado() == true) {
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
                            System.out.println("Estás en la raíz, no puedes regresar.");
                        }
                    }
                } else {
                    boolean correcto = false;
                    int pregunta = 0;
                    while (correcto == false) {
                        System.out.println(actual.getTrivia()[pregunta]);
                        String respuesta = leer.nextLine();
                        if (respuesta.equalsIgnoreCase(actual.getTrivia()[pregunta + 1])) {
                            System.out.println("¡Acertaste!");
                            correcto = true;
                            actual.setVisitadoTrue();
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
                                    System.out.println("Estás en la raíz, no puedes regresar.");
                                }
                            }
                        } else {
                            System.out.println("Incorrecto... Aquí está otra pregunta:");
                            pregunta = pregunta + 2;
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
                        System.out.println("Estás en la raíz, no puedes regresar.");
                    }
                }
            }
        }
    }

    private static Arbol generarArbol() {
        Arbol arbol = new Arbol();

        //Se instancian nodos
        Nodo nodo0 = new Nodo(0, "Bienvenido", Texto.getInstrucciones(), null, null);
        Nodo nodo1 = new Nodo(-4, "Terrestre", Texto.getContextoTerrestre(), Texto.getTriviaTerrestre(), nodo0);
        Nodo nodo2 = new Nodo(4, "Acuático", Texto.getContextoAcuatico(), Texto.getTriviaAcuatico(), nodo0);
        Nodo nodo3 = new Nodo(-6, "Bosque", Texto.getContextoBosque(), Texto.getTriviaBosque(), nodo1);
        Nodo nodo4 = new Nodo(-2, "Pradera", Texto.getContextoPradera(), Texto.getTriviaPradera(), nodo1);
        Nodo nodo5 = new Nodo(2, "Agua Dulce", Texto.getContextoAguaDulce(), Texto.getTriviaAguaDulce(), nodo2);
        Nodo nodo6 = new Nodo(6, "Agua Salada", Texto.getContextoAguaSalada(), Texto.getTriviaAguaSalada(), nodo2);
        Nodo nodo7 = new Nodo(-7, "Selva Tropical", Texto.getContextoSelvaTropical(), Texto.getTriviaSelvaTropical(), nodo3);
        Nodo nodo8 = new Nodo(-5, "Bosque Templado", Texto.getContextoBosqueTemplado(), Texto.getTriviaBosqueTemplado(), nodo3);
        Nodo nodo9 = new Nodo(-3, "Sabana", Texto.getContextoSabana(), Texto.getTriviaSabana(), nodo4);
        Nodo nodo10 = new Nodo(-1, "Estepa", Texto.getContextoEstepa(), Texto.getTriviaEstepa(), nodo4);
        Nodo nodo11 = new Nodo(1, "Rio", Texto.getContextoRio(), Texto.getTriviaRio(), nodo5);
        Nodo nodo12 = new Nodo(3, "Lago", Texto.getContextoLago(), Texto.getTriviaLago(), nodo5);
        Nodo nodo13 = new Nodo(5, "Océano", Texto.getContextoOceano(), Texto.getTriviaOceano(), nodo6);
        Nodo nodo14 = new Nodo(7, "Arrecife", Texto.getContextoArrecife(), Texto.getTriviaArrecife(), nodo6);

        //De la ultima fila (nodo7 a nodo14), se debe escoger uno aleatorio para ser el Nodo Sostenibilidad
        //Se insertan nodos en el arbol
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

}
