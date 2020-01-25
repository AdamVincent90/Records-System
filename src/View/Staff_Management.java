/*
    This class displays all the visual components for displaying staff information, the class adds a table and
    relevant buttons as well as extra components, this allows the user to view all lecturer information and filter
    certain information based on its respective controller.
*/

package View;

import Controller.StaffManageController;
import Model.File_Writer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Staff_Management {

    public JPanel staffBody;
    public JPanel staffHeader;
    public JPanel staffTablePanel;
    public JPanel staffSide;
    private JPanel searchPanel;
    public JTable staffTable;
    public JButton editStaff;
    public JLabel jlStaffSearch;

    public File_Writer getTableData;
    public JTextField staffSearch;

    public DefaultTableModel tableModel;

    private JLabel staffTitle;
    private JLabel staffRoleLabel;

    JTableHeader head;

    public JComboBox staffRole;

    public JButton searchButton;

    private String dep;
    public String depId;
    public int j = 0;

    private HashMap<String, String> tableDataStaff;

    private StaffManageController staffManageController;
    public String staffRoleName;

    public Staff_Management(JPanel staffBody, JPanel staffHeader, JPanel staffSide, String depId) {
        this.staffBody = staffBody;
        this.staffHeader = staffHeader;
        this.staffSide = staffSide;
        this.depId = depId;

        this.staffManageController = new StaffManageController(this);

        setDepTable();
        setDepBody();
        setDepHead();
        addActionListeners();
    }

    public void setDepTable() {

        this.staffBody.removeAll();
        this.staffBody.setVisible(false);
        this.staffBody.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        this.staffBody.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        this.staffBody.setPreferredSize(new Dimension(700, 350));

        this.staffTablePanel = new JPanel();
        this.staffTablePanel.setLayout(new BorderLayout());
        this.staffTablePanel.setPreferredSize(new Dimension(750, 350));
        this.staffTablePanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        String accessColumn = (this.depId == null) ? "password" : "Access right denied";

        String[] colNames = {"Admin/Secretary id", accessColumn, "Staff First Name", "Staff Last Name",
                "Staff Date of Birth", "Staff Employment Data", "Department Id", "Data Number", "Staff Role"};
        DefaultTableModel depTabModel = new DefaultTableModel(colNames, 8);

        this.staffTable = new JTable(depTabModel);
        this.staffTable.setPreferredSize(new Dimension(700, 320));
        this.staffTable.setRowHeight(30);
        this.staffTable.setPreferredScrollableViewportSize(this.staffTable.getPreferredSize());
        this.staffTablePanel.add(new JScrollPane(this.staffTable), BorderLayout.CENTER);
        this.staffBody.add(staffTablePanel, BorderLayout.CENTER);
        this.staffBody.setVisible(true);


        try {
            addRows("staff/all/", "", "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setDepHead() {
        this.staffHeader.removeAll();
        this.staffHeader.setVisible(false);

        this.staffTitle = new JLabel("Staff Management");
        this.staffTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        this.staffHeader.add(staffTitle);
        this.staffHeader.setVisible(true);

    }

    public void setDepBody() {
        this.searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        this.searchPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.searchPanel.setBackground(Color.white);

        String[] staffType = {"All", "Admin", "Secretary"};

        this.staffRoleLabel = new JLabel("Select Staff Type:");
        this.staffRoleLabel.setPreferredSize(new Dimension(130, 40));
        this.staffRoleLabel.setForeground(Color.white);
        this.staffRoleLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.staffBody.add(staffRoleLabel);

        this.staffRole = new JComboBox(staffType);
        this.staffRole.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.staffRole.setPreferredSize(new Dimension(100, 30));
        this.staffRole.setBackground(Color.white);
        this.staffBody.add(staffRole);

        this.jlStaffSearch = new JLabel("Search by Key Word");
        this.jlStaffSearch.setPreferredSize(new Dimension(130, 40));
        this.jlStaffSearch.setForeground(Color.black);
        this.jlStaffSearch.setFont(new Font("Monospace", Font.BOLD, 12));
        this.searchPanel.add(jlStaffSearch);

        this.staffSearch = new JTextField();
        this.staffSearch.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.staffSearch.setPreferredSize(new Dimension(130, 30));
        this.staffSearch.setBackground(Color.lightGray);
        this.searchPanel.add(this.staffSearch);

        this.searchButton = new JButton("Search");
        this.searchButton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.searchButton.setPreferredSize(new Dimension(70, 30));
        this.searchButton.setBackground(Color.white);
        this.searchPanel.add(this.searchButton);

        if (this.depId == null) {
            this.editStaff = new JButton("Select Row");
            this.editStaff.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            this.editStaff.setPreferredSize(new Dimension(100, 30));
            this.editStaff.setBackground(Color.white);
            this.searchPanel.add(this.editStaff);
        }

        this.staffBody.add(searchPanel);

    }

    public void addActionListeners() {
        if (depId == null) {
            this.editStaff.addActionListener(this.staffManageController);
        }
        this.staffRole.addActionListener(this.staffManageController);
        this.searchButton.addActionListener(this.staffManageController);
    }

    public void updateTableColumn(String arg, String param, String filter, String staffTypeVal) {
        this.head = staffTable.getTableHeader();
        TableColumnModel mod = this.head.getColumnModel();
        TableColumn col = mod.getColumn(0);
        col.setHeaderValue(arg);

        try {
            addRows(param, filter, staffTypeVal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        head.repaint();
    }

    public void addRows(String filePath, String filter, String staffTypeVal) throws IOException, ClassNotFoundException {

        switch (filePath) {
            case "staff/all/admin":
                this.dep = "admin_id";
                break;
            case "staff/all/secretary":
                this.dep = "secretary_id";
        }

        this.getTableData = new File_Writer(null, null, null, null, filePath, 0);
        this.tableModel = (DefaultTableModel) staffTable.getModel();
        this.tableModel.setRowCount(0);

        String[] name = {"admin", "secretary"};
        String[] columnData = {"admin_id", "secretary_id"};

        if (filePath.equals("staff/all/")) {
            for (int i = 0; i < name.length; i++) {
                loadTableDataRows(filter, name[i], columnData[i], name[i]);

            }
        } else {
            loadTableDataRows(filter, "", "", staffTypeVal);
        }


    }

    public void loadTableDataRows(String filter, String dirName, String columnName, String staffTypeVal) throws IOException, ClassNotFoundException {

        for (int i = 0; i < getTableData.fileCount(0, dirName); i++) {

            this.tableDataStaff = this.getTableData.readFile(i, dirName);
            this.staffRoleName = columnName;

            if (columnName.equals("admin_id") || columnName.equals("secretary_id")) {
                this.dep = columnName;
            }

            if (this.depId == null || this.tableDataStaff.containsValue(this.depId)) {

                if (filter.equals("") || this.tableDataStaff.containsValue(filter)) {

                    this.tableModel.addRow(new Object[]{Boolean.FALSE, null, null, null});
                    this.tableModel.setValueAt(this.tableDataStaff.get(this.dep), j, 0);
                    if (this.depId == null)
                    {
                        this.tableModel.setValueAt(this.tableDataStaff.get("password"), j, 1);
                    }
                    this.tableModel.setValueAt(this.tableDataStaff.get("first_name"), j, 2);
                    this.tableModel.setValueAt(this.tableDataStaff.get("last_name"), j, 3);
                    this.tableModel.setValueAt(this.tableDataStaff.get("date_of_birth"), j, 4);
                    this.tableModel.setValueAt(this.tableDataStaff.get("employment_date"), j, 5);
                    this.tableModel.setValueAt(this.tableDataStaff.get("department_id"), j, 6);
                    this.tableModel.setValueAt(i, j, 7);
                    this.tableModel.setValueAt(staffTypeVal, j, 8);
                    j++;
                }
            }
        }
    }
}
