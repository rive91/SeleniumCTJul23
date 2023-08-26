package prueba;

public class Ejemplo_If_Anidado {

	public static void main(String[] args) {
		int temperatura = 26;
		
		if(temperatura > 15) {
			if(temperatura > 25) {
				System.out.println("A la Playa!!!");
			}else {
				System.out.println("A la montaña!!!");
			}
		}else {
			System.out.println("A Descansar....");
		}

	}

}
