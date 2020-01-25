/*
    This class displays all the visual components for displaying department information, the class adds a table and
    relevant buttons as well as extra components, this allows the user to view all department information and filter
    certain information based on its respective controller.
*/

package View;

import Controller.DepartmentManageController;
import Model.File_Writer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;


public class DepartmentsManageView {

    public JPanel depBody;
    public JPanel depHead;
    public JPanel depSide;
    private JPanel tablePanel;
    private JPanel depSearchPanel;

    public JTable depTable;

    private JLabel depHeadTitle;

    public JButton selectRowButton;

    public JTextField tfDepSearch;
    public JButton depSearch;

    public String depId;

    private JLabel depLabel;

    public DefaultTableModel tableModel;

    public int j = 0;

    private DepartmentManageController departmentManageController;

    private HashMap<String, String> tableData;

    public DepartmentsManageView(JPanel depBody, JPanel depHead, JPanel depSide, String depId) {
        this.depBody = depBody;
        this.depHead = depHead;
        this.depSide = depSide;
        this.depId = depId;
        this.departmentManageController = new DepartmentManageController(this, null);
        setDepTable();
        setDepHead();
        addActionListeners();
    }

    public void setDepTable() {
        this.depBody.removeAll();
        this.depBody.setVisible(false);
        this.depBody.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        this.depBody.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        this.depBody.setPreferredSize(new Dimension(700, 350));

        this.depSearchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        this.depSearchPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.depSearchPanel.setBackground(Color.white);

        this.tablePanel = new JPanel();
        this.tablePanel.setLayout(new BorderLayout());
        this.tablePanel.setPreferredSize(new Dimension(750, 350));
        this.tablePanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        String[] colNames = {"Department Id", "Department Name", "Department Type", "Web-Address",
                "Username", "Department Password", "Data Number"};
        DefaultTableModel depTabModel = new DefaultTableModel(colNames, 7);

        this.depTable = new JTable(depTabModel);
        this.depTable.setPreferredSize(new Dimension(700, 320));
        this.depTable.setRowHeight(30);
        this.depTable.setPreferredScrollableViewportSize(this.depTable.getPreferredSize());
        this.tablePanel.add(new JScrollPane(this.depTable), BorderLayout.CENTER);
        this.depBody.add(tablePanel, BorderLayout.CENTER);

        this.tfDepSearch = new JTextField();
        this.tfDepSearch.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.tfDepSearch.setPreferredSize(new Dimension(130, 30));
        this.tfDepSearch.setBackground(Color.lightGray);
        this.depSearchPanel.add(this.tfDepSearch);

        this.depLabel = new JLabel("Search By Key Word");
        this.depLabel.setPreferredSize(new Dimension(130, 40));
        this.depLabel.setForeground(Color.black);
        this.depLabel.setFont(new Font("Monospace", Font.BOLD, 12));
        this.depSearchPanel.add(depLabel);

        this.depSearch = new JButton("Search");
        this.depSearch.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.depSearch.setPreferredSize(new Dimension(90, 30));
        this.depSearch.setBackground(Color.white);
        this.depSearchPanel.add(this.depSearch);

        this.selectRowButton = new JButton("Select Row");
        this.selectRowButton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.selectRowButton.setPreferredSize(new Dimension(100, 30));
        this.selectRowButton.setBackground(Color.white);
        this.depSearchPanel.add(this.selectRowButton);

        this.depBody.add(depSearchPanel);

        this.depBody.setVisible(true);

        try {
            addRows("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void setDepHead() {
        this.depHead.removeAll();
        this.depHead.setVisible(false);

        this.depHeadTitle = new JLabel("Departments Management");
        this.depHeadTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        this.depHead.add(depHeadTitle);
        this.depHead.setVisible(true);

    }


    public void addRows(String filter) throws IOException, ClassNotFoundException {

        File_Writer getTableData = new File_Writer(null, null, null, null, "departments", 0);
        this.tableModel = (DefaultTableModel) depTable.getModel();
        tableModel.setRowCount(0);

        for (int i = 0; i < getTableData.fileCount(0, ""); i++) {

            this.tableData = getTableData.readFile(i, "");

            if (this.depId == null || this.tableData.containsValue(this.depId)) {

                if (filter.equals("") || this.tableData.containsValue(filter)) {

                    this.tableModel.addRow(new Object[]{Boolean.FALSE, null, null, null});
                    this.tableModel.setValueAt(this.tableData.get("dep_id"), j, 0);
                    this.tableModel.setValueAt(this.tableData.get("dep_name"), j, 1);
                    this.tableModel.setValueAt(this.tableData.get("dep_type"), j, 2);
                    this.tableModel.setValueAt(this.tableData.get("dep_web"), j, 3);
                    this.tableModel.setValueAt(this.tableData.get("dep_username"), j, 4);
                    this.tableModel.setValueAt(this.tableData.get("dep_password"), j, 5);
                    this.tableModel.setValueAt(i, j, 6);
                    j++;
                }
            }
        }
    }

    public void updateTableRows(String filter) {
        JTableHeader head = depTable.getTableHeader();
        try {
            addRows(filter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        head.repaint();
    }


    public void addActionListeners() {

        this.selectRowButton.addActionListener(this.departmentManageController);
        this.depSearch.addActionListener(this.departmentManageController);
    }
}

