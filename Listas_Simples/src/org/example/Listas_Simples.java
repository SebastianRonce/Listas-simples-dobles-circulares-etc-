package org.example;

public class Listas_Simples {
    // Clase interna Nodo: representa cada elemento (nodo) de la lista
    private class Nodo {
        String titulo; // Dato que guarda el nodo (el título del libro)
        Nodo siguiente; // Enlace o puntero al siguiente nodo

        // Constructor del nodo
        public Nodo(String titulo) {
            this.titulo = titulo;
            this.siguiente = null;
        }
    }

    // Referencia al primer nodo de la lista
    private Nodo cabeza;

    // Constructor: al inicio la lista está vacía (sin cabeza)
    public Listas_Simples(){
        cabeza = null;
    }

    // Método para agregar un nuevo libro al final de la lista
    public void agregarLibro(String titulo) {
        Nodo nuevo = new Nodo(titulo); // Crear un nuevo nodo

        // Si la lista está vacía, el nuevo nodo será la cabeza
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            // Si no, recorremos hasta el último nodo
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente; // avanzar al siguiente nodo
            }
            actual.siguiente = nuevo; // enlazar el nuevo al final
        }
    }

    // Metodo para mostrar todos los libros de la lista
    public void mostrarLibros(){
        if (cabeza == null){
            System.out.println("La lista esta vacia. ");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("* Listas de libros: ");
        while (actual != null){
            System.out.println(" - "+ actual.titulo);
            actual = actual.siguiente; // Pasar al siguiente nodo
        }
    }

    // Metodo para eliminar un libro por su titulo
    public void eliminarLibro(String titulo){
        if (cabeza == null){
            System.out.println("La lista esta vacia, no se puede eliminar. ");
            return;
        }

        // Si el libro al eliminar esta en la cabeza
        if (cabeza.titulo.equalsIgnoreCase(titulo)){
            cabeza = cabeza.siguiente;
            System.out.println("Libro \"" + titulo + " eliminado \"");
            return;
        }

        // Buscar el libro en el resto de la lista
        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.titulo.equalsIgnoreCase(titulo)){
            actual = actual.siguiente;
        }

        // Si se encontro el libro
        if (actual.siguiente != null){
            actual.siguiente = actual.siguiente.siguiente; // Saltar el nodo eliminado
            System.out.println("Libro \"" + titulo + "\" celiminado. ");
        } else {
            System.out.println("Libro \"" + titulo + "\" no se encontro. ");
        }
    }

    // Metodo para buscar un libro
    public boolean buscarLibro(String titulo){
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Libro \"" + titulo + "\" si esta en la lista. ");
                return true;
            }
            actual = actual.siguiente;
        }
        System.out.println("Libro \"" + titulo + "\" no se encontro. ");
        return false;
    }
}
