import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Create UI components
        Label choiceLabel = new Label("Choose a conversion:");
        ComboBox<String> conversionOptions = new ComboBox<>();
        conversionOptions.getItems().addAll(
                "Pounds to Kilograms",
                "Inches to Millimeters",
                "Miles to Kilometers",
                "Feet to Yards",
                "Fahrenheit to Celsius"
        );

        Label inputLabel = new Label("Enter value:");
        TextField inputField = new TextField();
        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        // Set up the layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(choiceLabel, 0, 0);
        grid.add(conversionOptions, 1, 0);
        grid.add(inputLabel, 0, 1);
        grid.add(inputField, 1, 1);
        grid.add(convertButton, 1, 2);
        grid.add(resultLabel, 0, 3, 2, 1);

        // Set up the button action
        convertButton.setOnAction(e -> {
            String selectedConversion = conversionOptions.getValue();
            String inputValue = inputField.getText();
            double result = 0;
            String outputMessage = "";

            try {
                double input = Double.parseDouble(inputValue);

                switch (selectedConversion) {
                    case "Pounds to Kilograms":
                        result = input * 0.45359237;
                        outputMessage = input + " pounds is " + Math.round(result * 100.0) / 100.0 + " kilograms.";
                        break;
                    case "Inches to Millimeters":
                        result = input * 25.4;
                        outputMessage = input + " inches is " + Math.round(result * 100.0) / 100.0 + " millimeters.";
                        break;
                    case "Miles to Kilometers":
                        result = input / 0.6214;
                        outputMessage = input + " miles is " + Math.round(result * 100.0) / 100.0 + " kilometers.";
                        break;
                    case "Feet to Yards":
                        result = input / 3;
                        outputMessage = input + " feet is " + result + " yards.";
                        break;
                    case "Fahrenheit to Celsius":
                        result = (input - 32) * 5 / 9;
                        outputMessage = input + " Fahrenheit is " + result + " Celsius.";
                        break;
                    default:
                        outputMessage = "Please select a conversion type.";
                }
            } catch (NumberFormatException ex) {
                outputMessage = "Please enter a valid number.";
            }

            resultLabel.setText(outputMessage);
        });

        // Set up the scene and show the stage
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}