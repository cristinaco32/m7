package com.example.m7p1javafxcci;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Controller {
    public AnchorPane background;
    @FXML
    private TextField textField;
    @FXML
    private Label textLabel;
    @FXML
    private Circle geometricFigure;
    private Alert emptyInputAlert;
    private Alert invalidHexAlert;

    public void alertInitialize() {
        emptyInputAlert = new Alert(Alert.AlertType.WARNING);
        emptyInputAlert.setTitle("Empty Input");
        emptyInputAlert.setHeaderText(null);
        emptyInputAlert.setContentText("The input should not be empty. Please enter a color code");

        invalidHexAlert = new Alert(Alert.AlertType.ERROR);
        invalidHexAlert.setTitle("Invalid Hex Code");
        invalidHexAlert.setHeaderText(null);
        invalidHexAlert.setContentText("Please enter a valid hexadecimal color code.");
    }

    @FXML
    protected void onPaintButtonClick() {
        alertInitialize();
        String colorText = textField.getText();

        if (colorText.isEmpty()) {
            emptyInputAlert.showAndWait();
        } else if (isValidHexaCode(colorText)) {
            setPaintButton(colorText);
        } else if (isValidColorName(colorText)) {
            setPaintButton(colorText);
        } else {
            invalidHexAlert.showAndWait();
        }
    }
    protected void setPaintButton(String color) {
        String titleColor = setTitleWithColorName(color);
        textLabel.setText(titleColor);
        geometricFigure.setFill(Color.valueOf(color));
    }

    public Boolean isValidHexaCode(String color) {
        String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        Pattern pattern = Pattern.compile(regex);

        if (color == null) return false;
        Matcher matcher =pattern.matcher(color);

        return matcher.matches();
    }

    public Boolean isValidColorName(String colorText) {
        try {
            Color.web(colorText);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public String setTitleWithColorName(String color) {
        String labelText = "The Circle is ";
        return labelText + color;
    }
}