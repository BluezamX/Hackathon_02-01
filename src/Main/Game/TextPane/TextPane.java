package Main.Game.TextPane;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;



/**
 * Created by jaspe on 02/01/2018.
 */
public class TextPane extends Pane {

    public TextPane(){
        TextArea area = new TextArea();
        area.setEditable(false);
        area.setText("JEMOEDERISEENGROOTEHOERMETEENDIKKENEUS");
        getChildren().add(area);

    }

}
