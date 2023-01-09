import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel rootPanel;
    private JButton enterBtn;
    private JButton exitBtn;

    public JFrame mainMenuFrame = new JFrame("Animex");


    public static void centerFrame(JFrame frame) {
        Dimension grabUserScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Getting center coords
        int screenX = (int) ((grabUserScreenSize.getWidth() - frame.getWidth()) / 2);
        int screenY = (int) ((grabUserScreenSize.getHeight() - frame.getHeight()) / 2);

        // Setting the screen to center
        frame.setLocation(screenX, screenY);

    }


    MainMenu() {
        mainMenuFrame.add(rootPanel);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setVisible(true);
        mainMenuFrame.setSize(500, 500);

        centerFrame(mainMenuFrame);



        // Event listeners
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == enterBtn) {
                    mainMenuFrame.dispose();
                    StoreCart storeCart = new StoreCart();
                }
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exitBtn) {
                    System.exit(0);
                }
            }
        });
    }

}
