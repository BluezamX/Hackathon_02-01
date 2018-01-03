package Main.Game.TextPane;

import Main.Util.Constants;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 * Created by jaspe on 02/01/2018.
 * 
 */
public class TextPane extends Pane {

  TextArea area = new TextArea();
  int number = 0;
  String text = "";
  boolean acceptsText = true;

  public TextPane(){
    area.setStyle("-fx-font-size: 3em;");
    area.setEditable(false);
    area.setText("No Reception!\n" +
        "By Jasper Wijnhoven, Yvan Bibollet-Ruche, Caia Leithuijser and Nicky van Oort.");
    area.setWrapText(true);
    area.setMinWidth(Constants.width /  3 * 2);
    area.setMinHeight(Constants.height / 3);
    getChildren().add(area);
  }

//  public void print(String text){
//    area.setText(text);
//  }

  public void print(String text, int speed){
    if (!acceptsText){
      System.out.println("Stopped.");
      return;
    }
    area.clear();
    final IntegerProperty getal = new SimpleIntegerProperty(0);
    Timeline timeline = new Timeline(
      new KeyFrame(
        Duration.millis(speed),
        event -> {
          acceptsText = false;
          String temp = Character.toString(text.charAt(getal.getValue()));
          area.setText(area.getText() + temp);
          getal.set(getal.get() + 1);
          if (getal.get() == text.length()) acceptsText = true;
        }
      )
    );
    timeline.setCycleCount(text.length());
    timeline.play();
  }
}
