public class selectionSort {
    // Chia mang lam doi va cu the tim max hoac min trong phan chua sap xep
    // Hoan doi phan tu do voi phan tu dau tien cua phan chua sap xep
    // O(n^2) 
    // O(1) vì nó sắp xếp tại chỗ, không sử dụng thêm bộ nhớ
    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};

        //Sap xep day arr theo thu tu tang dan
        selectionSort(arr);

        //In ra day sau khi sap xep
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }  
    
    public static void selectionSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++){
            int min = i;
            for (int j = i + 1; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            // Hoan doi phan tu nho nhat voi phan tu dau tien cua day
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
