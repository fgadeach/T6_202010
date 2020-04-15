package model.data_structures;

public class Nodo<T> {
	private Nodo <T> siguiente;
	private T item;
	
	public Nodo (T item)
	{
		siguiente = null;
		this.item = item;
	}
	
	public Nodo<T> darSiguiente()
	{
		return siguiente;
	}
	
	public void cambiarSiguiente(Nodo<T> siguiente)
	{
		this.siguiente = siguiente;
	}
	
	public T darItem()
	{
		return item;
	}
	
	public void cambiarItem(T item)
	{
		this.item = item;
	}
}