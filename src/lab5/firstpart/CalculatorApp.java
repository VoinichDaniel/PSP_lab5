package lab5.firstpart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton;

    private double num1, num2, result;
    private char operator;

    public CalculatorApp() {
        this.setTitle("Калькулятор");
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 40, 240, 30);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[5];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equalsButton;

        for (int i = 0; i < 5; i++) {
            functionButtons[i].addActionListener(this);
        }

        clearButton.addActionListener(this);

        textField.setFont(new Font("Arial", Font.PLAIN, 18));

        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        for (int i = 0; i < 10; i++) {
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].setBounds(70 + ((i - 1) % 3) * 50, 100 + ((i - 1) / 3) * 50, 50, 50);
            this.add(numberButtons[i]);
        }

        for (int i = 0; i < 5; i++) {
            functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            functionButtons[i].setBounds(220, 100 + i * 50, 50, 50);
            this.add(functionButtons[i]);
        }

        clearButton.setBounds(110, 300, 100, 50);
        this.add(clearButton);

        this.add(textField);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        textField.setText("Ошибка");
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
    }
}

