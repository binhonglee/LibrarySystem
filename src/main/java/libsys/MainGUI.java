package libsys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({"unchecked", "serial"})

public class MainGUI extends javax.swing.JFrame
{
    Handler handler;

    public MainGUI(Handler handler)
    {
      this.handler = handler;
      initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        bookPanel = new javax.swing.JPanel();
        bookMgtLabel = new javax.swing.JLabel();
        bookSearch = new javax.swing.JTextField();
        bookSearchBtn = new javax.swing.JButton();
        bookTitle = new javax.swing.JLabel();
        bookStatus = new javax.swing.JLabel();
        bookID = new javax.swing.JLabel();
        bookDueDate = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        userMgtLabel = new javax.swing.JLabel();
        userSearch = new javax.swing.JTextField();
        userSearchBtn = new javax.swing.JButton();
        userName = new javax.swing.JLabel();
        userLimit = new javax.swing.JLabel();
        userID = new javax.swing.JLabel();
        userBooks = new javax.swing.JLabel();
        rentBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        bookMgtLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        bookMgtLabel.setText("Book Management");

        bookSearchBtn.setText("Search");
        bookSearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                bookSearchBtnActionPerformed(evt);
            }
        });

        bookTitle.setText("Title : ");

        bookStatus.setText("Status :");

        bookID.setText("ID :");

        bookDueDate.setText("Due Date :");

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookPanelLayout.createSequentialGroup()
                        .addComponent(bookSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bookSearchBtn))
                    .addGroup(bookPanelLayout.createSequentialGroup()
                        .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookTitle)
                            .addComponent(bookStatus)
                            .addComponent(bookMgtLabel)
                            .addComponent(bookID)
                            .addComponent(bookDueDate))
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookMgtLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookSearchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookDueDate)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Book", bookPanel);

        userMgtLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        userMgtLabel.setText("User Management");

        userSearchBtn.setText("Search");
        userSearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                userSearchBtnActionPerformed(evt);
            }
        });

        userName.setText("Name : ");

        userLimit.setText("Limit :");

        userID.setText("ID :");

        userBooks.setText("Books :");

        rentBtn.setText("Rent Another Book");
        rentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentBtnActionPerformed(evt);
            }
        });
        rentBtn.setVisible(false);

        returnBtn.setText("Return Book");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        rentBtn.setVisible(false);

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(userSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userSearchBtn))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userID)
                            .addComponent(userMgtLabel)
                            .addComponent(userName)
                            .addComponent(userBooks)
                            .addComponent(userLimit))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(returnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userMgtLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userSearchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLimit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userBooks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rentBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnBtn)
                .addContainerGap())
        );

        jTabbedPane.addTab("User", userPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed

        User thisUser = handler.users.getUser(Integer.parseInt(userSearch.getText()));
        ReturnDialog toReturnUI = new ReturnDialog(this, true, handler, thisUser.getId());
        toReturnUI.setVisible(true);
        int toReturnID = toReturnUI.getReturnStatus();

        if (toReturnID != -1)
        {
          handler.returnBook(thisUser, handler.books.getBook(toReturnID));
          userSearchBtnActionPerformed(evt);
          bookSearchBtnActionPerformed(evt);
        }
    }//GEN-LAST:event_returnBtnActionPerformed

    private void rentBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        User thisUser = handler.users.getUser(Integer.parseInt(userSearch.getText()));
        RentDialog toRentUI = new RentDialog(this, true, handler);
        toRentUI.setVisible(true);
        int toRentID = toRentUI.getReturnStatus();

        if (toRentID != -1)
        {
          handler.borrowBook(thisUser, handler.books.getBook(toRentID));
          userSearchBtnActionPerformed(evt);
          bookSearchBtnActionPerformed(evt);
        }
    }
    
    private void bookSearchBtnActionPerformed(ActionEvent evt)
    {
        try
        {
            Book thisBook = handler.books.getBook(Integer.parseInt(bookSearch.getText()));
            bookID.setText("ID : " + thisBook.getId());
            bookTitle.setText("Title : " + thisBook.getTitle());
            bookStatus.setText("Status : " + thisBook.getStatus());
            if ("RENTED".equals(thisBook.getStatus()))
            {
                bookDueDate.setText("Due date : " + thisBook.getDueDate()[0] + "/" + thisBook.getDueDate()[1] + "/" + thisBook.getDueDate()[2]);
            }
            else
            {
                bookDueDate.setText("Due date : ");
            }
        }
        catch (Exception e)
        {
            bookID.setText("ERROR : BOOK NOT FOUND");
            bookTitle.setText("");
            bookStatus.setText("");
            bookDueDate.setText("");
        }
    }

    private void userSearchBtnActionPerformed(ActionEvent evt)
    {
        try
        {
            User thisUser = handler.users.getUser(Integer.parseInt(userSearch.getText()));
            userID.setText("ID : " + thisUser.getId());
            userName.setText("Name : " + thisUser.getName());
            userLimit.setText("Limit : " + thisUser.getLimit());
            userBooks.setText("Books : " + handler.bookIdsToTitlesString(thisUser.bookStatus()));
            rentBtn.setVisible(thisUser.status());
            returnBtn.setVisible(thisUser.bookStatus().length > 0);
        }
        catch (Exception e)
        {
            userID.setText("ERROR : USER NOT FOUND");
            userName.setText("");
            userLimit.setText("");
            userBooks.setText("");
            rentBtn.setVisible(false);
            returnBtn.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookDueDate;
    private javax.swing.JLabel bookID;
    private javax.swing.JLabel bookMgtLabel;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JTextField bookSearch;
    private javax.swing.JButton bookSearchBtn;
    private javax.swing.JLabel bookStatus;
    private javax.swing.JLabel bookTitle;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton rentBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JLabel userBooks;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userLimit;
    private javax.swing.JLabel userMgtLabel;
    private javax.swing.JLabel userName;
    private javax.swing.JPanel userPanel;
    private javax.swing.JTextField userSearch;
    private javax.swing.JButton userSearchBtn;
    // End of variables declaration//GEN-END:variables
}
