package gameengine.observer;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {
    private final List<GameEventListener> listeners = new ArrayList<>();

    public void subscribe(GameEventListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(GameEventListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(String eventType, String message) {
        for (GameEventListener listener : listeners) {
            listener.onEvent(eventType, message);
        }
    }
}
