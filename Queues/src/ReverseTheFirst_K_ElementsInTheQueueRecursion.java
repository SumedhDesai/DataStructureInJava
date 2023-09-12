/*
 * Reverse The First K Elements In The Queue using //////pRecursion
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseTheFirst_K_ElementsInTheQueueRecursion {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
    	String[] n_k = br.readLine().trim().split(" ");

    	int n = Integer.parseInt(n_k[0]);
    	int k = Integer.parseInt(n_k[1]);

    	String[] values = br.readLine().trim().split(" ");

    	Queue<Integer> queue = new LinkedList<>();

    	for (int i = 0; i < n; i++) {
    		queue.add(Integer.parseInt(values[i]));
    	}

    	return new Input(n, k, queue);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Input input = takeInput();

    	int k = input.k;
    	Queue<Integer> queue = input.queue;

    	queue = reverseKElements(queue, k);


    	while (!queue.isEmpty()) {
    		System.out.print(queue.poll() + " ");
    	}
    }

	private static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		if(input.size()==0 || k==0 || k>input.size()) {
			return input;
		}
		reverseQueue(input, k);
		for(int i=0; i<input.size()-k; i++) {
			input.add(input.remove());
		}
		return input;
	}

	private static void reverseQueue(Queue<Integer> input, int k) {
		if(input.size()==0 || k==0) {
			return;
		}
		int temp = input.remove();
		reverseQueue(input, k-1);
		input.add(temp);
		
	}
}