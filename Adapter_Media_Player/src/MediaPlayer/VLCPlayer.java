package MediaPlayer;

public  class VLCPlayer extends AdvanceMediaPlayer {
    @Override
    public void playVLC(String audioName) {
        System.out.println("VLC Playing song from VLC Player: "+audioName);
    }

    @Override
    public void playMP4(String audioName){}
}
