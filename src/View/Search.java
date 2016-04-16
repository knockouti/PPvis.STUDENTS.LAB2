package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Игорь on 16.04.2016.
 */
public class Search {
JFrame frameSearch;

    public Search()
    {
        frameSearch = new JFrame("Поиск");
        frameSearch = new JFrame("Добавить нового студента");
        frameSearch.setSize(520, 430);
        frameSearch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameSearch.setLayout(new BorderLayout());
        frameSearch.setLocationRelativeTo(null);

        frameSearch.setVisible(true);
    }
}
