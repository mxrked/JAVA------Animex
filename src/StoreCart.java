import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class StoreCart {


    public ArrayList<Double> cartItemPrices = new ArrayList<>();
    public ArrayList<String> cartItems = new ArrayList<>();

    public JFrame storeCartFrame = new JFrame("Animex - Store/Cart");
    private JPanel storeCartPanel;
    private JCheckBox josephJoestarFigureCB;
    private JCheckBox demonSlayerVol1CB;
    private JCheckBox mobPsycho100TshirtCB;
    private JCheckBox dekuMidoriyaFigureCB;
    private JTextArea cartItemsTxt;

    private JButton checkoutBtn;

    private JButton clearBtn;
    private JLabel totalLabel;


    public static void centerFrame(JFrame frame) {
        Dimension grabUserScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Getting center coords
        int screenX = (int) ((grabUserScreenSize.getWidth() - frame.getWidth()) / 2);
        int screenY = (int) ((grabUserScreenSize.getHeight() - frame.getHeight()) / 2);

        // Setting the screen to center
        frame.setLocation(screenX, screenY);

    }

    public static void calculateTotal(ArrayList<Double> prices, JLabel totalLabel) {
        Double total = 0.00;

        for (Double cartPrice : prices) {
            total += cartPrice;
        }

        totalLabel.setText("$ " + String.format("%.2f", total)); // Making it 2 decimal points
    }

    public static void addItemToCart(ArrayList<String> items, ArrayList<Double> prices, String item, Double price, JTextArea txt, JLabel cartTotal, JButton clear, JButton checkout) {
        // Removing item and price
        items.remove(item);
        prices.remove(price);

        if (!items.contains(item)) {
            items.add(item);
            prices.add(price);

            // Enabling btns
            clear.setEnabled(true);
            checkout.setEnabled(true);

            txt.setText(""); // Clearing the textarea

            if (!items.isEmpty()) {
                for (String cartItem : items) {
                    txt.append("Item: " + cartItem + "\n");
                }
            }

            calculateTotal(prices, cartTotal); // Grabbing new total

        }


    }

    public static void removeItemToCart(ArrayList<String> items, ArrayList<Double> prices, String item, Double price, JTextArea txt, JLabel cartTotal, JButton clear, JButton checkout) {
        items.remove(item);
        prices.remove(price);

        txt.setText("");

        // Checking if there are no items, disabling btns
        if (items.isEmpty()) {
            clear.setEnabled(false);
            checkout.setEnabled(false);
        }

        for (String cartItem : items) {
            txt.append("Item: " + cartItem + "\n");
        }

        calculateTotal(prices, cartTotal);

    }

    StoreCart() {

        storeCartFrame.add(storeCartPanel);
        storeCartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        storeCartFrame.setVisible(true);
        storeCartFrame.setSize(700, 800);

        centerFrame(storeCartFrame);


        // Event listeners

            // Btns
            checkoutBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == checkoutBtn) {
                        if (!cartItems.isEmpty()) {
                            System.exit(0);
                        }
                    }
                }
            });

            clearBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!cartItems.isEmpty()) {

                        // Clearing/Reseting stuff
                        cartItems.clear();
                        cartItemPrices.clear();
                        cartItemsTxt.setText("");

                        josephJoestarFigureCB.setSelected(false);
                        demonSlayerVol1CB.setSelected(false);
                        mobPsycho100TshirtCB.setSelected(false);
                        dekuMidoriyaFigureCB.setSelected(false);

                        // Grabbing new total
                        calculateTotal(cartItemPrices, totalLabel);

                    }
                }
            });


            // Checkboxes
            josephJoestarFigureCB.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    // If checked
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        addItemToCart(cartItems, cartItemPrices, "Joseph Joestar Figure", 45.60, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }

                    // If NOT checked
                    if (e.getStateChange() != ItemEvent.SELECTED) {
                        removeItemToCart(cartItems, cartItemPrices, "Joseph Joestar Figure", 45.60, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }
                }
            });

            demonSlayerVol1CB.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    // If checked
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        addItemToCart(cartItems, cartItemPrices, "Demon Slayer Vol. 1", 23.99, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }

                    // If NOT checked
                    if (e.getStateChange() != ItemEvent.SELECTED) {
                        removeItemToCart(cartItems, cartItemPrices, "Demon Slayer Vol. 1", 23.99, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }
                }
            });

            mobPsycho100TshirtCB.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    // If checked
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        addItemToCart(cartItems, cartItemPrices, "Mob Psycho 100 T-shirt", 21.45, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }

                    // If NOT checked
                    if (e.getStateChange() != ItemEvent.SELECTED) {
                        removeItemToCart(cartItems, cartItemPrices, "Mob Psycho 100 T-shirt", 21.45, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }
                }
            });

            dekuMidoriyaFigureCB.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    // If checked
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        addItemToCart(cartItems, cartItemPrices, "Deku Midoriya Figure", 41.20, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }

                    // If NOT checked
                    if (e.getStateChange() != ItemEvent.SELECTED) {
                        removeItemToCart(cartItems, cartItemPrices, "Deku Midoriya Figure", 41.20, cartItemsTxt, totalLabel, clearBtn, checkoutBtn);
                    }
                }
            });
    }

}
