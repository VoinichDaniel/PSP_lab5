package lab5.secondpart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ProfileForm extends JFrame implements ActionListener {
    private JLabel nameLabel, ageLabel, genderLabel, countryLabel, commentsLabel;
    private JTextField nameField, ageField;
    private JComboBox<String> genderComboBox, countryComboBox;
    private JTextArea commentsArea;
    private JButton saveButton;
    private JCheckBox highlightCheckbox;

    private String[] genders = {"Мужской", "Женский"};
    private String[] countries = {"Россия", "США", "Китай", "Германия", "Франция"};

    public ProfileForm() {
        this.setTitle("Заполнение анкеты");
        this.setSize(400, 400);
        this.setLayout(new GridLayout(6, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Имя:");
        nameField = new JTextField();

        ageLabel = new JLabel("Возраст:");
        ageField = new JTextField();

        genderLabel = new JLabel("Пол:");
        genderComboBox = new JComboBox<>(genders);

        countryLabel = new JLabel("Страна:");
        countryComboBox = new JComboBox<>(countries);

        commentsLabel = new JLabel("Комментарии:");
        commentsArea = new JTextArea();

        saveButton = new JButton("Сохранить");
        saveButton.addActionListener(this);

        highlightCheckbox = new JCheckBox("Подсветить данные");

        this.add(nameLabel);
        this.add(nameField);
        this.add(ageLabel);
        this.add(ageField);
        this.add(genderLabel);
        this.add(genderComboBox);
        this.add(countryLabel);
        this.add(countryComboBox);
        this.add(commentsLabel);
        this.add(commentsArea);
        this.add(saveButton);
        this.add(highlightCheckbox);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ProfileForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            saveDataToFile();
            JOptionPane.showMessageDialog(this, "Данные сохранены!");
        }
    }

    private void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("profile.txt"))) {
            writer.println("Имя: " + nameField.getText());
            writer.println("Возраст: " + ageField.getText());
            writer.println("Пол: " + genderComboBox.getSelectedItem());
            writer.println("Страна: " + countryComboBox.getSelectedItem());
            writer.println("Комментарии: " + commentsArea.getText());
            writer.println("Подсветить данные: " + highlightCheckbox.isSelected());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при сохранении данных!");
            ex.printStackTrace();
        }
    }
}

