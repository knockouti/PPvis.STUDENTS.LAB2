package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Игорь on 15.04.2016.
 */
public class MainWindow {
    JFrame mainFrame;

    public MainWindow() {
        mainFrame = new JFrame("Главное окно");
        mainFrame.setSize(700, 700);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(this.addJToolBar(), BorderLayout.LINE_START);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public JToolBar addJToolBar() {
        JToolBar mainToolBar = new JToolBar();
        mainToolBar.setSize(400, 400);
        mainToolBar.setVisible(true);
        mainToolBar.setFloatable(false);
        mainToolBar.setLayout(new BoxLayout(mainToolBar, BoxLayout.Y_AXIS));
        mainToolBar.add(addButtonOpen());
        mainToolBar.add(addButonSave());
        return mainToolBar;

    }

    public JButton addButtonOpen() {
        JButton buttonOpen = new JButton(new ImageIcon("images\\open.png"));
        return buttonOpen;
    }

    public JButton addButonSave() {
        JButton buttonSave = new JButton(new ImageIcon("images\\save.png"));
        return buttonSave;
    }
}
