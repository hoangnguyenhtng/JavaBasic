package OOPs.QuanLyDongVat;

import java.util.ArrayList;
import java.util.List;

import OOPs.Inheritance.Animal;

public class kennel {
    List<Animal> listAnimal = new ArrayList<>();
    public void them(){
        Animal animal1 = new Animal();
        listAnimal.add(animal1);
    }
    public void keu(){
        Animal animal1 = new Animal();
        animal1.keu();
    }
}
