package life.ui;

import life.containers.NodesGrid;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    NodesGrid nodesGrid;
    int size = 5;
    int offset;

    public DrawPanel(NodesGrid nodesGrid) {
        this.nodesGrid = nodesGrid;
        this.offset = nodesGrid.getNodes().size();
    }

    public void drawNodes(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);

        int width = this.getWidth();
        int height = this.getHeight();

        g.clearRect(0,0,width,height);

        nodesGrid.getNodes().forEach(node -> {
            g.drawRect(size*(node.getPosition().getX()-offset/2)+width/2,size*node.getPosition().getY()+height/2,size-1,size-1);
        });

    }

    public void refresh() {
        drawNodes();
    }
}
