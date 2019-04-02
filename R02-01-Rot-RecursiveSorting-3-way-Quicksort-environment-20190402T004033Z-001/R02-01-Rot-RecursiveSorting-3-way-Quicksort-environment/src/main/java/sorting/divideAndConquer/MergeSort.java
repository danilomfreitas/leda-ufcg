package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {

      if (array == null) return;
      if (array.length == 0) return;
      if (leftIndex < 0 || rightIndex < 0) return;
      if (leftIndex > rightIndex) return;
      if (rightIndex > array.length - 1) return;

      if (leftIndex < rightIndex) {
         int middleIndex = ((leftIndex + rightIndex) / 2);

         sort(array, leftIndex, middleIndex);
         sort(array, middleIndex + 1, rightIndex);

         merge(array, leftIndex, middleIndex, rightIndex);
      }
   }

   private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

      T[] arrayCopy = Arrays.copyOf(array, array.length);
      int i = leftIndex;
      int j = leftIndex;
      int k = middleIndex + 1;

      while ((i <= middleIndex) && (k <= rightIndex)) {
         if (arrayCopy[i].compareTo(arrayCopy[k]) < 0) {
            array[j] = arrayCopy[i];
            i++;
         } else {
            array[j] = arrayCopy[k];
            k++;
         }
         j++;
      }

      while (i <= middleIndex) {
         array[j] = arrayCopy[i];
         i++;
         j++;
      }

      while (k <= rightIndex) {
         array[j] = arrayCopy[k];
         j++;
         k++;
      }
   }
}
