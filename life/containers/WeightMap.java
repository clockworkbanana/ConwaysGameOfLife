package life.containers;

import java.util.HashMap;
import java.util.Map;

public class WeightMap {

    Map<Point, Integer> weights;

    WeightMap(){
        weights=new HashMap<>();
    }

    void add(Point c){
        if(weights.containsKey(c)){
            int newWeight = weights.get(c)+1;
            weights.put(c,newWeight);
        }else {
            weights.put(c,1);
        }
    }

    void removeNode(Node node){
        if(weights.containsKey(node.getPosition())) {
            weights.remove(node.getPosition());
        }
    }

    Integer getWeight(Node n){
        if (weights.containsKey(n.getPosition())){
            return weights.get(n.getPosition());
        }else {
            return 0;
        }
    }

    public Map<Point, Integer> getWeights() {
        return weights;
    }

    public void clear() {
        weights.clear();
    }
}
