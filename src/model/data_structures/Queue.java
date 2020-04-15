package model.data_structures;

import java.util.Iterator;

public class Queue <T extends Comparable<T>> implements IQueue<T>{
	//ATRIBUTOS
	private int tamano;
	private Node<T> primerNode;
	private Node<T> ultimoNode;
	
	//CONSTRUCTORES
	public Queue()
	{
		primerNode = null;
		ultimoNode = null;
		tamano = 0;
	}
	
	public Queue(T item)
	{
		primerNode = new Node<T>(item);
		ultimoNode = new Node<T>(item);
		tamano =1;
	}
	
	//METODOS
	public Node<T> darPrimero()
	{
		return primerNode;
	}
	
	public Node<T> darUltimo()
	{
		return ultimoNode;
	}
	
	public boolean isEmpty() 
	{
		boolean respuesta = false;	
		if (tamano >= 1)
			respuesta =false;
		else
			respuesta = true;
		return respuesta;
	}

	@Override
	public int tamano() 
	{
		return tamano;
	}
	
	@Override
	public void enqueue (T t) 
	{
		Node <T> contenedor = new Node <T>(t);
		if (tamano == 0)
		{
			primerNode = contenedor;
			ultimoNode = contenedor;
		}
		else
		{
			Node <T> ultimo = ultimoNode;
			ultimo.cambiarSiguiente(contenedor);
			ultimoNode = contenedor;
		}
		
		tamano++;
	}

	@Override
	public T dequeue() 
	{
		T sacado = null;
		
		if (tamano ==0)
		{
			System.out.println("No hay elementos para quitar de la fila");
		}
		
		else
		{
			Node <T> primero = primerNode;
			sacado = primerNode.darItem();
			primerNode = primero.darSiguiente();
			primero.cambiarSiguiente(null);
			tamano --;
		}
		
		return sacado;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new Iterator<T>() {
			Node<T> act = null;

			@Override
			public boolean hasNext() {
				if (tamano == 0) {
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
					act = primerNode;
				} else {
					act = act.darSiguiente();
				}
				
				return act.darItem();
			}
		};
	}
}