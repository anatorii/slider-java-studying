import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Slider extends JFrame {
    static int width = 800;
    static int height = 600;
    static int clientWidth;
    static int clientHeight;
    JLabel label;

    public Slider() {
        super("Slider");
        initGui();
    }

    private void initGui() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Slider.width, Slider.height);
        this.setLocation(d.width / 2 - Slider.width / 2, d.height / 2 - Slider.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel panelUp = new JPanel(new GridLayout());
        panelUp.setPreferredSize(new Dimension(0, 100));

        JPanel panelDown = new JPanel(new GridBagLayout());
        panelDown.setBackground(Color.green);

        JSlider slider = new JSlider(5, 100, 50);
        slider.setFont(new Font("Courier", Font.PLAIN, 18));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(19);
        slider.setForeground(Color.red);
        slider.setBackground(Color.yellow);
        panelUp.add(slider);

        label = new JLabel("Slider");
        label.setFont(new Font("Serif", Font.PLAIN, slider.getValue()));
        label.setBackground(Color.white);
        label.setOpaque(true);
        panelDown.add(label);

        this.add(panelUp, BorderLayout.NORTH);
        this.add(panelDown, BorderLayout.CENTER);
        this.setVisible(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderChanged(e);
            }
        });
    }

    private void sliderChanged(ChangeEvent e) {
        label.setFont(new Font("Serif", Font.PLAIN, ((JSlider)e.getSource()).getValue()));
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
        clientWidth = Slider.width;
        clientHeight = Slider.height;
        if (isResizable()) {
            clientWidth = getContentPane().getWidth();
            clientHeight = getContentPane().getHeight();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Slider frame = new Slider();
            }
        });
    }
}
