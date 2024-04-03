// Esha Sharma
import java.util.Scanner;
public class CMSC401_A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfHouses = sc.nextInt();
        int[] housesYCoord = new int[numOfHouses];
        int[] housesSize = new int[numOfHouses];
        int[] sortedYCoord = new int[numOfHouses * 3];
        for (int i = 0; i < housesYCoord.length; i++) {
            housesYCoord[i] = sc.nextInt();
            housesSize[i] = sc.nextInt();
        }
        sc.close();
        int j = 0; int k = 0;
        while (j < numOfHouses) {
            if (housesSize[j] == 1) {
                sortedYCoord[k] = housesYCoord[j];
                k++;
            }
            else if (housesSize[j] == 2)  {
                 sortedYCoord[k] = housesYCoord[j];
                 sortedYCoord[k + 1] = housesYCoord[j];
                 k+=2;
            }
            else {
                sortedYCoord[k] = housesYCoord[j];
                sortedYCoord[k + 1] = housesYCoord[j];
                sortedYCoord[k + 2] = housesYCoord[j];
                k+=3;
            }
            j++;
        }
        int m = sortedYCoord.length - 1;
        int length; int temp = -1;
        boolean foundIt = false;
        while (m >= 0 && !foundIt) {
                if (sortedYCoord[m] != 0) {
                       temp = m;
                       foundIt = true;
                }
                m--;
        }
        length = temp + 1;
        int optimalLength;
        a = -1; b = -1;
        if (length % 2 == 1) {
            Median(sortedYCoord, 0, length - 1, length / 2);
            optimalLength = b;
        }
        else {
            Median(sortedYCoord, 0, length - 1, length / 2);
            optimalLength = ((a + b) / 2);
        }

        System.out.println(optimalLength);
    }
    public static int findRandomPivot(int[] array, int i, int r) {
        int n = r - i + 1;
        int pivot = (int) (Math.random() % n);
        swap(array, i + pivot, r);
        return Partition(array, i, r);
    }
    public static int Partition(int[] array, int i, int r) {
        int firstElement = array[r];
        int k = i, j = i;
        while (j < r)   {
            if (array[j] < firstElement) {
                swap(array, k, j);
                k++;
            }
            j++;
        }
        swap(array, k, r);
        return k;
    }
     public static int Median(int[] array, int l, int r, int k) {
         if (l <= r) {
             int pivot = findRandomPivot(array, l, r);
             if (pivot == k) {
                 b = array[pivot];
             } else if (pivot == (k - 1)) {
                 a = array[pivot];
             }

             if (pivot >= k) {
                 return Median(array, l, pivot - 1, k);
             } else {
                 return Median(array, pivot + 1, r, k);
             }

         }
         return 0;
     }
     public static void swap(int[] array, int i, int j) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
    }
    static int a, b;
}





