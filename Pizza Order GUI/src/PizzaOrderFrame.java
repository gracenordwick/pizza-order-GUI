import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderFrame extends JFrame {


    JPanel main = new JPanel();
    JPanel toppingsPanel = new JPanel();
    JPanel sizePanel = new JPanel();
    JPanel functionPanel = new JPanel();
    JPanel crustPanel = new JPanel();
    JPanel orderPanel = new JPanel();
    JTextArea pizzaOrder = new JTextArea();

    String printToppings = "";
    String printCrust = "";
    String printSize="";
    double subtotal = 0;
    double tax =0;
    double total=0;

String[] sizeStrings =  {"Small", "Medium","Large", "Super"};

    JRadioButton thinCrust = new JRadioButton("Thin");
    JRadioButton regCrust = new JRadioButton("Regular");
    JRadioButton deepCrust = new JRadioButton("Deep");


JCheckBox pepperoni = new JCheckBox("Pepperoni");
JCheckBox mushrooms = new JCheckBox("Mushrooms");
JCheckBox chicken = new JCheckBox("Chicken");
JCheckBox bacon = new JCheckBox("Bacon");
JCheckBox pineapple = new JCheckBox("Pineapple");
JCheckBox onions = new JCheckBox("Onions");

ButtonGroup crustGroup = new ButtonGroup();

JComboBox sizeComboBox = new JComboBox(sizeStrings);

public void createCrustButtons() {

    crustGroup.add(thinCrust); //adds options to a group so only one of them can be selected at once
    crustGroup.add(regCrust);
    crustGroup.add(deepCrust);
    crustPanel.add(thinCrust);
    crustPanel.add(regCrust);
    crustPanel.add(deepCrust);
    crustPanel.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));
    //action listener!!!!

}


public void clearToppings(){
    boolean state = false;
    pepperoni.setSelected(false);
    mushrooms.setSelected(false);
    chicken.setSelected(false);
    bacon.setSelected(false);
    pineapple.setSelected(false);
    onions.setSelected(false);
}

public void createSizeComboBox(){
    
    sizeComboBox.setSelectedIndex(3);
    //sizeComboBox.addActionListener(this); I DONT KNOW HOW TO USE THIS YET
    //sizeComboBox.addItem("Small");
    //sizeComboBox.addItem("Medium");
    //sizeComboBox.addItem("Large");
    //sizeComboBox.addItem("Super");

    sizePanel.add(sizeComboBox);
    sizeComboBox.setSelectedIndex(2);
    sizePanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
}

public void createToppingsPanel(){


    toppingsPanel.add(pepperoni);
    toppingsPanel.add(mushrooms);
    toppingsPanel.add(chicken);
    toppingsPanel.add(bacon);
    toppingsPanel.add(pineapple);
    toppingsPanel.add(onions);
    toppingsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));
}

public void crustChoice() {
    if (thinCrust.isSelected()){
        printCrust = "Thin crust    \n";
    }
    if (regCrust.isSelected()){
        printCrust = "Regular crust     \n";
    }
    if (deepCrust.isSelected()){
        printCrust="Deep crust      \n";
    }
}

public void sizeChoice(){
    if (sizeComboBox.getSelectedIndex()==0){
        subtotal= subtotal + 8;
        printSize="Small pizza          $8.00\n";
    }
    if (sizeComboBox.getSelectedIndex()==1){
        subtotal= subtotal + 12;
        printSize="Medium pizza         $12.00\n";
    }
    if (sizeComboBox.getSelectedIndex()==2){
        subtotal= subtotal + 16;
        printSize="Large pizza          $16.00\n";
    }
    if (sizeComboBox.getSelectedIndex()==3){
        subtotal= subtotal + 20;
        printSize="Super pizza          $20.00\n";
    }


}

public void toppingChoicePrice(){
    if (pepperoni.isSelected()){
        subtotal++;
        printToppings += "pepperoni         $1.00\n";
    }

    if (mushrooms.isSelected()){
        subtotal++;
        printToppings += "mushrooms         $1.00\n";
    }

    if (chicken.isSelected()){
        subtotal++;
        printToppings += "chicken           $1.00\n";
    }

    if (bacon.isSelected()){
        subtotal++;
        printToppings += "bacon             $1.00\n";
    }

    if (pineapple.isSelected()){
        subtotal++;
        printToppings += "pineapple         $1.00\n";
    }

    if (onions.isSelected()){
        subtotal++;
        printToppings += "onions            $1.00\n";
    }
}


//JScrollPane scrollPanel = new JScrollPane(textArea);
public PizzaOrderFrame(){
    createCrustButtons();
    createFunctionButtons();
    createToppingsPanel();
    createSizeComboBox();
    main.add(crustPanel);
    main.add(sizePanel);
    main.add(toppingsPanel);
    main.add(functionPanel);
    main.add(orderPanel);
    this.getContentPane().add(main);
    this.pack();
    this.setVisible(true);

}
public void createFunctionButtons() {
    JButton quitButton = new JButton("Quit");
        functionPanel.add(quitButton);

    quitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

    JButton clearButton = new JButton("Clear");
        functionPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
                crustGroup.clearSelection();
                clearToppings();
                sizeComboBox.setSelectedIndex(2);
                pizzaOrder.setText("");
                printToppings="";
                subtotal=0;
                total=0;
            }
    });

    JButton orderButton = new JButton("Order");
        functionPanel.add(orderButton);
        orderButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                receipt();
            }
        });

} //ends CreateFunctionButtons

public void prices(){
    tax = (subtotal *.07);
    total = subtotal +tax;
}


public void receipt(){
        pizzaOrder.setEditable(false);
        crustChoice();
        sizeChoice();
        toppingChoicePrice();
        prices();
        orderPanel.add(pizzaOrder);
        pizzaOrder.append("====================\n");
        pizzaOrder.append(printCrust);
        pizzaOrder.append(printToppings);
        pizzaOrder.append(printSize);
        pizzaOrder.append("                         \n");
        pizzaOrder.append("Sub-total:           $" +String.format("%,.2f\n", subtotal));
        pizzaOrder.append("Tax:           $"+String.format("%,.2f\n", tax));
        pizzaOrder.append("-----------------------------------\n");
        pizzaOrder.append("Total:           $"+String.format("%,.2f\n", total));
        pizzaOrder.append("====================\n");


    }



}



