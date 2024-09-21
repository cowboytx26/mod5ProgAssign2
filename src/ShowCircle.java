/*
Short Description:  This program will display a circle with a white fill, but when the mouse is clicked, the
                    fill turns black.  When the mouse is released, it turns back to white.
Author:  Brian Wiatrek
Date:  September 21, 2024
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle extends Application {

    //The circle pane will contain the circle
    private CirclePane circlePane = new CirclePane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        // Create a scene and place it in the stage
        Scene scene = new Scene(circlePane, 200, 200);

        //The next two lines utilizes lambda to register the appropriate change color
        //method to the appropriate event
        circlePane.setOnMousePressed(e -> circlePane.changeColorToBlack());
        circlePane.setOnMouseReleased(e -> circlePane.changeColorToWhite());

        primaryStage.setTitle("ShowCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    class CirclePane extends StackPane {

        //Declare a circle for the Pane
        private Circle circle = new Circle(50);

        public CirclePane() {
            //Constructor sets the variables appropriately for the pane
            circle.setCenterX(100);
            circle.setCenterY(100);
            circle.setRadius(50);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.WHITE);
            getChildren().add(circle);
        }

        public void changeColorToWhite() {
            //This method changes the color to white
            circle.setFill(Color.WHITE);
        }

        public void changeColorToBlack() {
            //This method changes the color to black
            circle.setFill(Color.BLACK);
        }
    }
}