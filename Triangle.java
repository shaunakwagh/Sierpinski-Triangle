package Problem_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
links that were used for this project

https://www.dreamincode.net/forums/topic/263788-painting-in-actionlistener/
https://stackoverflow.com/questions/36109551/sierpinski-triangle
https://docs.oracle.com/javase/tutorial/uiswing/components/applet.html
https://coderanch.com/t/515892/java/refresh-JFrame-call-paint-method
*/

public class Triangle extends JApplet {

    int numberorder;
    boolean enterpressed = false;
    private STriangle Tpanel= new STriangle();
    JPanel trianglegraphic= new JPanel();
    JButton enter= new JButton("Enter");
    JTextField order = new JTextField(5);
    JLabel label = new JLabel("Please enter the order:");
    public Triangle()
    {

       // setLayout(null);

         JPanel orderpanel=new JPanel();

        // trianglegraphic.setSize(400,400);
        // trianglegraphic.setBounds(50,200,400,400);

        order.setBounds(50,400,100,100);
        enter.setBounds(80,400,100,100);
         orderpanel.add(label);
         orderpanel.add(order);
       //  orderpanel.add(enter);
        // enter.addActionListener( this);
         orderpanel.setBounds(70,420,250,60);
        add(orderpanel,BorderLayout.PAGE_END);
        add(Tpanel);
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Integer.parseInt(order.getText()));
                Tpanel.STriangle(Integer.parseInt(order.getText()));

            }

        });


          //add(new STriangle());
    }

  /*  public void actionPerformed(ActionEvent e)
    {

        if (e.getSource()==enter)
        {
            numberorder=Integer.parseInt(order.getText());
            add(new STriangle(numberorder));
            order.setText("");
        }

    }*/




}
    class STriangle extends JPanel {
        int recursion;
        public void STriangle(int integer) {


         this.recursion = integer;
         repaint();


    }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point a = new Point(250, 50);
            Point b = new Point(50, 450);
            Point c = new Point(450, 450);
            drawingtriangle(g, recursion, a, b, c);

        }

        public void drawingtriangle(Graphics g, int order, Point a, Point b, Point c) {

            if (order <= 2) {
                Polygon triangle = new Polygon();
                triangle.addPoint(a.x, a.y);
                triangle.addPoint(b.x, b.y);
                triangle.addPoint(c.x, c.y);
                g.setColor(Color.GREEN);
                g.fillPolygon(triangle);

            } else {
                Point ab = midpoint(a, b);
                Point bc = midpoint(b, c);
                Point ca = midpoint(c, a);
                drawingtriangle(g, order - 1, a, ab, ca);
                drawingtriangle(g, order - 1, ab, b, bc);
                drawingtriangle(g, order - 1, ca, bc, c);

            }


        }

        public Point midpoint(Point a, Point b) {

            return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
        }



    public static void main(String[] args) {
        Triangle test = new Triangle();
        JFrame newframe = new JFrame();
        newframe.setSize(1000,1000);
        newframe.add(test);

       newframe.setVisible(true);
    }

}


