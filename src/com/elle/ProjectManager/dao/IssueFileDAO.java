
package com.elle.ProjectManager.dao;

import com.elle.ProjectManager.database.DBConnection;
import com.elle.ProjectManager.database.ModifiedData;
import com.elle.ProjectManager.entities.IssueFile;
import com.elle.ProjectManager.logic.LoggingAspect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 * IssueFileDAO
 * I was told to ignore this table. It is supposed to be another table
 * in the database so I will start this DAO here. This will just be a 
 * place holder for any code for the DAO while I focus on the IssueDAO.
 * @author Carlos Igreja
 * @since  Apr 26, 2016
 */
public class IssueFileDAO {

    // database table information
    private final String DB_TABLE_NAME = "issue_files";
    private final String COL_PK_FILE_ID = "fileID";
    private final String COL_TASK_ID = "taskID";
    private final String COL_APP = "app";
    private final String COL_SUBMITTER = "submitter";
    private final String COL_STEP = "step";
    private final String COL_DATE = "date_";
    private final String COL_FILES = "files";
    private final String COL_PATH = "path";
    private final String COL_NOTES = "notes";
    
    /**
     * This deletes the selected rows on the table from the database
     * @param table
     * @return 
     */
    public boolean delete(JTable table){

        String tableName = table.getName(); // name of the tableSelected
        
        String sqlDelete = ""; // String for the SQL Statement

        int[] selectedRows = table.getSelectedRows(); // array of the rows selected
        int rowCount = selectedRows.length; // the number of rows selected
        if (rowCount != -1) {
            for (int i = 0; i < rowCount; i++) {
                int row = selectedRows[i];
                Integer selectedID = (Integer) table.getValueAt(row, 0); // Add Note to selected taskID

                if (i == 0) // this is the first rowIndex
                {
                    sqlDelete += "DELETE FROM " + tableName
                            + " WHERE " + table.getColumnName(0) + " IN (" + selectedID; // 0 is the first column index = primary key
                } else // this adds the rest of the rows
                {
                    sqlDelete += ", " + selectedID;
                }

            }

            // windowClose the sql statement
            sqlDelete += ");";

            try {

                // delete records from database
                DBConnection.close();
                DBConnection.open();
                DBConnection.getStatement().executeUpdate(sqlDelete);
                LoggingAspect.afterReturn(rowCount + " Record(s) Deleted");
                String levelMessage = "3:" + sqlDelete;
                LoggingAspect.addLogMsgWthDate(levelMessage);
                return true;

            } catch (SQLException e) {
                LoggingAspect.afterThrown(e);
                return false;
            }
        }
        else{
            // no selected rows
            return false;
        }
    }

    /**
     * Formats string to return null or single quotes.
     * This will work for now as all the defaults for
     * the issues table is null. However his could change.
     * This was a last minute fix to get the factoring out.
     * @param s
     * @return 
     */
    private String format(String s){
        return (s.equals(""))?null:"'"+s+"'";
    }

    private Object processCellValue(Object cellValue) {
        return cellValue.toString().replaceAll("'", "''");
    }
    
    /**
     * update
     * @param tableName
     * @param modifiedData
     * @return 
     */
    public boolean update(String tableName,ModifiedData modifiedData) {
        
        boolean updateSuccessful = true;
        String sqlChange = null;

        DBConnection.close();
        if (DBConnection.open()) {

            String columnName = modifiedData.getColumnName();
            Object value = modifiedData.getValue();
            value = processCellValue(value);
            int id = modifiedData.getId();

            try {

                if (value.equals("")) {
                    value = null;
                    sqlChange = "UPDATE " + tableName + " SET " + columnName
                            + " = " + value + " WHERE ID = " + id + ";";
                } else {
                    sqlChange = "UPDATE " + tableName + " SET " + columnName
                            + " = '" + value + "' WHERE ID = " + id + ";";
                }

                DBConnection.getStatement().executeUpdate(sqlChange);
                LoggingAspect.afterReturn(sqlChange);

            } catch (SQLException e) {
                LoggingAspect.addLogMsgWthDate("3:" + e.getMessage());
                LoggingAspect.addLogMsgWthDate("3:" + e.getSQLState() + "\n");
                LoggingAspect.addLogMsgWthDate(("Upload failed! " + e.getMessage()));
                LoggingAspect.afterThrown(e);
                updateSuccessful = false;
            }
            if (updateSuccessful) {
                LoggingAspect.afterReturn(("Edits uploaded successfully!"));
            }
        } else {
            // connection failed
            LoggingAspect.afterReturn("Failed to connect");
        }
        // finally close connection
        DBConnection.close();
        return updateSuccessful;
    }

    /**
     * Returns a list of IssueFiles for the entire table
     * @return a list of IssueFiles
     */
    public ArrayList<IssueFile> get() {
        
        ArrayList<IssueFile> issueFiles = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM " + DB_TABLE_NAME 
                   + " ORDER BY " + COL_TASK_ID + " ASC";
        
        try {

            DBConnection.close();
            DBConnection.open();
            rs = DBConnection.getStatement().executeQuery(sql);
            while(rs.next()){
                IssueFile issueFile = new IssueFile();
                issueFile.setFileID(rs.getString(COL_PK_FILE_ID));
                issueFile.setTaskID(rs.getString(COL_TASK_ID));
                issueFile.setApp(rs.getString(COL_APP));
                issueFile.setSubmitter(rs.getString(COL_SUBMITTER));
                issueFile.setStep(rs.getString(COL_STEP));
                issueFile.setDate(rs.getString(COL_DATE));
                issueFile.setFiles(rs.getString(COL_FILES));
                issueFile.setPath(rs.getString(COL_PATH));
                issueFile.setNotes(rs.getString(COL_NOTES));
                issueFiles.add(issueFile);
            }
            
            LoggingAspect.afterReturn("Loaded table " + DB_TABLE_NAME);
        } 
        catch (SQLException e) {
            LoggingAspect.afterThrown(e);
        }

        return issueFiles;
    }
    
    /**
     * This is used in the changedTabState method.
     * This queries based on the last tab before selecting the issue_files tab.
     * @param currentTabName this is the 
     * @return a list of IssueFiles
     */
    public ArrayList<IssueFile> get(String currentTabName){
        
        ArrayList<IssueFile> issueFiles = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM " + DB_TABLE_NAME;

        if (currentTabName.equals("PM") || currentTabName.equals("ELLEGUI") || currentTabName.equals("Analyster")) {
            sql = sql + " WHERE app = " + "'" + currentTabName + "'";
        } else if (currentTabName.equals("Other")) {
            sql = sql + " WHERE app != 'PM' and app != 'Analyster' "
                    + "and app != 'ELLEGUI' or app IS NULL";
        }

        sql = sql + " ORDER BY taskId ASC";

        try {

            DBConnection.close();
            DBConnection.open();
            rs = DBConnection.getStatement().executeQuery(sql);
            while(rs.next()){
                IssueFile issueFile = new IssueFile();
                issueFile.setFileID(rs.getString(COL_PK_FILE_ID));
                issueFile.setTaskID(rs.getString(COL_TASK_ID));
                issueFile.setApp(rs.getString(COL_APP));
                issueFile.setSubmitter(rs.getString(COL_SUBMITTER));
                issueFile.setStep(rs.getString(COL_STEP));
                issueFile.setDate(rs.getString(COL_DATE));
                issueFile.setFiles(rs.getString(COL_FILES));
                issueFile.setPath(rs.getString(COL_PATH));
                issueFile.setNotes(rs.getString(COL_NOTES));
                issueFiles.add(issueFile);
            }
            
            LoggingAspect.afterReturn("Loaded table " + DB_TABLE_NAME);
        } 
        catch (SQLException e) {
            LoggingAspect.afterThrown(e);
        }
        
        return issueFiles;
    }
}
