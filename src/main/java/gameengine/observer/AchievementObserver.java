package gameengine.observer;

public class AchievementObserver implements GameEventListener {
    private boolean firstHitUnlocked = false;

    @Override
    public void onEvent(String eventType, String message) {
        if ("PLAYER_DAMAGED".equals(eventType) && !firstHitUnlocked) {
            firstHitUnlocked = true;
            System.out.println("[Achievement Unlocked!] 'First Blood' — Survived your first enemy hit!");
        }
    }
}