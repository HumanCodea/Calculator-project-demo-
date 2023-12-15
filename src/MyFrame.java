import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{

    JTextField text;
    JPanel panel = new JPanel();
    JButton[] numberButtons = new JButton[10];
    JButton[] fucButtons = new JButton[10];
    JButton equButton, sumButton, mulButton, divButton, fraButton,
            subButton, clrButton, delButton, poiButton, squButton;
    double s1=0, s2 = 0, result = 0;
    char operators;

    ImageIcon icon;

    public MyFrame(){

        Font myFont = new Font("MV Boly", Font.BOLD, 25);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(500,500);
        this.setLayout(new BorderLayout());

        icon = new ImageIcon("iconcalculator.png");
        this.setIconImage(icon.getImage());

        text = new JTextField();
        text.setFont(new Font("MV boky", Font.BOLD,50));
        text.setPreferredSize(new Dimension(150,165));
        text.setBackground(Color.white);
        text.setOpaque(true);
        text.setEditable(false);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150,300));
        panel.setLayout(new GridLayout(5,4,5,5));
        panel.setBackground(Color.white);
        panel.setOpaque(true);

        equButton = new JButton("=");
        sumButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        poiButton = new JButton(".");
        delButton = new JButton("<-");
        clrButton = new JButton("C");
        squButton = new JButton("x^2");
        fraButton = new JButton("1/x");

        fucButtons[0] = equButton;
        fucButtons[1] = sumButton;
        fucButtons[2] = subButton;
        fucButtons[3] = mulButton;
        fucButtons[4] = divButton;
        fucButtons[5] = poiButton; 
        fucButtons[6] = delButton; 
        fucButtons[7] = clrButton;
        fucButtons[8] = squButton;
        fucButtons[9] = fraButton;

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBackground(Color.white);
            numberButtons[i].setForeground(Color.BLACK);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        for(int i = 0; i < 10; i++){
            fucButtons[i].setFont(myFont);
            fucButtons[i].setFocusable(false);
            fucButtons[i].setBackground(Color.white);
            fucButtons[i].setForeground(Color.BLACK);
            fucButtons[i].addActionListener(this);
        }

        panel.add(fraButton);
        panel.add(squButton);
        panel.add(delButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(sumButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(poiButton);
        panel.add(equButton);

        this.add(text, BorderLayout.NORTH);
        this.add(panel, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == sumButton){
            s1 = Double.parseDouble(text.getText());
            operators = '+';
            text.setText("");
        }

        if(e.getSource() == divButton){
            s1 = Double.parseDouble(text.getText());
            operators = '/';
            text.setText("");
        }

        if(e.getSource() == subButton){
            s1 = Double.parseDouble(text.getText());
            operators = '-';
            text.setText("");
        }

        if(e.getSource() == mulButton){
            s1 = Double.parseDouble(text.getText());
            operators = 'x';
            text.setText("");
        }

        if(e.getSource() == poiButton){
            text.setText(text.getText().concat("."));
        }

        if(e.getSource() == clrButton){
            text.setText("");
        }

        if(e.getSource() == delButton){
            String string = text.getText();
            text.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                text.setText(text.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == fraButton){
            s1 = Double.parseDouble(text.getText());
            operators = '%';
            text.setText("1/" + text.getText());
        }

        if(e.getSource() == squButton){
            s1 = Double.parseDouble(text.getText());
            operators = '^';
            text.setText(text.getText() + "^2");
        }


        if(e.getSource() == equButton){
            switch (operators) {
                case '+': {
                    s2 = Double.parseDouble(text.getText());
                    result = s1 + s2;
                    break;
                }
                
                case '-': {
                    s2 = Double.parseDouble(text.getText());
                    result = s1 - s2;
                    break;
                }

                case 'x': {
                    s2 = Double.parseDouble(text.getText());
                    result = s1 * s2;
                    break;
                }

                case '/': {
                    s2 = Double.parseDouble(text.getText());
                    result = s1 / s2;
                    break;
                }

                case '^': {
                    result = s1 * s1;
                    break;
                }

                case '%': {
                    result = 1 / s1;
                    break;
                }
            
                default:
                    break;
            }
            text.setText(String.valueOf(result));
            s1 = result;
        }
    }
}
