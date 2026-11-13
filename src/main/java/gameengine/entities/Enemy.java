package gameengine.entities;

import gameengine.ai.AiBehavior;
import gameengine.visitor.EntityVisitor;

public class Enemy extends GameEntity {
    private int health;
    private final int damage;
    private AiBehavior aiBehavior;

    public Enemy(String name, int x, int y, int health, int damage, AiBehavior initialBehavior) {
        super(name, x, y);
        this.health = health;
        this.damage = damage;
        this.aiBehavior = initialBehavior;
    }

    public void setAiBehavior(AiBehavior aiBehavior) {
        this.aiBehavior = aiBehavior;
    }

    public void performTurn(Player target) {
        if (aiBehavior != null) {
            aiBehavior.executeTurn(this, target);
        }
    }

    @Override
    public void accept(EntityVisitor visitor) {
        visitor.visitEnemy(this);
    }

    public int getHealth() { return health; }
    public int getDamage() { return damage; }
}