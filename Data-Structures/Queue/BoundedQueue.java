import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;

public class BoundedQueue {
	private static void printCheck(String label, Object expected, Object got) {
		System.out.println(label + " -> Expected: " + expected + " | Got: " + got);
	}

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> boundedQueue = new ArrayBlockingQueue<>(2);

		printCheck("Initial queue", "[]", boundedQueue.toString());

		boundedQueue.add(10);
		boundedQueue.add(20);
		printCheck("After adding 10, 20", "[10, 20]", boundedQueue.toString());

		boolean inserted = boundedQueue.offer(30);
		printCheck("offer(30) when full", false, inserted);

		printCheck("peek() on non-empty queue", 10, boundedQueue.peek());
		printCheck("poll() on non-empty queue", 10, boundedQueue.poll());
		printCheck("Queue after poll()", "[20]", boundedQueue.toString());
		printCheck("remove() on non-empty queue", 20, boundedQueue.remove());
		printCheck("Queue after remove()", "[]", boundedQueue.toString());

		printCheck("peek() on empty queue", null, boundedQueue.peek());
		printCheck("poll() on empty queue", null, boundedQueue.poll());

		try {
			boundedQueue.remove();
			printCheck("remove() on empty queue", "NoSuchElementException", "No exception");
		} catch (NoSuchElementException ex) {
			printCheck("remove() on empty queue", "NoSuchElementException", ex.getClass().getSimpleName());
		}
	}
}
