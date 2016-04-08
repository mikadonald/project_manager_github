
package com.elle.ProjectManager.presentation;

import com.elle.ProjectManager.dao.IssueDAO;
import com.elle.ProjectManager.entities.Issue;
import com.elle.ProjectManager.logic.ShortCutSetting;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author fuxiaoqian
 */
public class ViewIssueWindow extends JFrame {

    // components
    private ProjectManagerWindow projectManager;
    private Issue issue;

    private Map<String, Component> ComponentsList;
    private JTable table;
    private int row;
    private IssueDAO dao;
    private boolean addIssueMode;

    //feature
    private ShortCutSetting ShortCutSetting;

    // boolean trigger
    private boolean contentChanged;

    /**
     * Creates new form ViewIssueWindow
     */
    public ViewIssueWindow(int row, JTable table) {
        projectManager = ProjectManagerWindow.getInstance();
        this.table = table;
        this.row = row;
        dao = new IssueDAO();
        issue = new Issue();
        ComponentsList = new HashMap<String, Component>();
        contentChanged = false; // if we do nothing about the text components' content, it stays false

        // new issue
        if (this.row == -1) {
            addIssueMode = true;
            issue.setId(dao.getMaxId() + 1);
            issue.setApp(projectManager.getSelectedTabName());
            issue.setDateOpened(todaysDate());
            issue.setSubmitter(projectManager.getUserName());
        } 
        // existing issue
        else {
            addIssueMode = false;
            setIssueValuesFromTable(row,table);
        }

        initComponents();

        setComponentValuesFromIssue();
        
        /**
         * Add all JTextComponents to add document listener, input mappings,
         * and shortcuts.
         */
        ArrayList<JTextComponent> textComponentList = new ArrayList<>();
        textComponentList.add(submitterText);
        textComponentList.add(dateOpenedText);
        textComponentList.add(programmerText);
        textComponentList.add(rkText);
        textComponentList.add(titleText);
        textComponentList.add(descriptionText);
        textComponentList.add(appText);
        textComponentList.add(dateClosedText);
        textComponentList.add(versionText);
        addDocumentListener(textComponentList);
        addInputMappingsAndShortcuts(textComponentList);
        
        /**
         * Add all JCheckBox components to add ItemListener to.
         */
        ArrayList<JCheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(lockCheckBox);
        addItemListener(checkBoxList);
        
        /**
         * Note: Combobox can use the action event.
         * You can double click it on the designer to create one for it.
         * You can check if one exists and use that for reference if needed.
         */
        
        setOpenCloseIssueBtnText();
        setIssueWindowMode();

        this.setTitle("Issue in " + table.getName());

        this.setPreferredSize(new Dimension(600, 750));

        // set view issue window location in screen
        Point pmWindowLocation = projectManager.getLocationOnScreen(); //get the project manager window in screen
        int numWindow = projectManager.getOpenningIssuesList().size();
//        System.out.println("now number of opened window is: " + numWindow);
        int x = pmWindowLocation.x - 150;
        int y = pmWindowLocation.y - 120;
        this.setLocation(x + numWindow * 30, y + numWindow * 15); // set location of view issue window depend on how many window open

        this.pack();
    }

    private void setIssueWindowMode() {
        dateClosedText.setEnabled(!addIssueMode);
        dateClosedText.setVisible(!addIssueMode);
        dateClosed.setVisible(!addIssueMode);

        versionText.setEnabled(!addIssueMode);
        versionText.setVisible(!addIssueMode);
        version.setVisible(!addIssueMode);

        buttonConfirm.setEnabled(false);
        buttonConfirm.setVisible(!addIssueMode);

        btnCloseIssue.setEnabled(!addIssueMode);
        btnCloseIssue.setVisible(!addIssueMode);

        BtnNext.setVisible(!addIssueMode);
        BtnPrevious.setVisible(!addIssueMode);

        buttonSubmit.setEnabled(false);
        buttonSubmit.setVisible(addIssueMode);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        formPane = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        rk = new javax.swing.JLabel();
        dateOpenedText = new javax.swing.JTextField();
        programmer = new javax.swing.JLabel();
        dateOpened = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        buttonCancel = new javax.swing.JButton();
        buttonSubmit = new javax.swing.JButton();
        dateClosed = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        buttonConfirm = new javax.swing.JButton();
        dateClosedText = new javax.swing.JTextField();
        versionText = new javax.swing.JTextField();
        btnCloseIssue = new javax.swing.JButton();
        app = new javax.swing.JLabel();
        appText = new javax.swing.JTextField();
        titleText = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        idText = new javax.swing.JLabel();
        BtnNext = new javax.swing.JButton();
        BtnPrevious = new javax.swing.JButton();
        programmerText = new javax.swing.JTextField();
        rkText = new javax.swing.JTextField();
        lock = new javax.swing.JLabel();
        submitterText = new javax.swing.JTextField();
        submitter = new javax.swing.JLabel();
        lockCheckBox = new javax.swing.JCheckBox();
        comboBoxIssueType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        title.setText(" title");

        id.setText(" id");

        rk.setText(" rk");

        dateOpenedText.setText("jTextField1");
        dateOpenedText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dateOpenedText.setMargin(new java.awt.Insets(-1, -1, -1, -1));
        dateOpenedText.setName("dateOpened"); // NOI18N
        dateOpenedText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateOpenedTextKeyReleased(evt);
            }
        });

        programmer.setText(" programmer");

        dateOpened.setText(" dateOpened");
        dateOpened.setPreferredSize(new java.awt.Dimension(79, 12));

        descriptionText.setColumns(20);
        descriptionText.setLineWrap(true);
        descriptionText.setRows(5);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setName("description"); // NOI18N
        descriptionText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionTextKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(descriptionText);

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        dateClosed.setText(" dateClosed");

        version.setText(" version");

        buttonConfirm.setText("Confirm");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        dateClosedText.setText("jTextField2");
        dateClosedText.setName("dateClosed"); // NOI18N
        dateClosedText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateClosedTextActionPerformed(evt);
            }
        });
        dateClosedText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateClosedTextKeyReleased(evt);
            }
        });

        versionText.setText("jTextField1");
        versionText.setName("version"); // NOI18N

        btnCloseIssue.setText("Close Issue");
        btnCloseIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseIssueActionPerformed(evt);
            }
        });

        app.setText(" app");

        appText.setText("jTextField1");
        appText.setName("app"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCancel)
                .addGap(4, 4, 4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(app))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCloseIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateClosedText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateClosed))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(version)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(app)
                    .addComponent(dateClosed)
                    .addComponent(version))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCloseIssue, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateClosedText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSubmit)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConfirm)))
        );

        appText.setPreferredSize(new Dimension(84,28));

        titleText.setText("jTextField1");
        titleText.setName("title"); // NOI18N
        titleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextActionPerformed(evt);
            }
        });

        description.setText(" description");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        idText.setText("jLabel1");

        BtnNext.setText(">");
        BtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextActionPerformed(evt);
            }
        });

        BtnPrevious.setText("<");
        BtnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPreviousActionPerformed(evt);
            }
        });

        programmerText.setName("programmer"); // NOI18N

        rkText.setText("jTextField2");
        rkText.setName("rk"); // NOI18N

        lock.setText(" lock");

        submitterText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitterTextActionPerformed(evt);
            }
        });

        submitter.setText(" submitter");

        lockCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockCheckBoxActionPerformed(evt);
            }
        });

        comboBoxIssueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEATURE", "BUG", "REFERENCE" }));
        comboBoxIssueType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIssueTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formPaneLayout = new javax.swing.GroupLayout(formPane);
        formPane.setLayout(formPaneLayout);
        formPaneLayout.setHorizontalGroup(
            formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPaneLayout.createSequentialGroup()
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lock)
                            .addComponent(id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idText)
                            .addComponent(lockCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxIssueType, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitter, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitterText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateOpenedText, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateOpened, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programmerText, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programmer))
                        .addGap(18, 18, 18)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rkText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(formPaneLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPaneLayout.createSequentialGroup()
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleText)
                            .addGroup(formPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(formPaneLayout.createSequentialGroup()
                                        .addComponent(description)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnPrevious)
                                        .addGap(0, 0, 0)
                                        .addComponent(BtnNext)))))
                        .addGap(18, 18, 18))
                    .addGroup(formPaneLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        formPaneLayout.setVerticalGroup(
            formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPaneLayout.createSequentialGroup()
                .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPaneLayout.createSequentialGroup()
                                .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idText)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateOpened, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(programmer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, 0)
                                .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lockCheckBox)))
                            .addComponent(comboBoxIssueType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formPaneLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(submitter, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(formPaneLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(submitterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dateOpenedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(programmerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rkText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)))
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPaneLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(formPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnNext)
                            .addComponent(BtnPrevious)))
                    .addGroup(formPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrollPane.setViewportView(formPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FillItWithDate(JTextField dateArea) {

        dateArea.requestFocusInWindow();
        dateArea.selectAll();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        dateArea.setText(today);
    }
    
    /**
     * Returns today's date as a String in format yyyy-MM-dd
     * @return today's date as a String in format yyyy-MM-dd
     */
    private String todaysDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    private void confirm() {
//        System.out.println("confirm!");
        setIssueValuesFromComponents();
        dao.update(issue);
        projectManager.loadData(); // refresh tableSelected
        projectManager.makeTableEditable(false);
    }

//    private void showNextIssue(int newRow) {
//        projectManager.getOpenningIssuesList().remove(issue.getID(), this);
//        projectManager.getSelectedTabCustomIdList(table.getName()).delete(issue.getID());
//
//        String newID = table.getValueAt(newRow, 0).toString();
//
//        if (!projectManager.getOpenningIssuesList().containsKey(newID)) {
//            issue = new Issue(newRow, dao);
//            issue.setIssueValues(table);
//            this.contentChanged = false;
//            //reinitial issueWindow text components' content and listener
//            updateIssueWindow();
//
//            this.contentChanged = false;
//            buttonConfirm.setEnabled(false);
//
//            projectManager.getOpenningIssuesList().put(issue.getID(), this);
//            projectManager.getSelectedTabCustomIdList(table.getName()).add(issue.getID());
//
//        } else {
//            projectManager.getViewIssueWindowOf(newID).toFront();
//            this.dispose();
//        }
//
//        table.setRowSelectionInterval(newRow, newRow);
//    }

//    private void updateIssueWindow() {
//        for (int i = 0; i < issue.getFieldsNumber(); i++) {
//            String columnName = issue.getFieldName(i);
//            String cellValue = issue.getIssueValueAt(i);
//            switch (columnName) {
//                case "ID":
//                    idText.setText(cellValue);
//                case "app":
////                    System.out.println(issue.getIssueValueAt(i));
//                    appText.setText(cellValue);// set app textfield with the content in app column in view issue
//                    break;
//                case "title":
//                    titleText.setText(cellValue);
//                    break;
//                case "description":
//                    descriptionText.setText(cellValue);
//                    break;
//                case "programmer":
//                    programmerText.setText(cellValue);
//                    break;
//                case "dateOpened":
//                    dateOpenedText.setText(cellValue);
//                    break;
//                case "rk":
//                    rkText.setText(cellValue);
//                    break;
//                case "version":
//                    versionText.setText(cellValue);
//                    break;
//                case "dateClosed":
//                    dateClosedText.setText(cellValue);
//                    break;
//                case "submitter":
//                    submitterText.setText(cellValue);
//                    break;
//                case "locked":
//                    if (cellValue.equals("Y")) {
//                        lockCheckBox.setSelected(true);
//                    } else {
//                        lockCheckBox.setSelected(false);
//                    }
//                    break;
//                default:
//                    break;
//            }
//            issue.getIssueData(columnName).setChanged(false);
//        }
//        
//        setOpenCloseIssueBtnText();
//    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        formWindowClosing();
//        System.out.println("window closing!");
    }//GEN-LAST:event_formWindowClosing

    private void dateOpenedTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateOpenedTextKeyReleased
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_D) {
            this.FillItWithDate((JTextField) evt.getComponent());
        }
    }//GEN-LAST:event_dateOpenedTextKeyReleased

    private void descriptionTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTextKeyReleased
        JTextArea dateArea = (JTextArea) evt.getComponent();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        String value = dateArea.getText();
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_D) {
            dateArea.requestFocusInWindow();
            dateArea.selectAll();
            value = value + " " + today;
            dateArea.setText(value);
        } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_N) {

            int pos = dateArea.getCaretPosition();
            String userName = projectManager.getUserName();
            String message = "\n" + "-- by " + userName + " on " + today + "-- \n";
            //String value1 = value.substring(0, pos) + message + value.substring(pos, value.length());
            dateArea.insert(message, pos);

            dateArea.setCaretPosition(pos + 31);

        }
    }//GEN-LAST:event_descriptionTextKeyReleased

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        //        System.out.println(selectedTable.getValueAt(0, 0));

//        projectManager.getOpenningIssuesList().remove(issue.getID(), this);
        formWindowClosing();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        submit();
        
        this.formWindowClosing();
    }//GEN-LAST:event_buttonSubmitActionPerformed

    private void submit() {

        // set issue values
        setIssueValuesFromComponents();
        
        dao.insert(issue);
        projectManager.loadData();
        projectManager.makeTableEditable(false);
    }
    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
//        updateLocked();
        confirm();
        formWindowClosing();

    }//GEN-LAST:event_buttonConfirmActionPerformed

//    private void updateLocked() {
//
//        //update the locked value back to database
//        String ID = idText.getText();
//        String sql = "";
//        if (lockCheckbox.getState() == true) {
//            sql = "UPDATE issues SET locked ='Y' WHERE ID ='" + ID + "';";
//
//        } else {
//            sql = "UPDATE issues SET locked = NULL WHERE ID ='" + ID + "';";
//        }
//        DBConnection.close();
//        DBConnection.open();
//
//        statement = DBConnection.getStatement();
//        try {
//            statement.executeUpdate(sql);
//
//        } catch (Exception ex) {
//            LoggingAspect.afterThrown(ex);
//        }
//
//    }
//    public String getSubmitter(String ID) {
//        String submitter = "";
//        String sql = "select submitter from issues where ID = '" + ID + "';";
//        ResultSet rs = null;
//        DBConnection.close();
//        DBConnection.open();
//
//        statement = DBConnection.getStatement();
//        try {
//            rs = statement.executeQuery(sql);
//
//            while (rs.next()) {
//                submitter = rs.getString("submitter");
//
//            }
//
//        } catch (Exception ex) {
//            LoggingAspect.afterThrown(ex);
//        }
//        return submitter;
//    }
//    public String getLock(String ID) {
//        String locked = "";
//        String sql = "select locked from issues where ID = '" + ID + "';";
//        ResultSet rs = null;
//        DBConnection.close();
//        DBConnection.open();
//
//        statement = DBConnection.getStatement();
//        try {
//            rs = statement.executeQuery(sql);
//
//            while (rs.next()) {
//                locked = rs.getString("locked");
//
//            }
//
//        } catch (Exception ex) {
//            LoggingAspect.afterThrown(ex);
//        }
//        System.out.println(sql + "..." + locked);
//        return locked;
//    }

    private void dateClosedTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateClosedTextActionPerformed

    }//GEN-LAST:event_dateClosedTextActionPerformed

    private void dateClosedTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateClosedTextKeyReleased
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_D) {
            FillItWithDate((JTextField) evt.getComponent());
        }
    }//GEN-LAST:event_dateClosedTextKeyReleased

    private void btnCloseIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseIssueActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        String userName = projectManager.getUserName();
        String value = descriptionText.getText();
        if (btnCloseIssue.getText().equalsIgnoreCase("close issue")) {
            // set dateClosed text field with date today
            FillItWithDate(dateClosedText);
            String temperaryVersion = "XXX";
            versionText.setText(temperaryVersion);
            btnCloseIssue.setText("Reopen Issue");
            value = value + "\n--- Issue Closed by "
                    + userName + " on " + today + "\n";
        } else if (btnCloseIssue.getText().equalsIgnoreCase("reopen issue")) {
            value = value + "\n \n--- Issue reopened by "
                    + userName + " on " + today + " (version " + versionText.getText() + ") \n";
            versionText.setText("");
            dateClosedText.setText("");
            btnCloseIssue.setText("Close Issue");
        }
        descriptionText.setText(value);
    }//GEN-LAST:event_btnCloseIssueActionPerformed

    private void titleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTextActionPerformed
        
    }//GEN-LAST:event_titleTextActionPerformed

    private void BtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextActionPerformed
        
        /**
         * If table has not changed then no need to execute this for loop.
         * boolean rowFound makes sure the issue is still in the table view.
         */
        boolean rowFound = true;
        if (!table.getValueAt(row, 0).toString().equals(issue.getId())) {
            rowFound = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                if (table.getValueAt(i, 0).toString().equals(issue.getId())) {
                    row = i;
                    rowFound = true;
                }
            }
        }
        
        // next row
        if(!rowFound){
            JOptionPane.showMessageDialog(this, "This issue is no longer on the table!");
        }
        else if (row == table.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "This issue is already the last row on the table!");
        } else {
            row++;
            setIssueValuesFromTable(row,table);
            setComponentValuesFromIssue();
            // set corresponding table row selected
            table.setRowSelectionInterval(row, row);
            //showNextIssue(row);
        }
    }//GEN-LAST:event_BtnNextActionPerformed

    private void BtnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPreviousActionPerformed

        /**
         * If table has not changed then no need to execute this for loop.
         * boolean found makes sure the issue is still in the table view.
         */
        boolean rowFound = true;
        if (!table.getValueAt(row, 0).toString().equals(issue.getId())) {
            rowFound = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                if (table.getValueAt(i, 0).toString().equals(issue.getId())) {
                    row = i;
                    rowFound = true;
                }
            }
        }
        
        // previous row
        if(!rowFound){
            JOptionPane.showMessageDialog(this, "This issue is no longer on the table!");
        }
        else if (row == 0) {
            JOptionPane.showMessageDialog(this, "This issue is already the first row on the table!");
        } else {
            row--;
            setIssueValuesFromTable(row,table);
            setComponentValuesFromIssue();
            // set corresponding table row selected
            table.setRowSelectionInterval(row, row);
            //showNextIssue(row);
        }
    }//GEN-LAST:event_BtnPreviousActionPerformed

    private void submitterTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitterTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitterTextActionPerformed

    private void lockCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockCheckBoxActionPerformed

    }//GEN-LAST:event_lockCheckBoxActionPerformed

    /**
     * Fires when IssueType ComboBox selection is changed
     * @param evt action event for the IssueType ComboBox
     */
    private void comboBoxIssueTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIssueTypeActionPerformed
        // if the same then check for other changes
        if(comboBoxIssueType.getSelectedItem().toString().equals(issue.getIssueType())){
            checkForChangeAndSetBtnsEnabled();
        }
        // we know right away there is a change so just set the button enabled
        else{
            setBtnsEnabled(true); // sets the submit or confirm button enabled
        }
    }//GEN-LAST:event_comboBoxIssueTypeActionPerformed

    private void formWindowClosing() {
        if (addIssueMode) {
            projectManager.setAddRecordsWindowShow(false);
        } else {
//            System.out.println(addIssueMode);
            projectManager.getOpenningIssuesList().remove(issue.getId(), this);
            projectManager.getSelectedTabCustomIdList(table.getName()).delete(issue.getId());
            projectManager.getSelectedTabCustomIdList(table.getName()).printOutIDList();
        }
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNext;
    private javax.swing.JButton BtnPrevious;
    private javax.swing.JLabel app;
    private javax.swing.JTextField appText;
    private javax.swing.JButton btnCloseIssue;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> comboBoxIssueType;
    private javax.swing.JLabel dateClosed;
    private javax.swing.JTextField dateClosedText;
    private javax.swing.JLabel dateOpened;
    private javax.swing.JTextField dateOpenedText;
    private javax.swing.JLabel description;
    private javax.swing.JTextArea descriptionText;
    private javax.swing.JPanel formPane;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lock;
    private javax.swing.JCheckBox lockCheckBox;
    private javax.swing.JLabel programmer;
    private javax.swing.JTextField programmerText;
    private javax.swing.JLabel rk;
    private javax.swing.JTextField rkText;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel submitter;
    private javax.swing.JTextField submitterText;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titleText;
    private javax.swing.JLabel version;
    private javax.swing.JTextField versionText;
    // End of variables declaration//GEN-END:variables

//    private void initIssueWindow() {
//        for (int i = 1; i < issue.getFieldsNumber(); i++) {
//            String columnName = issue.getFieldName(i);
//            String cellValue = issue.getIssueValueAt(i);
////            System.out.println(columnName);
//            switch (columnName) {
//                case "app":
//                    if (addIssueMode) {
//                        cellValue = projectManager.getSelectedTabName();
//                        issue.setIssueValueAt(columnName, cellValue);
//                        issue.getIssueData(i).setChanged(true);
//                    }
//                    appText.setText(cellValue);// set app textfield with the content in app column in view issue
//                    ComponentsList.put(columnName, appText); // add app text field to textcomponentlist
//                    break;
//                case "title":
//                    titleText.setText(cellValue);
//                    ComponentsList.put(columnName, titleText);
//                    break;
//                case "description":
//                    descriptionText.setText(cellValue);
//                    ComponentsList.put(columnName, descriptionText);
//                    break;
//                case "programmer":
//                    programmerText.setText(cellValue);
//                    ComponentsList.put(columnName, programmerText);
//                    break;
//                case "dateOpened":
//                    if (addIssueMode) {
//                        this.FillItWithDate(dateOpenedText);
//                        issue.setIssueValueAt(columnName, dateOpenedText.getText());
//                        issue.getIssueData(i).setChanged(true);
//                    } else {
//                        dateOpenedText.setText(cellValue);
//                    }
//                    ComponentsList.put(columnName, dateOpenedText);
//                    break;
//                case "rk":
//                    rkText.setText(cellValue);
//                    ComponentsList.put(columnName, rkText);
//                    break;
//                case "version":
//                    versionText.setText(cellValue);
//                    ComponentsList.put(columnName, versionText);
//                    break;
//                case "dateClosed":
////                    System.out.println("dateClosed " + cellValue);
//                    dateClosedText.setText(cellValue);
//                    ComponentsList.put(columnName, dateClosedText);
//                    break;
//                case "submitter":
////                    System.out.println("submitter " + cellValue);
//                    if (addIssueMode) {
//                        cellValue = projectManager.getUserName();
//                        issue.setIssueValueAt(columnName, cellValue);
//                        issue.getIssueData(i).setChanged(true);
//                    }
//                    submitterText.setText(cellValue);
//                    ComponentsList.put(columnName, submitterText);
//                    break;
//                case "locked":
////                    System.out.println("locked " + cellValue);
//                    if (cellValue.equalsIgnoreCase("y")) {
//                        lockCheckbox.setState(true);
//                    } else {
//                        lockCheckbox.setState(false);
//                    }
//                    ComponentsList.put(columnName, lockCheckbox);
//                    break;
//                default:
//                    break;
//            }
//        }
//        //add document listener to all text components in this window
//        setTextComponentListener();
//        //add action listener to all text components and using tab to transfer 
//        // all text area except description
//        setTabKeyTransferFocusBtwTextArea();
//
//        setCheckBoxListener();
//
//        setOpenCloseIssueBtnText();
//    }

//    private void setCheckBoxListener() {
//        lockCheckbox.addItemListener(new ItemListener() {
//            //set listener to lockCheckbox, so when we click it, it can be detected and confirm button should set at enabled
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                contentChanged = true;
//                if (addIssueMode) {
//                    buttonSubmit.setEnabled(true);
//                } else {
//                    buttonConfirm.setEnabled(true);
//                }
//                issue.getIssueData("locked").setChanged(true);
//                if (e.getStateChange() == 1) {
//                    issue.setIssueValueAt("locked", "Y");
//                }
////                else
////                    issue.setIssueValueAt("locked", null);
//
//            }
//        });
//    }

//    private void setTextComponentListener() {
//        DocumentListener textDocumentLis = new DocumentListener() {
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                contentChanged = true;
//                if (addIssueMode) {
//                    buttonSubmit.setEnabled(true);
//                } else {
//                    buttonConfirm.setEnabled(true);
//                }
//                Document doc = e.getDocument();
//                String columnName = (String) doc.getProperty("id");
//                String newValue = ((JTextComponent) ComponentsList.get(columnName)).getText();
//
////                System.out.println("here " + doc.getProperty("id") + " " + newValue);
//                issue.setIssueValueAt(columnName, newValue);
//                issue.getIssueData(columnName).setChanged(true);
//
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                contentChanged = true;
//                if (addIssueMode) {
//                    buttonSubmit.setEnabled(true);
//                } else {
//                    buttonConfirm.setEnabled(true);
//                }
//                Document doc = e.getDocument();
//                String columnName = (String) doc.getProperty("id");
//                String newValue = ((JTextComponent) ComponentsList.get(columnName)).getText();
//
////                System.out.println("here " + doc.getProperty("id") + " " + newValue);
//                issue.setIssueValueAt(columnName, newValue);
//                issue.getIssueData(columnName).setChanged(true);
////                System.out.println(doc.getProperty("id") + " " + newValue);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//            }
//
//        };
        
//        InputMap ip = null;
//        for (int i = 1; i < issue.getFieldsNumber(); i++) {
//            if (comp instanceof JTextComponent) {
//                Document doc = ((JTextComponent) comp).getDocument();
//                //doc.addDocumentListener(textDocumentLis);
//                doc.putProperty("id", columnName);
//
//                ip = ((JTextComponent) comp).getInputMap();
//                ShortCutSetting.copyAndPasteShortCut(ip);
//                ShortCutSetting.undoAndRedoShortCut(((JTextComponent) comp));
//            }
//        }
//    }
    
    /**
     * Adds input mappings and shortcuts for JTextComponent Objects
     * (ex. TextFields, TextAreas)
     */
    private void addInputMappingsAndShortcuts(ArrayList<JTextComponent> textComponentList){

        for(JTextComponent comp:textComponentList){
            ShortCutSetting.copyAndPasteShortCut(comp.getInputMap());
            ShortCutSetting.undoAndRedoShortCut(comp);
        }      
    }

//    private void setTabKeyTransferFocusBtwTextArea() {
//        AbstractAction transferFocus = new AbstractAction() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ((Component) e.getSource()).transferFocus();
//            }
//        };
//        for (int i = 1; i < issue.getFieldsNumber(); i++) {
//            String columnName = issue.getFieldName(i);
//            Component comp = this.ComponentsList.get(i);
//            if (comp instanceof JTextComponent) {
//                if (!columnName.equals("description")) {
//                    ((JTextComponent) comp).getInputMap().
//                            put(KeyStroke.getKeyStroke("TAB"), "transferFocus");
//                    ((JTextComponent) comp).getActionMap().
//                            put("transferFocus", transferFocus);
//                }
//            }
//        }
//    }

    private int getIssueRowInTableModel() {
        for (int i = 0; i < table.getModel().getRowCount(); i++) {
            if (table.getModel().getValueAt(i, 0).equals(issue.getId())) {
                return i;
            }
        }
        System.out.println("can not find this issue in Model!");
        return -1;
    }

    /**
     * Sets issue values from table
     * @param row the row index on table for issue to retrieve
     * @param table the table with the row/issue data
     */
    private void setIssueValuesFromTable(int row, JTable table) {

        issue.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));
        issue.setApp(table.getValueAt(row, 0).toString());
        issue.setTitle(table.getValueAt(row, 0).toString());
        issue.setDescription(table.getValueAt(row, 0).toString());
        issue.setProgrammer(table.getValueAt(row, 0).toString());
        issue.setDateOpened(table.getValueAt(row, 0).toString());
        issue.setRk(table.getValueAt(row, 0).toString());
        issue.setVersion(table.getValueAt(row, 0).toString());
        issue.setDateClosed(table.getValueAt(row, 0).toString());
        issue.setIssueType(table.getValueAt(row, 0).toString());
        issue.setSubmitter(table.getValueAt(row, 0).toString());
        issue.setLocked(table.getValueAt(row, 0).toString());
    }
    
    /**
     * Sets the issue values from the components and fields from issue window.
     */
    private void setIssueValuesFromComponents() {
        issue.setId(Integer.parseInt(idText.getText()));
        issue.setApp(appText.getText());
        issue.setTitle(titleText.getText());
        issue.setDescription(descriptionText.getText());
        issue.setProgrammer(programmerText.getText());
        issue.setDateOpened(dateOpenedText.getText());
        issue.setRk(rkText.getText());
        issue.setVersion(versionText.getText());
        issue.setDateClosed(dateClosedText.getText());
        issue.setIssueType(comboBoxIssueType.getSelectedItem().toString());
        issue.setSubmitter(submitterText.getText());
        issue.setLocked((lockCheckBox.isSelected())?"Y":null);
    }

    /**
     * Sets the components and fields on issue window from the issue object.
     */
    private void setComponentValuesFromIssue() {

        idText.setText(Integer.toString(issue.getId()));
        appText.setText(issue.getApp());
        titleText.setText(issue.getTitle());
        descriptionText.setText(issue.getDescription());
        programmerText.setText(issue.getProgrammer());
        dateOpenedText.setText(issue.getDateOpened());
        rkText.setText(issue.getRk());
        versionText.setText(issue.getVersion());
        dateClosedText.setText(issue.getDateClosed());
        comboBoxIssueType.setSelectedItem(issue.getIssueType());
        submitterText.setText(issue.getSubmitter());
        lockCheckBox.setSelected(issue.getLocked().equals("Y")?true:false);
        
        setOpenCloseIssueBtnText(); // set button text to Open/Close issue
    }
    
    /**
     * This method compares the values of the issue with the component values
     * and returns true or false.
     * @return boolean true if there is a change in any of the component values
     */
    private boolean hasChange(){

        return (appText.getText().equals(issue.getApp())
            && titleText.getText().equals(issue.getTitle())
            && descriptionText.getText().equals(issue.getDescription())
            && programmerText.getText().equals(issue.getProgrammer())
            && dateOpenedText.getText().equals(issue.getDateOpened())
            && rkText.getText().equals(issue.getRk())
            && versionText.getText().equals(issue.getVersion())
            && dateClosedText.getText().equals(issue.getDateClosed())
            && comboBoxIssueType.getSelectedItem().equals(issue.getIssueType())
            && submitterText.getText().equals(issue.getSubmitter())
            && (lockCheckBox.isSelected()?"Y":"").equals(issue.getLocked()))
            ?false:true;
    }

    private void setOpenCloseIssueBtnText() {
        //set close issue btn property
        if (dateClosedText.getText().isEmpty() || versionText.getText().isEmpty()) {
            btnCloseIssue.setText("Close Issue");
        } else {
            btnCloseIssue.setText("Reopen Issue");
        }
    }

    private void addDocumentListener(ArrayList<JTextComponent> textComponentList) {
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkForChangeAndSetBtnsEnabled();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkForChangeAndSetBtnsEnabled();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // this does not get fired for plain text
            }
        };
        
        for(JTextComponent comp:textComponentList){
            comp.getDocument().addDocumentListener(documentListener);
        }      
    }
    
    /**
     * Checks all components for a change in value
     * and sets the submit or confirm buttons accordingly.
     */
    private void checkForChangeAndSetBtnsEnabled() {
        setBtnsEnabled(hasChange());
    }
    
    /**
     * Sets the visible button enabled for either submit or confirm
     * @param isChange if true then sets the button enabled or disables if false.
     */
    private void setBtnsEnabled(boolean isChange){
        if(buttonSubmit.isVisible()){
            buttonSubmit.setEnabled(isChange);
        }
        else if(buttonConfirm.isVisible()){
            buttonConfirm.setEnabled(isChange);
        }
    }
    
    /**
     * Sets ItemListener for JCheckBox Components 
     * @param checkBoxList The JCheckBox Components to add the ItemListener to.
     */
    private void addItemListener(ArrayList<JCheckBox> checkBoxList) {
        
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkForChangeAndSetBtnsEnabled();
            }
        };
        
        for(JCheckBox checkbox: checkBoxList){
            checkbox.addItemListener(itemListener);
        }
    }
}
