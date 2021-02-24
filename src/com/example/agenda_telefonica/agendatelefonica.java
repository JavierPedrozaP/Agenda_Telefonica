package com.example.agenda_telefonica;
import java.io.IOException;
import java.util.Scanner;

public class agendatelefonica {//Se Declara la clase principal

    public static void main(String[] args) throws IOException {
        //se programa para mostrar la clase menu al iniciar el codigo
        Menu menu = new Menu(); //Se hace el llamado la clase Menu
        menu.menudeAgenda();//Se llama al metodo menu de Agenda
    }


    public static class Menu {//Se Declara la clase Menu
        Scanner scanner = new Scanner(System.in);
        //Se ejecuta el codigo para que el usuario interactue con el codigo
        int menu;//Se declara la variable
        AddressBook contactos = new AddressBook(); //Se hace el llamado a la clase AddressBook

        private void showMenu() {//Se realiza la programacion para visualizar las opciones
            //Que el usuario podra elegir
            System.out.println("\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE");
        //Se Utiliza  para ala hora de ejecutar el codigo se muestre una imagen de un telefono
            //Para saber el codigo correspondiente a java se utilizo esta pagina "https://emojiterra.com/es/auricular-de-telefono/"
            System.out.println("Agenda Telefonica, porfavor ingrese una opcion:\n" +
                    "1-Ver contactos de la Agenda \n" +
                    "2-Agregar contactos a la Agenda\n" +
                    "3-Eliminar contactos de la Agenda\n" +
                    "0-Salir de la Agenda Telefonica");
            System.out.println("\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE\uD83D\uDCDE");
        }

        public void menudeAgenda() throws IOException {
        //Se declaran las opciones
            boolean isRunning = true;
            do {
                showMenu();
                System.out.println("\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F");
                System.out.print("Ingrese una opcion: \n");
                menu = scanner.nextInt();

                switch (menu){
                    case 1://Se muestran los contactos existentes
                        System.out.println("\uD83D\uDCD4\uD83D\uDCD4\uD83D\uDCD4\uD83D\uDCD4");
                        System.out.println("Contactos:");
                        System.out.println("          ");
                        contactos.list();
                        System.out.println("          ");
                        break;

                    case 2://Se realiza la creacion y el guardado del nuevo contacto a la agenda
                        System.out.println("Crear contacto:");
                        System.out.println("\uD83D\uDE4B\u200D\u2642\uFE0F"+"\uD83D\uDE4B\u200D\u2640\uFE0F");
                        System.out.print("Ingrese el nombre: ");
                        var nombre = scanner.next();
                        System.out.println("\uD83D\uDCF1\uD83D\uDCF1\uD83D\uDCF1\uD83D\uDCF1\uD83D\uDCF1");
                        System.out.print("Ingrese el telefono: ");
                        var telefono = scanner.next();
                        contactos.create(nombre, telefono);
                        System.out.println("          ");
                        System.out.println("Contacto Guardado");

                        break;

                    case 3://Se realiza la eliminacion del contacto existente
                        //Siempre y cuando el usuario ingrese el numero telefonico a eliminar
                        System.out.println("Eliminar contacto:");
                        System.out.println("\uD83D\uDCF1\uD83D\uDCF1\uD83D\uDCF1\uD83D\uDCF1\uD83D\uDCF1");
                        System.out.print("Ingrese el teléfono que desea eliminar: ");
                        var deleteTel = scanner.next();
                        contactos.delete(deleteTel);
                        System.out.println("          ");
                        System.out.println("Contacto eliminado");
                        break;


                    case 0:
                        System.out.println("\uD83D\uDCD4\uD83D\uDCD4\uD83D\uDCD4\uD83D\uDCD4");
                        System.out.println("Saliendo de la Agenda Telefonica");
                        isRunning = false;
                        break;
                }

            } while (isRunning);//Cuando el usuario ejecuta la opcion cero se detiene el programa mientras
            // el programa se estara ejecutando
        }

    }
}
