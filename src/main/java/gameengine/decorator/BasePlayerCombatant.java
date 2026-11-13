package gameengine.decorator;

import gameengine.entities.Player;

public class BasePlayerCombatant implements Combatant {
    private final Player player;

    public BasePlayerCombatant(Player player) {
        this.player = player;
    }

    @Override
    public String getDescription() {
        return player.getName();
    }

    @Override
    public int getAttackPower() {
        return player.getBaseAttack();
    }

    @Override
    public int getSpeed() {
        return player.getBaseSpeed();
    }
}