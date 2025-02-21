import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    public static void main (String[] args) {

        new Main();
    }

    private Main() {

        JFrame frame = new JFrame("Menu");
        JPanel pnlMain = new JPanel();

        JPanel pnlDish = new JPanel();
        JLabel lblDish = new JLabel("Dish");

        JPanel pnlMainContent = new JPanel();
        MyLine lineUp = new MyLine();
        MyLine lineDown = new MyLine();

        JPanel pnlButtonsLeft = new JPanel();
        JPanel pnlButtonsRight = new JPanel();
        JPanel pnlAllButtons = new JPanel();
        JButton btnLeft = new JButton("<");
        JButton btnRight = new JButton(">");
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        pnlMain.setLayout(new BorderLayout());
        pnlDish.setLayout(new FlowLayout());
        pnlMainContent.setLayout(new BorderLayout());
        pnlButtonsLeft.setLayout(new BorderLayout());
        pnlButtonsLeft.setLayout(new BorderLayout());

        pnlDish.add(lblDish);
        pnlDish.setBounds(1,1,1,1);

        pnlMainContent.add(lineUp, BorderLayout.NORTH);
        //TODO: add list or name
        pnlMainContent.add(lineDown, BorderLayout.SOUTH);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog dialog = new JDialog(frame, "Add Dish");
                dialog.setSize(300, 300);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        pnlButtonsLeft.add(btnLeft, BorderLayout.WEST);
        pnlButtonsLeft.add(btnRight, BorderLayout.EAST);

        pnlButtonsRight.add(btnAdd, BorderLayout.WEST);
        pnlButtonsRight.add(btnEdit, BorderLayout.CENTER);
        pnlButtonsRight.add(btnDelete, BorderLayout.EAST);

        pnlAllButtons.add(pnlButtonsLeft, BorderLayout.WEST);
        pnlAllButtons.add(pnlButtonsRight, BorderLayout.EAST);

        pnlMain.add(pnlDish, BorderLayout.NORTH);
        pnlMain.add(pnlMainContent, BorderLayout.CENTER);
        pnlMain.add(pnlAllButtons, BorderLayout.SOUTH);

        frame.add(pnlMain);

        frame.pack();
        frame.setSize (400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public class MyLine extends JPanel
    {
        @Override public void paint(Graphics g)
        {
            //Get the current size of this component
            Dimension d = this.getSize();

            //draw in black
            g.setColor(Color.BLACK);
            //draw a centered horizontal line
            g.drawLine(0,d.height,d.width,d.height);
        }
    }
}