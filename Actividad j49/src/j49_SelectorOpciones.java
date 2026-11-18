import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* ¿Qué conceptos nuevos aprendemos aquí?
- JComboBox<String>: Es la lista desplegable clásica de
    las interfaces gráficas. Entre los diamantes <String>
    le indicamos que almacenará datos de tipo texto.

- comboLenguajes.getSelectedItem(): Es el método clave
    que le pregunta a la lista desplegable cuál es la
    opción exacta que está marcada en ese momento para
    poder usarla en nuestra lógica.

- El evento integrado: Aunque el JComboBox puede usar
    ItemListener (como las casillas), también se lleva
    muy bien con el clásico ActionListener, ya que cada
    vez que cambias de opción en el menú, se interpreta
    como una "acción completada".
    */
public class j49_SelectorOpciones {
    public static void main(String[] args) {
        // 1. Creamos la ventana principal
        JFrame ventana = new JFrame("j49_SelectorOpciones - Menú Desplegable");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 240);
        ventana.setLayout(new FlowLayout());
        ventana.setLocationRelativeTo(null);

        // 2. Creamos los elementos para la primera lista (Lenguajes)
        String[] lenguajes = {"Java", "Python", "JavaScript", "C++", "Ruby"};
        JComboBox<String> comboLenguajes = new JComboBox<>(lenguajes);
        JLabel etiquetaLenguaje = new JLabel("Selecciona un lenguaje de la lista.");

        // Creamos los elementos para la segunda lista (Áreas de desarrollo relacionadas)
        String[] areas = {"Desarrollo Web", "Desarrollo Móvil", "Inteligencia Artificial", "Videojuegos", "Bases de Datos"};
        JComboBox<String> comboAreas = new JComboBox<>(areas);
        JLabel etiquetaArea = new JLabel("Selecciona un área de interés.");

        // --------------------
        // 3. PROGRAMANDO LOS EVENTOS CON ActionListener
        // --------------------

        // Evento para el primer combo (Lenguajes)
        comboLenguajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) comboLenguajes.getSelectedItem();
                etiquetaLenguaje.setText("Has elegido lenguaje: " + seleccionado);
            }
        });

        // Evento para el segundo combo (Áreas)
        comboAreas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) comboAreas.getSelectedItem();
                etiquetaArea.setText("Has elegido área: " + seleccionado);
            }
        });

        // 4. Añadimos los componentes ordenadamente a la ventana
        ventana.add(new JLabel("Lenguaje favorito:"));
        ventana.add(comboLenguajes);
        ventana.add(etiquetaLenguaje);

        ventana.add(new JLabel("Área de especialización:"));
        ventana.add(comboAreas);
        ventana.add(etiquetaArea);

        // 5. Hacemos visible la ventana
        ventana.setVisible(true);
    }
}