package ui;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 * MouseSensitivityScreen is the view screen for modifying mouse sensitivity.
 * A slider is used to change the sensitivity and can be saved with the save button.
 * Hitting the back button saves nothing.
 */
public class MouseSensitivityScreen extends Pane {

    Slider slider = new Slider(1, 20, 10);

    public MouseSensitivityScreen() {
        this.setStyle("-fx-background-color: #99aab5;");

        slider.setLayoutX(60);
        slider.setLayoutY(375);
        slider.setStyle("-fx-pref-width: 680px; -fx-pref-height: 50px; -fx-font-size: 24; -fx-control-inner-background: #2c2f33");
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);


        Label sliderLabel = new Label("Change Mouse Sensitivity:");
        sliderLabel.setLayoutX(60);
        sliderLabel.setLayoutY(285);
        sliderLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        this.getChildren().addAll(slider, sliderLabel);
    }

    /**
     * Get method for the sensitivity value in the slider.
     * @return Slider value for the mouse sensitivity bar.
     */
    public double getSensitivity() {
        return slider.getValue();
    }
}
