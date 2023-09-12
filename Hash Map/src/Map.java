import java.util.ArrayList;

public class Map<K, V> {

	ArrayList<MapNode<K, V>> buckets ;
	/*
	 * java doesn't allow generic array 
	 * so we need to crate array list so we can pass
	 * generic key value pair.
	 */
	int bucketSize;
	int count;

	public Map() {
		buckets = new ArrayList<>();
		bucketSize=5;
		count=0;
		for(int i=0; i<bucketSize; i++) {
			buckets.add(null);
			//			so we can put value at desire index by using arr.set() function 
		}
	}
	public void insert(K key, V value) {
		int index = findIndex(key);
		// if element is present update it's value
		MapNode<K , V> temp = buckets.get(index);
		while(temp!=null) {
			if(temp.key.equals(key)) {
				temp.value=value;
				return;
			}
			temp = temp.next;
		}
		// if element is not present create node and attach to head of LL
		MapNode<K , V> newNode = new MapNode<>(key, value);
		newNode.next = buckets.get(index);
		buckets.set(index, newNode);
		count++;
		double loadFactor = loadFactor();
		if(loadFactor > 0.7) {
			rehash();
		}
	}
	private void rehash() {
		System.out.println("rehash");
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		
		for(int i=0; i<(bucketSize*2); i++) {
			buckets.add(null);
		}
		count=0;
//		count needs to be zero because in insert function we increase count
		bucketSize=bucketSize*2;
//		it is very important to increase bucketSize otherwise insert function calculation gets wrong
//		and stock overflow error come.
		for(int i=0; i< temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while(head!=null) {
				K key = head.key;
				V val = head.value;
				insert(key,val);
				head=head.next;
			}
			
		}
		
	}
	public double loadFactor() {
		return ((1.0*count)/bucketSize);
	}
	private int findIndex(K key) {
		int code = key.hashCode();
		int index = code % bucketSize;
		return index;
	}

	public V getValue(K key) {
		int index = findIndex(key);
		MapNode<K, V> temp = buckets.get(index);
		while(temp!=null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp=temp.next;
		}
		return null;
	}

	public int size() {
		return count;
	}
	public V removeKey(K key) {
		int index = findIndex(key);
		MapNode<K, V> temp = buckets.get(index);
		MapNode<K, V> prev = null;
		while(temp!=null) {
			if(temp.key.equals(key)) {
				if(prev != null) {
					V val = temp.value;
					prev.next=temp.next;
					count--;
					return val;
				}else {
					V val = temp.value;
					buckets.set(index, temp.next);
					count--;
					return val;
				}
			}
			prev = temp;
			temp=temp.next;
		}
		return null;
	}
}
