package com.example.calcapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class HelloController {
    @FXML
    TextField textField;
    @FXML
    private Button modulusButton, ClearButton, deleteButton, divButton, sevenButton, eightButton, nineButton, multipleButton, fourButton, fiveButton, sixButton, subtractButton, oneButton, twoButton, threeButton, addButton, negButton, zeroButton, pointButton, ansButton;
    private ArrayList<Button> buttonList;

    private double num1 = 0;
    private double num2 = 0;
    private String operator = " ";

    public void initialize() {
        buttonList = new ArrayList<>();

        //Operators
        buttonList.add(divButton);
        buttonList.add(multipleButton);
        buttonList.add(subtractButton);
        buttonList.add(ansButton);
        buttonList.add(ClearButton);
        buttonList.add(addButton);
        buttonList.add(deleteButton);
        buttonList.add(negButton);
        buttonList.add(pointButton);
        buttonList.add(modulusButton);


        //first row
        buttonList.add(sevenButton);
        buttonList.add(eightButton);
        buttonList.add(nineButton);
        //second row
        buttonList.add(fourButton);
        buttonList.add(fiveButton);
        buttonList.add(sixButton);

        //thirdRow
        buttonList.add(threeButton);
        buttonList.add(twoButton);
        buttonList.add(oneButton);

        //fourth row
        buttonList.add(zeroButton);


        for (Button button : buttonList) {
            if (!button.getText().equals("=") && !button.getText().equals("C") &&
                    !button.getText().equals("DEL") && !button.getText().equals("%") &&
                    !button.getText().equals(".") && !button.getText().equals("-+")) {
                button.setOnAction(event -> {
                    textField.appendText(button.getText());
                });
            }
        }
        // Set actions for operator buttons
        for (Button button : buttonList) {
            String buttonText = button.getText();
            if (buttonText.matches("[+\\-X/]")) {
                button.setOnAction(event -> {
                    operator = buttonText;
                    num1 = Double.parseDouble(textField.getText());
                    textField.clear();
                });
            } else if (buttonText.equals("=")) {
                button.setOnAction(event -> {
                    num2 = Double.parseDouble(textField.getText());
                    double result = calculateResult(num1, num2, operator);
                    displayResult(result);
                });
            } else if (buttonText.equals("C")) {
                button.setOnAction(event -> {
                    clearTextField();
                });
            } else if (buttonText.equals("DEL")) {
                button.setOnAction(event -> {
                    deleteCharacter();
                });
            } else if (buttonText.equals("%")) {
                button.setOnAction(event -> {
                    num1 = Double.parseDouble(textField.getText());
                    double percentage = num1 / 100;
                    displayResult(percentage);
                });
            } else if (buttonText.equals(".")) {
                button.setOnAction(event -> {
                    if (!textField.getText().contains(".")) {
                        textField.appendText(buttonText);
                    }
                });
            } else if (buttonText.equals("-+")) {
                button.setOnAction(event -> {
                    String currentText = textField.getText();
                    if (!currentText.isEmpty() && !currentText.equals("0")) {
                        if (currentText.charAt(0) == '-') {
                            textField.setText(currentText.substring(1));
                        } else {
                            textField.setText("-" + currentText);
                        }
                    }
                });
            }
        }
    }

    private void deleteCharacter() {
        String currentText = textField.getText();
        if (!currentText.isEmpty()) {
            textField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    private void clearTextField() {
        textField.clear();
        num1 = 0;
        num2 = 0;
        operator = "";
    }

    private void displayResult(double result) {
        if (result == (int) result) {
            textField.setText(Integer.toString((int) result));
        } else {
            textField.setText(Double.toString(result));
        }
    }

    private double calculateResult(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "X":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println(" ");
                    ;
                }
            default:
                return Double.NaN;
        }
    }
}
