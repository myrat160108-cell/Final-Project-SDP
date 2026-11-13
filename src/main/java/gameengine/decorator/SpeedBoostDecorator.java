package gameengine.decorator;

public class SpeedBoostDecorator extends CombatantDecorator {
    public SpeedBoostDecorator(Combatant wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + [Haste Boots]";
    }

    @Override
    public int getSpeed() {
        return wrapped.getSpeed() * 2;
    }
}