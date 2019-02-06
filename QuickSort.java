
public class QuickSort {
	public void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	
	private void quickSort(int[] A, int low, int high) {
		if (low<high+1) {
			int p = partition(A, low, high);
			quickSort(A, low, p-1);
			quickSort(A, p+1, high);
		}
	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private int partition(int[] A, int low, int high) {
		swap(A, low, high);
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (A[i]<A[low]) {
				swap(A, i, border++);
			}
		}
		swap(A, low, border-1);
		return border-1;
	}
}
