import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimalFactory animalFactory = new AnimalFactory();
        System.out.println("Enter the Animal Name");
        String animalType = sc.next();
        Animal animal = animalFactory.getAnimal(animalType);
        if(animal==null){
            System.out.println("Animal Does not exists please choose a valid animal");
            System.exit(404);
        }
        int legs;
        System.out.println("Enter the number of legs");
        legs = sc.nextInt();
        animal.numOfLegs(legs);
        animal.sound();
    }
}