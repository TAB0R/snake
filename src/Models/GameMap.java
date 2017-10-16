package Models;

import java.util.*;

public class GameMap {
    private int width;
    private int height;
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

    public void clearMap() {
        mapObjects.clear();
    }

    public void addSnake(Snake snake) {
        addGameObject(snake.getHead());
        snake.getTail().forEach(this::addGameObject);
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