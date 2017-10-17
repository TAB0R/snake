package Models;

public class SnakeTail implements IGameObject {
    private Point position;
    private Snake parentSnake;
    private boolean isFullTail;
    private boolean isDead = false;
    static private Character character = '☯';

    public SnakeTail(Point position, Snake parentSnake, boolean isFullTail) {
        this.position = position;
        this.parentSnake = parentSnake;
        this.isFullTail = isFullTail;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public boolean isDisabled() {
        return isDead;
    }

    @Override
    public void disable() {
        isDead = true;
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        snake.die();
    }

    public Snake getSnake() {
        return parentSnake;
    }

    public boolean getIsFullTail() {
        return isFullTail;
    }

    public void setIsFullTail(boolean value) {
        isFullTail = value;
    }
}
