package kontroler;

import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Gra {
	private final String PUSTY = "    ";
	private int nrPustego = 16;
	public Button[] przyciski = new Button[17];

	public Gra() {
		poczatek();
		losuj(10);
	}

	public void poczatek() {
		for (int nr = 1; nr <= 16; nr++) {
			if (nr < 10) {
				przyciski[nr] = new Button("0" + Integer.toString(nr));

			} else {
				przyciski[nr] = new Button(Integer.toString(nr));
			}
			przyciski[nr].setId(Integer.toString(nr));
		}
		przyciski[16].setText(PUSTY);
	}

	public void odNowa() {
		for (int nr = 1; nr <= 16; nr++) {
			przyciski[nr].setText(Integer.toString(nr));
		}
		
	}

	public void losuj(int ileRazy) {
		int wylosowany;
		Random r = new Random();
		for (int i = 0; i < ileRazy; i++) {
			wylosowany = r.nextInt() % 4;
			if (wylosowany == 0 && nrPustego > 4) {
				int napisWylosowanego = Integer.parseInt(przyciski[nrPustego - 4].getText());
				przyciski[nrPustego].setText(Integer.toString(napisWylosowanego));
				przyciski[nrPustego - 4].setText(PUSTY);
				nrPustego -= 4;
				continue;
			}
			if (wylosowany == 1 && nrPustego % 4 > 0) {
				int napisWylosowanego = Integer.parseInt(przyciski[nrPustego + 1].getText());
				przyciski[nrPustego].setText(Integer.toString(napisWylosowanego));
				przyciski[nrPustego + 1].setText(PUSTY);
				nrPustego += 1;
				continue;
			}
			if (wylosowany == 2 && nrPustego < 12) {
				int napisWylosowanego = Integer.parseInt(przyciski[nrPustego + 4].getText());
				przyciski[nrPustego].setText(Integer.toString(napisWylosowanego));
				przyciski[nrPustego + 4].setText(PUSTY);
				nrPustego += 4;
			}
			if (wylosowany == 3 && nrPustego % 4 != 1) {
				int napisWylosowanego = Integer.parseInt(przyciski[nrPustego - 1].getText());
				przyciski[nrPustego].setText(Integer.toString(napisWylosowanego));
				przyciski[nrPustego - 1].setText(PUSTY);
				nrPustego -= 1;
			}
		}
		popraw();
	}

	private void popraw() {
		for (int i = 1; i <= 16; i++) {
			if (przyciski[i].getText().length() < 2)
				przyciski[i].setText("0" + przyciski[i].getText());
		}
	}

	public void graj(String sIdNacisnietego) {
		int idNacisnietego = Integer.parseInt(sIdNacisnietego);
		if (idNacisnietego - 1 == nrPustego || idNacisnietego + 1 == nrPustego || idNacisnietego - 4 == nrPustego
				|| idNacisnietego + 4 == nrPustego) {
			int pom = nrPustego;
			String nrNacisnietego = przyciski[idNacisnietego].getText();
			nrPustego = idNacisnietego;
			idNacisnietego = pom;
			przyciski[nrPustego].setText(PUSTY);
			przyciski[idNacisnietego].setText(nrNacisnietego);
		}
		if (czyKoniec()) {
			odNowa();
			losuj(100);
		}

	}

	public boolean czyKoniec() {
		int ile = 1;
		while (ile != nrPustego && Integer.parseInt(przyciski[ile].getText()) == ile) {
			ile++;
		}
		if (ile == 16) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informacja dnia");
			alert.setHeaderText(null);
			alert.setContentText("Ukonczyłes grę");
			alert.showAndWait();
            return true;
		}
		return false;
	}
}
