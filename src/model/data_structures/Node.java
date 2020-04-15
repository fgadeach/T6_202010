package model.data_structures;
public class Node <T>
{
	//ATRIBUTOS
	private Node<T> siguiente;
	private Node<T> anterior;
	private T objeto;
	
	//CONSTRUCTOR
	public Node (T objeto)
	{
		siguiente = null;
		anterior = null;
		this.objeto = objeto;
	}
	
	//METODOS
	public Node<T> darSiguiente()
	{
		return siguiente;
	}
	public Node<T> darAnterior() 
	{
		return anterior;
	}
	
	public void cambiarSiguiente(Node<T> siguiente)
	{
		this.siguiente = siguiente;
	}
	
	public void cambiarAnterior(Node<T> anterior)
	{
		this.anterior = anterior;
	}
	
	public T darItem()
	{
		return objeto;
	}
	
	public void cambiarItem(T objeto)
	{
		this.objeto = objeto;
	}
}