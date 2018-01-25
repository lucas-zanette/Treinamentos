import java.util.LinkedList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lstS = new LinkedList<Integer>();
		
		lstS.add(5);
		lstS.add(70);
		lstS.add(3);
		lstS.add(27);
		lstS.add(55);
		lstS.add(87);
		lstS.add(905);
		lstS.add(1);
		lstS.add(-2);
		lstS.add(3);
		lstS.add(57);
		lstS.add(89);
		verificaMenor(lstS);
	}

	public static void verificaMenor(List<Integer> lstS){
		
		int pos = -1;
		int menor = Integer.MAX_VALUE;
		
		for (int i = 0;  i < lstS.size(); i++) {			
			if ( lstS.get(i) < menor ) {
				menor = lstS.get(i);
				pos = i;			
			}
		}
		
		if (pos > -1){
			lstS.remove(pos);
		}
		
		for (Integer n : lstS) {
			System.out.println("O menor valor é: " + n);
		}
	}
	
}
	
