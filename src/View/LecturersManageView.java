/*
    This class displays all the visual components for displaying lecturer information, the class adds a table and
    relevant buttons as well as extra components, this allows the user to view all lecturer information and filter
    certain information based on its respective controller.
*/

package View;

import Controller.LecturerManageController;
import Model.File_Writer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class LecturersManageView {


    public JPanel lecBody;
    public JPanel lecHead;
    public JPanel lecSide;
    private JPanel tablePanelLec;
    private String result;

    private JPanel lecSearchPanel;
    public DefaultTableModel tableModel;

    public JTable depTableLec;
    public File_Writer getTableData;

    private JLabel lecHeadTitle;
    private JLabel tableSelect;
    private JLabel jlLecSearch;

    public JTextField lecSearch;
    public JButton lecSearchButton;

    public JComboBox lecSelect;
    public JButton selectRow;

    public String depId;
    public String roleName;

    public int j = 0;

    private HashMap<String, String> tableResults;

    public String[] LecType = {"All", "Full-Time", "Part-Time", "Contract"};
    public String[] colNames = {"Lec Id", "Lec First Name", "Lec Last Name", "Lec Contact",
            "Lec Email", "Lec Start", "Lec Dep Id", "Sal/Wage/End", "Data Number", "Lecturer Role"};

    private LecturerManageController lecturerManageController;

    public LecturersManageView(JPanel lecBody, JPanel lecHead, JPanel lecSide, String depId) {
        this.lecBody = lecBody;
        this.lecHead = lecHead;
        this.lecSide = lecSide;
        this.depId = depId;
        this.lecturerManageController = new LecturerManageController(this);

        setDepTable();
        setDepHead();
        setDepBody();
        addActionListeners();
    }

    public void setDepTable() {

        this.lecBody.removeAll();
        this.lecBody.setVisible(false);
        this.lecBody.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        this.lecBody.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        this.lecBody.setPreferredSize(new Dimension(700, 350));

        this.tablePanelLec = new JPanel();
        this.tablePanelLec.setLayout(new BorderLayout());
        this.tablePanelLec.setPreferredSize(new Dimension(750, 350));
        this.tablePanelLec.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        DefaultTableModel depTabModel = new DefaultTableModel(colNames, 8);

        this.depTableLec = new JTable(depTabModel);
        this.depTableLec.setPreferredSize(new Dimension(700, 320));
        this.depTableLec.setRowHeight(30);
        this.depTableLec.setPreferredScrollableViewportSize(this.depTableLec.getPreferredSize());
        this.tablePanelLec.add(new JScrollPane(this.depTableLec), BorderLayout.CENTER);
        this.lecBody.add(tablePanelLec, BorderLayout.CENTER);
        this.lecBody.setVisible(true);

        try {
            addRows("lecturers/all/", "", "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setDepHead() {
        this.lecHead.removeAll();
        this.lecHead.setVisible(false);

        this.lecHeadTitle = new JLabel("Lecturers Management");
        this.lecHeadTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        this.lecHead.add(lecHeadTitle);
        this.lecHead.setVisible(true);

    }

    public void setDepBody() {
        this.lecSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        this.lecSearchPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecSearchPanel.setBackground(Color.white);

        this.tableSelect = new JLabel("Select Lecturer Type");
        this.tableSelect.setPreferredSize(new Dimension(130, 40));
        this.tableSelect.setForeground(Color.white);
        this.tableSelect.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecBody.add(tableSelect);

        this.lecSelect = new JComboBox(LecType);
        this.lecSelect.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecSelect.setPreferredSize(new Dimension(100, 30));
        this.lecSelect.setBackground(Color.white);
        this.lecBody.add(lecSelect);

        this.jlLecSearch = new JLabel("Search By Key Word");
        this.jlLecSearch.setPreferredSize(new Dimension(130, 40));
        this.jlLecSearch.setForeground(Color.black);
        this.jlLecSearch.setFont(new Font("Monospace", Font.BOLD, 12));
        this.lecSearchPanel.add(jlLecSearch);

        this.lecSearch = new JTextField();
        this.lecSearch.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecSearch.setPreferredSize(new Dimension(130, 30));
        this.lecSearch.setBackground(Color.lightGray);
        this.lecSearchPanel.add(this.lecSearch);

        this.lecSearchButton = new JButton("Search");
        this.lecSearchButton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecSearchButton.setPreferredSize(new Dimension(70, 30));
        this.lecSearchButton.setBackground(Color.white);
        this.lecSearchPanel.add(this.lecSearchButton);

        this.selectRow = new JButton("Select Row");
        this.selectRow.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.selectRow.setPreferredSize(new Dimension(100, 30));
        this.selectRow.setBackground(Color.white);
        this.lecSearchPanel.add(selectRow);

        this.lecBody.add(lecSearchPanel);
    }

    public void addActionListeners() {
        if (this.depId == null) {
            this.selectRow.addActionListener(this.lecturerManageController);
        }
        this.lecSelect.addActionListener(this.lecturerManageController);
        this.lecSearchButton.addActionListener(this.lecturerManageController);

    }

    public void updateTableColumn(String arg, String filePath, String filter, String lecTypeVal) {
        JTableHeader head = depTableLec.getTableHeader();
        TableColumnModel mod = head.getColumnModel();
        TableColumn col = mod.getColumn(7);
        col.setHeaderValue(arg);

        try {
            addRows(filePath, filter, lecTypeVal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        head.repaint();
    }

    public void addRows(String lecType, String filter, String lecTypeVal) throws IOException, ClassNotFoundException {

        switch (lecType) {
            case "lecturers/all/full_time":
                this.result = "salary";
                break;
            case "lecturers/all/part_time":
                this.result = "hourly_rate";
                break;
            case "lecturers/all/contract":
                this.result = "end_date";
                break;
        }

        this.getTableData = new File_Writer(null, lecBody, lecHead, lecHead, lecType, 0);
        this.tableModel = (DefaultTableModel) depTableLec.getModel();
        this.tableModel.setRowCount(0);


        String[] name = {"full_time", "part_time", "contract"};
        String[] columnNames = {"salary", "hourly_rate", "end_date"};

        if (lecType.equals("lecturers/all/")) {
            for (int i = 0; i < name.length; i++) {
                loadTableDataRows(filter, name[i], columnNames[i], name[i]);

            }
        } else {
            loadTableDataRows(filter, "", "", lecTypeVal);
        }
    }

    public void loadTableDataRows(String filter, String dirName, String colNames, String lecTypeVal) throws IOException, ClassNotFoundException {
        for (int i = 0; i < getTableData.fileCount(0, dirName); i++) {

            this.tableResults = getTableData.readFile(i, dirName);
            this.roleName = colNames;

            if (colNames.equals("salary") || colNames.equals("hourly_rate") || colNames.equals("end_date")) {
                this.result = this.roleName;
            }

            if (this.depId == null || this.tableResults.containsValue(this.depId)) {
                if (filter.equals("") || this.tableResults.containsValue(filter)) {

                    this.tableModel.addRow(new Object[]{Boolean.FALSE, null, null, null});
                    this.tableModel.setValueAt(this.tableResults.get("lec_id"), j, 0);
                    this.tableModel.setValueAt(this.tableResults.get("first_name"), j, 1);
                    this.tableModel.setValueAt(this.tableResults.get("last_name"), j, 2);
                    this.tableModel.setValueAt(this.tableResults.get("contact"), j, 3);
                    this.tableModel.setValueAt(this.tableResults.get("email"), j, 4);
                    this.tableModel.setValueAt(this.tableResults.get("start_date"), j, 5);
                    this.tableModel.setValueAt(this.tableResults.get("dep_id"), j, 6);
                    this.tableModel.setValueAt(this.tableResults.get(this.result), j, 7);
                    this.tableModel.setValueAt(i, j, 8);
                    this.tableModel.setValueAt(lecTypeVal, j, 9);
                    j++;
                }
            }
        }
    }
}
