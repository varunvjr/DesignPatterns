package MediaPlayer;

public  class MP4Player extends AdvanceMediaPlayer{
    @Override
    public void playMP4(String audioName) {
        System.out.println("MP4 Playing song from: "+audioName);
    }

    @Override
    public void playVLC(String audioName){}
}
