import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaSubcadenasGUI extends JFrame {
    private JTextField campoBusqueda;
    private JLabel etiquetaResultado;
    private final String cadena = "manzana, pera, mango, banana, uva";

    public BusquedaSubcadenasGUI() {
        setTitle("Búsqueda de Subcadenas");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel etiquetaCadena = new JLabel("Cadena: " + cadena);
        campoBusqueda = new JTextField(20);
        JButton botonBuscar = new JButton("Buscar");
        etiquetaResultado = new JLabel("Ingrese un elemento y presione Buscar.");

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(etiquetaCadena);

        JPanel panelCentro = new JPanel();
        panelCentro.add(new JLabel("Buscar: "));
        panelCentro.add(campoBusqueda);
        panelCentro.add(botonBuscar);

        JPanel panelInferior = new JPanel();
        panelInferior.add(etiquetaResultado);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subcadena = campoBusqueda.getText();
                int resultado = buscar(cadena.toLowerCase(), subcadena.toLowerCase());

                if (resultado != -1) {
                    etiquetaResultado.setText("El elemento '" + subcadena + "' está en la posición: " + resultado);
                } else {
                    etiquetaResultado.setText("El elemento '" + subcadena + "' no se encontró.");
                }
            }
        });
    }

    public static int buscar(String cadena, String subcadena) {
        int longitudCadena = cadena.length();
        int longitudSubcadena = subcadena.length();

        for (int i = 0; i <= longitudCadena - longitudSubcadena; i++) {
            int j;
            for (j = 0; j < longitudSubcadena; j++) {
                if (cadena.charAt(i + j) != subcadena.charAt(j)) {
                    break;
                }
            }
            if (j == longitudSubcadena) {
                return i; // Posición de la subcadena
            }
        }
        return -1; // No encontrada
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BusquedaSubcadenasGUI().setVisible(true);
        });
    }
}
