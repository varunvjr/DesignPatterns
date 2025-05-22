public class Dice {
    private int minValue;
    private int maxValue;

    public Dice(int minValue,int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int roll(){
        int position = (int)Math.random()*(maxValue-minValue+1)+minValue;
        return position;
    }
}
