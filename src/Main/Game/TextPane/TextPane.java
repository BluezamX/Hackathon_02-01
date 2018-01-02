package Main.Game.TextPane;

import Main.Util.Constants;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;



/**
 * Created by jaspe on 02/01/2018.
 * 
 */
public class TextPane extends Pane {

  public TextPane(){
    TextArea area = new TextArea();
    area.setEditable(false);
    area.setText("JEMOEDERISEENGROTEHOERMETEENDIKKENEUS yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
    area.setWrapText(true);
    area.setMinWidth(Constants.width);
    area.setMinHeight(Constants.height / 3);
    getChildren().add(area);
  }
}
