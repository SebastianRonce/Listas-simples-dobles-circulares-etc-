package org.example;
    class Nodos {
        int dato;
        Nodos siguiente;
        Nodos anterior;

        public Nodos(int dato){
            this.dato = dato;
            this.siguiente = null;
            this.anterior = null;
        }
    }
public class ListaDobleCircular {
    private Nodos inicio;

    public ListaDobleCircular(){
        this.inicio = null;
    }

    // Metodo Agregar
    public void agregar(int dato){
        Nodos nuevoNodo = new Nodos(dato);
        if (inicio == null){
            inicio = nuevoNodo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            Nodos ultimo = inicio.anterior;

            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;
            nuevoNodo.siguiente = inicio;
            inicio.anterior = nuevoNodo;
        }
    }
    // Metodo eliminar
    public boolean eliminar(int dato){
        if (inicio == null){//Si la lista esta vacia no hay nada que eliminar
            return false;
        }

        Nodos actual = inicio;  // Nodo auxiliar para recorrer la lista
        do {
            if (actual.dato == dato){ // Si encuentra el nodo a eliminar
                // Caso: La lista solo tiene un elemento
                if (actual.siguiente == actual && actual.anterior == actual){
                    inicio = null; // Lista queda vacia
                } else {
                    // Ajustar los enlaces de los nodos vecinos
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    // Si el nodo eliminado es el primero, mover 'ínicio' al siguiente
                    if (actual == inicio){
                        inicio = actual.siguiente;
                    }
                }
                return true; // eliminado exitosamente
            }
            // Avanzar al siguiente Nodo
            actual = actual.siguiente;
        }while (actual != inicio);
            return false; // Valor no encontrado

    }

    /**
     * Metodo Buscar (int dato)
     * Verifica si existe un nodo con un valor especifico
     * Retorna True si lo encuentra, retorna flase si no.
     */
    public boolean buscar(int dato){
        if (inicio==null){ // Si la lista esta vacia
            return false;
        }
        Nodos actual = inicio; // Nodo auxiliar para recorrer
        do {
            if (actual.dato == dato){
                return true; // valor encontrado
            }
            actual = actual.siguiente; // avanzar
        }while ( actual != inicio); // Recorrido circular
        return false; // No se encontro el valor
    }

    /**
     * Metodo mostrar
     * Recorre la lista desde el inicio y muestra los datos
     */
    public void mostrar(){
        if (inicio == null){
            System.out.println("La lista esta vacia. ");
            return;
        }

        Nodos actual = inicio;
        System.out.println("Elemento de la lista: ");
        do {
            System.out.print(actual.dato + " "); // imprimir valor actual
            actual = actual.siguiente; // Buscar el siguiente Nodo
        }while (actual != inicio); // Cuando vuelve al inicio termina
        System.out.println(); // SALTO DE LINEA Final
    }
    /**
     * Metodo Main
     */
    public static void main(String[] args) {
        ListaDobleCircular listas = new ListaDobleCircular();
        // Agregar tres Nodos
        listas.agregar(10);
        listas.agregar(20);
        listas.agregar(30);

        // Mostrar los elementos actuales
        System.out.println("Lista Inicial: ");
        listas.mostrar();

        // Buscar elementos existentes e inexistentes
        System.out.println("¿Existe el 20? " + listas.buscar(20));
        System.out.println("¿Existe el 40? " + listas.buscar(40));

        // Eliminar un Nodo intermedio
        System.out.println("Eliminando el 20... ");
        listas.eliminar(20);
        listas.mostrar();

        // Eliminar un valor inexistente
        System.out.println("Eliminando el 40... ");
        System.out.println("El número 40: " + listas.eliminar(40));
        listas.mostrar();
    }
}
