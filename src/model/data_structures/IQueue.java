package model.data_structures;

public interface IQueue <T> extends Iterable<T> 
{
	public Node<T> darPrimero();
	
	public Node<T> darUltimo();
	
	public boolean isEmpty();
	
	public int tamano();
	
	public void enqueue(T t);
	
	public T dequeue();
}
