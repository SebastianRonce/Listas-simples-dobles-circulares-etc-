package org.example;

public class Arbol {

    private static class Nodo {
        int valor; // valor almacenado
        Nodo izquierda; // referencia al hijo iquierda
        Nodo derecha; // Referencia al hijo derecha

        // constructor
        Nodo(int valor) {
            this.valor = valor; // Asigna el valor
            this.izquierda = null;
            this.derecha = null;
        }
    }

    private Nodo raiz; // Raiz del arbol (comienza vacia)

    // ------------------------------
    //   METODO INSERTAR
    // ------------------------------
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if(actual == null) {
            return new Nodo(valor);
        }

        if(valor < actual.valor) {
            actual.izquierda = insertarRecursivo(actual.izquierda, valor);
        }else if(valor > actual.valor){
            actual.derecha = insertarRecursivo(actual.derecha, valor);
        } else {
            System.out.println("Valor duplicado: "+ valor);
        }
        return actual; // retorna el nodo actualizado
    }
    // -------------------------------
    //   METODO BUSCAR

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private  boolean buscarRecursivo(Nodo actual, int valor){
        if (actual == null){
            return false;
        }
        if (valor == actual.valor){
            return true;
        }

        return valor < actual.valor
                ? buscarRecursivo(actual.izquierda, valor)
                : buscarRecursivo(actual.derecha, valor);
    }

    // ------------------------------------
    //   TAREA

    /*
        Métodos de recorrido: InOrden, PreOrden y PostOrden.
     */

    // ----------- RECORRIDO INORDEN (izquierda - nodo - derecha)
    public void inOrden() {
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    private void inOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            inOrdenRecursivo(actual.izquierda);
            System.out.print(actual.valor + " ");
            inOrdenRecursivo(actual.derecha);
        }
    }

    // ----------- RECORRIDO PREORDEN (nodo - izquierda - derecha)
    public void preOrden() {
        preOrdenRecursivo(raiz);
        System.out.println();
    }

    private void preOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.valor + " ");
            preOrdenRecursivo(actual.izquierda);
            preOrdenRecursivo(actual.derecha);
        }
    }

    // ----------- RECORRIDO POSTORDEN (izquierda - derecha - nodo)
    public void postOrden() {
        postOrdenRecursivo(raiz);
        System.out.println();
    }

    private void postOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            postOrdenRecursivo(actual.izquierda);
            postOrdenRecursivo(actual.derecha);
            System.out.print(actual.valor + " ");
        }
    }

    // MAIN
        public static void main(String[] args) {
            Arbol arbol = new Arbol();
            System.out.println("Buscando en la lista vacia: ");
            System.out.println(arbol.buscar(40));

            arbol.insertar(50);
            arbol.insertar(30);
            arbol.insertar(70);
            arbol.insertar(20);
            arbol.insertar(40);
            arbol.insertar(60);
            arbol.insertar(80);

            System.out.print("InOrden: ");
            arbol.inOrden();    // 20 30 40 50 60 70 80

            System.out.print("PreOrden: ");
            arbol.preOrden();   // 50 30 20 40 70 60 80

            System.out.print("PostOrden: ");
            arbol.postOrden();  // 20 40 30 60 80 70 50

            System.out.println("Buscando nodo 40: ");
            System.out.println(arbol.buscar(40));
            System.out.println("Buscando nodo 90: ");
            System.out.println(arbol.buscar(90));
        }

}