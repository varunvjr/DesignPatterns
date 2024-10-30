public class Lion implements Animal{
     private int numLegs;
    @Override
    public  void numOfLegs(int numLegs){
        this.numLegs = numLegs;
    }
    @Override
    public void sound(){
        System.out.println("The Lion has "+numLegs+" Legs and it roars");
    }
}
