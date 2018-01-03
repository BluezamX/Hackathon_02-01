package Main.Game.OptionPane;

import Main.Game.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;




public class OptionPane extends Pane {


    Button buttonja;
    Button buttonnee;
    ApplicationPane applicationPane ;
    public OptionPane(ApplicationPane app ) {
        this.applicationPane = app;

        BorderPane root = new BorderPane();
        buttonja =  new Button("Ja");
        buttonnee = new Button("Nee");
        buttonja.setOnAction(buttonHandler);
        buttonnee.setOnAction(buttonHandler);
        root.setLeft(buttonja);
        root.setRight(buttonnee);
        getChildren().add(root);
    }

    EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource().equals(buttonja)) {
                applicationPane.praat(true);
                event.consume();
            }
            if(event.getSource().equals(buttonnee)) {
                applicationPane.praat(false);
                event.consume();
            }
        }
    };
}
