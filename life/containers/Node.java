package life.containers;

import java.util.ArrayList;
import java.util.List;

public class Node {

    Boolean toBeRemoved;
    Point position;

    Node(){
        this(0,0);
    }

    Node(int x, int y){
        this.position = new Point(x,y);
        this.toBeRemoved = false;
    }

    Node(Point c){
        this.position = c;
        this.toBeRemoved = false;
    }

    public void markForRemoval(){
        assert !toBeRemoved;
        toBeRemoved=true;
    }

    public boolean isToBeRemoved(){
        return toBeRemoved;
    }

    public Point getPosition(){
        return position;
    }

    public List<Point> neighbors(){
        List<Point> result = new ArrayList<>();

        result.add(new Point(position.x-1,position.y-1));
        result.add(new Point(position.x,position.y-1));
        result.add(new Point(position.x+1,position.y-1));

        result.add(new Point(position.x-1,position.y));
        result.add(new Point(position.x+1,position.y));

        result.add(new Point(position.x-1,position.y+1));
        result.add(new Point(position.x,position.y+1));
        result.add(new Point(position.x+1,position.y+1));

        return result;
    }
}
