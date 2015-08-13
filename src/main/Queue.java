import java.util.LinkedList;
//数据结构队列，用LinkedList来实现 T是泛型,可自定义传入的泛型
public class Queue<T> {
	private LinkedList<T> queue = new LinkedList<T>();
	//队列中加操作
	public void enQueue(T t){
		queue.add(t);
	}
	//删除第一个，并提取出来
	public T deQueue(){
		return queue.removeFirst();
	}
	public boolean isQueueEmpty(){
		return queue.isEmpty();
	}
	public boolean contains(T t){
		return queue.contains(t);
	}
}
