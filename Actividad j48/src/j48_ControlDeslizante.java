import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* JSlider
    Es el componente gráfico de la barra deslizante.
    Le indicamos su valor mínimo (0), máximo (100) y
    dónde debe arrancar (50).

- El Contrato (ChangeListener): Es la interfaz encargada
    de escuchar cambios continuos de estado. Obliga a
    implementar el método stateChanged(ChangeEvent e).

- slider.getValue(): Es el método que le pregunta en
    tiempo real a la barra en qué número exacto se
    encuentra posicionada la perilla para reflejarlo
    de inmediato en la interfaz.
 */

public class j48_ControlDeslizante {
    public static void main(String[] args) {
        // 1. Creamos la ventana principal
        JFrame ventana = new JFrame("j48_ControlDeslizante - Control Deslizante");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(420, 260);
        ventana.setLayout(new FlowLayout());
        ventana.setLocationRelativeTo(null);

        // 2. Creamos los componentes del primer deslizante (de 0 a 100, empezando en 50)
        JSlider deslizador1 = new JSlider(0, 100, 50);
        deslizador1.setMajorTickSpacing(20);
        deslizador1.setPaintTicks(true);
        deslizador1.setPaintLabels(true);

        JLabel etiqueta1 = new JLabel("Valor actual 1: 50");

        // Creamos los componentes del segundo deslizante (por ejemplo, con rango de 0 a 10, empezando en 3)
        JSlider deslizador2 = new JSlider(0, 10, 3);
        deslizador2.setMajorTickSpacing(2);
        deslizador2.setPaintTicks(true);
        deslizador2.setPaintLabels(true);

        JLabel etiqueta2 = new JLabel("Valor actual 2: 3");

        // -----------------
        // 3. PROGRAMANDO LOS CHANGEEVENT CON ChangeListener
        // -----------------

        // Evento para el primer deslizador
        deslizador1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valorActual = deslizador1.getValue();
                etiqueta1.setText("Valor actual 1: " + valorActual);
            }
        });

        // Evento para el segundo deslizador
        deslizador2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valorActual = deslizador2.getValue();
                etiqueta2.setText("Valor actual 2: " + valorActual);
            }
        });

        // 4. Añadimos todos los elementos ordenadamente a la ventana
        ventana.add(new JLabel("Desliza la barra 1:"));
        ventana.add(deslizador1);
        ventana.add(etiqueta1);

        ventana.add(new JLabel("Desliza la barra 2:"));
        ventana.add(deslizador2);
        ventana.add(etiqueta2);

        // 5. Hacemos visible la ventana
        ventana.setVisible(true);
    }
}