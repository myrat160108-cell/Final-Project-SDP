package gameengine.facade;

public class AudioSubsystem {
    public void initAudio() {
        System.out.println("[AudioSystem] OpenAL audio channels initialized.");
    }

    public void playSound(String clip) {
        System.out.println("[AudioSystem] Playing SFX: " + clip);
    }
}