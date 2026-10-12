# Dungeon Quest

A turn-based console RPG built in Java 21 to practice OOP and design patterns.

## Run

```bash
mvn package
java -jar target/dungeon-quest-0.1.0.jar
```

Run tests: `mvn test`

## Structure

```
com.kavindu.dungeon
├── Main.java            entry point, wires everything together
├── model/               game state (no UI code here)
│   ├── Character        abstract base: HP, attack, defense, damage rules
│   ├── Player           + potions
│   └── Enemy
├── engine/              game rules and the game loop
│   ├── Game             render -> input -> update loop
│   └── PlayerAction
└── ui/                  presentation only
    ├── GameView         interface the engine talks to
    └── ConsoleView      console implementation
```

The engine depends only on the `GameView` interface, so the console UI can later be
replaced with a LibGDX/JavaFX view without touching game logic.

## Roadmap

- [x] Step 1: basic battle loop (no patterns yet)
- [ ] Step 2: introduce patterns where real problems appear
  - Strategy: enemy AI behaviours
  - Factory: creating enemy types
  - Command: player actions
  - State: stunned / poisoned / dead
  - Decorator: weapons and buffs
- [ ] Step 3: levels, inventory, Observer event log, Memento save/load
- [ ] Step 4: graphical view (LibGDX + Kenney assets)

## Design patterns used

| Pattern | Why | Where |
|---------|-----|-------|
| _(filled in as they are added)_ | | |
