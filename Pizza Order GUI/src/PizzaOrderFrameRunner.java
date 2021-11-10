import javax.swing.*;
import javax.swing.JFrame;
import java.io.IOException;

public class PizzaOrderFrameRunner {
    public static void main(String[] args) {
        JFrame pizzaOrder = new PizzaOrderFrame();
        pizzaOrder.setVisible(true);

        pizzaOrder.setTitle("Order a Pizza");
        pizzaOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
