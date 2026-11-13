package gameengine.decorator;

public abstract class CombatantDecorator implements Combatant {
    protected final Combatant wrapped;

    public CombatantDecorator(Combatant wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public int getAttackPower() {
        return wrapped.getAttackPower();
    }

    @Override
    public int getSpeed() {
        return wrapped.getSpeed();
    }
}