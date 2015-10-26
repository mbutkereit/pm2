package aufgabenblatt2;

import java.util.ArrayList;
import java.util.List;

public class Rennen {

	public static void main(String[] args) {
		
		List<Rennauto> rennWagen = new ArrayList<Rennauto>();

		Rennabbruch rennabbruch = new Rennabbruch(rennWagen);

		Rennauto vettel = new Rennauto("Vettel", 10, 1);
		Rennauto schumi = new Rennauto("Schumi", 10, 1);
		Rennauto ricardo = new Rennauto("Ricardo", 10, 1);

		rennWagen.add(0, vettel);
		rennWagen.add(1, schumi);
		rennWagen.add(2, ricardo);
		
		for (Rennauto car : rennWagen) {
			car.start();
		}

		rennabbruch.start();

		int imZiel = 0;
		do {
			imZiel = 0;
			for (Rennauto car : rennWagen) {
				if (!car.isAlive()) {
					imZiel++;
				}
			}

		} while (rennWagen.size() > imZiel);
		
		if (rennabbruch.isAlive()) {
			rennabbruch.interrupt();
		}
		
		rennWagen.sort(null);
		System.out.println("Ergebnis:");
		for (Rennauto auto : rennWagen) {
			System.out.println(auto);
		}
	}

}
