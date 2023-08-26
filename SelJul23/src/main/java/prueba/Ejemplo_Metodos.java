package prueba;

public class Ejemplo_Metodos {

	public static void main(String[] args) {
		int resultado = suma(3,4);
		System.out.println(resultado);
		
		int resultado2 = suma(10,345);
		System.out.println(resultado2);
		
		int resultado3 = suma(10,20,40);
		System.out.println(resultado3);


	}
	
	public static int suma (int a, int b) {
		int c = a + b;
		return c;
	}
	
	public static int suma (int a, int b, int c) {
		int d = a + b + c;
		return d;
	}

}
