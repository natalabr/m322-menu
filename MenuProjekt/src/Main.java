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
                createDialog(frame);
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

    private void createDialog(Frame frame) {

        JDialog dialog = new JDialog(frame, "Add Dish");
        JPanel pnlDish = new JPanel();
        JLabel lblDish = new JLabel("Dish Configuration");

        JPanel pnlMainContent = new JPanel();
        JPanel pnlContent = new JPanel();
        MyLine lineUp = new MyLine();
        MyLine lineDown = new MyLine();
        //TODO: add main content to pnlContent

        JPanel pnlButtons = new JPanel();
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        pnlDish.setLayout(new FlowLayout());
        pnlMainContent.setLayout(new BorderLayout());

        pnlDish.add(lblDish);
        pnlDish.setBounds(1,1,1,1);

        pnlMainContent.add(lineUp, BorderLayout.NORTH);
        pnlMainContent.add(pnlContent, BorderLayout.CENTER);
        pnlMainContent.add(lineDown, BorderLayout.SOUTH);

        pnlButtons.add(btnSave, BorderLayout.WEST);
        pnlButtons.add(btnCancel, BorderLayout.EAST);

        dialog.add(pnlDish, BorderLayout.NORTH);
        dialog.add(pnlMainContent, BorderLayout.CENTER);
        dialog.add(pnlButtons, BorderLayout.SOUTH);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:Save input
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private class MyLine extends JPanel
    {
        @Override public void paint(Graphics g)
        {
            Dimension d = this.getSize();
            g.setColor(Color.BLACK);
            g.drawLine(0,d.height,d.width,d.height);
        }
    }
}