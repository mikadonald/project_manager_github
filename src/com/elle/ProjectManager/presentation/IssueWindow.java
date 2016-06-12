
package com.elle.ProjectManager.presentation;

import com.elle.ProjectManager.admissions.Authorization;
import com.elle.ProjectManager.dao.IssueDAO;
import com.elle.ProjectManager.entities.Issue;
import com.elle.ProjectManager.logic.ShortCutSetting;
import com.elle.ProjectManager.logic.Tab;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.swing.text.StyledEditorKit.UnderlineAction;
import javax.swing.text.rtf.RTFEditorKit;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
/**
 *
 * @author fuxiaoqian
 */
public class IssueWindow extends JFrame {

    private ProjectManagerWindow projectManager;
    private Issue issue;
    private JTable table;
    private int row;
    private IssueDAO dao;
    private boolean addIssueMode;

    public ProjectManagerWindow getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManagerWindow projectManager) {
        this.projectManager = projectManager;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public IssueDAO getDao() {
        return dao;
    }

    public void setDao(IssueDAO dao) {
        this.dao = dao;
    }

    public boolean isAddIssueMode() {
        return addIssueMode;
    }

    public void setAddIssueMode(boolean addIssueMode) {
        this.addIssueMode = addIssueMode;
    }

    public ShortCutSetting getShortCutSetting() {
        return ShortCutSetting;
    }

    public void setShortCutSetting(ShortCutSetting ShortCutSetting) {
        this.ShortCutSetting = ShortCutSetting;
    }

    public String[] getDropdownlist() {
        return dropdownlist;
    }

    public void setDropdownlist(String[] dropdownlist) {
        this.dropdownlist = dropdownlist;
    }

    public Map<String, Tab> getTabs() {
        return tabs;
    }

    public void setTabs(Map<String, Tab> tabs) {
        this.tabs = tabs;
    }

    public JButton getBtnNext() {
        return BtnNext;
    }

    public void setBtnNext(JButton BtnNext) {
        this.BtnNext = BtnNext;
    }

    public JButton getBtnPrevious() {
        return BtnPrevious;
    }

    public void setBtnPrevious(JButton BtnPrevious) {
        this.BtnPrevious = BtnPrevious;
    }

    public JLabel getApp() {
        return app;
    }

    public void setApp(JLabel app) {
        this.app = app;
    }

    public JComboBox getAppComboBox() {
        return appComboBox;
    }

    public void setAppComboBox(JComboBox appComboBox) {
        this.appComboBox = appComboBox;
    }

    public JButton getBtnCloseIssue() {
        return btnCloseIssue;
    }

    public void setBtnCloseIssue(JButton btnCloseIssue) {
        this.btnCloseIssue = btnCloseIssue;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }

    public void setButtonConfirm(JButton buttonConfirm) {
        this.buttonConfirm = buttonConfirm;
    }

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(JButton buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }

    public JComboBox<String> getComboBoxIssueType() {
        return comboBoxIssueType;
    }

    public void setComboBoxIssueType(JComboBox<String> comboBoxIssueType) {
        this.comboBoxIssueType = comboBoxIssueType;
    }

    public JLabel getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(JLabel dateClosed) {
        this.dateClosed = dateClosed;
    }

    public JTextField getDateClosedText() {
        return dateClosedText;
    }

    public void setDateClosedText(JTextField dateClosedText) {
        this.dateClosedText = dateClosedText;
    }

    public JLabel getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(JLabel dateOpened) {
        this.dateOpened = dateOpened;
    }

    public JTextField getDateOpenedText() {
        return dateOpenedText;
    }

    public void setDateOpenedText(JTextField dateOpenedText) {
        this.dateOpenedText = dateOpenedText;
    }

    public JLabel getDescription() {
        return description;
    }

    public void setDescription(JLabel description) {
        this.description = description;
    }

    public JTextPane getDescriptionText() {
        return rtftext;
    }

    public void setDescriptionText(JTextArea descriptionText) {
        this.rtftext = rtftext;
    }

    public JPanel getFormPane() {
        return formPane;
    }

    public void setFormPane(JPanel formPane) {
        this.formPane = formPane;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getIdText() {
        return idText;
    }

    public void setIdText(JLabel idText) {
        this.idText = idText;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JLabel getLock() {
        return lock;
    }

    public void setLock(JLabel lock) {
        this.lock = lock;
    }

    public JCheckBox getLockCheckBox() {
        return lockCheckBox;
    }

    public void setLockCheckBox(JCheckBox lockCheckBox) {
        this.lockCheckBox = lockCheckBox;
    }

    public JLabel getProgrammer() {
        return programmer;
    }

    public void setProgrammer(JLabel programmer) {
        this.programmer = programmer;
    }

    public JComboBox getProgrammerComboBox() {
        return programmerComboBox;
    }

    public void setProgrammerComboBox(JComboBox programmerComboBox) {
        this.programmerComboBox = programmerComboBox;
    }

    public JLabel getRk() {
        return rk;
    }

    public void setRk(JLabel rk) {
        this.rk = rk;
    }

    public JComboBox getRkComboBox() {
        return rkComboBox;
    }

    public void setRkComboBox(JComboBox rkComboBox) {
        this.rkComboBox = rkComboBox;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JLabel getSubmitter() {
        return submitter;
    }

    public void setSubmitter(JLabel submitter) {
        this.submitter = submitter;
    }

    public JTextField getSubmitterText() {
        return submitterText;
    }

    public void setSubmitterText(JTextField submitterText) {
        this.submitterText = submitterText;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JTextField getTitleText() {
        return titleText;
    }

    public void setTitleText(JTextField titleText) {
        this.titleText = titleText;
    }

    public JLabel getVersion() {
        return version;
    }

    public void setVersion(JLabel version) {
        this.version = version;
    }

    public JTextField getVersionText() {
        return versionText;
    }

    public void setVersionText(JTextField versionText) {
        this.versionText = versionText;
    }
    private ShortCutSetting ShortCutSetting;
    private String[] dropdownlist = {"app","title", "description","programmer", "dateOpened", "rk", "version", "dateClosed"};
    private Map<String, Tab> tabs;       // used to update the records label

    /**
     * Creates new form IssueWindow
     * @param row
     */
    public IssueWindow(int row, JTable table, ArrayList<Issue> issues) throws IOException, BadLocationException {
        projectManager = ProjectManagerWindow.getInstance();
         tabs = projectManager.getTabs();
        this.table = table;
        this.row = row;
        dao = new IssueDAO();
        issue = new Issue();

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
            int currentid = getcurrentissueid(row,table);
            
            if(!issues.isEmpty() && issues != null){
                for(Issue issueindb: issues){
                    if (issueindb.getId() == currentid) {
                        issue.setId(issueindb.getId());
                        issue.setApp(issueindb.getApp());
                        issue.setTitle(issueindb.getTitle());
                        issue.setDescription(issueindb.getDescription());
                        issue.setProgrammer(issueindb.getProgrammer());
                        System.out.println(issueindb.getProgrammer());
                        issue.setDateOpened(issueindb.getDateOpened());
                        issue.setRk(issueindb.getRk());
                        issue.setVersion(issueindb.getVersion());
                        issue.setDateClosed(issueindb.getDateClosed());
                        issue.setIssueType(issueindb.getIssueType());
                        issue.setSubmitter(issueindb.getSubmitter());
                        issue.setLocked(issueindb.getLocked());
                        System.out.println(issueindb.getLocked());
                    }
                }
            }
            //setComponentValuesFromIssue(this);
            //setIssueValuesFromTable(row,table);
        }
       
        initComponents();
        submitterText.setText(projectManager.getUserName());

        setComponentValuesFromIssue(this);
        
        /**
         * Add all JTextComponents to add document listener, input mappings,
         * and shortcuts.
         * Note: ComboBox and CheckBox components can use the action event.
         * You can double click it on the designer to create one for it.
         * You can reference one that exists for help with the code if needed.
         */
        ArrayList<JTextComponent> textComponentList = new ArrayList<>();
        textComponentList.add(submitterText);
        textComponentList.add(dateOpenedText);
        
        textComponentList.add(titleText);
        textComponentList.add(rtftext);
   
        textComponentList.add(dateClosedText);
        textComponentList.add(versionText);
        addDocumentListener(textComponentList);
        addInputMappingsAndShortcuts(textComponentList);
         updateComboList("programmer", projectManager.getSelectedTabName());
        updateComboList("rk", projectManager.getSelectedTabName());
        updateComboList("app", projectManager.getSelectedTabName());
        setComponentValuesFromIssue(this);
        
        
        
        
        setOpenCloseIssueBtnText();
        setIssueWindowMode();
       

        this.setTitle("Issue in " + table.getName());
        
        // get current monitor resolution.height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // set the preferred framesize
        Dimension frameSize = new Dimension(620, 750);
       
        // if the screensize is not big enough, change the preferred size height
        if (screenSize.height * 0.85 < frameSize.height) {
            frameSize.height = (int)(screenSize.height * 0.85);
        }
        
       // set the minimum size, width 620, height 750 or 80% of screen size
        int minHeight = (screenSize.height * 0.85 < 750) ? (int)(screenSize.height * 0.8) : 750; 
        Dimension minSize = new Dimension(620, minHeight);
        
        this.setPreferredSize(frameSize);
        this.setMinimumSize(minSize);
        
 

        // set view issue window location in screen
        // check x and y , if beyond the boarder, set to default 10 and 5
        Point pmWindowLocation = projectManager.getLocationOnScreen(); //get the project manager window in screen
        int numWindow = projectManager.getOpeningIssuesList().size();
        int x = (pmWindowLocation.x - 150 > 0)? pmWindowLocation.x - 150 :10;
        int y = (pmWindowLocation.y - 120 > 0)?pmWindowLocation.y - 120 : 5;
        this.setLocation(x + numWindow * 30, y + numWindow * 15); // set location of view issue window depend on how many window open

        this.pack();
        
        Authorization.authorize(this);
    }

    /**
     * Displays the components accordingly 
     * for either a new issue submittal form
     * or populate the form with an existing issue.
     */
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
        java.awt.GridBagConstraints gridBagConstraints;

        colorButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        formPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        programmerComboBox = new javax.swing.JComboBox();
        programmer = new javax.swing.JLabel();
        idText = new javax.swing.JLabel();
        rk = new javax.swing.JLabel();
        dateOpenedText = new javax.swing.JTextField();
        submitterText = new javax.swing.JTextField();
        comboBoxIssueType = new javax.swing.JComboBox<>();
        id = new javax.swing.JLabel();
        dateOpened = new javax.swing.JLabel();
        lockCheckBox = new javax.swing.JCheckBox();
        rkComboBox = new javax.swing.JComboBox();
        lock = new javax.swing.JLabel();
        submitter = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        description = new javax.swing.JLabel();
        BtnPrevious = new javax.swing.JButton();
        BtnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rtftext = new javax.swing.JTextPane();
        jPanel6 = new javax.swing.JPanel();
        versionText = new javax.swing.JTextField();
        buttonConfirm = new javax.swing.JButton();
        btnCloseIssue = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        appComboBox = new javax.swing.JComboBox();
        dateClosed = new javax.swing.JLabel();
        dateClosedText = new javax.swing.JTextField();
        app = new javax.swing.JLabel();
        buttonSubmit = new javax.swing.JButton();
        version = new javax.swing.JLabel();
        colorButton1 = new javax.swing.JButton();
        B_Bold = new javax.swing.JButton();
        UnderlineBotton = new javax.swing.JButton();
        StrikethroughBotton = new javax.swing.JButton();
        Italic = new javax.swing.JButton();
        Fsize = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        titleText = new javax.swing.JTextField();
        title = new javax.swing.JLabel();

        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(583, 307));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(583, 301));

        formPane.setMinimumSize(new java.awt.Dimension(0, 0));
        formPane.setPreferredSize(new java.awt.Dimension(523, 301));
        formPane.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        formPane.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        programmerComboBox.setEditable(true);
        programmerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        programmerComboBox.setMinimumSize(new java.awt.Dimension(90, 28));
        programmerComboBox.setPreferredSize(new java.awt.Dimension(90, 28));
        programmerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmerComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(programmerComboBox, gridBagConstraints);

        programmer.setText(" programmer");
        programmer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(programmer, gridBagConstraints);

        idText.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanel3.add(idText, gridBagConstraints);

        rk.setText(" rk");
        rk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(rk, gridBagConstraints);

        dateOpenedText.setText("jTextField1");
        dateOpenedText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dateOpenedText.setMargin(new java.awt.Insets(-1, -1, -1, -1));
        dateOpenedText.setMinimumSize(new java.awt.Dimension(6, 20));
        dateOpenedText.setName("dateOpened"); // NOI18N
        dateOpenedText.setPreferredSize(new java.awt.Dimension(90, 28));
        dateOpenedText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateOpenedTextKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(dateOpenedText, gridBagConstraints);

        submitterText.setMinimumSize(new java.awt.Dimension(90, 20));
        submitterText.setPreferredSize(new java.awt.Dimension(90, 28));
        submitterText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitterTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(submitterText, gridBagConstraints);

        comboBoxIssueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEATURE", "BUG", "REFERENCE" }));
        comboBoxIssueType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIssueTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(comboBoxIssueType, gridBagConstraints);

        id.setText(" id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanel3.add(id, gridBagConstraints);

        dateOpened.setText(" dateOpened");
        dateOpened.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        dateOpened.setMaximumSize(new java.awt.Dimension(79, 14));
        dateOpened.setMinimumSize(new java.awt.Dimension(79, 14));
        dateOpened.setPreferredSize(new java.awt.Dimension(79, 14));
        dateOpened.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(dateOpened, gridBagConstraints);

        lockCheckBox.setBorder(null);
        lockCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lockCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lockCheckBox.setMaximumSize(new java.awt.Dimension(16, 16));
        lockCheckBox.setMinimumSize(new java.awt.Dimension(16, 16));
        lockCheckBox.setPreferredSize(new java.awt.Dimension(16, 16));
        lockCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lockCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        jPanel3.add(lockCheckBox, gridBagConstraints);

        rkComboBox.setEditable(true);
        rkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rkComboBox.setMinimumSize(new java.awt.Dimension(38, 20));
        rkComboBox.setPreferredSize(new java.awt.Dimension(38, 28));
        rkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rkComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(rkComboBox, new java.awt.GridBagConstraints());

        lock.setText(" lock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        jPanel3.add(lock, gridBagConstraints);

        submitter.setText(" submitter");
        submitter.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        submitter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(submitter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        formPane.add(jPanel3, gridBagConstraints);
        jPanel3.getAccessibleContext().setAccessibleName("");

        jPanel1.setPreferredSize(new java.awt.Dimension(360, 113));

        description.setText(" description");
        description.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        BtnPrevious.setText("<");
        BtnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPreviousActionPerformed(evt);
            }
        });

        BtnNext.setText(">");
        BtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextActionPerformed(evt);
            }
        });

        rtftext.setContentType("text/rtf"); // NOI18N
        rtftext.setPreferredSize(new java.awt.Dimension(120, 80));
        jScrollPane2.setViewportView(rtftext);

        versionText.setText("jTextField1");
        versionText.setName("version"); // NOI18N

        buttonConfirm.setText("Confirm");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        btnCloseIssue.setText("Close Issue");
        btnCloseIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseIssueActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        appComboBox.setEditable(true);
        appComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        appComboBox.setPreferredSize(new java.awt.Dimension(80, 28));
        appComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appComboBoxActionPerformed(evt);
            }
        });

        dateClosed.setText(" dateClosed");
        dateClosed.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        dateClosedText.setText("jTextField2");
        dateClosedText.setName("dateClosed"); // NOI18N
        dateClosedText.setPreferredSize(new java.awt.Dimension(90, 28));
        dateClosedText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateClosedTextKeyReleased(evt);
            }
        });

        app.setText(" app");
        app.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        version.setText(" version");
        version.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(app)
                        .addGap(355, 355, 355)
                        .addComponent(dateClosed)
                        .addGap(28, 28, 28)
                        .addComponent(version))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(appComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(btnCloseIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(dateClosedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(buttonConfirm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(buttonCancel)))))
                .addGap(60, 60, 60))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateClosed)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(version)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCloseIssue)
                                    .addComponent(dateClosedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonConfirm)
                                    .addComponent(buttonSubmit)
                                    .addComponent(buttonCancel)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(app)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        colorButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elle/ProjectManager/presentation/Color3.png"))); // NOI18N
        colorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButton1ActionPerformed(evt);
            }
        });

        B_Bold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elle/ProjectManager/presentation/Bold_os.png"))); // NOI18N
        B_Bold.setMargin(new java.awt.Insets(1, 2, 0, 2));
        B_Bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BoldActionPerformed(evt);
            }
        });

        UnderlineBotton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elle/ProjectManager/presentation/Underline_os.png"))); // NOI18N
        UnderlineBotton.setMargin(new java.awt.Insets(1, 2, 0, 2));
        UnderlineBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnderlineBottonActionPerformed(evt);
            }
        });

        StrikethroughBotton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elle/ProjectManager/presentation/Strike_os2.png"))); // NOI18N
        StrikethroughBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrikethroughBottonActionPerformed(evt);
            }
        });

        Italic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elle/ProjectManager/presentation/Italic_os2.png"))); // NOI18N
        Italic.setMargin(new java.awt.Insets(1, 2, 0, 2));
        Italic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItalicActionPerformed(evt);
            }
        });

        Fsize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elle/ProjectManager/presentation/Font3.png"))); // NOI18N
        Fsize.setMargin(new java.awt.Insets(1, 2, 0, 2));
        Fsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FsizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(description)
                        .addGap(32, 32, 32)
                        .addComponent(colorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_Bold, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UnderlineBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StrikethroughBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Italic, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fsize, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnNext))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnNext)
                        .addComponent(BtnPrevious)
                        .addComponent(description))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UnderlineBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(B_Bold, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Italic, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Fsize, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(StrikethroughBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(colorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        formPane.add(jPanel1, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        titleText.setText("jTextField1");
        titleText.setName("title"); // NOI18N
        titleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(titleText, gridBagConstraints);

        title.setText(" title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(title, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        formPane.add(jPanel5, gridBagConstraints);

        scrollPane.setViewportView(formPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(scrollPane, gridBagConstraints);

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

    /**
     * This updates the custom id list when traversing the table
     * @param newRow 
     */
    private void updateCustomIdList(int newRow) {
        
        // remove this id from the openIssuesList and CustomIdList
        projectManager.getOpeningIssuesList().remove(issue.getId(), this);
        projectManager.getSelectedTabCustomIdList(table.getName()).delete(issue.getId());

        String newID = table.getValueAt(newRow, 0).toString();

        // if issue is not open
        if (!projectManager.getOpeningIssuesList().containsKey(newID)) {
            projectManager.getOpeningIssuesList().put(issue.getId(), this);
            projectManager.getSelectedTabCustomIdList(table.getName()).add(issue.getId());

        } 
        // use the window with this issue already open
        else {
            projectManager.getViewIssueWindowOf(newID).toFront();
            this.dispose();
        }
    }

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
        issueWindowClosing();
//        System.out.println("window closing!");
    }//GEN-LAST:event_formWindowClosing

    private void titleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleTextActionPerformed

    private void rkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rkComboBoxActionPerformed
        
        if (issue.getRk() == null) {
            setBtnsEnabled(true);
        } else {
            if(rkComboBox.getSelectedItem().toString().equals(issue.getRk())){
                checkForChangeAndSetBtnsEnabled();
            }
                // we know right away there is a change so just set the button enabled
            else{
                setBtnsEnabled(true); // sets the submit or confirm button enabled
            }
        }
    }//GEN-LAST:event_rkComboBoxActionPerformed

    /**
     * Fires when Lock CheckBox selection is changed
     * @param evt action event for the Lock CheckBox
     */
    private void lockCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockCheckBoxActionPerformed

        // if the same then check for other changes
        if (issue.getLocked() == null) {
            setBtnsEnabled(true);
        } else {
            if((lockCheckBox.isSelected()?"Y":"").equals(issue.getLocked())){
                checkForChangeAndSetBtnsEnabled();
            }
            // we know right away there is a change so just set the button enabled
            else{
                setBtnsEnabled(true); // sets the submit or confirm button enabled
            }
        }
    }//GEN-LAST:event_lockCheckBoxActionPerformed

    /**
     * Fires when IssueType ComboBox selection is changed
     * @param evt action event for the IssueType ComboBox
     */
    private void comboBoxIssueTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIssueTypeActionPerformed
        // if the same then check for other changes
        if (issue.getIssueType() == null) {
            setBtnsEnabled(true);
        } else {
            if(comboBoxIssueType.getSelectedItem().toString().equals(issue.getIssueType())){
                checkForChangeAndSetBtnsEnabled();
            }
            // we know right away there is a change so just set the button enabled
            else{
                setBtnsEnabled(true); // sets the submit or confirm button enabled
            }
        }
    }//GEN-LAST:event_comboBoxIssueTypeActionPerformed

    private void submitterTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitterTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitterTextActionPerformed

    private void dateOpenedTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateOpenedTextKeyReleased
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_D) {
            this.FillItWithDate((JTextField) evt.getComponent());
        }
    }//GEN-LAST:event_dateOpenedTextKeyReleased

    private void programmerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmerComboBoxActionPerformed
        //System.out.println(issue.getProgrammer());
        //System.out.println(programmerComboBox.getSelectedItem().toString());
        if (issue.getProgrammer() == null) {
            setBtnsEnabled(true);
        } else {
            if(programmerComboBox.getSelectedItem().toString().equals(issue.getProgrammer())){
                checkForChangeAndSetBtnsEnabled();
            }
            // we know right away there is a change so just set the button enabled
            else{
                setBtnsEnabled(true); // sets the submit or confirm button enabled
            }
        }
    }//GEN-LAST:event_programmerComboBoxActionPerformed

    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButtonActionPerformed

    }//GEN-LAST:event_colorButtonActionPerformed

    /**
     * This method is called when the submit button is pressed.
     * @param evt 
     */
    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        setIssueValuesFromComponents();

        try {
            if(dao.insert(issue)){
                try {
                    projectManager.inserTableRow(table,issue);
                } catch (IOException ex) {
                    Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadLocationException ex) {
                    Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                projectManager.makeTableEditable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        issueWindowClosing();
    }//GEN-LAST:event_buttonSubmitActionPerformed

    private void dateClosedTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateClosedTextKeyReleased
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_D) {
            FillItWithDate((JTextField) evt.getComponent());
        }
    }//GEN-LAST:event_dateClosedTextKeyReleased

    private void appComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appComboBoxActionPerformed
        if (issue.getApp() == null) {
            setBtnsEnabled(true); 
        } else {
            if(appComboBox.getSelectedItem().toString().equals(issue.getApp())){
                checkForChangeAndSetBtnsEnabled();
            }
            // we know right away there is a change so just set the button enabled
            else{
                setBtnsEnabled(true); // sets the submit or confirm button enabled
            }
        }
    }//GEN-LAST:event_appComboBoxActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        //        System.out.println(selectedTable.getValueAt(0, 0));

        //        projectManager.getOpeningIssuesList().remove(issue.getID(), this);
        issueWindowClosing();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void btnCloseIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseIssueActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        String userName = projectManager.getUserName();

        //clean the text pane
        //rtftext.setText("");

        ByteArrayOutputStream getcurrentdescriptiontext = new ByteArrayOutputStream();
        try {
            rtftext.getEditorKit().write(getcurrentdescriptiontext, rtftext.getDocument(), 0, rtftext.getDocument().getLength());
        } catch (IOException | BadLocationException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] getcurrentdescriptiontextbytearray = getcurrentdescriptiontext.toByteArray();
        String rtfstring = getcurrentdescriptiontext.toString();
        String newrtfstring = rtfstring.substring(0,rtfstring.length()-2);

        //String newrtfstring2 = rtfstring.substring(rtfstring.length()-1,rtfstring.length());

        //for(int i=0; i < rtfstring.length(); i++ ) {
            //System.out.print( rtfstring.charAt(i) );
            //System.out.print(",");
            //}

        System.out.println(newrtfstring);

        /*
        String value = descriptionText.getText();
        InputStream middle = null ;
        String beginning = "Once upon a time ...\n";
        String end = "\n... and they lived happily ever after.";
        List<InputStream> streams = Arrays.asList(
            new ByteArrayInputStream(beginning.getBytes()),
            middle,
            new ByteArrayInputStream(end.getBytes()));
        InputStream story = new SequenceInputStream(Collections.enumeration(streams));
        */

        if (btnCloseIssue.getText().equalsIgnoreCase("close issue")) {
            // set dateClosed text field with date today
            FillItWithDate(dateClosedText);
            String temperaryVersion = "XXX";
            versionText.setText(temperaryVersion);
            btnCloseIssue.setText("Reopen Issue");

            newrtfstring = newrtfstring + "\n--- Issue Closed by "
            + userName + " on " + today + "\\par";
            newrtfstring = newrtfstring + "\n}";

        } else if (btnCloseIssue.getText().equalsIgnoreCase("reopen issue")) {

            newrtfstring = newrtfstring + "\n \n--- Issue reopened by "
            + userName + " on " + today + " (version " + versionText.getText() + ")\\par";
            newrtfstring = newrtfstring + "\n}";

            versionText.setText("");
            dateClosedText.setText("");
            btnCloseIssue.setText("Close Issue");
        }

        byte[] close_openrtfbytearray = newrtfstring.getBytes(Charset.forName("UTF-8"));
        InputStream close_openrtfstream = new ByteArrayInputStream(close_openrtfbytearray);
        try {
            rtftext.getEditorKit().read(close_openrtfstream, rtftext.getDocument(), 0);
            //descriptionText.setText(value);
        } catch (IOException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCloseIssueActionPerformed

    /**
     * This method is called when the confirm button is pressed.
     * @param evt 
     */
    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        setIssueValuesFromComponents();

        try {
            if(dao.update(issue)){
                projectManager.updateTableRow(table,issue);
                projectManager.makeTableEditable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        issueWindowClosing();
    }//GEN-LAST:event_buttonConfirmActionPerformed

    /**
     * Fired when the next button is invoked.
     * The next button traverses the table to get the next issue.
     * @param evt 
     */
    private void BtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextActionPerformed

        /**
        * If table has not changed then no need to execute this for loop.
        * boolean rowFound makes sure the issue is still in the table view.
        */
        boolean rowFound = true;
        if (!table.getValueAt(row, 0).toString().equals(Integer.toString(issue.getId()))) {
            rowFound = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                if (table.getValueAt(i, 0).toString().equals(Integer.toString(issue.getId()))) {
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
            try {
                setIssueValuesFromTable(row,table);
            } catch (IOException ex) {
                Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setComponentValuesFromIssue(this);
            } catch (IOException ex) {
                Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadLocationException ex) {
                Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            table.setRowSelectionInterval(row, row);
            updateCustomIdList(row);
        }
    }//GEN-LAST:event_BtnNextActionPerformed

    /**
     * Fired when the previous button is invoked.
     * The previous button traverses the table to get the previous issue.
     * @param evt 
     */
    private void BtnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPreviousActionPerformed

        /**
        * If table has not changed then no need to execute this for loop.
        * boolean found makes sure the issue is still in the table view.
        */
        boolean rowFound = true;
        if (!table.getValueAt(row, 0).toString().equals(Integer.toString(issue.getId()))) {

            rowFound = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                if (table.getValueAt(i, 0).toString().equals(Integer.toString(issue.getId()))) {
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
            try {
                setIssueValuesFromTable(row,table);
            } catch (IOException ex) {
                Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setComponentValuesFromIssue(this);
            } catch (IOException ex) {
                Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadLocationException ex) {
                Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            table.setRowSelectionInterval(row, row);
            updateCustomIdList(row);
        }
    }//GEN-LAST:event_BtnPreviousActionPerformed

    private void colorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButton1ActionPerformed
        Action b = new ForegroundAction();
        b.actionPerformed(evt);
    }//GEN-LAST:event_colorButton1ActionPerformed

    private void B_BoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BoldActionPerformed
        Action b = new BoldAction();
        b.actionPerformed(evt);
    }//GEN-LAST:event_B_BoldActionPerformed

    private void UnderlineBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnderlineBottonActionPerformed
        Action b = new UnderlineAction();
        b.actionPerformed(evt);
    }//GEN-LAST:event_UnderlineBottonActionPerformed

    private void StrikethroughBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrikethroughBottonActionPerformed
        Action b = (Action) new StrikethroughAction();
        b.actionPerformed(evt);
    }//GEN-LAST:event_StrikethroughBottonActionPerformed

    private void ItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItalicActionPerformed
        Action b = new ItalicAction();
        b.actionPerformed(evt);
    }//GEN-LAST:event_ItalicActionPerformed

    private void FsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FsizeActionPerformed
        Action b = new FontAndSizeAction();
        b.actionPerformed(evt);
    }//GEN-LAST:event_FsizeActionPerformed

    private void log(String toString, NullPointerException nullPointer, PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class StrikethroughAction extends StyledEditorKit.StyledTextAction {

        private static final long serialVersionUID = 9174670038684056758L;

        public StrikethroughAction() {
            super("font-bold");
        }

        public String toString() {
            return "Strikethrough";
        }

        public void actionPerformed(ActionEvent e) {
            JEditorPane editor = getEditor(e);
            if (editor != null) {
                StyledEditorKit kit = getStyledEditorKit(editor);
                MutableAttributeSet attr = kit.getInputAttributes();
                boolean bold;
                bold = !(StyleConstants.isStrikeThrough(attr));
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setStrikeThrough(sas, bold);
                setCharacterAttributes(editor, sas, false);

            }
        }
    }
    
    public class ForegroundAction extends StyledEditorKit.StyledTextAction {

        private static final long serialVersionUID = 6384632651737400352L;

        JColorChooser colorChooser = new JColorChooser();

        JDialog dialog = new JDialog();

        boolean noChange = false;

        boolean cancelled = false;

        public ForegroundAction() {
            super("foreground");

        }

        public void actionPerformed(ActionEvent e) {
            JTextPane editor = (JTextPane) getEditor(e);

            if (editor == null) {
                JOptionPane.showMessageDialog(null,
                        "You need to select the editor pane before you can change the color.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int p0 = editor.getSelectionStart();
            StyledDocument doc = getStyledDocument(editor);
            Element paragraph = doc.getCharacterElement(p0);
            AttributeSet as = paragraph.getAttributes();
            fg = StyleConstants.getForeground(as);
            if (fg == null) {
                fg = Color.BLACK;
            }
            colorChooser.setColor(fg);

            JButton accept = new JButton("OK");
            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    fg = colorChooser.getColor();
                    dialog.dispose();
                }
            });

            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cancelled = true;
                    dialog.dispose();
                }
            });

            JButton none = new JButton("None");
            none.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    noChange = true;
                    dialog.dispose();
                }
            });

            JPanel buttons = new JPanel();
            buttons.add(accept);
            buttons.add(none);
            buttons.add(cancel);

            dialog.getContentPane().setLayout(new BorderLayout());
            dialog.getContentPane().add(colorChooser, BorderLayout.CENTER);
            dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
            dialog.setModal(true);
            dialog.pack();
            dialog.setVisible(true);

            if (!cancelled) {

                MutableAttributeSet attr = null;
                if (editor != null) {
                    if (fg != null && !noChange) {
                        attr = new SimpleAttributeSet();
                        StyleConstants.setForeground(attr, fg);
                        setCharacterAttributes(editor, attr, false);
                    }
                }
            }// end if color != null
            noChange = false;
            cancelled = false;
        }

        private Color fg;
    }
    
    public class FontAndSizeAction extends StyledEditorKit.StyledTextAction {

        private static final long serialVersionUID = 584531387732416339L;

        private String family;

        private float fontSize;

        JDialog formatText;

        private boolean accept = false;

        JComboBox fontFamilyChooser;

        JComboBox fontSizeChooser;

        public FontAndSizeAction() {
            super("Font and Size");
        }

        public String toString() {
            return "Font and Size";
        }


         
        public void actionPerformed(ActionEvent e) {
            
            JTextPane editor = (JTextPane) getEditor(e);
            int p0 = editor.getSelectionStart();
            StyledDocument doc = getStyledDocument(editor);
            Element paragraph = doc.getCharacterElement(p0);
            AttributeSet as = paragraph.getAttributes();

            family = StyleConstants.getFontFamily(as);
            fontSize = StyleConstants.getFontSize(as);

            formatText = new JDialog(new JFrame(), "Font and Size", true);
            formatText.getContentPane().setLayout(new BorderLayout());

            JPanel choosers = new JPanel();
            choosers.setLayout(new GridLayout(2, 1));

            JPanel fontFamilyPanel = new JPanel();
            fontFamilyPanel.add(new JLabel("Font"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            String[] fontNames = ge.getAvailableFontFamilyNames();

            fontFamilyChooser = new JComboBox();
            for (int i = 0; i < fontNames.length; i++) {
                fontFamilyChooser.addItem(fontNames[i]);
            }
            fontFamilyChooser.setSelectedItem(family);
            fontFamilyPanel.add(fontFamilyChooser);
            choosers.add(fontFamilyPanel);

            JPanel fontSizePanel = new JPanel();
            fontSizePanel.add(new JLabel("Size"));
            fontSizeChooser = new JComboBox();
            fontSizeChooser.setEditable(true);
            fontSizeChooser.addItem(new Float(4));
            fontSizeChooser.addItem(new Float(8));
            fontSizeChooser.addItem(new Float(12));
            fontSizeChooser.addItem(new Float(16));
            fontSizeChooser.addItem(new Float(20));
            fontSizeChooser.addItem(new Float(24));
            fontSizeChooser.setSelectedItem(new Float(fontSize));
            fontSizePanel.add(fontSizeChooser);
            choosers.add(fontSizePanel);

            JButton ok = new JButton("OK");
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    accept = true;
                    formatText.dispose();
                    family = (String) fontFamilyChooser.getSelectedItem();
                    fontSize = Float.parseFloat(fontSizeChooser.getSelectedItem().toString());
                }
            });

            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    formatText.dispose();
                }
            });

            JPanel buttons = new JPanel();
            buttons.add(ok);
            buttons.add(cancel);
            formatText.getContentPane().add(choosers, BorderLayout.CENTER);
            formatText.getContentPane().add(buttons, BorderLayout.SOUTH);
            formatText.pack();
            formatText.setVisible(true);

            MutableAttributeSet attr = null;
            if (editor != null && accept) {
                attr = new SimpleAttributeSet();
                StyleConstants.setFontFamily(attr, family);
                StyleConstants.setFontSize(attr, (int) fontSize);
                setCharacterAttributes(editor, attr, false);
            }

        }
    }

    
    
    /**
     * Called to close the form
     */
    private void issueWindowClosing() {
        if (addIssueMode) {
            projectManager.setAddIssueWindowShow(false);
        } else {
            projectManager.getOpeningIssuesList().remove(issue.getId(), this);
            projectManager.getSelectedTabCustomIdList(table.getName()).delete(issue.getId());
            projectManager.getSelectedTabCustomIdList(table.getName()).printOutIDList();
        }
        this.dispose();
    }
    
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

    /**
     * Sets issue values from table
     * @param row the row index on table for issue to retrieve
     * @param table the table with the row/issue data
     */
    private void setIssueValuesFromTable(int row, JTable table) throws IOException {

        issue.setId(Integer.parseInt(getTableValueAt(row, 0).toString()));
        issue.setApp(getTableValueAt(row, 1).toString());
        issue.setTitle(getTableValueAt(row, 2).toString());
        
        
        issue.setDescription(convertStringToBytearrary((String) getTableValueAt(row, 3)));
        
        issue.setProgrammer(getTableValueAt(row, 4).toString());
        issue.setDateOpened(getTableValueAt(row, 5).toString());
        issue.setRk(getTableValueAt(row, 6).toString());
        issue.setVersion(getTableValueAt(row, 7).toString());
        issue.setDateClosed(getTableValueAt(row, 8).toString());
        issue.setIssueType(getTableValueAt(row, 9).toString());
        issue.setSubmitter(getTableValueAt(row, 10).toString());
        issue.setLocked(getTableValueAt(row, 11).toString());
    }
    
    private int getcurrentissueid(int row, JTable table) throws IOException {
        
        return (int) getTableValueAt(row, 0);
    }
    
    public byte[] convertStringToBytearrary(String is) throws IOException {
        // To convert the InputStream to String we use the
        // Reader.read(char[] buffer) method. We iterate until the
        // Reader return -1 which means there's no more data to
        // read. We use the StringWriter class to produce the string.
        if (is != null) {
            byte[] b = is.getBytes(Charset.forName("UTF-8"));
            return b;
        }
        return new byte[0];
    }
    
    /**
     * This returns cell value of table but replaces null with "" to handle
     * null pointer exceptions.
     * @param row row of table cell
     * @param col column of table cell
     * @return Object of cell value but null values are replaced with ""
     */
    private Object getTableValueAt(int row, int col){
        return (table.getValueAt(row, col)==null)?"":table.getValueAt(row, col);
    }
    
    /**
     * Sets the issue values from the components and fields from issue window.
     */
    private void setIssueValuesFromComponents() {

        issue.setId(Integer.parseInt(idText.getText()));
        
        if (appComboBox.getSelectedItem() == null) {
            issue.setApp("");
        } else {
            issue.setApp(appComboBox.getSelectedItem().toString());
        }
        
        if (titleText.getText() == null) {
            issue.setTitle("");
        } else {
            issue.setTitle(titleText.getText());
        }
        
        ByteArrayOutputStream setdescriptionoutputstream = new ByteArrayOutputStream();                   
        try {
            rtftext.getEditorKit().write(setdescriptionoutputstream, rtftext.getDocument(), 0, rtftext.getDocument().getLength());
        } catch (IOException | BadLocationException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] setdescriptionbytearray = setdescriptionoutputstream.toByteArray();
        
        if (setdescriptionbytearray == null) {
            byte[] emptyarray = new byte[0];
            issue.setDescription(emptyarray);
        } else {
            issue.setDescription(setdescriptionbytearray);
        }
        
        if (programmerComboBox.getSelectedItem() == null) {
            issue.setProgrammer("");
        } else {
            issue.setProgrammer(programmerComboBox.getSelectedItem().toString());
        }
        
        if (dateOpenedText.getText() == null) {
            issue.setDateOpened("");
        } else {
            issue.setDateOpened(dateOpenedText.getText());
        }
        
        if (rkComboBox.getSelectedItem() == null) {
            issue.setRk("");
        } else {
            issue.setRk(rkComboBox.getSelectedItem().toString());
        }
                
        if (versionText.getText() == null) {
            issue.setVersion("");
        } else {
            issue.setVersion(versionText.getText());
        }
        
        if (dateClosedText.getText() == null) {
            issue.setDateClosed("");
        } else {
            issue.setDateClosed(dateClosedText.getText());
        }
        
        if (comboBoxIssueType.getSelectedItem() == null) {
            issue.setIssueType("");
        } else {
            issue.setIssueType(comboBoxIssueType.getSelectedItem().toString());
        }
        
        if (submitterText.getText() == null) {
            issue.setSubmitter("");
        } else {
            issue.setSubmitter(submitterText.getText());
        }
        
        if (lockCheckBox.isSelected()) {
            issue.setLocked("");
        } else {
            issue.setLocked((lockCheckBox.isSelected())?"Y":"");
        }

    }

    /**
     * Sets the components and fields on issue window from the issue object.
     */
    private void setComponentValuesFromIssue(IssueWindow aThis) throws IOException, BadLocationException {

        idText.setText(Integer.toString(issue.getId()));
        appComboBox.setSelectedItem(issue.getApp());
        titleText.setText(issue.getTitle());
        
        rtftext.setText("");
        byte[] descriptionbytesout = issue.getDescription();
        InputStream rtfstream = new ByteArrayInputStream(descriptionbytesout);
        String convertedstrings = convertStreamToString(rtfstream);
        String rtfsign = "{\\rtf1\\ansi";
        boolean rtfornot = convertedstrings.contains(rtfsign);

        if (rtfornot) {
            byte[] descriptionbytesout2 = issue.getDescription();
            InputStream rtfstream2 = new ByteArrayInputStream(descriptionbytesout2);
            rtftext.getEditorKit().read(rtfstream2, rtftext.getDocument(), 0);
        } else {
            String displaystringinrtf = "{\\rtf1\\ansi\n" +
                    "{\\fonttbl\\f0\\fnil Monospaced;\\f1\\fnil sansserif;}\n" +
                    "{\\colortbl\\red0\\green0\\blue0;\\red0\\green0\\blue0;}\n" +
                                                                            "\n" +
                     "\\li0\\ri0\\fi0\\f1\\fs24\\i0\\b0\\cf1 " + convertedstrings + "\\par\n" +
                    "}";
            byte[] displaystringinrtfbyte = displaystringinrtf.getBytes(Charset.forName("UTF-8"));
            InputStream displaystringinrtfintput = new ByteArrayInputStream(displaystringinrtfbyte);
            rtftext.getEditorKit().read(displaystringinrtfintput, rtftext.getDocument(), 0);
        }

        //descriptionText.setText(issue.getDescription());
        
        programmerComboBox.setSelectedItem(issue.getProgrammer());
        dateOpenedText.setText(issue.getDateOpened());
        rkComboBox.setSelectedItem(issue.getRk());
        versionText.setText(issue.getVersion());
        dateClosedText.setText(issue.getDateClosed());
        comboBoxIssueType.setSelectedItem(issue.getIssueType());
        submitterText.setText(issue.getSubmitter());
        //lockCheckBox.setSelected(issue.getLocked().equals("Y"));
        
        setOpenCloseIssueBtnText(); // set button text to Open/Close issue
    }
    
        public String convertStreamToString(InputStream is) throws IOException {
        // To convert the InputStream to String we use the
        // Reader.read(char[] buffer) method. We iterate until the
        // Reader return -1 which means there's no more data to
        // read. We use the StringWriter class to produce the string.
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader;
                reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        }
        return "";
    }
        
        
    /**
     * This method compares the values of the issue with the component values
     * and returns true or false.
     * @return boolean true if there is a change in any of the component values
     */
    private boolean hasChange(){
        
        ByteArrayOutputStream str = new ByteArrayOutputStream();                   
        try {
            rtftext.getEditorKit().write(str, rtftext.getDocument(), 0, rtftext.getDocument().getLength());
        } catch (IOException | BadLocationException ex) {
            Logger.getLogger(IssueWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte[] bkey = str.toByteArray();
        String rtfstring = new String(bkey);
        System.out.println(rtfstring);

        byte[] bkey1 = issue.getDescription();
        String rtfstringindb = new String(bkey1);
        System.out.println(rtfstringindb);
        System.out.println(rtfstring.equals(rtfstringindb));
        
        return ( appComboBox.getSelectedItem().equals(issue.getApp())
                &&titleText.getText().equals(issue.getTitle())
            && rtfstring.equals(rtfstringindb)
            && programmerComboBox.getSelectedItem().equals(issue.getProgrammer())
            && dateOpenedText.getText().equals(issue.getDateOpened())
            && rkComboBox.getSelectedItem().equals(issue.getRk())
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
                checkForChangeAndSetBtnsEnabled();
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
     * @param hasChange if true then sets the button enabled or disables if false.
     */
    private void setBtnsEnabled(boolean hasChange){
        if(buttonSubmit.isVisible()){
            buttonSubmit.setEnabled(hasChange);
        }
        else if(buttonConfirm.isVisible()){
            buttonConfirm.setEnabled(hasChange);
        }
    }
    private Map loadingDropdownList() {
        String selectedTabName = projectManager.getSelectedTabName();
        Tab tab = tabs.get(selectedTabName);
        
   
        Map<Integer, ArrayList<Object>> valueListMap = new HashMap();
        if (!selectedTabName.equalsIgnoreCase("issue_files")) {
            for (String searchField : dropdownlist) {

                for (int i = 0; i < tab.getTable().getColumnCount(); i++) {
                    if (tab.getTable().getColumnName(i).equalsIgnoreCase(searchField)) {
                        valueListMap.put(i, new ArrayList<Object>());
                    }
                }
            }
            for (int col : valueListMap.keySet()) {
                //for each search item, create a new drop down list
                ArrayList DropDownListValueForEachColumn = new ArrayList<Object>();
                // load drop down for each table
                for (Map.Entry<String, Tab> entry : tabs.entrySet()) {
                    if (!entry.getKey().equalsIgnoreCase("issue_files")) {
                        tab = tabs.get(entry.getKey());

                        String[] columnNames = tab.getTableColNames();
                        JTable table = tab.getTable();
                        TableModel tableModel = table.getModel();
                        String colName;
                        colName = columnNames[col].toLowerCase();
                  

                        switch (colName) {
                            case "title":
                            case "description":
                            case "version":
                                DropDownListValueForEachColumn.add("");
                                break;
                            default:
                                Object valueAddToDropDownList;
                                for (int row = 0; row < tableModel.getRowCount(); row++) {
                                    valueAddToDropDownList = tableModel.getValueAt(row, col);

                                    if (valueAddToDropDownList != null) {
                                        // add to drop down list
                                        DropDownListValueForEachColumn.add(valueAddToDropDownList);
                                    } else {
                                        DropDownListValueForEachColumn.add("");
                                    }
                                }
                                break;
                        }
                    }
                }

                //make every item in drop down list unique
                Set<Object> uniqueValue = new HashSet<Object>(DropDownListValueForEachColumn);
                ArrayList uniqueList = new ArrayList<Object>(uniqueValue);
//                System.out.println(col + " " + uniqueList);
                valueListMap.put(col, uniqueList);
                System.out.println(uniqueList);
            }
        }
        return valueListMap;

    }
        private void updateComboList(String colName, String tableName) {
        //create a combo box model
        DefaultComboBoxModel comboBoxSearchModel = new DefaultComboBoxModel();
        if (colName.equalsIgnoreCase("programmer")) {
            programmerComboBox.setModel(comboBoxSearchModel);
        } else if (colName.equalsIgnoreCase("rk")) {
            rkComboBox.setModel(comboBoxSearchModel);
        } else if (colName.equalsIgnoreCase("app")) {
            appComboBox.setModel(comboBoxSearchModel);
        }


        Map comboBoxForSearchValue = loadingDropdownList();

        JTable table = tabs.get(tableName).getTable();

        for (int col = 0; col < table.getColumnCount(); col++) {

            if (table.getColumnName(col).equalsIgnoreCase(colName)) {
                ArrayList<Object> dropDownList = (ArrayList<Object>) comboBoxForSearchValue.get(col);

                if (colName.equalsIgnoreCase("dateOpened") || colName.equalsIgnoreCase("dateClosed")) {
                    Collections.sort(dropDownList, new Comparator<Object>() {
                        public int compare(Object o1, Object o2) {
                            return o2.toString().compareTo(o1.toString());
                        }

                    });

                } else if (colName.equalsIgnoreCase("rk")) {
                    if (dropDownList.get(0) == "") {
                        ArrayList<Object> list = new ArrayList<Object>();

                        for (int i = 1; i < dropDownList.size(); i++) {
                            list.add(dropDownList.get(i));
                        }
                        list.add(dropDownList.get(0));

                        dropDownList = list;
                    }
                } else if (colName.equalsIgnoreCase("programmer") || colName.equalsIgnoreCase("app") ) {
                    Object nullValue = "";

                    Collections.sort(dropDownList, new Comparator<Object>() {
                        public int compare(Object o1, Object o2) {
                            if (o1 == nullValue && o2 == nullValue) {
                                return 0;
                            }

                            if (o1 == nullValue) {

                                return 1;
                            }

                            if (o2 == nullValue) {

                                return -1;
                            }

                            return o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase());
                        }

                    });

                }
//                System.out.println(dropDownList);

                for (Object item : dropDownList) {
 
                    comboBoxSearchModel.addElement(item);

                }

            }
        }
//        comboBoxForSearch.setSelectedItem("Enter " + colName + " here");
//        comboBoxStartToSearch = true;
    }
            private void setComboBoxValue() {
        int row = projectManager.getSelectedTable().getSelectedRow();
        String programmer = "";
        String rk = "";
        String app = "";
        if (projectManager.getSelectedTable().getModel().getValueAt(row, 1) != null) {
            app = projectManager.getSelectedTable().getModel().getValueAt(row, 1).toString();
        }
        if (projectManager.getSelectedTable().getModel().getValueAt(row, 4) != null) {
            programmer = projectManager.getSelectedTable().getModel().getValueAt(row, 4).toString();
        }
        if (projectManager.getSelectedTable().getModel().getValueAt(row, 6) != null) {
            rk = projectManager.getSelectedTable().getModel().getValueAt(row, 6).toString();
        }
        programmerComboBox.setSelectedItem(programmer);
        rkComboBox.setSelectedItem(rk);
        appComboBox.setSelectedItem(app);

    }
    

//    private void updateComboBoxValue() {
//        int row = projectManager.getSelectedTable().getSelectedRow();
//        String programmer = "";
//        String rk = "";
//        String app = "";
//        programmer = programmerComboBox.getSelectedItem().toString();
//        rk = rkComboBox.getSelectedItem().toString();
//        app = appComboBox.getSelectedItem().toString();
//        projectManager.getSelectedTable().getModel().setValueAt(programmer, row, 4);
//        projectManager.getSelectedTable().getModel().setValueAt(rk, row, 6);
//        projectManager.getSelectedTable().getModel().setValueAt(app, row, 1);
//
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Bold;
    private javax.swing.JButton BtnNext;
    private javax.swing.JButton BtnPrevious;
    private javax.swing.JButton Fsize;
    private javax.swing.JButton Italic;
    private javax.swing.JButton StrikethroughBotton;
    private javax.swing.JButton UnderlineBotton;
    private javax.swing.JLabel app;
    private javax.swing.JComboBox appComboBox;
    private javax.swing.JButton btnCloseIssue;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JButton colorButton;
    private javax.swing.JButton colorButton1;
    private javax.swing.JComboBox<String> comboBoxIssueType;
    private javax.swing.JLabel dateClosed;
    private javax.swing.JTextField dateClosedText;
    private javax.swing.JLabel dateOpened;
    private javax.swing.JTextField dateOpenedText;
    private javax.swing.JLabel description;
    private javax.swing.JPanel formPane;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lock;
    private javax.swing.JCheckBox lockCheckBox;
    private javax.swing.JLabel programmer;
    private javax.swing.JComboBox programmerComboBox;
    private javax.swing.JLabel rk;
    private javax.swing.JComboBox rkComboBox;
    private javax.swing.JTextPane rtftext;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel submitter;
    private javax.swing.JTextField submitterText;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titleText;
    private javax.swing.JLabel version;
    private javax.swing.JTextField versionText;
    // End of variables declaration//GEN-END:variables

}
