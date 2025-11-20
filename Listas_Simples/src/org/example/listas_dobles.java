package org.example;

public class listas_dobles {
    // Clase interna NODO: representa cada elemento de la lista
    private static class Nodo {
        int dato;
        Nodo anterior;
        Nodo siguiente;

        // constructor del Nodo
        public  Nodo(int dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    // Referencias a la cabeza y la cola de la lista
    private  Nodo cabeza;
    private Nodo cola;

    // Constructor: al inicio la lista vacia
    public listas_dobles() {
        cabeza = null;
        cola = null;
    }

    public  void agregar(int dato){
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente  = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    //metodo para mostrar los numeros de la lista
    public  void mostrar(){
        if(cabeza == null){
            System.out.println("La lista esta vacias. ");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("Lista de numeros: ");
        while (actual != null) {
            System.out.println(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para eliminar un número por su valor
    public void eliminar(int dato){
        if (cabeza == null){
            System.out.println("La lista esta vacia, no se puede eliminar. ");
            return;
        }
        Nodo actual = cabeza;
        // Buscar el nodo a elimminar
        while (actual != null && actual.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual == null){
            System.out.println("El número "+ dato + " no se encontro. ");
            return;
        }

        // Si el nodo a eliminar es la cabeza
        if (actual == cabeza){
            cabeza = cabeza.siguiente;
            if (cabeza != null){
                cabeza.anterior = null;
            } else {
                cola = null; // La lista quedo vacia
            }
        } else if (actual == cola){ // Si el nodo a eliminar es la cola
            cola = cola.anterior;
            cola.siguiente = null;
        } else { // Si el nodo esta en el medio
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        System.out.println("Número "+ dato + " eliminado. ");
    }

    // Metodo para buscar un número en la lista
    public boolean buscar(int dato){
        Nodo actual = cabeza;

        while (actual != null){
            if (actual.dato == dato){
                System.out.println("El número "+ dato + " esta en la lista. ");
                return true;
            }
            actual = actual.siguiente;
        }

        System.out.println("El número "+ dato + " no se encontro. ");
        return false;
    }

    // Metodo para mostrar detalles de un nodo
    public void mostrarDetallesNodo(int dato){
        Nodo actual = cabeza;

        while (actual != null){
            if (actual.dato == dato) {
                System.out.println("Detalles del nodo con valor " + dato +": ");
                System.out.println("- Anterior: " + (actual.anterior != null ? actual.anterior.dato :" null. "));
                System.out.println("- Siguiente: " + (actual.siguiente != null ? actual.siguiente.dato :" null. "));
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("El número "+ dato + " no se encontro en la lista. ");
    }
}
