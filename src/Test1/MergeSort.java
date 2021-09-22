package Test1;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4, 5, 3, 2, 7, 9, 1};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array,left,mid,right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] array1=new int[mid-left+1];
        int[] array2=new int[right-mid];
        for(int i=0;i<array1.length;i++){
            array1[i]=array[left+i];
        }
        for(int j=0;j< array2.length;j++){
            array2[j]=array[mid+1+j];
        }
        int i,j,k;
        i=0;
        j=0;
        k=left;

        while(i< array1.length && j< array2.length){
            if(array1[i]<=array2[j]){
                array[k]=array1[i];
                i++;
            }
            else{
                array[k]=array2[j];
                j++;
            }
            k++;
        }
        while(i< array1.length){
            array[k]=array1[i];
            i++;
            k++;
        }
        while(j< array2.length){
            array[k]=array2[j];
            j++;
            k++;
        }
    }
}
