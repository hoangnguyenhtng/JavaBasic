package OOPs.QuanLyDongVat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import OOPs.Inheritance.Animal;

public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> chuong = new ArrayList<>();
        dog dog = new dog();
        cat cat = new cat();
        kennel kennel = new kennel();
        System.out.println("Mời nhập số con vật: ");
        int n = sc.nextInt();
        for(int i = 1; i<=n;i++){
            dog.getLoai();
            System.out.println("Moi nhap ten con vat");
            String nameDog = sc.nextLine();
            dog.getTen();
            dog.setTen(nameDog);
            kennel.listAnimal.add(null);
        }
        for (Animal animal : chuong) {
            animal.keu();
        }
        System.out.println("Mời nhập chuồng: ");
        int i = sc.nextInt();
        for(Animal animal : chuong){
            animal.keu(); 
        }
    }
}
