package org.example;

public class Cola {
    // Clase interna Nodo
    private static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Atributos principales
    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    // Constructor
    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamanio = 0;
    }

    // Método enqueue: agrega un elemento al final de la cola
    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (isEmpty()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }

        fin = nuevo;
        tamanio++;
        System.out.println("Elemento " + dato + " encolado correctamente.");
    }

    // Método dequeue: elimina el elemento del frente
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No se puede desencolar.");
            return -1;
        }

        int valorEliminado = frente.dato;
        frente = frente.siguiente;
        tamanio--;

        if (frente == null) {
            fin = null;
        }

        System.out.println("Elemento " + valorEliminado + " desencolado correctamente.");
        return valorEliminado;
    }

    // Método peek: devuelve el valor del frente sin eliminarlo
    public int peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No hay elementos para mostrar.");
            return -1;
        }
        System.out.println("Elemento al frente: " + frente.dato);
        return frente.dato;
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return frente == null;
    }

    // Tamaño actual de la cola
    public int size() {
        System.out.println("Tamaño actual de la cola: " + tamanio);
        return tamanio;
    }

    // Método clear: elimina todos los elementos
    public void clear() {
        frente = null;
        fin = null;
        tamanio = 0;
        System.out.println("La cola fue vaciada correctamente.");
    }

    // Método printQueue: muestra todos los elementos
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("Contenido de la cola (frente → final):");
        Nodo actual = frente;
        while (actual != null) {
            System.out.println("-> " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // Método main: prueba de todos los métodos
    public static void main(String[] args) {
        Cola cola = new Cola();

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);
        cola.enqueue(50);

        cola.printQueue();

        cola.dequeue();
        cola.dequeue();
        cola.peek();
        cola.size();

        cola.clear();
        cola.printQueue();
    }
}
