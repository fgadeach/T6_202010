package model.data_structures;

import java.util.Iterator;

public class Queue <T extends Comparable<T>> implements IQueue<T>{
	private int size;
	private Nodo<T> primerNodo;
	private Nodo<T> ultimoNodo;
	
	public Queue()
	{
		primerNodo = null;
		ultimoNodo = null;
		size = 0;
	}
	
	public Queue(T item)
	{
		primerNodo = new Nodo<T>(item);
		ultimoNodo = new Nodo<T>(item);
		size =1;
	}
	
	public Nodo<T> darPrimero()
	{
		return primerNodo;
	}
	
	public Nodo<T> darUltimo()
	{
		return ultimoNodo;
	}
	
	public boolean isEmpty() 
	{
		boolean respuesta =false;
		
		if (size >= 1)
		{
			respuesta =false;
		}
		
		else
		{
			respuesta = true;
		}
		return respuesta;
	}

	@Override
	public int size() 
	{
		return size;
	}
	
	@Override
	public void enqueue (T t) 
	{
		Nodo <T> nuevo = new Nodo <T>(t);
		
		if (size==0)
		{
			primerNodo = nuevo;
			ultimoNodo = nuevo;
		}
		
		else
		{
			Nodo <T> ultimo = ultimoNodo;
			ultimo.cambiarSiguiente(nuevo);
			ultimoNodo = nuevo;
		}
		
		size++;
	}

	@Override
	public T dequeue() 
	{
		T sacado = null;
		
		if (size ==0)
		{
			System.out.println("No hay elementos para quitar de la fila");
		}
		
		else
		{
			Nodo <T> primero = primerNodo;
			sacado = primerNodo.darItem();
			primerNodo = primero.darSiguiente();
			primero.cambiarSiguiente(null);
			size --;
		}
		
		return sacado;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new Iterator<T>() {
			Nodo<T> act = null;

			@Override
			public boolean hasNext() {
				if (size == 0) {
					return false;
				}
				
				if (act == null) {
					return true;
				}
				
				return act.darSiguiente() != null; 
			}

			@Override
			public T next() {
				if (act == null) {
					act = primerNodo;
				} else {
					act = act.darSiguiente();
				}
				
				return act.darItem();
			}
		};
	}


}