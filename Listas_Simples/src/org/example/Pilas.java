package org.example;

public class Pilas {
    // Clase interna que representa un nodo de la lista enlazada.
    private static class Nodo {
        int dato;  // Valor almacenado en el Nodo
        Nodo siguiente; // Referencia al siguiente Nodo

        // Constructor del nodo
        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Atributos principales
    private Nodo tope;
    private int tamanio;

    // Constructor: inicializa la pila vacía
    public Pilas() {
        this.tope = null;
        this.tamanio = 0;
    }

    // Método Push: Agregar un elemento al tope de la pila
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
        System.out.println("Elemento " + dato + " apilado correctamente.");
    }

    // Verifica si la pila está vacía
    private boolean isEmpty() {
        return tope == null;
    }

    // Método pop: elimina y retorna el elemento del tope de la pila
    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No se puede desapilar.");
            return -1; // valor simbólico de error
        }

        int valorEliminado = tope.dato;
        tope = tope.siguiente;
        tamanio--;
        System.out.println("Elemento " + valorEliminado + " desapilado correctamente.");
        return valorEliminado;
    }

    // Método peek: devuelve el elemento en el tope sin eliminarlo
    public int peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No hay elementos para mostrar.");
            return -1;
        }
        System.out.println("Elemento en el tope: " + tope.dato);
        return tope.dato;
    }

    // Tamaño actual de la pila
    public int size() {
        System.out.println("Tamaño actual de la pila: " + tamanio);
        return tamanio;
    }

    // Método clear: elimina todos los elementos de la pila
    public void clear() {
        tope = null;
        tamanio = 0;
        System.out.println("La pila fue vaciada correctamente.");
    }

    // Método printStack: muestra todos los elementos de la pila sin modificarla
    public void printStack() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }

        System.out.println("Contenido de la pila (arriba hacia abajo):");
        Nodo actual = tope;
        while (actual != null) {
            System.out.println("-> " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // Método main: prueba de los métodos de la clase
    public static void main(String[] args) {
        Pilas pila = new Pilas();

        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        pila.printStack();

        pila.pop();
        pila.peek();
        pila.size();

        pila.clear();
        pila.printStack();
    }
}
