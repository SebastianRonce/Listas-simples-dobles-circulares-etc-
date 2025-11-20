package org.example;

    // Clase que representa el nodo de la lista
    class  Nodo{
        int data;
        Nodo next;

        public Nodo(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public class listasCirculares {
        private Nodo last;

        public listasCirculares(){
            this.last = null;
        }

        // Metodo para agregar un nodo al final de la lista
        public void insert(int data){
            Nodo newNodo = new Nodo(data);
            if (last == null){ // Si la lista esta vacia
                last = newNodo;
                last.next = last; // El nodo apunta así mismo
            } else  {
                newNodo.next = last.next; // El nuevo nodo apunta al primer nodo
                last.next = newNodo; // El ultimo nodo apunta al nuevo nodo
                last = newNodo; // El nuevo nodo se convierte en el ultimo
            }
        }

        // Metodo para eliminar un nodo con un valor especifico
        public  boolean delete(int data){
            if (last == null){
                return false;
            }

            Nodo current = last.next; // Nodo actual inicio de la lista
            Nodo previus = last; // Nodo previo al actual

            do {
                if (current.data == data) { // Si se encuentra el Nodo
                    if (current == last && current.next == last){ // Caso: un solo nodo
                        last = null;
                    } else if (current == last) { // Caso: Eliminar el ultimo nodo
                        previus.next = current.next;
                        last = previus;
                    } else { // Caso: Nodo intermedio o primero
                        previus.next = current.next;
                    }
                    return true; // Nodo eliminado
                }
                previus = current;
                current = current.next;
            } while (current != last.next);

            return false; // Nodo no encontrado
        }

        // Metodo para bsucar un nodo con  un valor especifico
        public boolean search(int data){
            if (last == null){ // Si la lista esta vacia
                return false;
            }

            Nodo current = last.next;
            do{
                if (current.data == data){ // si se encuentra el Nodo
                    return true;
                }
                current = current.next;
            } while (current != last.next);
            return false; // Nodo no encontrado
        }

        // Metodo para mostrar los elementos de la lista
        public void mostrar(){
            if (last ==  null){
                System.out.println("La lista esta vacia. ");
                return;
            }
            Nodo current = last.next;
            do {
                System.out.println(current.data + " "); // Imprime el dato del nodo
                current = current.next;
            } while (current != last.next);
            System.out.println();
        }
        public static void main(String[] args) {
            listasCirculares ListaCircular = new listasCirculares();

            ListaCircular.insert(1);
            ListaCircular.insert(2);
            ListaCircular.insert(3);
            ListaCircular.insert(5);
            ListaCircular.insert(4);
            ListaCircular.mostrar();

            System.out.println("Borrar. ");
            System.out.println(ListaCircular.delete(5));
            System.out.println(ListaCircular.delete(9));

            System.out.println("Buscar. ");
            ListaCircular.search(4);
            ListaCircular.search(2);
            ListaCircular.search(8);

            System.out.println("Lista");
            ListaCircular.mostrar();
        }
    }
