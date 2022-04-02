package com.ammarabbas;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    Image image;
    Graphics graphics;
    Box player;
    Box enemy;
    Box panel;

    Box westWall;
    Box northWall;
    Box eastWall;
    Box southWall;

    Box pickWest;
    Box pickNorth;
    Box pickEast;


    Box barrier5;
    boolean gameOver;

    Box a;
    Box b;
    Box c;
    Box d;
    Box e;
    Box f;
    Box h;
    Box i;
    Box j;
    Box k;
    Box l;
    Box m;
    Box n;
    Box o;
    Box p;
    Box q;
    Box r;
    Box s;
    Box t;
    Box u;
    Box v;
    Box w;
    Box x;
    Box y;
    Box z;


    MyFrame(){

        westWall = new Box (8,0,40,800,Color.red);
        northWall = new Box (48,25,1400,40,Color.red);
        eastWall = new Box (1352,0,40,800,Color.red);
        southWall = new Box (0,755,1400,40,Color.red);

        pickWest = new Box (0,450,175,40,Color.red);
        pickNorth = new Box (415,20,40,320,Color.red);

        a = new Box (150,150,150,40,Color.red);
        b = new Box (150,150,40,175,Color.red);
        c = new Box (150,300,300,40,Color.red);
        d = new Box (280,300,40,150,Color.red);

        e = new Box (150,580,300,40,Color.red);
        f = new Box (275,300,300,40,Color.red);
        h = new Box (540,300,40,150,Color.red);
        i = new Box (430,450,150,40,Color.red);

        j = new Box (430,450,40,170,Color.red);
        k = new Box (570,625,40,170,Color.red);
        l = new Box (725,500,40,125,Color.red);
        m = new Box (725,600,300,40,Color.red);

        n = new Box (850,625,40,150,Color.red);
        o = new Box (725,215,40,125,Color.red);
        p = new Box (580,180,185,40,Color.red);
        q = new Box (1175,600,175,40,Color.red);

        r = new Box (725,325,175,40,Color.red);
        s = new Box (860,360,40,250,Color.red);
        t = new Box (860,450,340,40,Color.red);
        u = new Box (1175,315,175,40,Color.red);

        v = new Box (900,40,40,175,Color.red);
        w = new Box (1025,40,40,325,Color.red);



        panel = new Box (0,0,1400,800, Color.orange);
        player = new Box(75,100,50,50,Color.blue);
        enemy = new Box(400,300,50,50,Color.red);
        gameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400,800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new AL());
    }

    public void paint(Graphics g) {
        //image = createImage(this.getWidth(),this.getHeight());
        //graphics = image.getGraphics();
        //g.drawImage(image,0,0,this);

        Graphics2D g2D = (Graphics2D) g;

        panel.draw(g2D);

        westWall.draw(g2D);
        northWall.draw(g2D);
        eastWall.draw(g2D);
        southWall.draw(g2D);

        a.draw(g2D);
        b.draw(g2D);
        c.draw(g2D);
        d.draw(g2D);

        e.draw(g2D);
        f.draw(g2D);
        h.draw(g2D);
        i.draw(g2D);

        j.draw(g2D);
        k.draw(g2D);
        l.draw(g2D);
        m.draw(g2D);

        n.draw(g2D);
        o.draw(g2D);
        p.draw(g2D);
        q.draw(g2D);

        r.draw(g2D);
        s.draw(g2D);
        t.draw(g2D);
        u.draw(g2D);

        v.draw(g2D);
        w.draw(g2D);
        //x.draw(g2D);
        //y.draw(g2D);

        pickWest.draw(g2D);
        pickNorth.draw(g2D);
        //pickEast.draw(g2D);

        player.draw(g2D);
        //enemy.draw(g2D);

        if(gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman",Font.PLAIN,45));
            g.drawString("GAME OVER!", 575, 400);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.exit(0);
        }
    }

    public void checkCollision() throws InterruptedException {
        if(player.intersects(westWall) || player.intersects(northWall) || player.intersects(eastWall)
                || player.intersects(westWall) || player.intersects(pickWest) || player.intersects(pickNorth)
                || player.intersects(a) || player.intersects(b) || player.intersects(c)
                || player.intersects(d) || player.intersects(e) || player.intersects(f) || player.intersects(h)
                || player.intersects(i) || player.intersects(j) || player.intersects(k) || player.intersects(l)
                || player.intersects(m) || player.intersects(n) || player.intersects(o) || player.intersects(p)
                || player.intersects(q) || player.intersects(r) || player.intersects(s) || player.intersects(t)
                || player.intersects(u) || player.intersects(v) || player.intersects(w)) {
            gameOver = true;
            System.out.println("GAME OVER!");
        }
    }

    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            try {
                checkCollision();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            repaint();
        }
    }
}