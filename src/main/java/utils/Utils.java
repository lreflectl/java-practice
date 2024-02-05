package utils;

public class Utils {
    public static double[] parseArrayFromString(String arrayStr) throws NullPointerException, NumberFormatException {
        // Parse comma-separated list from string to array of doubles
        String[] splitArrayStr = arrayStr.split(",\\s*");
        double[] parsedResults = new double[splitArrayStr.length];
        for (int i = 0; i < splitArrayStr.length; i++) {
            parsedResults[i] = Double.parseDouble(splitArrayStr[i]);
        }
        return parsedResults;
    }

    public static int partition(double[] A, int p, int q) {
        double pivot = A[q];  // base element to compare others to
        int i = p-1;  // idx of element that should be lower than pivot
        for (int j = p; j < q; j++) {  // j is idx of current element
            if (A[j] <= pivot) {  // check if j less than pivot and swap it with i
                i++;
                if (j != i) {  // Optimization to skip redundant swaps
                    double tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        double tmp = A[i+1];  // put pivot after all lower elements found
        A[i+1] = A[q];
        A[q] = tmp;
        return i + 1;  // return index of splitting element (first half <= the element < second half)
    }

    public static void quickSort(double[] A, int p, int q) {
        if (p >= q) return;
        int i = partition(A, p, q);
        quickSort(A, p, i-1);
        quickSort(A, i+1, q);
    }
}
