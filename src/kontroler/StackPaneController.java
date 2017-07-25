package kontroler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StackPaneController {
	@FXML
	private Button button;
	@FXML
	private GridPane gridpanel;
	Gra gra = new Gra();
	private EventHandler<ActionEvent> handler;
	public StackPaneController() {
	};

	@FXML
	void initialize() {

		handler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(((Button)event.getSource()).getText());

				//if (!((Button) event.getSource()).getText().toString().equals("OK")) {
					gra.graj(((Button) event.getSource()).getId());
			//	}

			}

		};
		uruchomGre();
	}

	public void onClick(ActionEvent e) {
	 gra.odNowa();
	 gra.losuj(100);

	}

	private void uruchomGre() {
		int nr = 1;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				gridpanel.add(gra.przyciski[nr], j, i);
				gra.przyciski[nr].addEventHandler(ActionEvent.ACTION, handler);
				nr++;
			}
	}

}
