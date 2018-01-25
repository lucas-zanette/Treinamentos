package aula;

import java.util.Comparator;

public class OrdenaTerreno implements Comparator<Terreno> {

	@Override
	public int compare(Terreno t1, Terreno t2) {
		if (t1.getPreco() > t2.getPreco())
			return -1;
		else
			return 1;
	}

}
