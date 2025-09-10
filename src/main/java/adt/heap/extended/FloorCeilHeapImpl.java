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
			
			for (int i = 0; i < array.length; i++) {

				Integer current = extractRootElement();
				
				if (current.doubleValue() <= numero && (num == null || current > num)) {
					num = current;
				}
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

			for (int i = 0; i < array.length; i++) {

				Integer current = extractRootElement();

				if (current.doubleValue() >= numero && (ceil == null || current < ceil)) {
					ceil = current;
				}
			}
		}
		return ceil;
	}

}
