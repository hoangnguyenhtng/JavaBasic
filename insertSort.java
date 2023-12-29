public class insertSort {
    //Lap qua mang, bat dau tu phan tu thu 2
    //Với mỗi phần từ hiện tại, so sánh nó với các phần tử ở bên trái nó đã được sắp xếp
    //Nếu phần tử hiện tại nhỏ hơn một phần tử ở bên trái, di chuyển phần tử đó sang phải để tạo chỗ trống cho phần tử hiện tại
    //Chèn phần tử hiện tại vào vị trí thích hợp trong phần đã sắp xếp

    //Độ phức tạp thời gian trung bình: O(n^2)
    //Độ phức tạp thời gian tốt nhất: O(n) nếu mảng đã được sắp xếp
    //Độ phức tạp không gian: O(1)

    public static void main(String[] args) {
        int arr[] = {12, 11, 14, 5, 7, 9};

        insertionSort(arr);

        System.out.println("Mảng sau khi sắp xếp là: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;

        for(int i = 1; i < n; ++i) {
            int k = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử có giá trị lớn hơn k về bên phải
            while(j >= 0 && arr[j] > k){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = k;
        }
    }
}
