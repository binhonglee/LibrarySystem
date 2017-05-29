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

  //GEN-BEGIN:initComponents
  private void initComponents()
  {
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    mainPanel = new javax.swing.JPanel();
    jTabbedPane = new javax.swing.JTabbedPane();
    bookPanel = new javax.swing.JPanel();
    bookMgtLabel = new javax.swing.JLabel();
    bookSearch = new javax.swing.JTextField();
    bookSearchBtn = new javax.swing.JButton();
    bookTitle = new javax.swing.JLabel();
    bookStatus = new javax.swing.JLabel();
    bookID = new javax.swing.JLabel();
    userPanel = new javax.swing.JPanel();
    userMgtLabel = new javax.swing.JLabel();
    userSearch = new javax.swing.JTextField();
    userSearchBtn = new javax.swing.JButton();
    userName = new javax.swing.JLabel();
    userLimit = new javax.swing.JLabel();
    userID = new javax.swing.JLabel();
    userBooks = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    bookMgtLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    bookMgtLabel.setText("Book Management");

    bookSearchBtn.setText("Search");
    bookSearchBtn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        bookSearchBtnActionPerformed(evt);
      }
    });

    bookTitle.setText("Title : ");

    bookStatus.setText("Status :");

    bookID.setText("ID :");

    javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
    bookPanel.setLayout(bookPanelLayout);
    bookPanelLayout.setHorizontalGroup(
        bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(bookPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bookMgtLabel)
                .addGroup(bookPanelLayout.createSequentialGroup()
                    .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bookSearchBtn))
                .addComponent(bookTitle)
                .addComponent(bookStatus)
                .addComponent(bookID))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    bookPanelLayout.setVerticalGroup(
        bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(bookPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(bookMgtLabel)
            .addGap(18, 18, 18)
            .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bookSearchBtn))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bookID)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bookTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bookStatus)
            .addContainerGap(38, Short.MAX_VALUE))
    );

    jTabbedPane.addTab("Book", bookPanel);

    userMgtLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    userMgtLabel.setText("User Management");

    userSearchBtn.setText("Search");
    userSearchBtn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        userSearchBtnActionPerformed(evt);
      }
    });

    userName.setText("Name : ");

    userLimit.setText("Limit :");

    userID.setText("ID :");

    userBooks.setText("Books :");

    javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
    userPanel.setLayout(userPanelLayout);
    userPanelLayout.setHorizontalGroup(
        userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(userPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(userPanelLayout.createSequentialGroup()
                    .addComponent(userSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userSearchBtn))
                .addGroup(userPanelLayout.createSequentialGroup()
                    .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userMgtLabel)
                        .addComponent(userName)
                        .addComponent(userID)
                        .addComponent(userBooks)
                        .addComponent(userLimit))
                    .addGap(0, 0, Short.MAX_VALUE)))
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
            .addContainerGap(28, Short.MAX_VALUE))
    );

    jTabbedPane.addTab("User", userPanel);

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(32, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 7, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }
  //GEN-END:initComponents

  private void bookSearchBtnActionPerformed(ActionEvent evt)
  {
    Book thisBook = handler.books.getBook(0);
    bookID.setText("ID : " + thisBook.getId());
    bookTitle.setText("Title : " + thisBook.getTitle());
    bookStatus.setText("Status : " + thisBook.getStatus());
  }

  private void userSearchBtnActionPerformed(ActionEvent evt)
  {
    User thisUser = handler.users.getUser(0);
    userID.setText("ID : " + thisUser.getId());
    userName.setText("Name : " + thisUser.getName());
    userLimit.setText("Limit : " + thisUser.getLimit());
    userBooks.setText("Books : " + handler.bookIdsToTitlesString(thisUser.bookStatus()));
  }

  //GEN-BEGIN:variables
  private javax.swing.JLabel bookID;
  private javax.swing.JLabel bookMgtLabel;
  private javax.swing.JPanel bookPanel;
  private javax.swing.JTextField bookSearch;
  private javax.swing.JButton bookSearchBtn;
  private javax.swing.JLabel bookStatus;
  private javax.swing.JLabel bookTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTabbedPane jTabbedPane;
  private javax.swing.JLabel userBooks;
  private javax.swing.JLabel userID;
  private javax.swing.JLabel userLimit;
  private javax.swing.JLabel userMgtLabel;
  private javax.swing.JLabel userName;
  private javax.swing.JPanel userPanel;
  private javax.swing.JTextField userSearch;
  private javax.swing.JButton userSearchBtn;
  //GEN-END:variables
}
