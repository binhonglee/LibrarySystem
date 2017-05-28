package libsys;

public class MainGUI extends javax.swing.JFrame
{
  public MainGUI()
  {
    initComponents();
  }

  @SuppressWarnings("unchecked")

  //GEN-BEGIN:initComponents
  private void initComponents()
  {
    jPanel1 = new javax.swing.JPanel();
    jTabbedPane1 = new javax.swing.JTabbedPane();
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

    jTabbedPane1.addTab("Book", bookPanel);

    userMgtLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    userMgtLabel.setText("User Management");

    userSearchBtn.setText("Search");

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

    jTabbedPane1.addTab("User", userPanel);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(32, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 7, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }
  //GEN-END:initComponents

  //GEN-BEGIN:variables
  private javax.swing.JLabel bookID;
  private javax.swing.JLabel bookMgtLabel;
  private javax.swing.JPanel bookPanel;
  private javax.swing.JTextField bookSearch;
  private javax.swing.JButton bookSearchBtn;
  private javax.swing.JLabel bookStatus;
  private javax.swing.JLabel bookTitle;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTabbedPane jTabbedPane1;
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
