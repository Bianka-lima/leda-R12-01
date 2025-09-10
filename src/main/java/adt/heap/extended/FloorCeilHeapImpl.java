package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer num = null;
		
		if (array != null) {
			
			for (int i = 0; i < array.length; i++) {
				insert(array[i]);
			} 

			boolean exactly = false;
			for (int i = 0; i < array.length && !exactly; i++) {

				Integer current = rootElement();
				
				if (current.equals(numero)) {
					exactly = true;
					num = current;
				}
				if (current < numero && (num == null || current > num)) {
					num = current;
				}
				
				extractRootElement();
			}
		}
		return num;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;

		if (array != null) {

			for (int i = 0; i < array.length; i++) {
				insert(array[i]);
			}

			boolean exactly = false;

			for (int i = 0; i < array.length && !exactly; i++) {

				Integer current = rootElement();

				if(current.equals(numero)) {
					exactly= true;
					ceil = current;
				} else if (current > numero && (ceil == null || current < ceil)) {
					ceil = current;
				}

				extractRootElement();
			}
		}
		return ceil;
	}

}
