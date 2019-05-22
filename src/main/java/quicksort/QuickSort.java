package quicksort;

public class QuickSort {
    private static int partition(int[] array, int beg, int end) {
        int first = array[beg];
        int i = beg, j = end;
        while (i < j) {
            while (array[i] <= first && i < end) {
                i++;
            }
            while (array[j] > first && j >= beg) {
                j--;
            }
            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
        if (j != beg) {
            array[j] = array[beg] ^ array[j];
            array[beg] = array[beg] ^ array[j];
            array[j] = array[beg] ^ array[j];
        }
        return j;
    }

    private static void quickSort(int[] ints, int low, int height) {
        if (low < height) {
            int middle = partition(ints, low, height);
            quickSort(ints, low, middle - 1);
            quickSort(ints, middle + 1, height);
        }
    }

    public static void main(String[] args) {
        int[] list = {15, 7, 6, 18, 25, 11, 33, 2};
        quickSort(list, 0, list.length - 1);
        for (int aList : list) {
            System.out.print(aList + " ");
        }
        System.out.println();
    }

}
