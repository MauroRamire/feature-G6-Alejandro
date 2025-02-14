package co.edu.ucatolica.modelo.persistencia;

import java.io.*;
import java.util.List;

public class GestorArchivos {

    // Método para guardar datos en un archivo de texto
    public static void guardarTexto(String rutaArchivo, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(contenido);
        }
    }

    // Método para leer datos desde un archivo de texto
    public static String leerTexto(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
        }
        return contenido.toString();
    }

    // Método para guardar un objeto en un archivo serializado
    public static void guardarSerializado(String rutaArchivo, Serializable objeto) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
        }
    }

    // Método para leer un objeto desde un archivo serializado
    public static Object leerSerializado(String rutaArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return ois.readObject();
        }
    }

    // Método para guardar una lista de objetos en un archivo de texto
    public static void guardarListaTexto(String rutaArchivo, List<String> lista) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String item : lista) {
                writer.write(item);
                writer.newLine();
            }
        }
    }

    // Método para leer una lista de objetos desde un archivo de texto
    public static List<String> leerListaTexto(String rutaArchivo) throws IOException {
        List<String> lista;
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            lista = reader.lines().toList();
        }
        return lista;
    }
}

