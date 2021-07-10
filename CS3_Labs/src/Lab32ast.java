// Lab32ast.java
// The student version of the Lab32a assignment.


import java.awt.*;
import java.awt.event.*;


public class Lab32ast
{
	public static void main(String args[])
	{
		Windows win = new Windows();
		win.setSize(1000,750);
		win.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		win.show();
	}
}


class Windows extends Frame
{

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		drawSquares(g, 0, 100, 145);
		drawSquaresReverse(g, 850, 445, 145);
	}

	public void drawSquares(Graphics g, int x, int y, int length){
		if(x>g.getClipBounds().width-20 || length<4)
			return;
		g.fillRect(x, y, length, length);
		drawSquares(g, x+length+20, (int)(y+(length*0.2)), (int)(length*0.8));
	}

	public void drawSquaresReverse(Graphics g, int x, int y, int length){
		if(x<20 || length<4)
			return;
		g.fillRect(x, y, length, length);
		drawSquaresReverse(g, (int)(x-length*0.8-20), y, (int)(length*0.8));
	}
}


