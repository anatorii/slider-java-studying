import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Slider extends JFrame {
    static int width = 800;
    static int height = 600;
    static int clientWidth;
    static int clientHeight;
    private JPanel panelUp;
    private JPanel panelBottom;
    private JLabel label;
    private JSlider slider;

    public Slider() {
        super("Slider");
        initGui();
    }

    private void initGui() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(Slider.width, Slider.height));
        this.setLocation(d.width / 2 - Slider.width / 2, d.height / 2 - Slider.height / 2);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLayout(null);

        JLabel label = new JLabel();
        label.setText("label text");
        label.setFont(new Font("Serif", Font.PLAIN, 50));

        JSlider slider = new JSlider();
        slider.setMinimum(1);
        slider.setMaximum(100);
        slider.setValue(20);
        slider.setOpaque(true);
        slider.setLayout(null);


        JPanel panelUp = new JPanel();
        panelUp.setBackground(Color.orange);
        panelUp.setLayout(new GridBagLayout());
        panelUp.add(slider);
        getContentPane().add(panelUp);

        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(Color.green);
        panelBottom.setLayout(new GridBagLayout());
        panelBottom.add(label);
        getContentPane().add(panelBottom);

        this.pack();
        this.setVisible(true);

        panelUp.setBounds(0, 0, Slider.clientWidth, 100);
        panelBottom.setBounds(0, 100, Slider.clientWidth, Slider.clientHeight - 100);
        slider.setFont(new Font("Serif", Font.PLAIN, 50));
        slider.setBounds(0, 0, Slider.clientWidth, 100);
        panelUp.revalidate();
        panelUp.repaint();

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderChanged(e);
            }
        });
    }

    private void sliderChanged(ChangeEvent e) {
        System.out.println(slider.getValue());
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
