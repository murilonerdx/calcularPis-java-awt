package application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

public class TelaPis implements TelaImposto, Observer {
    private TextField txtValor;
    private Button btnCalcular;

    public TelaPis() {
        Frame frame = new Frame("Calculo imposto Pis");
        frame.add("North", new Label("Valor para calcular"));
        txtValor = new TextField();
        frame.add("Center", txtValor);

        Panel panel = new Panel();
        btnCalcular = new Button("Calcular");
        panel.add(btnCalcular);
        frame.add("South", panel);
        frame.addWindowListener(new CloseListener());
        frame.setSize(100, 150);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    @Override
    public float getValor() {
        return Float.parseFloat(txtValor.getText());
    }

    @Override
    public void update(Observable model, Object estadoModel) {
        String msg = "Valor total: " + estadoModel;
        JOptionPane.showMessageDialog(null, msg);
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent event){
            event.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    public void addController(ActionListener controller){
        btnCalcular.addActionListener(controller);

    }
}
