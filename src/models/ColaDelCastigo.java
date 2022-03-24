package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import exceptions.ColaExceededSizeException;
import exceptions.ElementBlockedException;
import exceptions.LlevateTuNullDeAquiException;

public class ColaDelCastigo <E>{
	

	/*
	 * ATRIBUTOS
	 */
	private Comparator <E> comparador;
	private LinkedList <E> cola;

	/*
	 * CONSTRUCTOR
	 */
	public ColaDelCastigo(Comparator <E> comparador) {
		this.comparador = comparador;
		this.cola = new LinkedList<E>();
	}
	

	/*
	 * MÉTODOS
	 */
	//Devuelve el tamaño de la cola
	public int size() {
		return cola.size();
	}

	//Si la cola está vacia devuelve true
	public boolean isEmpty() {
		if(cola.size() == 0) {
			return true;
		}else {
			return false;
		}
	}

	//Si la cola contiene al objeto 0 devuelve true
	public boolean contains(Object o) {
		if(cola.contains(o)) {
			return true;
		}else {
			return false;
		}
	}

	//Recorre la cola
	public Iterator iterator() {
		
		return cola.iterator();
	}

	//Devuelve una matriz que contiene los elementos de la cola
	public Object[] toArray() {
		
		return cola.toArray();
	}

	//Devuelve los elementos de a
	public Object[] toArray(Object[] a) {
		return cola.toArray(a);
	}

	
	/**
	 * Elimina el objeto o de la cola
	 * @param o
	 * @return
	 * @throws ElementBlockedException
	 */
	public boolean remove(Object o) throws ElementBlockedException {		
		if(cola.size()<1){
			throw new ElementBlockedException("No puedes vaciar la cola");
		}else{
			cola.remove(o);
			return true;			
		}
	}

	/**
	 * Devuelve true si los elementos son contenidos por la coleccion c
	 * @param c, colección insertada
	 * @return true si lo contiene, false si no
	 */
	public boolean containsAll(Collection c) {
		if(cola.containsAll(c)) {
			return true;
		}else {
			return false;
		}		
	}

	/**
	 * Añade la coleccion que se le inserta a otra
	 * @param c colección insertada
	 * @return true si se ha añadido, false si no
	 * @throws ColaExceededSizeException 
	 */
	public boolean addAll(Collection c) throws ColaExceededSizeException {
		if(c.contains(null)) {
			throw new LlevateTuNullDeAquiException("No puedes introducir valores nulos");
			
		}else {
			if((cola.size()+c.size()) <= 10) {
				cola.addAll(c);
				return true;
			}else{
				throw new ColaExceededSizeException("La colección supera el tamaño maximo de la cola");
			}
		}
	}

	/**
	 * Elimina todos los elementos de la coleccion introducida de la cola
	 * @param c, coleccion introducida
	 * @return retorna true si es posible eliminar la coleccion de la cola
	 * @throws ElementBlockedException 
	 */
	public boolean removeAll(Collection<E> c) throws ElementBlockedException {
		if((cola.size()-c.size())<1) {
			throw new ElementBlockedException("No puedes vaciar la cola");
		}else {
			cola.removeAll(c);
			return true;
		}
	}

	/**
	 * Elimina los elementos distintos de la coleccón introducida de la cola
	 * @param c, coleccion introducida
	 * @return 
	 * @throws ElementBlockedException 
	 */
	public boolean retainAll(Collection<E> c) throws ElementBlockedException {
		if (cola.retainAll(c)) {
			if (cola.size() > 0) {
				return true;
			}else {
				throw new ElementBlockedException("No puedes vaciar la cola");
			}
		}else {
			return false;
		}
	}

	/**
	 * Vaciar la cola (en este caso no podemos)
	 * @throws ElementBlockedException 
	 * 
	 */
	public void clear() throws ElementBlockedException {
		throw new ElementBlockedException("No puedes vaciar la cola");

	}

	/**
	 * Añade el elemento introducido a la cola
	 * @param e, elemento introducido
	 * @return
	 * @throws ColaExceededSizeException
	 * @throws LlevateTuNullDeAquiException
	 */
	public boolean add(E e) throws Exception {
		if(e.equals(null)) {
			throw new LlevateTuNullDeAquiException("No puedes introducir valores nulos");			
		}else {
			if((cola.size()< 10)) {
				cola.add(e);
				cola.sort(this.comparador);
				return true;
			}else{
				throw new ColaExceededSizeException("La colección supera el tamaño maximo de la cola");
			}
		}
	}

	/**
	 * Nos devuelve true si el elemento se ha introducido en la cola y false si ha sido al contrario
	 * @param e, objeto que se desea introducir
	 * @return true or false
	 * 

	 */
	public boolean offer(E e){
		if(!e.equals(null) && (cola.size() < 10)) {
			cola.add(e);
			return true;	
		}else{
			return false;
		}
	}

	/**
	 * Elimina el primer elemento de la cola
	 * @return
	 * @throws ElementBlockedException
	 */
	public Object remove() throws ElementBlockedException{
		if (cola.size() < 1) {
			throw new ElementBlockedException("No puedes vaciar la cola");
		} else {
			cola.remove();
			return true;
		}
	}

	/**
	 * Devuelve true or false si se ha eliminado el primer elemento de la cola
	 * @return true / false
	 */
	public Object poll(){
		if (cola.size() < 1) {
			return false;
		} else {
			cola.remove();
			return true;
		}
	}

	/**
	 * Devuelve el primero elemento de la cola
	 * @return
	 */
	public Object element() {
		return cola.element();
	}

	/**
	 * Devuelve el primero elemento de la cola
	 * @return si esta vacia devuelve null, y si no el elemento
	 */
	public Object peek() {
		if (cola.isEmpty()) {
			return null;
		}else{
			return cola.peek();
		}
	}
	
}
