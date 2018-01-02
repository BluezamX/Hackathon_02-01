package Main.Game.TextPane;

import Main.Util.Constants;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


/**
 * Created by jaspe on 02/01/2018.
 * 
 */
public class TextPane extends Pane {

  TextArea area = new TextArea();
  public TextPane(){
    area.setStyle("-fx-font-size: 3em;");
    area.setEditable(false);
    area.setText("No Reception!\n" +
        "By Jasper Wijnhoven, Yvan Bibollet-Ruche, Caia Leithuijser and Nicky van Oort.");
    area.setWrapText(true);
    area.setMinWidth(Constants.width);
    area.setMinHeight(Constants.height / 3);
    getChildren().add(area);
  }

  public void print(String text){
    area.setText(text);
  }

  public void append(String text){
    area.setText(area.getText() + text);
  }
}
