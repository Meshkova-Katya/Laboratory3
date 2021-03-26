package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    static double x, y, z;
    static double x2, y2;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField label1;

    @FXML
    private TextField label2;

    @FXML
    private TextField label3;

    @FXML
    private Label label4;

    @FXML
    private Button button1;

    @FXML
    private TextField labelX;

    @FXML
    private TextField labelY;

    @FXML
    private RadioButton radCos;

    @FXML
    private RadioButton radSqr;

    @FXML
    private RadioButton radExp;

    @FXML
    private Label function;

    @FXML
    private Button button2;

    @FXML
    private ToggleGroup group;

    @FXML
    void onClickButton1(ActionEvent event) {
        if (parses(label1, label2, label3)) {
            double a = Math.log(y - Math.sqrt(Math.abs(x))) * (x - 2 * y) + Math.sin(2) * Math.atan(z);
            label4.setText("a= " + a);
        } else label4.setText("Ошибка");
    }

    @FXML
    void onClickButton2(ActionEvent event) {

        if (checkingForValidity(labelX, labelY)) groupSelection();
        else {
            function.setText("Ошибка!");
        }


    }

    boolean parses(TextField... label) {
        boolean isBool = false;
        String str = "Некорректный ввод";
        try {
            x = Double.parseDouble(label1.getText());
            isBool = true;
        } catch (Exception e) {
            label1.setText(str);
            isBool = false;
        }
        try {
            y = Double.parseDouble(label2.getText());
            isBool = true;
        } catch (Exception e) {
            label2.setText(str);
            isBool = false;
        }
        try {
            z = Double.parseDouble(label3.getText());
            isBool = true;
        } catch (Exception e) {
            label3.setText(str);
            isBool = false;
        }
        return isBool;
    }

    boolean checkingForValidity(TextField... label) {
        boolean isBool = false;
        String str = "Некорректный ввод";
        try {
            x2 = Double.parseDouble(labelX.getText());
            isBool = true;
        } catch (Exception e) {
            labelX.setText(str);
            isBool = false;
        }
        try {
            y2 = Double.parseDouble(labelY.getText());
            isBool = true;
        } catch (Exception e) {
            labelY.setText(str);
            isBool = false;
        }
        return isBool;
    }

    void cosFunction() {
        if (4 > x2 * y2 && 1 < x2 * y2) {
            function.setText("Ответ: " + String.valueOf(Math.pow((Math.cos(x2) + y), 2)));
        }
        if (8 < x2 * y2 && 10 > x2 * y2) {
            function.setText("Ответ: " + String.valueOf(Math.cos(x2) * Math.tan(y2)));
        }
        function.setText("Ответ: " + String.valueOf(Math.cos(x2) + y2));
    }


    void sqrFunction() {
        if (4 > x2 * y2 && 1 < x2 * y2) {
            function.setText("Ответ: " + String.valueOf(Math.pow((Math.sqrt(x2) + y2), 2)));
        }
        if (8 < x2 * y2 && 10 < x2 * y2) {
            function.setText("Ответ: " + String.valueOf(Math.sqrt(x2) * Math.tan(y2)));
        }
        function.setText("Ответ: " + String.valueOf(Math.exp(x2) + y2));
    }

    void expFunction() {
        if (4 > x2 * y2 && 1 < x2 * y2) {
            function.setText("Ответ: " + String.valueOf(Math.pow((Math.exp(x2) + y2), 2)));
        }
        if (8 < x2 * y2 && 10 < x2 * y2) {
            function.setText("Ответ: " + String.valueOf(Math.exp(x2) * Math.tan(y2)));
        }
        function.setText("Ответ: " + String.valueOf(Math.exp(x2) + y2));
    }

    void groupSelection() {
        if (group.getSelectedToggle().equals(radCos)) cosFunction();
        if (group.getSelectedToggle().equals(radSqr)) sqrFunction();
        if (group.getSelectedToggle().equals(radExp)) expFunction();
    }
}
