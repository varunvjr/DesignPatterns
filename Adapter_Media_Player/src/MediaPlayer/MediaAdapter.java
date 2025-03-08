package MediaPlayer;

public class MediaAdapter extends MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer = null;
    @Override
    public void play(String audioName,String audioType) {
        if(audioType.equalsIgnoreCase("VLC")){
            advanceMediaPlayer = new VLCPlayer();
            advanceMediaPlayer.playVLC(audioName);
        }else if(audioType.equalsIgnoreCase("MP4")){
            advanceMediaPlayer = new MP4Player();
            advanceMediaPlayer.playMP4(audioName);
        }else{
            System.out.println("Media Player only support MP4 and VLC play formats");
            System.exit(0);
        }
    }
}
