package com.example.agenda_telefonica;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {//Se Declara la clase AddressBook

    private HashMap<String,String> contactos = new HashMap<>();
//almacena los elementos en una estructura de datos llamada Árbol binario
// (los árboles binarios son una estructura de datos importante en las ciencias de la computación, pero su explicación está fuera del alcance del curso).
    public void load() throws IOException {//cargará los contactos del archivo.
//Se realiza la programacion para Carga los contactos que se crearon
        String CSV = ("src/com/example/agenda_telefonica/Agenda.csv");
//Se declara la varible indicandole que su valor sera el documento Agenda.csv
//Lugar donde se guardaran los contactos se se vallan a crear
        Path path = Paths.get(CSV);
//Se utiliza este metodo para que lo ultimo agregado a la agenda se almacene en el archivo
//Agenda.csv
//El parámetro path indica el camino hacia el directorio donde se encuentra el archivo, y name indica el nombre del archivo.
        ArrayList<String> load = new ArrayList<>();
//Se crea la listla llamada load donde se le insertara para mostrar, toda informacion alojada en el archivo Agenda.csv
        if (!Files.exists(path)){
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }//Esta función determina si existe o no un archivo o directorio denotado por el nombre del archivo abstracto.
        load = (ArrayList<String>) Files.readAllLines(path);
        for (var contacto : load){
            var infoContacto = contacto.split(",");
            contactos.put(infoContacto[0].trim(),infoContacto[1].trim());
        }
    }

    public void save() throws IOException{//guardará los cambios en el archivo.
//Se realiza la programacion para guardar los contactos que se vallan a crear
        String CSV = ("src/com/example/agenda_telefonica/Agenda.csv");
//Se declara la varible indicandole que su valor sera el documento Agenda.csv
//Lugar donde se guardaran los contactos que se vallan a crear
        Path path = Paths.get(CSV);
        ArrayList<String> saveContactos = new ArrayList<>();
        for (var contacto : contactos.entrySet()){
            saveContactos.add(contacto.getKey() + ", " + contacto.getValue());
//Con los métodos getKey y getValue se extraen la clave y el valor de una entrada.

        }
        Files.write(path,saveContactos);
    }

    public void list() throws IOException{//mostrar los contactos de la agenda.
//Se realiza la programacion para listar los contactos de la agenda
        for(var contact : contactos.entrySet()){
            System.out.println(String.format("Numero: %s, Nombre: %s",
                    contact.getKey(),contact.getValue()));
        }
        if (contactos.entrySet().isEmpty()){
            System.out.println("No Hay Contactos Existentes");
        }
    }

    public void create(String nombre, String telefono) throws IOException {//crear un nuevo contacto.
//Se realiza la programacion para Crear los contactos
        contactos.put(telefono,nombre);
        save();
        load();
    }

    public void delete(String telefono) throws IOException {//borrar un contacto.
//Se realiza la programacion para Eliminar los contactos
        var del = contactos.remove(telefono);
        save();
        load();
    }
}