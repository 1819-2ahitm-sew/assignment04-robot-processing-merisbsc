package at.htl.robot.model;

public class Robot {

    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.SOUTH;

    //region getter and setter

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    //endregion

    public int stepForward() {
        switch (direction) {
            case SOUTH:
                if (y <= 10) {
                    y += 1;
                }
                return y;
            case NORTH:
                if (y >= 1) {
                    y -= 1;
                }
                return y;
            case WEST:
                if (x >= 1) {
                    x -= 1;
                }
                return x;
            case EAST:
                if (x <= 10) {
                    x += 1;
                }
                return x;
        }
        return x;
    }

    public Direction rotateLeft() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
                break;
        }
        return this.direction;
    }

    public int setPositionTeleport() {
        if (this.x == 11) {
            return this.x = 1;
        }
        if (this.x == 0) {
            return this.x = 10;
        }
        if (this.y == 11) {
            return this.y = 1;
        }
        if (this.y == 0) {
            return this.y = 10;
        }
        return x;
    }

    public int setPositionRestrict() {
        if (this.x > 10) {
            return this.x = 10;
        }
        if (this.x < 1) {
            return this.x = 1;
        }
        if (this.y > 10) {
            return this.y = 10;
        }
        if (this.y < 1) {
            return this.y = 1;
        }
        return x;
    }
}