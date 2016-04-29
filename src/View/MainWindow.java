package View;

import Controller.ControllerButton;
import javafx.scene.control.Tab;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Игорь on 15.04.2016.
 */
public class MainWindow {
    JFrame mainFrame;
    TableModel tableModel;
    ControllerButton controllerButton;
    JTable tableForMainMindow;
    public MainWindow(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;

        mainFrame = new JFrame("Главное окно");
        mainFrame.setSize(1200, 700);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(this.addJToolBar(), BorderLayout.LINE_START);
        mainFrame.add(this.addJMenuBar(), BorderLayout.PAGE_START);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void setBool(boolean bool) {
        mainFrame.setVisible(bool);
    }

    public void addTableModel(View.TableModel tableModel) {
        mainFrame.add(this.addTableForManWindow(tableModel), BorderLayout.CENTER);
    }

    private JScrollPane addTableForManWindow(View.TableModel tableModel) {

        JPanel panelForTable = new JPanel();
        panelForTable.setSize(600, 600);
        tableForMainMindow = new JTable(tableModel);
        JScrollPane scrollPaneMainTable = new JScrollPane(tableForMainMindow);

        return scrollPaneMainTable;
    }

    private JToolBar addJToolBar() {
        JToolBar mainToolBar = new JToolBar();
        mainToolBar.setSize(400, 400);
        mainToolBar.setVisible(true);
        mainToolBar.setFloatable(false);
        mainToolBar.setLayout(new BoxLayout(mainToolBar, BoxLayout.Y_AXIS));
        mainToolBar.add(addButtonOpen());
        mainToolBar.add(addButonSave());
        mainToolBar.add(buttonAddFrame());
        mainToolBar.add(addButtonDelete());
        mainToolBar.add(addButtonSearch());
        return mainToolBar;

    }

    private JMenuBar addJMenuBar() {
        JMenuBar mainMenBar = new JMenuBar();
        JMenu mainFile = new JMenu("Файл");
        JMenuItem mainOpen = new JMenuItem("Открыть");
        JMenuItem mainSave = new JMenuItem("Сохранить");
        JMenuItem mainExit = new JMenuItem("Выйти");
        mainFile.add(mainOpen);
        mainFile.add(mainSave);
        mainFile.add(mainExit);
        mainMenBar.add(mainFile);
        return mainMenBar;
    }

    private JButton addButtonOpen() {
        JButton buttonOpen = new JButton(new ImageIcon("images\\open.png"));
        return buttonOpen;
    }

    private JButton addButonSave() {
        JButton buttonSave = new JButton(new ImageIcon("images\\save.png"));
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DocumentBuilderFactory f = DocumentBuilderFactory
                            .newInstance();
                    DocumentBuilder builder = f.newDocumentBuilder();
                    File file = new File("table.xml");

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    Document doc = builder.newDocument();
                    Element tableEl = doc.createElement("table");
                    doc.appendChild(tableEl);

                    TableModel model = tableForMainMindow.getModel();
                    TableColumnModel columns = tableForMainMindow.getColumnModel();

                    for (int i = 0; i < model.getRowCount(); i++) {
                        Element rowEl = doc.createElement("row");
                        tableEl.appendChild(rowEl);

                        for (int j = 0; j < columns.getColumnCount(); j++) {
                            TableColumn col = columns.getColumn(j);
                            String header = col.getHeaderValue().toString();
                            String value = model.getValueAt(i, j).toString();
                            Element cellEl = doc.createElement("cell");
                            Attr colAttr = doc.createAttribute("colName");
                            cellEl.setAttributeNode(colAttr);
                            rowEl.appendChild(cellEl);
                            colAttr.appendChild(doc.createTextNode(header));
                            cellEl.appendChild(doc.createTextNode(value));
                        }
                    }

                    TransformerFactory tFactory = TransformerFactory
                            .newInstance();
                    Transformer transformer = tFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(file);
                    transformer.transform(source, result);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        return buttonSave;
    }

    private JButton buttonAddFrame() {
        JButton buttonAdd = new JButton(new ImageIcon("images\\add.png"));
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.add();
            }
        });
        return buttonAdd;
    }

    private JButton addButtonDelete()

    {
        JButton buttonDelete = new JButton(new ImageIcon("images\\delete.png"));
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.goMainDelete();
            }
        });
        return buttonDelete;
    }

    private JButton addButtonSearch() {
        JButton buttonSearch = new JButton(new ImageIcon("images\\find.png"));
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.goMainSearch();
            }
        });
        return buttonSearch;
    }


}
