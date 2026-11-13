package gameengine.decorator;

public class FireWeaponDecorator extends CombatantDecorator {
    public FireWeaponDecorator(Combatant wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + [Fire Enchantment]";
    }

    @Override
    public int getAttackPower() {
        return wrapped.getAttackPower() + 15;
    }
}