import java.util.*;
public class Sorting {

    public void group(int[] arr){
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                int count = map.get(arr[i]);
                map.put(arr[i],++count);
            }
        }
        int i=0;
        for (Integer key : map.keySet()) {
            for (int j = 0; j < map.get(key); j++) {
                arr[i] = key;
                i++;
            }
        }
    }

    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int partition = arr[(start+end)/2];
        int s = start;
        int e = end;
        while(start<=end){
            while(arr[start]<partition && start < end){
                start++;
            }
            while(arr[end]>partition && start < end){
                end--;
            }
            if(start<end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
            start++;
            end--;
        }
        quickSort(arr, s, start-1);
        quickSort(arr, start , e);

    }

    public void mergeSort(int[] arr){
        if(arr.length<=1){
            return;
        }
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for(int i=0;i<mid;i++){
            left[i]=arr[i];
        }

        for(int i=mid;i<arr.length;i++){
            right[i-mid]=arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        int leftCounter = 0;
        int rightCounter = 0;
        int arrCounter = 0;
        while(arrCounter<arr.length){
            if(rightCounter==right.length || leftCounter<left.length && left[leftCounter]<right[rightCounter]){
                arr[arrCounter++]= left[leftCounter++];
            }else{
                arr[arrCounter++]=right[rightCounter++];
            }
        }

    }


    public static void main (String[] args){
        Sorting sort = new Sorting();
        int[] arr = {3,4,4,5,5,5,6,6,6,2,3,4,5,6,7};
        //     sort.mergeSort(arr);
        //    sort.quickSort(arr, 0, arr.length-1);
        //     sort.bubbleSort(arr);
        sort.selectionSort(arr);
        sort.group(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
