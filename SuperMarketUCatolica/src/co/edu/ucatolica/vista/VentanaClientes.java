package co.edu.ucatolica.vista;

import javax.swing.*;

import co.edu.ucatolica.modelo.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaClientes extends JFrame {

    private JTextField txtCedula;
    private JTextField txtNombreCompleto;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTable tableClientes;
    private List<Cliente> listaClientes;

    public VentanaClientes() {
        super("Clientes");

        JLabel lblTitulo = new JLabel("Gestión de Clientes");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setOpaque(true);
        lblTitulo.setForeground(Color.GREEN);

        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);

        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblTelefono = new JLabel("Teléfono:");
        JLabel lblCorreo = new JLabel("Correo Electrónico:");

        txtCedula = new JTextField(20);
        txtNombreCompleto = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtCorreo = new JTextField(20);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                String nombreCompleto = txtNombreCompleto.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();

                if (!cedulaExiste(cedula)) {
                    Cliente cliente = new Cliente(cedula, nombreCompleto, direccion, telefono, correo);
                    guardarCliente(cliente);
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "La cédula ya existe. No se puede guardar el cliente.");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criterio = txtCedula.getText();
                buscarCliente(criterio);
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableClientes.getSelectedRow();
                if (selectedRow >= 0) {
                    Cliente cliente = listaClientes.get(selectedRow);
                    cliente.setNombreCompleto(txtNombreCompleto.getText());
                    cliente.setDireccion(txtDireccion.getText());
                    cliente.setTelefono(txtTelefono.getText());
                    cliente.setCorreo(txtCorreo.getText());
                    guardarListaClientes();
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla para modificar.");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableClientes.getSelectedRow();
                if (selectedRow >= 0) {
                    listaClientes.remove(selectedRow);
                    guardarListaClientes();
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla para eliminar.");
                }
            }
        });

        tableClientes = new JTable();
        listaClientes = new ArrayList<>();
        cargarListaClientes();
        actualizarTabla();

        tableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && tableClientes.getSelectedRow() != -1) {
                    int selectedRow = tableClientes.getSelectedRow();
                    Cliente cliente = listaClientes.get(selectedRow);
                    txtCedula.setText(cliente.getCedula());
                    txtNombreCompleto.setText(cliente.getNombreCompleto());
                    txtDireccion.setText(cliente.getDireccion());
                    txtTelefono.setText(cliente.getTelefono());
                    txtCorreo.setText(cliente.getCorreo());
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(lblCedula);
        panel.add(txtCedula);
        panel.add(lblNombreCompleto);
        panel.add(txtNombreCompleto);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblCorreo);
        panel.add(txtCorreo);
        panel.add(btnGuardar);
        panel.add(btnBuscar);
        panel.add(btnModificar);
        panel.add(btnEliminar);

        JScrollPane scrollPane = new JScrollPane(tableClientes);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // Espacio de 20 píxeles a la derecha e izquierda
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelTitulo, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void guardarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        guardarListaClientes();
        System.out.println("Cliente guardado correctamente.");
    }

    private void guardarListaClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/co/edu/ucatolica/controlador/clientes.dat"))) {
            oos.writeObject(listaClientes);
        } catch (IOException ex) {
            System.out.println("Error al guardar la lista de clientes: " + ex.getMessage());
        }
    }

    private void cargarListaClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/co/edu/ucatolica/controlador/clientes.dat"))) {
            listaClientes = (List<Cliente>) ois.readObject();
        } catch (EOFException ex) {
            // Se alcanzó el final del archivo, se ignora la excepción
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al cargar la lista de clientes: " + ex.getMessage());
        }
    }

    private void buscarCliente(String criterio) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(criterio) || cliente.getNombreCompleto().contains(criterio)) {
                clientesEncontrados.add(cliente);
            }
        }
        mostrarClientes(clientesEncontrados);
    }

    private void mostrarClientes(List<Cliente> clientes) {
        String[] columnNames = {"Cédula", "Nombre Completo", "Dirección", "Teléfono", "Correo Electrónico"};
        String[][] data = new String[clientes.size()][5];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = cliente.getCedula();
            data[i][1] = cliente.getNombreCompleto();
            data[i][2] = cliente.getDireccion();
            data[i][3] = cliente.getTelefono();
            data[i][4] = cliente.getCorreo();
        }

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void actualizarTabla() {
        mostrarClientes(listaClientes);
    }

    private boolean cedulaExiste(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaClientes().setVisible(true);
            }
        });
    }
}
