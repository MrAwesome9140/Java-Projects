// Lab33ast.java
// This is the student Version of the Lab33a assignment.


import java.awt.*;
import java.awt.event.*;


public class Lab33ast
{
	public static void main(String args[])
	{
		GfxApp gfx = new GfxApp();
		gfx.setSize(1000,750);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}


class GfxApp extends Frame
{
	
	private int td = 10000;		// time delay to slow down graphics display
	
	public void paint (Graphics g)
	{
		g.setFont(new Font("ARIAL",Font.BOLD,28));
		g.drawString("LAB 33A 80/100 POINT VERSION",300,50); 
		g.setFont(new Font("ARIAL",Font.BOLD,20));
		g.drawString("DRAWING A LINKED LIST AS A STACK",50,215); 
		g.drawString("DRAWING A LINKED LIST AS A QUEUE",50,415);   	// for 100 point version only
		drawStack(g);
		drawQueue(g);												// for 100 point version only
	}
	
	public void drawStack(Graphics g)
	{
		GfxNode prev = null;
		for(int i = 0; i<4; i++){
			GfxNode node = new GfxNode(g, 700-60*i, 200, (char)(i+65), 0, td); // Create new node
			g.clearRect(700-60*(i-1), 200-33, 15, 32); // Remove pointer to previous node
			node.drawPointer(g, 'P', 1, 0); // Draw pointer to current node
			node.enterData(g,(char)(i+65),0);
			if(i==0)
				node.drawNull(g, 0); // First node doesn't point to any other node
			else
				node.drawLink(g, prev, 0); // Draw a link from current node to previous node
			g.clearRect(700-60*(i-1), 200-33, 30, 32); // Remove pointer to previous node
			node.drawPointer(g, 'F', 2, 0); // Current node becomes the front of the linked list
			prev = node; // Set previous node to be current node
		}
	}
	

	public void drawQueue(Graphics g)
	{
		GfxNode prev = null;
		for(int i = 0; i<4; i++){
			GfxNode node = new GfxNode(g, 520+60*i, 400, (char)(i+65), 0, td); // Create new node
			if(i>0) {
				g.clearRect(520 + 60 * (i - 1), 400 - 33, 15, 32); // Remove pointer to previous node
			}
			node.drawPointer(g, 'P', 1, 0); // Draw pointer to current node
			node.enterData(g,(char)(i+65),0);
			if(prev!=null)
				prev.drawLink(g, node, 0); // Draw a link from previous node to current node
			if(i==3)
				node.drawNull(g, 0); // Last node doesn't point to any other node
			if(i==0)
				node.drawPointer(g, 'F', 2, 0); // First node is designated as front of the queue
			else{
				if(i>1)
					g.clearRect(520 + 60 * (i - 1), 400 - 33, 30, 32); // Remove pointer to previous node
				node.drawPointer(g, 'B', 2, 0);
			}
			prev = node; // Set previous node to be current node
		}
	}
	

}


