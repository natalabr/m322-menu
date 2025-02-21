import Controller.DishController;
import Model.Dish;
import Model.DishModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main extends JFrame{

    public static void main (String[] args) {

        new Main();
    }

    private DishController dishController;
    private DefaultListModel dishListModel;

    private Main() {

        dishListModel = new DefaultListModel<>();

        CardLayout cardLayout = new CardLayout();
        JPanel pnlCard = new JPanel(cardLayout);

        String[] dishes = {"Pizza", "Pasta", "Salad"};
        for (String dish : dishes) {
            pnlCard.add(new JLabel(dish), dish);
        }

        JFrame frame = new JFrame("Menu");
        JPanel pnlMain = new JPanel();

        JPanel pnlDish = new JPanel();
        JLabel lblDish = new JLabel("Dish");

        JPanel pnlMainContent = new JPanel();
        MyLine lineUp = new MyLine();
        JList<Dish> dishJList = new JList<>();

        dishJList.setModel(dishListModel);
        MyLine lineDown = new MyLine();

        JPanel pnlButtonsLeft = new JPanel();
        JPanel pnlButtonsRight = new JPanel();
        JPanel pnlAllButtons = new JPanel();
        JButton btnLeft = new JButton("<");
        JButton btnRight = new JButton(">");
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        pnlButtonsLeft.setLayout(new BorderLayout());
        pnlButtonsLeft.add(btnLeft, BorderLayout.WEST);
        pnlButtonsLeft.add(btnRight, BorderLayout.EAST);

        pnlMain.setLayout(new BorderLayout());
        pnlDish.setLayout(new FlowLayout());
        pnlMainContent.setLayout(new BorderLayout());
        pnlDish.add(lblDish);
        pnlDish.setBounds(1,1,1,1);

        pnlMainContent.add(lineUp, BorderLayout.NORTH);
        //TODO: add list
        pnlMainContent.add(lineDown, BorderLayout.SOUTH);

        dishJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDialog(frame);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDialog(frame);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:delete function
            }
        });

        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int currentDish = 0;
                currentDish = (currentDish - 1 + dishes.length) % dishes.length;
                cardLayout.show(pnlCard, dishes[currentDish]);
            }
        });

        btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int currentDish = 0;
                currentDish = (currentDish + 1) % dishes.length;
                cardLayout.show(pnlCard, dishes[currentDish]);
            }
        });

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

    private void createDialog(JFrame frame) {

        JDialog dialog = new JDialog(frame, "Add Dish");
        JPanel pnlDish = new JPanel();
        JLabel lblDish = new JLabel("Dish Configuration");

        JPanel pnlMainContent = new JPanel();
        JPanel pnlContent = new JPanel();
        MyLine lineUp = new MyLine();
        MyLine lineDown = new MyLine();
        JLabel lblName = new JLabel(" Name:");
        JTextField txtName = new JTextField();
        JPanel pnlName = new JPanel();
        JLabel lblIngredients = new JLabel(" Ingredients:");
        JTextArea txtIngridients = new JTextArea();
        JPanel pnlIngredients = new JPanel();
        JLabel lblCategory = new JLabel(" Category:");
        JRadioButton rdbtnAppetizer = new JRadioButton(" Appetizer");
        JRadioButton rdbtnMainDish = new JRadioButton(" Main Dish");
        JRadioButton rdbtnDessert = new JRadioButton(" Dessert");
        ButtonGroup btnGroup = new ButtonGroup();
        JPanel pnlCategoryOptions = new JPanel();
        JPanel pnlCategory = new JPanel();
        JLabel lblPrice = new JLabel(" Price:");
        JTextField txtPrice = new JTextField();
        JPanel pnlPrice = new JPanel();
        JLabel lblDietaryRestrictions = new JLabel(" Dietary Restrictions:");
        JCheckBox cbDietaryRestrictionsVegan = new JCheckBox("Vegan");
        JCheckBox cbDietaryRestrictionsGlutenFree = new JCheckBox("No-Gluten");
        JCheckBox cbDietaryRestrictionsVegetarian = new JCheckBox("Vege");
        JPanel pnlDietaryRestrictionsOptions = new JPanel();
        JPanel pnlDietaryRestrictions = new JPanel();
        JLabel lblSpicinessRating = new JLabel(" Spiciness Rating 1-10:");
        JSpinner spinnerSpicinessRating = new JSpinner();
        JPanel pnlSpicinessRating = new JPanel();

        pnlName.setLayout(new GridLayout(1,2));
        pnlName.add(lblName);
        pnlName.add(txtName);

        pnlIngredients.setLayout(new GridLayout(1,2));
        pnlIngredients.add(lblIngredients);
        pnlIngredients.add(txtIngridients);

        btnGroup.add(rdbtnAppetizer);
        btnGroup.add(rdbtnMainDish);
        btnGroup.add(rdbtnDessert);

        pnlCategoryOptions.setLayout(new GridLayout(1,3));
        pnlCategoryOptions.add(rdbtnAppetizer);
        pnlCategoryOptions.add(rdbtnMainDish);
        pnlCategoryOptions.add(rdbtnDessert);

        pnlCategory.setLayout(new BorderLayout());
        pnlCategory.add(lblCategory, BorderLayout.WEST);
        pnlCategory.add(pnlCategoryOptions, BorderLayout.EAST);

        pnlPrice.setLayout(new GridLayout(1,2));
        pnlPrice.add(lblPrice);
        pnlPrice.add(txtPrice);

        pnlDietaryRestrictionsOptions.setLayout(new GridLayout(1,3));
        pnlDietaryRestrictionsOptions.add(cbDietaryRestrictionsVegan);
        pnlDietaryRestrictionsOptions.add(cbDietaryRestrictionsGlutenFree);
        pnlDietaryRestrictionsOptions.add(cbDietaryRestrictionsVegetarian);

        pnlDietaryRestrictions.setLayout(new BorderLayout());
        pnlDietaryRestrictions.add(lblDietaryRestrictions, BorderLayout.WEST);
        pnlDietaryRestrictions.add(pnlDietaryRestrictionsOptions, BorderLayout.EAST);

        pnlSpicinessRating.setLayout(new GridLayout(1,2));
        pnlSpicinessRating.add(lblSpicinessRating);
        pnlSpicinessRating.add(spinnerSpicinessRating);

        pnlContent.setLayout(new GridLayout(6,1));
        pnlContent.add(pnlName);
        pnlContent.add(pnlIngredients);
        pnlContent.add(pnlCategory);
        pnlContent.add(pnlPrice);
        pnlContent.add(pnlDietaryRestrictions);
        pnlContent.add(pnlSpicinessRating);

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

                int spicinessRating = Integer.parseInt(spinnerSpicinessRating.getValue().toString());
                if (spicinessRating > 10 || spicinessRating < 0) {
                    invalidInput(dialog);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.setSize(550, 250);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void invalidInput(Dialog dialog) {
        showMessageDialog(dialog, "Invalid Input", "", JOptionPane.ERROR_MESSAGE);
    }

    private void updateDish(int index) {

    }

    private void refreshDishList() {
        dishListModel.removeAllElements();

        for (Dish dish : dishController.getDishes()) {
            dishListModel.addElement(dish.toString());
        }
    }

    private void deleteDishesList(int index) {
        dishController.deleteDish(index);
        List<Dish> dishesList = dishController.getDishes();

        refreshDishList();
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