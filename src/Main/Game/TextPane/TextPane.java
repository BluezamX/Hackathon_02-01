package Main.Game.TextPane;

import Main.Util.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;



/**
 * Created by jaspe on 02/01/2018.
 * 
 */
public class TextPane extends Pane {

    public TextPane(){
        setMaxHeight(Constants.height / 3);
        setMaxHeight(Constants.height / 3);
        setMinWidth(Constants.width);
        setMaxWidth(Constants.width);
        TextArea area = new TextArea();
        area.setEditable(false);
        area.setText("JEMOEDERISEENGROTEHOERMETEENDIKKENEUS");
        getChildren().add(area);

    }

}
