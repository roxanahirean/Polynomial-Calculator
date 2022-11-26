import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class View extends JFrame {
    private JButton sub = new JButton("Sub");
    private JButton add = new JButton("Add");
    private JButton division = new JButton("Division");
    private JButton integration = new JButton("Integration");
    private JButton derivation = new JButton("Derivation");
    private JButton multiply = new JButton("Multiply");
    private JTextField polinomial2 = new JTextField(35);
    private JTextField polinomial1 = new JTextField(35);
    private JTextField result = new JTextField(25);
    private JButton resetBtn = new JButton("Reset");

    View() {
        JPanel pannel = new JPanel();
        pannel.setLayout(new BoxLayout(pannel, BoxLayout.Y_AXIS));
        pannel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JPanel polinom1 = new JPanel();
        polinom1.setLayout(new FlowLayout());
        JLabel l = new JLabel("Polinomial1:");
        polinom1.add(l);
        polinom1.add(polinomial1);
        pannel.add(polinom1);

        JPanel polinom2 = new JPanel();
        polinom2.setLayout(new FlowLayout());
        JLabel l2 = new JLabel("Polinomial2:");
        polinom2.add(l2);
        polinom2.add(polinomial2);
        pannel.add(polinom2);

        JPanel buttonPannel = new JPanel();
        buttonPannel.setLayout(new GridLayout(0,2));
        buttonPannel.add(add);
        buttonPannel.add(sub);
        buttonPannel.add(multiply);
        buttonPannel.add(division);
        buttonPannel.add(derivation);
        buttonPannel.add(integration);
        add.setBorder(BorderFactory.createEmptyBorder(15,1,15,1));
        pannel.add(buttonPannel);

        JPanel resultPannel = new JPanel();
        resultPannel.setLayout(new FlowLayout());
        JLabel l1 = new JLabel("Result:");
        resultPannel.add(l1);
        resultPannel.add(result);
        resultPannel.add(resetBtn);
        pannel.add(resultPannel);

        result.setEditable(false);
        this.setContentPane(pannel);
        this.pack();
        this.setTitle("Polinomial Calculator");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void setResult(String result1) {
        result.setText(result1);
    }
    String getPolinomial2() {
        return polinomial2.getText();
    }
    String getPolinomial1() {
        return polinomial1.getText();
    }

    void multiplyL(ActionListener buttonAction) {
        multiply.addActionListener(buttonAction);
    }
    void subL(ActionListener buttonAction) {
        sub.addActionListener(buttonAction);
    }
    void addL(ActionListener buttonAction) {
        add.addActionListener(buttonAction);
    }
    void divisionL(ActionListener buttonAction) {
        division.addActionListener(buttonAction);
    }
    void integrationL(ActionListener buttonAction) {
        integration.addActionListener(buttonAction);
    }
    void resetBtnL(ActionListener buttonAction) {
        resetBtn.addActionListener(buttonAction);
    }
    void derivationL(ActionListener buttonAction) {
        derivation.addActionListener(buttonAction);
    }

    public void reset() {
        result.setText("0");
        polinomial1.setText("0");
        polinomial2.setText("0");
    }
    public void showErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
}
