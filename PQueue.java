import java.util.*;


public class PQueue extends AbstractCollection<Job> {
	
	private static class DefaultComparator implements Comparator<Job> {

		
		public int compare(Job o1, Job o2) {
			
			return ((Comparable) 01).compareTo(o2);
		}
		
	}
	
	private Comparator<Job> comp = new DefaultComparator();
    private int size;
    private ArrayList<Job> list;
    
    private class PQItr implements Iterator<Job> {
    	
    	private int cursor = 1;

		public boolean hasNext() {
			
			return cursor <= size;
		}

		public Job next() {
			
			return list.get(cursor);
		}
    	
    }
    
    public PQueue() {
    	
    	list = new ArrayList<Job>(30);
    	list.add(null);
    	size = 0;
    	
    }
    
    public PQueue(Comparator<Job> e) {
    	
    	this();
    	comp = e;
    	
    }
	
    public PQueue(Collection<Job> e) {
    	
    	this();
    	list.addAll(e);
    	size = e.size();
    	
    	for (int k = e.size() / 2; k >= 1; k--) {
    		
    		heapify(k);
    		
    	}
    	
    }
    
    public boolean add(Job e) {
    	
    	list.add(e);
    	size++;
    	int k = size;
    	
    	while (k > 1 && comp.compare(list.get(k / 2), e) > 0) {
    		
    		list.set(k, list.get(k / 2));
    		k /= 2;
    		
    	}
    	
    	list.set(k, e);
    	return true;
    	
    }
    
    public int size() {
    	return size;
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public Job remove() {
    	
    	if (!isEmpty()) {
    		
    		Job grab = list.get(1);
    		
    		list.set(1, list.get(size));
    		list.remove(size);
    		size--;
    		
    		if (size > 1) {
    			
    			heapify(1);
    			
    		}
    		
    		return grab;
    		
    	}
    	
    	return null;
    	
    }
    
    
    public Job max() {
    	
    	return list.get(1);
    	
    }
    
    public Iterator<Job> iterator() {
    	
    	return new PQItr();
    	
    }
	
	private void heapify(int num) {
		
		Job last = list.get(num);
		int child, k = num;
		
		while (2 * k <= size) {
			
			child = 2 * k;
			
			if (child < size && comp.compare(list.get(child), list.get(child + 1)) > 0) {
				child++;
			}
			
			if (comp.compare(last, list.get(child)) <= 0) {
				break;
			} else {
				list.set(k, list.get(child));
				k = child;
			}
			
		}
		
		list.set(k, last);
		
	}

	

	

}
