package gameengine.observer;

public interface GameEventListener {
    void onEvent(String eventType, String message);
}