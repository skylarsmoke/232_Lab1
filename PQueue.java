import java.util.*;


public class PQueue extends AbstractCollection<Object> {
	
	private static class DefaultComparator implements Comparator<Object> {

		
		public int compare(Object o1, Object o2) {
			
			return ((Comparable) 01).compareTo(o2);
		}
		
	}
	
	private Comparator<Object> comp = new DefaultComparator();
    private int size;
    private ArrayList<Object> list;
    
    private class PQItr implements Iterator<Object> {
    	
    	private int cursor = 1;

		public boolean hasNext() {
			
			return cursor <= size;
		}

		public Object next() {
			
			return list.get(cursor);
		}
    	
    }
    
    public PQueue() {
    	
    	list = new ArrayList<Object>(30);
    	list.add(null);
    	size = 0;
    	
    }
    
    public PQueue(Comparator<Object> e) {
    	
    	this();
    	comp = e;
    	
    }
	
    public PQueue(Collection<Object> e) {
    	
    	this();
    	list.addAll(e);
    	size = e.size();
    	
    	for (int k = e.size() / 2; k >= 1; k--) {
    		
    		heapify(k);
    		
    	}
    	
    }
    
    public boolean add(Object e) {
    	
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
    
    public Object remove() {
    	
    	if (!isEmpty()) {
    		
    		Object grab = list.get(1);
    		
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
    
    public Object max() {
    	
    	return list.get(1);
    	
    }
    
    public Iterator iterator() {
    	
    	return new PQItr();
    	
    }
	
	private void heapify(int num) {
		
		Object last = list.get(num);
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
