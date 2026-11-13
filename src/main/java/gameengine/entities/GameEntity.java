package gameengine.entities;

import gameengine.visitor.EntityVisitor;

public abstract class GameEntity {
    protected String name;
    protected int x;
    protected int y;

    public GameEntity(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public abstract void accept(EntityVisitor visitor);

    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }
}