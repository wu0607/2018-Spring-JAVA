import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Draw{
	public static void main(String[] args) {
		MyPanel p = new MyPanel();
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(p);
		app.setSize(800, 800);
		app.setVisible(true);
	}
}