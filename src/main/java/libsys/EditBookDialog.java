package libsys;

public class EditBookDialog extends javax.swing.JDialog {

    public EditBookDialog(java.awt.Frame parent, boolean modal, Book book) {
        super(parent, modal);
        initComponents();
        this.book = book;
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        statusLbl = new javax.swing.JLabel();
        dueDateLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLbl.setText("Edit Book");

        idLbl.setText("ID :");

        nameLbl.setText("Name :");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        statusLbl.setText("Status :");

        dueDateLbl.setText("Due Date :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(cancelBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLbl)
                            .addComponent(idLbl)
                            .addComponent(statusLbl)
                            .addComponent(dueDateLbl))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTxtField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl)
                .addGap(18, 18, 18)
                .addComponent(idLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dueDateLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        doClose(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        doClose(true);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void init()
    {
        idLbl.setText("ID : " + (book.getId()));
        dueDateLbl.setText("Due date : " + book.getDueDate()[0] + "/" + book.getDueDate()[1] + "/" + book.getDueDate()[2]);
        statusLbl.setText("Status : " + book.getStatus());
        nameTxtField.setText(book.getTitle());
    }
    
    private void doClose(boolean toReturn)
    {
        if (toReturn)
        {
            returnStatus = toReturn;
            newName = nameTxtField.getText();
        }
        setVisible(false);
        dispose();
    }
    
    public String getNewName()
    {
        return newName;
    }
    
    public boolean getReturnStatus()
    {
        return returnStatus;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel dueDateLbl;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables

    private Book book;
    private String newName;
    private boolean returnStatus = false;
}
