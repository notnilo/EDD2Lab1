/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author notnilo
 */


public class Arbol {

    private Nodo raiz;
    //Este insertar es para no pasar la raiz directamente en los argumentos del metodo.
    public void insertar(Nodo nodo) {
        if (this.raiz == null) {
            this.raiz = nodo;
        } else {
            insertarRecursivo(this.raiz, nodo);
        }
    }
	//Insertar de verdad. El que verdaderamente inserta.
    void insertarRecursivo(Nodo nodo, Nodo nuevoNodo) {
        if (nuevoNodo.getValor() < nodo.getValor()) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(nuevoNodo);
            } else {
                insertarRecursivo(nodo.getIzq(), nuevoNodo);
            }
        } else {
            if (nodo.getDer() == null) {
                nodo.setDer(nuevoNodo);
            } else {
                insertarRecursivo(nodo.getDer(), nuevoNodo);
            }
        }
    }

    public Nodo getRaiz() {
        return this.raiz;
    }
    
    public void imprimir(Nodo n1, int nivel) {
        if (n1 != null) {
            imprimir(n1.getDer(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("            ");
            }
            if (n1.isVisitado()){
                System.out.println(n1.getNombre());
            }else{
                System.out.println("X");
            }
            imprimir(n1.getIzq(), nivel + 1);

        }
    }
}
