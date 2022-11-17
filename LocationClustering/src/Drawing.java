import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Drawing extends JPanel{

    HashMap<Coords, ArrayList<Coords>> sol;
    Color[] colors = {Color.red, Color.blue, Color.green, Color.GRAY, Color.black, Color.orange, Color.pink, Color.CYAN, Color.magenta, Color.DARK_GRAY, Color.LIGHT_GRAY, new Color(82,11,6), new Color(2,54,18), new Color(93,94,1), new Color(135,121,86), new Color(97,3,95)};
    private final int timerDelay = 40;
    private BufferedImage img = new BufferedImage(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, BufferedImage.TYPE_INT_ARGB);
    private Timer animationTimer = null;

    public Drawing(HashMap<Coords, ArrayList<Coords>> temp){
        setBackground(Color.white);
        sol = temp;
        //draw();
    }

    @Override
    public Dimension getPreferredSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
//        if(img != null)
//            g.drawImage(img, 0, 0, this);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        super.paintComponent(g);
        //Graphics2D g2d = img.createGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        drawCoordinatePlane(g2d, size);
        drawPoints(g2d,size);
        g2d.dispose();
    }

    private void draw(){
        if(animationTimer != null && animationTimer.isRunning())
            animationTimer.stop();
        img = new BufferedImage(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, BufferedImage.TYPE_INT_ARGB);
        animationTimer = new Timer(timerDelay, new TimerListener());
        animationTimer.start();
    }

    private void drawPoints(Graphics2D g2d, Dimension size){
        Random rand = new Random();
        int squareSize = (int) (size.height*0.75);
        int xAxisStartX = (size.width-squareSize)/2, yAxisStartY = (size.height-squareSize)/2;
        int xAxisStartY = size.height/2, yAxisStartX = size.width/2;
        int markingDist = (int)((squareSize*0.98)/12);

        int coordBottom = yAxisStartY+squareSize;
        int coordTop = yAxisStartY+squareSize-(markingDist*12);
        int coordLeft = xAxisStartX;
        int coordRight = xAxisStartX+(markingDist*12);

        int coordHeight = coordBottom-coordTop;
        int coordWidth = coordRight-coordLeft;

        int i = 0;
        for(Coords p:sol.keySet()){
            g2d.setColor(colors[i++]);
            int x = (int) ((p.x/960)*coordWidth+coordLeft);
            int y = (int) (coordBottom-(p.y/960)*coordHeight);
            g2d.fillRoundRect(x,y,10,10,3,3);
            for(Coords s:sol.get(p)){
                x = (int) ((s.x/960)*coordWidth+coordLeft);
                y = (int) (coordBottom-(s.y/960)*coordHeight);
                g2d.drawRect(x,y,5,5);
            }
        }
    }

    private void drawCoordinatePlane(Graphics2D g2d, Dimension size){
        int squareSize = (int) (size.height*0.75);
        int xAxisStartX = (size.width-squareSize)/2, yAxisStartY = (size.height-squareSize)/2;
        int xAxisStartY = size.height/2, yAxisStartX = size.width/2;
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Blah", Font.BOLD, 20));
        g2d.drawLine(xAxisStartX, yAxisStartY+squareSize, xAxisStartX+squareSize, yAxisStartY+squareSize);
        g2d.drawLine(xAxisStartX, yAxisStartY, xAxisStartX, yAxisStartY+squareSize);

        int markingDist = (int)((squareSize*0.98)/12);
        int curMark = 80;
        for(int y = yAxisStartY+squareSize-markingDist; y>(yAxisStartY+squareSize-markingDist*12-5); y-=markingDist){
            g2d.drawLine(xAxisStartX-5, y, xAxisStartX+5, y);
            if(curMark>=100)
                g2d.drawString(String.valueOf(curMark), xAxisStartX-44, y+7);
            else
                g2d.drawString(String.valueOf(curMark), xAxisStartX-32, y+7);
            curMark+=80;
        }

        curMark = 80;
        for(int x = xAxisStartX+markingDist; x<(xAxisStartX+markingDist*12+5); x+=markingDist){
            g2d.drawLine(x, yAxisStartY+squareSize-5, x, yAxisStartY+squareSize+5);
            if(curMark>=100)
                g2d.drawString(String.valueOf(curMark), x-17, yAxisStartY+squareSize+23);
            else
                g2d.drawString(String.valueOf(curMark), x-10, yAxisStartY+squareSize+23);
            curMark+=80;
        }
    }

    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(img == null)
                return;
            Graphics2D g2 = img.createGraphics();
            repaint();
        }
    }

}
