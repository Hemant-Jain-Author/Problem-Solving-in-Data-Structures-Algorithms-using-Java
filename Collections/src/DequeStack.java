import java.util.ArrayDeque;

public class DequeStack<T> {

	private ArrayDeque<T> deque = new ArrayDeque<T>();

	public void push(T obj) {
		deque.push(obj);
	}

	public T pop() {
		return deque.pop();
	}

	public T top() {
		return deque.peekLast();
	}

	public int size() {
		return deque.size();
	}

	public boolean isEmpty() {
		return deque.isEmpty();
	}

	public static void main(String[] args) {

	}
}