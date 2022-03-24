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
		 * Creamos la cola y dichos ordenadores para comenzar a utilizar los m�todos de la cola
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
		  * las Exceptions lo detendr�n
		  */
		 
		 /*
		  * 1. Comprobamos el tama�o de la cola, que deber� devolver 0 ya que no hemos a�adido nada aun:
		  */		 		 
		  System.out.println("Tama�o Cola: " + cola.size());
		  
		 /*
		  * Por lo tanto si queremos saber si esta vacio nos devolver� true:
		  */
		  System.out.println("Vacia: " + cola.isEmpty());

		  
		 /*
		  * add() a�ade a la cola los objetos que deseemos (en este caso ordenadores), probamos con un valor nulo
		  * para que nos salte la primera excepci�n, a�adimos el segundo p�rrafo y no habra problema, pero al intentar
		  * a�adir el d�cimo ordenador nos saltara otra excepci�n
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
		  * 2. Utilizamos el metodo offer() para que nos devuelva true or false si fuese posible a�adirlo,
		  * en este caso no habr� excepciones, solo devoler� true o false y el programa podr� continuar
		  */
		 System.out.println("\nEs posible a�adir a o10?\n" + cola.offer(o10));
	
		 /*
		  * Volvemos a comprobar el tama�o de la cola, que deber� devolver 10:
		  */		 
		  System.out.println("\nTama�o Cola: " + cola.size());
		  
		 /*
		  * Ahora isEmpty() nos devolvera false.
		  */
		 System.out.println("Vacia: " + cola.isEmpty());
		 
		 /*
		  * Con contains comprobamos que la cola contenga al ordenador que deseemos y lo eliminamos, 
		  * volvemos a comprobar
		  */
		 System.out.println("\n�La cola contiene a o6?\n" + cola.contains(o6));
		 cola.remove(o6);
		 System.out.println("Eliminando elemento o6...");
		 System.out.println("\n�La cola contiene a o6?" + cola.contains(o6));
		  System.out.println("Tama�o Cola: " + cola.size());


		 /*
		  * Ahora removeremos el primer elemento de la cola y comprobaremos que ha sido as� 
		  */
		 System.out.println("\nPrimer elemento de la cola: \n" + cola.element());
		 cola.remove();
		 System.out.print("Eliminando primer elemento...");
		 System.out.println("\n�Se ha eliminado correctamente?: \n" + cola.contains(cola.element()));
		 System.out.println("Tama�o Cola: " + cola.size());

		 
		 /*
		  * He creado distintos arrayLists para utilizar los metodos que necesitan una coleccion
		  * @pcA array para a�adir
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
		  * Comenzamos intentando vaciar la cola, lo que no ser� posible
		  */
		 
		 /*
		  * volver a comentar para continuar
		  */
		 //cola.clear();
		 
		 /*
		  * Intentaremos a�adir la siguiente colecci�n, lo cual ser� posible ya que anterior mente 
		  * hemos eliminado dos elementos por lo que el tama�o actual es 8 y ser� despues 10
		  */
		  System.out.println("\nA�adiendo coleccion...");
		  cola.addAll(pcA);
		  System.out.println("Tama�o Cola: " + cola.size());
		  System.out.println("Se ha a�adido correctamente...\n");
		  
		  /*
		   * Eliminamos la colecci�n pcE, el tama�o deberia ser 8
		   */
		  System.out.println("\nEliminando coleccion... ");
		  cola.removeAll(pcE);
		  System.out.println("Tama�o Cola: " + cola.size());

		  /*
		   * Eliminamos los elementos distintos a la conecci�n pcC, el tama�o quedar� en dos
		   */
		  System.out.println("\nEliminando todos los elementos distintos a la colecci�n introducida...");
		  cola.retainAll(pcC);
		  System.out.println("Tama�o Cola: " + cola.size());
		  


 
	}

}
