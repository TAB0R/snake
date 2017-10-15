package Models;

import java.util.*;

public class GameMap {
    private int width;
    private int height;
    //TODO: change to hashmap
    private HashMap<Point, IGameObject> mapObjects;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapObjects = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public IGameObject[] getMapObjects() {
        return mapObjects.values().toArray(new IGameObject[mapObjects.size()]);
    }

    public void addGameObject(IGameObject obj) {
        if (isFreeSpace(obj.getPosition()))
            mapObjects.put(obj.getPosition(), obj);
        else
            throw new UnsupportedOperationException("Point " + obj.getPosition() +
                    " was occupied");
    }

    public void addSnake(Snake snake) {
        addGameObject(snake.getHead());
        for (SnakeTail tail : snake.getTail())
            addGameObject(tail);
    }

    public boolean isFreeSpace(Point point) {
        return !mapObjects.containsKey(point);
    }

    public IGameObject getMapObject(Point position) {
        if (isFreeSpace(position))
            return new EmptyObject(position);
        return mapObjects.get(position);
    }
}