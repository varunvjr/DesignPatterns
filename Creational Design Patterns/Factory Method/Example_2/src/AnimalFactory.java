public class AnimalFactory {
    public Animal getAnimal(String animalType){
        animalType = animalType.toLowerCase();
        if(animalType.equals("lion")){
            return new Lion();
        }
        if(animalType.equals("peacock")){
            return new Peacock();
        }
        return null;
    }
}
