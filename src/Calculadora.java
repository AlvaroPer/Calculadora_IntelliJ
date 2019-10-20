import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private Container contenedor;

    private JPanel superior;
    private JPanel central;

    private JButton[] botones;
    private JTextArea pantallaInferior;
    private JTextArea pantallaSuperior;

    private Operaciones calculos;


    public void initGUI() {

        instancias();
        acciones();

        setTitle("Calculadora");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));
        setLocationRelativeTo(null);

        configurarPaneles();

        setVisible(true);

    }

    private void configurarPaneles() {

        pantallaInferior.setRows(1);
        pantallaInferior.setEditable(false);
        pantallaInferior.setFocusable(false);
        Font fuente=new Font("Calibri", Font.BOLD, 30);
        pantallaInferior.setFont(fuente);

        pantallaSuperior.setRows(1);
        pantallaSuperior.setEditable(false);
        pantallaSuperior.setFocusable(false);
        Font fuente2=new Font("Calibri", Font.BOLD, 15);
        pantallaSuperior.setFont(fuente2);


        superior.setLayout(new BorderLayout());
        superior.add(pantallaSuperior, BorderLayout.NORTH);
        superior.add(pantallaInferior, BorderLayout.CENTER);

        central.setLayout(new GridLayout(5,4));
        for(int i=0;i<botones.length;i++)
            central.add(botones[i]);


        contenedor.add(superior, BorderLayout.NORTH);
        contenedor.add(central, BorderLayout.CENTER);

    }

    private void acciones() {

        for(int i=0;i<botones.length;i++)
            botones[i].addActionListener(this);

    }

    private void instancias() {

        contenedor = getContentPane();
        superior = new JPanel();
        central = new JPanel();
        botones = new JButton[]{
                new JButton("CE"), new JButton("C"), new JButton("x2"), new JButton("%"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("X"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("+-"), new JButton("0"), new JButton(","), new JButton("=")
        };

        pantallaInferior = new JTextArea();
        pantallaSuperior = new JTextArea();
        calculos = new Operaciones();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            calculos.entrada(boton.getText());
        }

        pantallaInferior.setText(calculos.getDisplayOperador());
        pantallaSuperior.setText(calculos.getDisplayAcumulado());

    }
}
