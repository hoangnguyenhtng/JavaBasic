import java.util.Scanner;

public class caesar {
    public static void decrypt() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String text = sc.nextLine();

        System.out.print("k: ");
        int k = sc.nextInt();
        String ab = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
        String decryptedText = "";
  
        for (char c : text.toCharArray()) {
        char lChar = Character.toLowerCase(c);
        int index = ab.indexOf(lChar);
    
        if (index == -1) {
            decryptedText += c;
        } else {
            int newIndex = (index - k + 26) % 26;
            char newChar = ab.charAt(newIndex);
      
        if(Character.isUpperCase(c)){
            newChar = Character.toUpperCase(newChar);
        }
      
        decryptedText += newChar;
    }

    }
            System.out.println("Output: " + decryptedText);

}

    public static void encrypt(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String text = sc.nextLine();

        System.out.print("k: ");
        int k = sc.nextInt();

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String encryptedText = "";

        for (char c : text.toCharArray()) {

            char lowerChar = Character.toLowerCase(c);
            int index = alphabet.indexOf(lowerChar);

            if (index == -1) {
                encryptedText += c;
            } else {

                int newIndex = (index + k) % 26;
                char newChar = alphabet.charAt(newIndex);

                if (Character.isUpperCase(c)) {
                    newChar = Character.toUpperCase(newChar);
                }

                encryptedText += newChar;
            }

        }

        System.out.println("Output: " + encryptedText);

    } 

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while (true) {

        System.out.println("Mã hóa Caesar:");
        System.out.println("1. Giải mã");   
        System.out.println("2. Mã hóa");
      
        int choice = sc.nextInt();
      
        if (choice == 1) {

            System.out.println("Giải mã văn bản sau:");
            decrypt();
        }
        else if (choice == 2) {
            System.out.println("Mã hóa văn bản sau:");
            encrypt();
        }
        else{
            System.err.println("Chỉ chọn 1 hoặc 2!");
            continue;
        }

        System.out.println("Quay lại menu...");
        sc.nextLine();
        }
    }
}



