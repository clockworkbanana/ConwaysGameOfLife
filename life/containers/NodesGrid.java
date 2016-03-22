package life.containers;

import java.util.LinkedList;
import java.util.List;

public class NodesGrid {

    private List<Node> nodesList = new LinkedList<>();
    private WeightMap weightMap = new WeightMap();
    int generation;

    public NodesGrid(Integer[][] intarray){
        loadNodes(intarray);

    }

    public void addNode(Node node) {
        nodesList.add(node);
    }
    public void addNode(int x, int y) {
        nodesList.add(new Node(x, y));
    }

    public void loadNodes(Integer[][] matrix) {
        generation=0;
        nodesList.clear();
        for (int y = matrix.length - 1; y >= 0; y--) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] != 0) {
                    addNode(x, y);
                }
            }
        }
        System.out.println("Generation:"+generation+", number of cells="+nodesList.size());
    }

    public void removeNode(Node node) {
        nodesList.remove(node);
    }

    void calculateWeights() {
        for (Node node : nodesList) {
            for (Point c : node.neighbors()) {
                weightMap.add(c);
            }
        }
    }

    void markNodesToBeRemoved() {
        for (Node node : nodesList) {
            if (weightMap.getWeight(node) < 2 || weightMap.getWeight(node) > 3) {
                node.markForRemoval();
            }
            weightMap.removeNode(node);
        }
    }

    void addNewNodes() {
        weightMap.getWeights().forEach((c, w) -> {
            if (w == 3) {
                addNode(new Node(c));
            }
        });
    }

    void removeNodes() {
        int i = 0;
        while (i < nodesList.size()) {
            if (nodesList.get(i).isToBeRemoved()) {
                nodesList.remove(i);
            } else {
                i++;
            }
        }
        ;
    }

    public List<Node> getNodes(){
        return nodesList;
    }

    public void performStep() {
        calculateWeights();
        markNodesToBeRemoved();
        removeNodes();
        addNewNodes();
        weightMap.clear();
        generation++;
        System.out.println("Generation:"+generation+", number of cells="+nodesList.size());
    }
}
