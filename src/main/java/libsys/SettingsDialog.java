package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

/**
 * UI for updating all the informations in Settings
 */
@SuppressWarnings("serial")
public class SettingsDialog extends javax.swing.JDialog {

    /**
     * Creates new SettingsDialog
     * @param  parent   java.awt.Frame
     * @param  modal    boolean
     * @param  preset   Settings
     */
    public SettingsDialog(java.awt.Frame parent, boolean modal, Settings preset) {
        super(parent, modal);
        initComponents();
        setup(preset);
        this.preset = preset;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        titleTxtField = new javax.swing.JTextField();
        usersFilenameLbl = new javax.swing.JLabel();
        usersFilenameTxt = new javax.swing.JTextField();
        booksFilenameLbl = new javax.swing.JLabel();
        booksFilenameTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        discardBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        settingsLbl.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        settingsLbl.setText("Settings");

        titleLbl.setText("Title :");

        usersFilenameLbl.setText("Users Filename :");

        booksFilenameLbl.setText("Books Filename :");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        discardBtn.setText("Discard");
        discardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(discardBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(settingsLbl)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usersFilenameLbl)
                                    .addComponent(titleLbl)
                                    .addComponent(booksFilenameLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(booksFilenameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(titleTxtField)
                                    .addComponent(usersFilenameTxt))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settingsLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLbl)
                    .addComponent(titleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersFilenameLbl)
                    .addComponent(usersFilenameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(booksFilenameLbl)
                    .addComponent(booksFilenameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(discardBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        doClose(1);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void discardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardBtnActionPerformed
        doClose(-1);
    }//GEN-LAST:event_discardBtnActionPerformed

    private void setup(Settings preset)
    {
        titleTxtField.setText(preset.get(preset.getKey(0)));
        usersFilenameTxt.setText((preset.get(preset.getKey(1))));
        booksFilenameTxt.setText(preset.get(preset.getKey(2)));
    }

    private void doClose(int retStatus)
    {
        returnStatus = retStatus;
        title = titleTxtField.getText();
        usersFilename = usersFilenameTxt.getText();
        booksFilename = booksFilenameTxt.getText();
        setVisible(false);
    }

    /**
     * Get the new title for the MainGUi
     * @return Get title from titleTxtField
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get the new Users file name
     * @return Users file name from usersFilenameTxt
     */
    public String getUsersFilename()
    {
        return usersFilename;
    }

    /**
     * Get the new Books file name
     * @return Books file name from booksFilenameTxt
     */
    public String getBooksFilename()
    {
        return booksFilename;
    }

    /**
     * Get the return status
     * @return -1:Discard|1:Save
     */
    public int getReturnStatus()
    {
        return returnStatus;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel booksFilenameLbl;
    private javax.swing.JTextField booksFilenameTxt;
    private javax.swing.JButton discardBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel settingsLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextField titleTxtField;
    private javax.swing.JLabel usersFilenameLbl;
    private javax.swing.JTextField usersFilenameTxt;
    // End of variables declaration//GEN-END:variables

    private int returnStatus;
    private String title;
    private String usersFilename;
    private String booksFilename;
    private Settings preset;
}
