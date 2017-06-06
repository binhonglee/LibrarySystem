package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

/**
 * Main Graphic User Interface
 */
@SuppressWarnings({"unchecked", "serial"})
public class MainGUI extends javax.swing.JFrame
{
    Handler handler;
    Settings settings;
    Book book;
    User user;
    boolean bookExist = false;
    boolean userExist = false;

    /**
     * Creates a new MainGUI
     * @param  handler       Given Handler from Main
     * @param  settings      Given Settings from Main
     */
    public MainGUI(Handler handler, Settings settings)
    {
      this.handler = handler;
      this.settings = settings;
      initComponents();
      nameLabel.setText(settings.get(settings.getKey(0)));
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
        editBookBtn = new javax.swing.JButton();
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
        editUserBtn = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        createBookBtn = new javax.swing.JButton();
        createUserBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();

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

        editBookBtn.setVisible(false);
        editBookBtn.setText("Edit");
        editBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookBtnActionPerformed(evt);
            }
        });

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
                            .addComponent(bookID))
                        .addGap(0, 214, Short.MAX_VALUE))
                    .addGroup(bookPanelLayout.createSequentialGroup()
                        .addComponent(bookDueDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editBookBtn)))
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
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookDueDate)
                    .addComponent(editBookBtn))
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
        returnBtn.setVisible(false);

        editUserBtn.setVisible(false);
        editUserBtn.setText("Edit");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });

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
                    .addComponent(returnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userMgtLabel)
                            .addComponent(userName)
                            .addComponent(userBooks))
                        .addGap(0, 219, Short.MAX_VALUE))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userID)
                            .addComponent(userLimit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editUserBtn)))
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
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(userID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userLimit))
                    .addComponent(editUserBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userBooks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(rentBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnBtn)
                .addContainerGap())
        );

        jTabbedPane.addTab("User", userPanel);

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        nameLabel.setText("Welcome to the library");

        createBookBtn.setText("Add new book");
        createBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookBtnActionPerformed(evt);
            }
        });

        createUserBtn.setText("Add new user");
        createUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserBtnActionPerformed(evt);
            }
        });

        settingsBtn.setText("Settings");
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(createBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(settingsBtn)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsBtn))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        SettingsDialog settingsUI = new SettingsDialog(this, true, settings);

        settingsUI.setVisible(true);

        if (settingsUI.getReturnStatus() != -1)
        {
            settings.setTitle(settingsUI.getTitle());
            settings.setUsersFilename(settingsUI.getUsersFilename());
            settings.setBooksFilename(settingsUI.getBooksFilename());
            nameLabel.setText(settingsUI.getTitle());
        }
    }//GEN-LAST:event_settingsBtnActionPerformed

    private void createUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserBtnActionPerformed
        NewUserDialog newUserUI = new NewUserDialog(this, true);
        newUserUI.setVisible(true);

        if (newUserUI.getReturnStatus() != -1)
        {
            userSearch.setText(String.valueOf(handler.users.newUser(newUserUI.getName(), newUserUI.getLimit()).getId()));
            userSearchBtnActionPerformed(evt);
        }
    }//GEN-LAST:event_createUserBtnActionPerformed

    private void createBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBookBtnActionPerformed
        NewBookDialog newBookUI = new NewBookDialog(this, true);
        newBookUI.setVisible(true);

        if (newBookUI.getReturnStatus() != -1)
        {
            bookSearch.setText(String.valueOf(handler.books.newBook(newBookUI.getTitle(), newBookUI.getStatus()).getId()));
            bookSearchBtnActionPerformed(evt);
        }
    }//GEN-LAST:event_createBookBtnActionPerformed

    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        EditUserDialog editUserDialog = new EditUserDialog(this, true, user, handler.books);
        editUserDialog.setVisible(true);

        if (editUserDialog.getReturnStatus())
        {
            User newUser = user;
            user.setName(editUserDialog.getNewName());
            user.setLimit(editUserDialog.getNewLimit());
        }

        userSearchBtnActionPerformed(evt);
    }//GEN-LAST:event_editUserBtnActionPerformed

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

    private void rentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentBtnActionPerformed
        User thisUser = handler.users.getUser(Integer.parseInt(userSearch.getText()));
        RentDialog toRentUI = new RentDialog(this, true, handler);
        toRentUI.setVisible(true);
        int toRentID = toRentUI.getReturnStatus();

        if (toRentID != -1)
        {
          handler.borrowBook(thisUser, handler.books.getBook(toRentID));
          userSearchBtnActionPerformed(evt);
          bookSearchBtnActionPerformed(evt);
        }    }//GEN-LAST:event_rentBtnActionPerformed

    private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookBtnActionPerformed
        EditBookDialog editBookDialog = new EditBookDialog(this, true, book);
        editBookDialog.setVisible(true);

        if (editBookDialog.getReturnStatus())
        {
            Book newBook = book;
            book.setTitle(editBookDialog.getNewName());
            handler.books.update(book, newBook);
        }
        bookSearchBtnActionPerformed(evt);
    }//GEN-LAST:event_editBookBtnActionPerformed

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
            book = thisBook;
            bookExist = true;
            editBookBtn.setVisible(true);
        }
        catch (Exception e)
        {
            bookID.setText("ERROR : BOOK NOT FOUND");
            bookTitle.setText("");
            bookStatus.setText("");
            bookDueDate.setText("");
            bookExist = false;
            editBookBtn.setVisible(false);
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
            editUserBtn.setVisible(true);
            user = thisUser;
            userExist = true;
        }
        catch (Exception e)
        {
            userID.setText("ERROR : USER NOT FOUND");
            userName.setText("");
            userLimit.setText("");
            userBooks.setText("");
            rentBtn.setVisible(false);
            returnBtn.setVisible(false);
            userExist = false;
            editUserBtn.setVisible(false);
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
    private javax.swing.JButton createBookBtn;
    private javax.swing.JButton createUserBtn;
    private javax.swing.JButton editBookBtn;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton rentBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton settingsBtn;
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
