package gameengine.visitor;

import gameengine.entities.Enemy;
import gameengine.entities.Obstacle;
import gameengine.entities.Player;

public class SceneExportVisitor implements EntityVisitor {
    private final StringBuilder xmlBuilder = new StringBuilder("<scene>\n");

    @Override
    public void visitPlayer(Player player) {
        xmlBuilder.append(String.format("  <player name=\"%s\" hp=\"%d\" pos=\"%d,%d\"/>\n",
                player.getName(), player.getHealth(), player.getX(), player.getY()));
    }

    @Override
    public void visitEnemy(Enemy enemy) {
        xmlBuilder.append(String.format("  <enemy name=\"%s\" hp=\"%d\" dmg=\"%d\" pos=\"%d,%d\"/>\n",
                enemy.getName(), enemy.getHealth(), enemy.getDamage(), enemy.getX(), enemy.getY()));
    }

    @Override
    public void visitObstacle(Obstacle obstacle) {
        xmlBuilder.append(String.format("  <obstacle name=\"%s\" destructible=\"%b\" pos=\"%d,%d\"/>\n",
                obstacle.getName(), obstacle.isDestructible(), obstacle.getX(), obstacle.getY()));
    }

    public String getXmlReport() {
        return xmlBuilder.toString() + "</scene>";
    }
}