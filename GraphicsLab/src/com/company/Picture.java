package com.company;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/*
<applet code="House" width=1000 height=1000>
</applet>
*/

public class Picture extends Applet {

    @Override
    public void paint(Graphics g) {
        BeachLandscape b = new BeachLandscape(g);
        House h = new House(g);
    }
}

class House{

    public House(Graphics g){
        g.setColor(Color.red);
        g.fillRect(300,300,400,400);
        Door d = new Door(g);
        Roof r = new Roof(g);
        Windows w = new Windows(g);
    }

}

class Windows{

    public Windows(Graphics g){
        g.setColor(Color.white);
        g.fillRect(325, 325, 100, 100);
        g.fillRect(325, 575, 100, 100);
        g.fillRect(575, 325, 100, 100);
        g.fillRect(575, 575, 100, 100);
        g.setColor(Color.black);
        for(int x = 325; x<=575; x+=250){
            for(int y = 325; y<=575; y+=250){
                g.drawLine(x+50, y, x+50, y+100);
                g.drawLine(x, y+50, x+100, y+50);
            }
        }
    }

}


class Door{

    public Door(Graphics g){
        g.setColor(Color.black);
        g.fillRect(460, 550, 80, 150);
        DoorHandle handle = new DoorHandle(g);
    }

}

class DoorHandle{

    public DoorHandle(Graphics g){
        g.setColor(Color.GRAY);
        g.fillOval(480, 620, 10,10);
    }

}

class Roof{

    public Roof(Graphics g){
        g.setColor(Color.black);
        int[] xPoints = {300,500,700};
        int[] yPoints = {300,150,300};
        g.fillPolygon(xPoints, yPoints, 3);
    }

}

class Landscape{

    public Landscape(Graphics g){
        g.setColor(new Color(255, 222, 173));
        g.fillRect(0,600,g.getClipBounds().width, g.getClipBounds().height-600);
        Road r = new Road(g);
    }

}

class SummerLandscape extends Landscape{

    public SummerLandscape(Graphics g){
        super(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,400,g.getClipBounds().width, 200);
    }

}

class BeachLandscape extends SummerLandscape{

    public BeachLandscape(Graphics g){
        super(g);
        Sky s = new Sky(g);
        Sun sun = new Sun(g);
        Boat b = new Boat(g);
        WhiteCloud w = new WhiteCloud(g);
        DarkCloud d = new DarkCloud(g);
    }

}

class Boat{

    public Boat(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1000,350,200,100);
        g.setColor(Color.yellow);
        g.setFont(new Font("My Font", Font.BOLD, 30));
        g.drawString("Speedboat", 1030, 410);
        g.setColor(Color.red);
        g.fillRect(1000,325, 50, 25);
    }

}

class Sky{

    public Sky(Graphics g){
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0,0,g.getClipBounds().width,400);
    }

}

class Sun{

    public Sun(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(1300,50,100,100);
    }

}

class Road{

    public Road(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0,750,g.getClipBounds().width, 100);
        g.setColor(Color.black);
        for(int x = 10; x<2000; x+=100){
            g.fillRect(x, 790, 40, 10);
        }
    }

}

class Cloud{

    public Cloud(Graphics g){

    }

}

class WhiteCloud extends Cloud{

    public WhiteCloud(Graphics g){
        super(g);
        g.setColor(Color.white);
        for(int i = 400; i<1100; i+=200){
            g.fillOval(i, 50, 150, 100);
        }
    }

}


class DarkCloud extends Cloud{

    public DarkCloud(Graphics g){
        super(g);
        g.setColor(Color.darkGray);
        for(int i = 20; i<400; i+=200){
            g.fillOval(i, 50, 150, 100);
        }
        Rain r = new Rain(g);
        Lightning l = new Lightning(g);
    }
}

class Rain{

    public Rain(Graphics g){
        g.setColor(Color.BLUE);
        for(int i = 150; i<450; i+=30){
            for(int x = 10; x<275; x+=20){
                g.fillRect(x, i, 10, 20);
            }
        }
    }
}

class Lightning{

    public Lightning(Graphics g){
        g.setColor(Color.yellow);
        int[] xPoints = {300, 250, 200, 150, 100, 150, 200, 250};
        int[] yPoints = {150, 230, 310, 390, 470, 410, 330, 250};
        g.fillPolygon(xPoints, yPoints, 8);
    }

}