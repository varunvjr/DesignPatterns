import MediaPlayer.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Enter the audioType");
        Scanner sc = new Scanner(System.in);
        String audioType = sc.next();
        System.out.println("Enter the audio name");
        String audioName = sc.next();
        MediaAdapter mediaAdapter = new MediaAdapter();
        mediaAdapter.play(audioName,audioType);
    }
}