package mainapp;

import java.util.ArrayList;
import java.util.Comparator;

import exceptions.ColaExceededSizeException;
import exceptions.LlevateTuNullDeAquiException;
import models.ColaDelCastigo;
import models.Comparador;
import models.Ordenador;

public class MainApp {

	public static void main(String[] args) throws Exception {
	
		/*  COMPARADORES
		 * 
		 *  Si queremos ordenarlo por nombre (alfabeticamente) 
		 * 
		 *  Comparator<Ordenador> CompaPorName = (Ordenador o1, Ordenador o2) -> o1.getName().compareTo(o2.getName());
		 *
		 *  Como vamos a hacerlo por el numero de serie utilizamos el siguiente comparador
		 */
		
		 Comparator<Ordenador> compaPorNum = (Ordenador o1, Ordenador o2) -> o1.getNumSerie() - (o2.getNumSerie());

		/*
		 * Creamos la cola y dichos ordenadores para comenzar a utilizar los métodos de la cola
		 */
		 

		 
		 Ordenador o0 = new Ordenador ("MiniPC", 12340);
		 Ordenador o1 = new Ordenador ("MiniPC1", 12341);
		 Ordenador o2 = new Ordenador ("MiniPC2", 12342);
		 Ordenador o3 = new Ordenador ("MiniPC3", 12343);
		 Ordenador o4 = new Ordenador ("MiniPC4", 12344);
		 Ordenador o5 = new Ordenador ("MiniPC5", 12345);
		 Ordenador o6 = new Ordenador ("MiniPC6", 12346);	 
		 Ordenador o7 = new Ordenador ("MiniPC7", 12347);
		 Ordenador o8 = new Ordenador ("MiniPC8", 12348);
		 Ordenador o9 = new Ordenador ("MiniPC9", 12349);
		 
		 Ordenador o10 = new Ordenador ("MiniPC", 12350);
		 
		 ColaDelCastigo <Ordenador> cola = new ColaDelCastigo <Ordenador>(compaPorNum);

		 
		 /*
		  * Antes de empezar las pruebas debemos tener en cuenta que para que el programa funcione 
		  * correctamente debemos comentar e ir descomentandolas poco a poco ya que 
		  * las Exceptions lo detendrán
		  */
		 
		 /*
		  * 1. Comprobamos el tamaño de la cola, que deberá devolver 0 ya que no hemos añadido nada aun:
		  */		 		 
		  System.out.println("Tamaño Cola: " + cola.size());
		  
		 /*
		  * Por lo tanto si queremos saber si esta vacio nos devolverá true:
		  */
		  System.out.println("Vacia: " + cola.isEmpty());

		  
		 /*
		  * add() añade a la cola los objetos que deseemos (en este caso ordenadores), probamos con un valor nulo
		  * para que nos salte la primera excepción, añadimos el segundo párrafo y no habra problema, pero al intentar
		  * añadir el décimo ordenador nos saltara otra excepción
		  */
		 
		 /*
		  * volver a comentar para continuar
		  */
		 //cola.add(null);
		 
		 cola.add(o9);
		 cola.add(o4);
		 cola.add(o8);
		 cola.add(o3);
		 cola.add(o1);
		 cola.add(o2);
		 cola.add(o6);
		 cola.add(o7);
		 cola.add(o5);
		 cola.add(o0);
		 
		 /*
		  * volver a comentar para continuar
		  */
		 //cola.add(o10);
		 
		 /*
		  * 2. Utilizamos el metodo offer() para que nos devuelva true or false si fuese posible añadirlo,
		  * en este caso no habrá excepciones, solo devolerá true o false y el programa podrá continuar
		  */
		 System.out.println("\nEs posible añadir a o10?\n" + cola.offer(o10));
	
		 /*
		  * Volvemos a comprobar el tamaño de la cola, que deberá devolver 10:
		  */		 
		  System.out.println("\nTamaño Cola: " + cola.size());
		  
		 /*
		  * Ahora isEmpty() nos devolvera false.
		  */
		 System.out.println("Vacia: " + cola.isEmpty());
		 
		 /*
		  * Con contains comprobamos que la cola contenga al ordenador que deseemos y lo eliminamos, 
		  * volvemos a comprobar
		  */
		 System.out.println("\n¿La cola contiene a o6?\n" + cola.contains(o6));
		 cola.remove(o6);
		 System.out.println("Eliminando elemento o6...");
		 System.out.println("\n¿La cola contiene a o6?" + cola.contains(o6));
		  System.out.println("Tamaño Cola: " + cola.size());


		 /*
		  * Ahora removeremos el primer elemento de la cola y comprobaremos que ha sido así 
		  */
		 System.out.println("\nPrimer elemento de la cola: \n" + cola.element());
		 cola.remove();
		 System.out.print("Eliminando primer elemento...");
		 System.out.println("\n¿Se ha eliminado correctamente?: \n" + cola.contains(cola.element()));
		 System.out.println("Tamaño Cola: " + cola.size());

		 
		 /*
		  * He creado distintos arrayLists para utilizar los metodos que necesitan una coleccion
		  * @pcA array para añadir
		  * @pcE array para eliminar
		  * @pcC array para comprobar si los contiene
		  */
		 
		 ArrayList<Ordenador> pcE = new ArrayList<Ordenador>();
		 ArrayList<Ordenador> pcA = new ArrayList<Ordenador>();
		 ArrayList<Ordenador> pcC = new ArrayList<Ordenador>();

		 
		 pcE.add(o1);
		 pcE.add(o2);
		 
		 pcA.add(o3);
		 pcA.add(o4);
		 
		 pcC.add(o5);
		 pcC.add(o7);
		 
		 
		 /*
		  * Comenzamos intentando vaciar la cola, lo que no será posible
		  */
		 
		 /*
		  * volver a comentar para continuar
		  */
		 //cola.clear();
		 
		 /*
		  * Intentaremos añadir la siguiente colección, lo cual será posible ya que anterior mente 
		  * hemos eliminado dos elementos por lo que el tamaño actual es 8 y será despues 10
		  */
		  System.out.println("\nAñadiendo coleccion...");
		  cola.addAll(pcA);
		  System.out.println("Tamaño Cola: " + cola.size());
		  System.out.println("Se ha añadido correctamente...\n");
		  
		  /*
		   * Eliminamos la colección pcE, el tamaño deberia ser 8
		   */
		  System.out.println("\nEliminando coleccion... ");
		  cola.removeAll(pcE);
		  System.out.println("Tamaño Cola: " + cola.size());

		  /*
		   * Eliminamos los elementos distintos a la conección pcC, el tamaño quedará en dos
		   */
		  System.out.println("\nEliminando todos los elementos distintos a la colección introducida...");
		  cola.retainAll(pcC);
		  System.out.println("Tamaño Cola: " + cola.size());
		  


 
	}

}
