public class bubbleSort {
    // So sang 2 phan tu dau o ben trai mang, neu phan tu dau lon hon phan tu thu hai thi doi cho sau do tiep tuc nhu vay
    // Do phuc tap cua thuat toan noi bot la O(n^2)

    public static void main(String[] args) {
        int arr[] = {1,7,2,3,5,6,11,8,4,10,12};

        bubbleSort.BubbleSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
