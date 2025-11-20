//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package org.example;
public class Main {
    public static void main(String[] args) {
        // Crear una lista simplemente enlazada de libros
        Listas_Simples Lista = new Listas_Simples();

        // lISTAS SIMPLES

        // Agregar libros
        //Lista.agregarLibro("El principito");
        //Lista.agregarLibro("Cien años de soledad");
        //Lista.agregarLibro("1984");
        //Lista.agregarLibro("Don Quijote de la mancha");

        // Mostrar libros
        //Lista.mostrarLibros();

        // Buscar libro
        //Lista.buscarLibro("1984");
        //Lista.buscarLibro("Rayuela");

        // Eliminar Libro
        //Lista.eliminarLibro("El principito");
        //Lista.mostrarLibros();

        // LISTAS DOBLES

        // Agregar números
        listas_dobles listaDoble = new listas_dobles();
        System.out.println(" LISTA: ");
        listaDoble.agregar(10);
        listaDoble.agregar(20);
        listaDoble.agregar(30);
        listaDoble.agregar(40);

        System.out.println(" Mostrar LISTA: ");
        // Mostrar numeros
        listaDoble.mostrar();
        System.out.println(" Buscar: ");
        // Buscar un número
        listaDoble.buscar(30);
        listaDoble.buscar(20);
        listaDoble.buscar(50);
        System.out.println(" Eliminar: ");
        // Eliminar un número
        listaDoble.eliminar(10);
        listaDoble.mostrar();

        System.out.println(" Mostrar detalles: ");
        // Mostrar detalles de un nodo
        listaDoble.mostrarDetallesNodo(20);
        listaDoble.mostrarDetallesNodo(50);
    }
}