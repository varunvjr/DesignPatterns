public class Peacock implements Animal{
    private int numLegs;
    @Override
    public void numOfLegs(int numLegs){
        this.numLegs = numLegs;
    }
    @Override
    public void sound(){
        System.out.println("The peacock has "+numLegs+" legs and it makes a humming sound");
    }
}
