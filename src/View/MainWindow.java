package View;

import Controller.ControllerButton;
import Controller.OutpuStr;
import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Игорь on 15.04.2016.
 */
public class MainWindow {
    JFrame mainFrame;
    View.TableModel tableModel;
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
        this.tableModel = tableModel;
        mainFrame.add(this.addTableForManWindow(this.tableModel), BorderLayout.CENTER);
        OutpuStr outpuStr = new OutpuStr(tableModel);
        mainFrame.add(outpuStr, BorderLayout.PAGE_END);
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

//    public JPanel panelForStr() {
//        JPanel panelStr = new JPanel(new FlowLayout());
//        JTextField textFieldForVisibleSize = new JTextField();
//        textFieldForVisibleSize.setFont(textFieldForVisibleSize.getFont().deriveFont(15f));
//        textFieldForVisibleSize.setPreferredSize(new Dimension(30, 30));
//        JButton next = new JButton("next");
//        JButton firstElement = new JButton("1");
//        JButton lateElement = new JButton();
//if(tableModel.getOneStudent().size() == 0){
//    lateElement.setText("-");
//}
//        JLabel labelCurrentPage =  new JLabel();
//        labelCurrentPage.setPreferredSize(new Dimension(30,30));
//        labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//        next.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tableModel.pageUp();
//                labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//                tableModel.fireTableDataChanged();
//            }
//        });
//        JButton prev = new JButton("Prev");
//        lateElement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lateElement.setText(String.valueOf(tableModel.getNubmerStr()));
//                tableModel.setCurrent(tableModel.getNubmerStr());
//                tableModel.pageUp();
//                labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//            }
//        });
//        firstElement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                tableModel.setCurrent(tableModel.getNubmerStr());
//                tableModel.goFirstStr();
//                labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//            }
//        });
//        prev.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tableModel.pageDown();
//                labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//                tableModel.fireTableDataChanged();
//            }
//        });
//        textFieldForVisibleSize.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    tableModel.setSize(Integer.valueOf(textFieldForVisibleSize.getText()).intValue());
//                    labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//                }
//            }
//        });
//
//
//        panelStr.add(prev);
//        panelStr.add(firstElement);
//      panelStr.add(labelCurrentPage);
//        panelStr.add(lateElement);
//        panelStr.add(next);
//        panelStr.add(textFieldForVisibleSize);
//
//        return panelStr;
//    }

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

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DocumentBuilderFactory dbfLoad = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = dbfLoad.newDocumentBuilder();
                    File file = new File("src\\XMLfiles\\table.xml");
                    Document docLoad = builder.parse(file);
                    NodeList name = docLoad.getElementsByTagName("name");
                    NodeList surname = docLoad.getElementsByTagName("surname");
                    NodeList patronomic = docLoad.getElementsByTagName("patr");
                    NodeList data = docLoad.getElementsByTagName("date");
                    NodeList footballTeam = docLoad.getElementsByTagName("namefootballteam");
                    NodeList faculty = docLoad.getElementsByTagName("namefaculty");
                    NodeList position = docLoad.getElementsByTagName("pos");
                    NodeList composition = docLoad.getElementsByTagName("comp");
                    NodeList listRow = docLoad.getElementsByTagName("student");
                    for (int i = 0; i < listRow.getLength(); i++) {
                        controllerButton.addNewStudent();
                        controllerButton.getStudent().setName(name.item(i).getFirstChild().getNodeValue());
                        controllerButton.getStudent().setSurname(surname.item(i).getFirstChild().getNodeValue());
                        controllerButton.getStudent().setPatronomic(patronomic.item(i).getFirstChild().getNodeValue());
                        controllerButton.getStudent().setDateBirthday(format.parse(data.item(i).getFirstChild().getNodeValue()));
                        controllerButton.getStudent().setFootbalTeam(footballTeam.item(i).getFirstChild().getNodeValue());
                        controllerButton.getStudent().setFaculty(faculty.item(i).getFirstChild().getNodeValue());
                        controllerButton.getStudent().setPosition(position.item(i).getFirstChild().getNodeValue());
                        controllerButton.getStudent().setComposition(composition.item(i).getFirstChild().getNodeValue());
                        controllerButton.setDataTable();
                    }
                } catch
                        (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        return buttonOpen;
    }

    private JButton addButonSave() {
        JButton buttonSave = new JButton(new ImageIcon("images\\save.png"));
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
                    File file = new File("src\\XMLfiles\\table.xml");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    Document doc = builder.newDocument();
                    Element tableEl = doc.createElement("liststudent");
                    doc.appendChild(tableEl);
                    TableColumnModel columns = tableForMainMindow.getColumnModel();
                    for (int i = 0; i < tableModel.oneStudent.size(); i++) {
                        Element rowEl = doc.createElement("student");
                        tableEl.appendChild(rowEl);
                        String strValueName = tableModel.getOneStudent().get(i).getName();
                        Element elementName = doc.createElement("name");
                        rowEl.appendChild(elementName);
                        elementName.appendChild(doc.createTextNode(strValueName));
                        String strValueSurname = tableModel.getOneStudent().get(i).getSurname();
                        Element elementSurName = doc.createElement("surname");
                        rowEl.appendChild(elementSurName);
                        elementSurName.appendChild(doc.createTextNode(strValueSurname));
                        String strValuePat = tableModel.getOneStudent().get(i).getPatronomic();
                        Element elementPat = doc.createElement("patr");
                        rowEl.appendChild(elementPat);
                        elementPat.appendChild(doc.createTextNode(strValuePat));
                        String strValueDate = tableModel.getOneStudent().get(i).getDateBirthday();
                        Element elementDate = doc.createElement("date");
                        rowEl.appendChild(elementDate);
                        elementDate.appendChild(doc.createTextNode(strValueDate));
                        String strValueFootball = tableModel.getOneStudent().get(i).getFootballTeam();
                        Element elementFootball = doc.createElement("footballteam");
                        Element nameFootbalTeam = doc.createElement("namefootballteam");
                        nameFootbalTeam.appendChild(doc.createTextNode(strValueFootball));
                        elementFootball.appendChild(nameFootbalTeam);
                        rowEl.appendChild(elementFootball);

                        String strValueFaculty = tableModel.getOneStudent().get(i).getFaculty();
                        Element elementFaculty = doc.createElement("faculty");
                        Element nameFaculty = doc.createElement("namefaculty");
                        nameFaculty.appendChild(doc.createTextNode(strValueFaculty));
                        elementFaculty.appendChild(nameFaculty);
                        rowEl.appendChild(elementFaculty);

                        String strValuePos = tableModel.getOneStudent().get(i).getPosition();
                        Element elementPos = doc.createElement("pos");
                        rowEl.appendChild(elementPos);
                        elementPos.appendChild(doc.createTextNode(strValuePos));
                        String strValueComp = tableModel.getOneStudent().get(i).getComposition();
                        Element elementComp = doc.createElement("comp");
                        rowEl.appendChild(elementComp);
                        elementComp.appendChild(doc.createTextNode(strValueComp));
                    }
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    doc.normalizeDocument();
                    Transformer transformer = tFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
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
