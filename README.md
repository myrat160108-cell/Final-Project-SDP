cat << 'EOF' > README.md
# 2D Game Engine — Software Design Patterns Final Project

A modular 2D game engine simulation built in Java 17 (Gradle) demonstrating the practical integration of **six GoF design patterns** working together in a unified game loop.

## Team Members & Responsibilities (Group SE-2503)

* **Murat Islam** (`@myrat160108-cell`)
  * **Strategy Pattern** (`gameengine.ai`) — Dynamic enemy AI behavior switching at runtime.
  * **Factory Pattern** (`gameengine.entities`) — Centralized creation of game entities (`Player`, `Enemy`, `Obstacle`).
  * **Visitor Pattern** (`gameengine.visitor`) — Decoupled scene operations via Double Dispatch (Stats Audit & XML Export).
* **Akniyet Zhanarbek** (`@akniet0`)
  * **Observer Pattern** (`gameengine.observer`) — Event-driven notifications for UI HUD updates and achievement tracking.
  * **Decorator Pattern** (`gameengine.decorator`) — Runtime character stat buffs (`FireWeaponDecorator`, `SpeedBoostDecorator`).
  * **Facade Pattern** (`gameengine.facade`) — Unified `GameEngineFacade` encapsulating audio/render subsystems and simulation ticks.

---

## Architecture & Implemented Patterns


src/main/java/gameengine/
├── Main.java                  # Entry point running the full simulation scenario
├── ai/                        # Strategy Pattern (AiBehavior, PatrolStrategy, AggressiveChaseStrategy)
├── entities/                  # Factory Pattern (EntityFactory, GameEntity, Player, Enemy, Obstacle)
├── visitor/                   # Visitor Pattern (EntityVisitor, StatsAuditVisitor, SceneExportVisitor)
├── observer/                  # Observer Pattern (GameEventManager, GameEventListener, HudDisplayObserver, AchievementObserver)
├── decorator/                 # Decorator Pattern (Combatant, BasePlayerCombatant, CombatantDecorator, FireWeaponDecorator, SpeedBoostDecorator)
└── facade/                    # Facade Pattern (GameEngineFacade, AudioSubsystem, RenderSubsystem)
