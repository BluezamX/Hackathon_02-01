package Main.Game;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class ApllicationMenu extends Pane {

    public ApllicationMenu() {
        Button startknop = new Button("Start");
        getChildren().add(startknop);
        startknop.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                       ApplicationPane applicationPane = new ApplicationPane();

                       getChildren().add(applicationPane);

                    }
                });

    }
}
