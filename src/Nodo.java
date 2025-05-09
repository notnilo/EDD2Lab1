/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author notnilo
 */
public class Nodo {

    private Nodo izq;
    private Nodo der;
    //El padre es un atributo necesario para poder escoger direccion 'regresar'.
    private Nodo padre;
    private int valor;
    private String contexto;
    private String[] trivia;
    //Visitado es un atributo necesario para saber si se le pone preguntas o no al jugador.
    private boolean visitado;
    private String nombre;
    
    

    public Nodo(int valor, String nombre, String contexto, String[] trivia, Nodo padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.valor = valor;
        this.contexto = contexto;
        this.trivia = trivia;
    }

    public String getNombre() {
        return nombre;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public int getValor() {
        return valor;
    }

    public String getContexto() {
        return contexto;
    }

    public String[] getTrivia() {
        return trivia;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitadoTrue() {
        this.visitado = true;
    }

    public void setNombre(String nombre){
    	this.nombre = nombre;
    }

    public void setContexto(String contexto){
    	this.contexto = contexto;
    }

    public void setTrivia(String[] trivia){
    	this.trivia = trivia;
    }
    
}
