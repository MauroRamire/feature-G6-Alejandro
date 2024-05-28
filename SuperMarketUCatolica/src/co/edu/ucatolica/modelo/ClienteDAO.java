package co.edu.ucatolica.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static final String FILE_NAME = "clientes.dat";

    public void guardarClientes(List<Cliente> clientes) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(clientes);
        }
    }

    public List<Cliente> cargarClientes() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Cliente>) ois.readObject();
        }
    }
}
