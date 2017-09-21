import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class FX extends Application {
    public void start (Stage primaryStage){
        //JOptionPane
        int screenWidth;
        int screenHeigth;

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolKit.getScreenSize();
        screenWidth = (int)dimension.getWidth();
        screenHeigth = (int)dimension.getHeight();

        JOptionPane pane = new JOptionPane("Enter your height in Centimeters. ");
        JDialog dialog;
        pane.setWantsInput(true);

        dialog = pane.createDialog("Centimeters to Inches");

        dialog.setLocation(0,screenHeigth - dialog.getHeight()*3);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        JOptionPane resultPane = new JOptionPane("Result is " + Double.parseDouble((String)(pane.getInputValue()))*0.39 + "In.");
        JDialog resultDialog;
        resultDialog = resultPane.createDialog("Result");
        resultDialog.setLocation(screenWidth - dialog.getWidth(),screenHeigth - dialog.getHeight()*3);
        resultDialog.setAlwaysOnTop(true);
        resultDialog.setVisible(true);

        //java fx input message
        TextInputDialog textInputDialog = new TextInputDialog("150");
        textInputDialog.setTitle ("Metric Converter");
        textInputDialog.setHeaderText("Centimeters to Feet and Inches Converter");
        textInputDialog.setContentText("Enter your heiht in centimeters");
        Optional<String> result = textInputDialog.showAndWait();

        //logic
        double heightInCm = Double.parseDouble(result.get());
        double heightInInches = heightInCm*0.39;
        int heightInFeet = (int)(heightInInches/12); //casting
        int remainderHeightInInches = (int)(heightInInches%12); //% is for only the reminder

        //display information
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Height Converter");
        alert.setHeaderText("Your Height is ");
        alert.setContentText(heightInFeet + "feet " + remainderHeightInInches + "Inches.");
        alert.showAndWait();

        //location

      
    }
}

