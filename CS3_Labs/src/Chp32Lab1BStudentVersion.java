//// Lab32bst.java
//// The student version of the Lab32 "Square Fractal" assignment.
//
//
//import java.awt.*;
//import java.awt.event.*;
//
//
//public class Chp32Lab1BStudentVersion
//{
//	public static void main(String args[])
//	{
//		GfxApp gfx = new GfxApp();
//		gfx.setSize(1000,750);
//		gfx.addWindowListener(new WindowAdapter() {public void
//		windowClosing(WindowEvent e) {System.exit(0);}});
//		gfx.show();
//	}
//}
//
//
//class GfxApp extends Frame
//{
//
//	public void paint (Graphics g)
//	{
//		try {
//			drawSquare1(g,1000,750);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void drawSquare1(Graphics g, int maxX, int maxY) throws InterruptedException {
//		g.setColor(Color.BLACK); //Set color to black
//		int initWidth = maxX/4; //Initial rect width is 1/4 of window width
//		int initLength = maxY/4; // Initial rect height is 1/4 of window height
//
//		//Top left corner of initial rectangle
//		int topCornerX = (maxX/2)-initWidth/2;
//		int topCornerY = (maxY/2)-initLength/2;
//
//		g.fillRect(topCornerX, topCornerY, initWidth, initLength); //Draw initial rectangle
//		g.setColor(new Color(51,0,0)); //Dark red
//		// Top left rectangle
//		recursiveFractal(g, topCornerX-(maxX/8), topCornerY-(maxY/8), maxX/8, maxY/8, true, true, 51,0,0);
//		g.setColor(new Color(0,51,0)); //Dark Green
//		// Bottom left rectangle
//		recursiveFractal(g, topCornerX-(maxX/8), topCornerY+(maxY/4), maxX/8, maxY/8, false, true,0,51,0);
//		g.setColor(new Color(0,0,51)); //Dark Blue
//		// Top right rectangle
//		recursiveFractal(g, topCornerX+(maxX/4), topCornerY-(maxY/8), maxX/8, maxY/8, true, false,0,0,51);
//		g.setColor(new Color(51,51,0)); //Dark Yellow
//		// Bottom right rectangle
//		recursiveFractal(g, topCornerX+(maxX/4), topCornerY+(maxY/4), maxX/8, maxY/8, false, false,51,51,0);
//	}
//
//	public void recursiveFractal(Graphics g, int cornerX, int cornerY, int width, int height, boolean top, boolean left, int r, int gr, int b) throws InterruptedException {
//		Thread.sleep(10); //Makes it look animated
//		g.fillRect(cornerX, cornerY, width, height); //Draw rectangle
//
//		//These conditional statements make the color lighter based on which color it currently is. Makes the rectangles get lighter as you go outwards
//		if(gr==0 && b==0) {
//			r+=34;
//			g.setColor(new Color(r, 0, 0));
//		}
//		else if(r==0 && b==0) {
//			gr+=34;
//			g.setColor(new Color(0, gr, 0));
//		}
//		else if(r==0 && gr==0) {
//			b+=34;
//			g.setColor(new Color(0, 0, b));
//		}
//		else {
//			r+=34;
//			gr+=34;
//			g.setColor(new Color(r, gr, 0));
//		}
//
//		//Minimum rectangle size is 4 by 4
//		if(width < 4 || height<4)
//			return;
//
//		//Draw rectangles in different corners based which corner the current rectangle is at
//		if(top && left) {
//			recursiveFractal(g, cornerX - width / 2, cornerY - height / 2, width / 2, height / 2, true, true, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX - width / 2, cornerY + height, width / 2, height / 2, false, true, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX + width, cornerY - height / 2, width / 2, height / 2, true, false, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//		}
//		else if(!top && left){
//			recursiveFractal(g, cornerX + width, cornerY + height, width / 2, height / 2, false, false, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX - width / 2, cornerY - height / 2, width / 2, height / 2, true, true, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX - width / 2, cornerY + height, width / 2, height / 2, false, true, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//		}
//		else if(top){
//			recursiveFractal(g, cornerX + width, cornerY - height / 2, width / 2, height / 2, true, false, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX + width, cornerY + height, width / 2, height / 2, false, false, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX - width / 2, cornerY - height / 2, width / 2, height / 2, true, true, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//		}
//		else{
//			recursiveFractal(g, cornerX - width / 2, cornerY + height, width / 2, height / 2, false, true, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX + width, cornerY - height / 2, width / 2, height / 2, true, false, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//			recursiveFractal(g, cornerX + width, cornerY + height, width / 2, height / 2, false, false, r, gr, b);
//			g.setColor(new Color(r,gr,b));
//		}
//	}
//
//
//
//	private void delay(double n)
//	{
//		for (double k = 1; k < n; k+=0.001);
//	}
//
//}
//
//
