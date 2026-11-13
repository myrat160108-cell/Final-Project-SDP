package gameengine.observer;

public class HudDisplayObserver implements GameEventListener {
    @Override
    public void onEvent(String eventType, String message) {
        System.out.println("[UI HUD Update] (" + eventType + "): " + message);
    }
}