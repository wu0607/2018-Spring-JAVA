package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Prepare {
	Player p;
	
	public Prepare(Player p) {
		this.p = p;
	}
	public Rectangle A = new Rectangle(50, 125, 40, 40);
	public Rectangle B = new Rectangle(100, 125, 40, 40);
	public Rectangle C = new Rectangle(150, 125, 40, 40);
	public Rectangle D = new Rectangle(200, 125, 40, 40);
	public Rectangle E = new Rectangle(250, 125, 40, 40);
	public Rectangle F = new Rectangle(300, 125, 40, 40);
	public Rectangle G = new Rectangle(350, 125, 40, 40);
	public Rectangle H = new Rectangle(400, 125, 40, 40);
	public Rectangle I = new Rectangle(450, 125, 40, 40);
	public Rectangle J = new Rectangle(500, 125, 40, 40);
	public Rectangle K = new Rectangle(550, 125, 40, 40);
	
	public Rectangle L = new Rectangle(50, 175, 40, 40);
	public Rectangle M = new Rectangle(100, 175, 40, 40);
	public Rectangle N = new Rectangle(150, 175, 40, 40);
	public Rectangle O = new Rectangle(200, 175, 40, 40);
	public Rectangle P = new Rectangle(250, 175, 40, 40);
	public Rectangle Q = new Rectangle(300, 175, 40, 40);
	public Rectangle R = new Rectangle(350, 175, 40, 40);
	public Rectangle S = new Rectangle(400, 175, 40, 40);
	public Rectangle T = new Rectangle(450, 175, 40, 40);
	public Rectangle U = new Rectangle(500, 175, 40, 40);
	public Rectangle V = new Rectangle(550, 175, 40, 40);
	
	public Rectangle W = new Rectangle(50, 225, 40, 40);
	public Rectangle X = new Rectangle(100, 225, 40, 40);
	public Rectangle Y = new Rectangle(150, 225, 40, 40);
	public Rectangle Z = new Rectangle(200, 225, 40, 40);
	public Rectangle reset = new Rectangle(250, 225, 100, 40);
	
	public Rectangle N0 = new Rectangle(30, 410, 40, 40);
	public Rectangle N1 = new Rectangle(80, 410, 40, 40);
	public Rectangle N2 = new Rectangle(130, 410, 40, 40);
	public Rectangle N3 = new Rectangle(180, 410, 40, 40);
	public Rectangle N4 = new Rectangle(230, 410, 40, 40);
	public Rectangle N5 = new Rectangle(280, 410, 40, 40);
	public Rectangle N6 = new Rectangle(330, 410, 40, 40);
	public Rectangle N7 = new Rectangle(380, 410, 40, 40);
	public Rectangle N8 = new Rectangle(430, 410, 40, 40);
	public Rectangle N9 = new Rectangle(480, 410, 40, 40);
	public Rectangle NDot = new Rectangle(530, 410, 40, 40);
	public Rectangle NR = new Rectangle(580, 410, 40, 40);
	
	public Rectangle M0 = new Rectangle(30, 600, 40, 40);
	public Rectangle M1 = new Rectangle(80, 600, 40, 40);
	public Rectangle M2 = new Rectangle(130, 600, 40, 40);
	public Rectangle M3 = new Rectangle(180, 600, 40, 40);
	public Rectangle M4 = new Rectangle(230, 600, 40, 40);
	public Rectangle M5 = new Rectangle(280, 600, 40, 40);
	public Rectangle M6 = new Rectangle(330, 600, 40, 40);
	public Rectangle M7 = new Rectangle(380, 600, 40, 40);
	public Rectangle M8 = new Rectangle(430, 600, 40, 40);
	public Rectangle M9 = new Rectangle(480, 600, 40, 40);
	public Rectangle MDot = new Rectangle(530, 600, 40, 40);
	public Rectangle MR = new Rectangle(580, 600, 40, 40);
	
	public Rectangle start = new Rectangle(250, 780, 100, 40);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.white);
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g2d.draw(A);
		g.drawString("A", A.x+10, A.y+29);
		g2d.draw(B);
		g.drawString("B", B.x+10, B.y+29);
		g2d.draw(C);
		g.drawString("C", C.x+10, C.y+29);
		g2d.draw(D);
		g.drawString("D", D.x+10, D.y+29);
		g2d.draw(E);
		g.drawString("E", E.x+10, E.y+29);
		g2d.draw(F);
		g.drawString("F", F.x+10, F.y+29);
		g2d.draw(G);
		g.drawString("G", G.x+10, G.y+29);
		g2d.draw(H);
		g.drawString("H", H.x+10, H.y+29);
		g2d.draw(I);
		g.drawString("I", I.x+13, I.y+29);
		g2d.draw(J);
		g.drawString("J", J.x+10, J.y+29);
		g2d.draw(K);
		g.drawString("K", K.x+10, K.y+29);
		g2d.draw(L);
		g.drawString("L", L.x+10, L.y+29);
		g2d.draw(M);
		g.drawString("M", M.x+10, M.y+29);
		g2d.draw(N);
		g.drawString("N", N.x+10, N.y+29);
		g2d.draw(O);
		g.drawString("O", O.x+10, O.y+29);
		g2d.draw(P);
		g.drawString("P", P.x+10, P.y+29);
		g2d.draw(Q);
		g.drawString("Q", Q.x+10, Q.y+29);
		g2d.draw(R);
		g.drawString("R", R.x+10, R.y+29);
		g2d.draw(S);
		g.drawString("S", S.x+10, S.y+29);
		g2d.draw(T);
		g.drawString("T", T.x+10, T.y+29);
		g2d.draw(U);
		g.drawString("U", U.x+10, U.y+29);
		g2d.draw(V);
		g.drawString("V", V.x+10, V.y+29);
		g2d.draw(W);
		g.drawString("W", W.x+10, W.y+29);
		g2d.draw(X);
		g.drawString("X", X.x+10, X.y+29);
		g2d.draw(Y);
		g.drawString("Y", Y.x+10, Y.y+29);
		g2d.draw(Z);
		g.drawString("Z", Z.x+10, Z.y+29);
		g2d.draw(reset);
		g.drawString("Reset", reset.x+10, reset.y+29);
		
		g2d.draw(N0);
		g.drawString("0", N0.x+11, N0.y+30);
		g2d.draw(N1);
		g.drawString("1", N1.x+11, N1.y+30);
		g2d.draw(N2);
		g.drawString("2", N2.x+11, N2.y+30);
		g2d.draw(N3);
		g.drawString("3", N3.x+11, N3.y+30);
		g2d.draw(N4);
		g.drawString("4", N4.x+11, N4.y+30);
		g2d.draw(N5);
		g.drawString("5", N5.x+11, N5.y+30);
		g2d.draw(N6);
		g.drawString("6", N6.x+11, N6.y+30);
		g2d.draw(N7);
		g.drawString("7", N7.x+11, N7.y+30);
		g2d.draw(N8);
		g.drawString("8", N8.x+11, N8.y+30);
		g2d.draw(N9);
		g.drawString("9", N9.x+11, N9.y+30);
		g2d.draw(NDot);
		g.drawString(" .", NDot.x+10, NDot.y+29);
		g2d.draw(NR);
		g.drawString("R", NR.x+10, NR.y+29);
		
		g2d.draw(M0);
		g.drawString("0", M0.x+11, M0.y+30);
		g2d.draw(M1);
		g.drawString("1", M1.x+11, M1.y+30);
		g2d.draw(M2);
		g.drawString("2", M2.x+11, M2.y+30);
		g2d.draw(M3);
		g.drawString("3", M3.x+11, M3.y+30);
		g2d.draw(M4);
		g.drawString("4", M4.x+11, M4.y+30);
		g2d.draw(M5);
		g.drawString("5", M5.x+11, M5.y+30);
		g2d.draw(M6);
		g.drawString("6", M6.x+11, M6.y+30);
		g2d.draw(M7);
		g.drawString("7", M7.x+11, M7.y+30);
		g2d.draw(M8);
		g.drawString("8", M8.x+11, M8.y+30);
		g2d.draw(M9);
		g.drawString("9", M9.x+11, M9.y+30);
		g2d.draw(MDot);
		g.drawString(" .", MDot.x+10, MDot.y+29);
		g2d.draw(MR);
		g.drawString("R", MR.x+10, MR.y+29);
		
		g2d.draw(start);
		g.drawString("Start", start.x+12, start.y+29);
		//g2d.draw();
		g.drawString(p.get_name(), 210, 320);
		g.drawLine(150,330,460,330);
		g.drawString(p.get_initial(), 270, 500);
		g.drawLine(200,515,410,515);
		g.drawString(p.get_ideal(), 270, 700);
		g.drawLine(200,715,410,715);
		
	}
}
