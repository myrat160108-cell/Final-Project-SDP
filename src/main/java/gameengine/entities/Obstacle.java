package gameengine.entities;

import gameengine.visitor.EntityVisitor;

public class Obstacle extends GameEntity {
    private final boolean destructible;

    public Obstacle(String name, int x, int y, boolean destructible) {
        super(name, x, y);
        this.destructible = destructible;
    }

    @Override
    public void accept(EntityVisitor visitor) {
        visitor.visitObstacle(this);
    }

    public boolean isDestructible() { return destructible; }
}