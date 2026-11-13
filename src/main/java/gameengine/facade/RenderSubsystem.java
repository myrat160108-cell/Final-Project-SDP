package gameengine.facade;

import gameengine.entities.GameEntity;
import java.util.List;

public class RenderSubsystem {
    public void initGraphics() {
        System.out.println("[RenderSystem] 2D Viewport (1920x1080) initialized.");
    }

    public void renderScene(List<GameEntity> entities) {
        System.out.println("[RenderSystem] Rendering " + entities.size() + " active objects on screen...");
    }
}
