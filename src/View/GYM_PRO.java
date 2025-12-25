/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Member;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controller.Logic;

/**
 *
 * @author Kritika Pandey
 */
public class GYM_PRO extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GYM_PRO.class.getName());

    // Declaration of CardLayouts.
    private java.awt.CardLayout cardLayoutBody;
    private java.awt.CardLayout cardLayoutMain;
    private java.awt.CardLayout cardLayoutAdmin;

    private Logic logicController = new Logic();

    /**
     * Creates new form NewJFrame
     */
    public GYM_PRO() {
        // initializing components for the GUI
        initComponents();
        // Initializing body layout for switching login and main page
        BodyLayout();
        // Initializing main layout for switiching home and admin page
        MainLayout();
        // Initializing admin layout for switching pages in admin page
        AdminLayout();

        logicController = new Logic();  // creates data
        initializeData();
    }

    // Initializing multiple data for the table and arraylist 
    private void initializeData() {
        // 1. Clear the table UI first so you don't get duplicates
        DefaultTableModel table = (DefaultTableModel) memberDatabase.getModel();
        table.setRowCount(0);

        // 2. Get the list that was populated in the Logic constructor
        List<Member> members = logicController.getMemberList();

        // 3. Loop through those 5 members and add them to the JTable
        for (Member m : members) {
            // We call a version of registerMember that ONLY updates the UI
            addRowToTable(m);
        }
    }

    /**
     * Initializes layout for frame as cardLayout
     */
    private void MainLayout() {
        cardLayoutMain = new CardLayout();
        // setting cardlayout to frame
        getContentPane().setLayout(cardLayoutMain);

        // adding panels (cards) in the frame
        getContentPane().add(Login, "LoginPanel");
        getContentPane().add(main, "MainPanel");

        // showing login panel as default
        changingMainPanels("LoginPanel");
    }

    /**
     * Initializes layout for body panels
     */
    private void BodyLayout() {
        cardLayoutBody = new CardLayout();
        body.setLayout(cardLayoutBody);

        // adding panels in the body
        body.add(home, "HomePage");
        body.add(admin, "AdminPage");

        // showing home page as dafault panel
        changingBodyPanels("HomePage");
    }

    /**
     * initializes admin layout
     */
    private void AdminLayout() {
        cardLayoutAdmin = new CardLayout();
        admin.setLayout(cardLayoutAdmin);

        // adding panels to admin panles
        admin.add(addMembers, "AdminAddMembers");
        admin.add(adminDashboard, "AdminDashboard");
        admin.add(updateMembers, "AdminUpdateMembers");

        // showing admin dashboard as default panel
        changingAdminPanels("AdminDashboard");
    }

    /**
     * changes panels of frame according to the panel passed to parameter
     *
     * @param panelName the panel to be shown in the frame
     */
    private void changingMainPanels(String panelName) {
        cardLayoutMain.show(getContentPane(), panelName);
    }

    /**
     * changes panels of body panel according to the panel passed to parameters
     *
     * @param panelName the panel to be shown in the body panel
     */
    private void changingBodyPanels(String panelName) {
        cardLayoutBody.show(body, panelName);
    }

    /**
     * changes panels of admin panel according to the panel passed to parameters
     *
     * @param panelName the panel to be shown in the admin panel
     */
    private void changingAdminPanels(String panelName) {
        cardLayoutAdmin.show(admin, panelName);
    }

    /**
     * This method loads the homepage after being called.
     */
    private void loadHomePage() {
        // changes page to home page
        changingBodyPanels("HomePage");
        // resets the admin page
        changingAdminPanels("AdminDashboard");
        // making the admin pages default 
        clearDashboardError();
        clearAddError();
        clearAddText();
        clearUpdateError();
        // Clearing selection of row in the table
        memberDatabase.clearSelection();
    }

    /**
     * This method loads the admin page after being called.
     */
    private void loadAdminPage() {
        // changes the page to admin page and show default page
        changingBodyPanels("AdminPage");
        changingBodyPanels("AdminDashboard");
    }

    /**
     * This method clears all the error messages in the admin dashboard page.
     */
    private void clearDashboardError() {
        adminError.setText("");
        addVerify.setText("");
        confirmation.setText("");

    }

    /**
     * This method clears text fields in the add panel
     */
    private void clearAddText() {
        // clearing the text fields in the add page
        nameField.setText("");
        idField.setText("");
        ageField.setText("");
        locationField.setText("");
    }

    /**
     * This method clears the error messages in the add panel
     */
    private void clearAddError() {
        // clearing errors in the add page
        addIdError.setText("");
        addNameError.setText("");
        addAgeError.setText("");
        addLocationError.setText("");

    }

    /**
     * This method clears the errors messages in the text field
     */
    private void clearUpdateError() {
        // clearing errors in the update page
        updateIdErorr.setText("");
        updateNameErorr.setText("");
        addAgeError.setText("");
        updateLocationErorr.setText("");
    }

    private void addRowToTable(Member member) {
        DefaultTableModel table = (DefaultTableModel) memberDatabase.getModel();
        table.addRow(new Object[]{
            member.getMemberId(),
            member.getName(),
            member.getAge(),
            member.getMembershipType(),
            member.getLocation(),
            member.getGender()
        });
    }

    private void registerNewMember(Member member) {
        // 1. Add to the Logic list
        logicController.getMemberList().add(member);
        // 2. Add to the JTable UI
        addRowToTable(member);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JPanel();
        intro = new javax.swing.JLabel();
        homepic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addMembers = new javax.swing.JPanel();
        CancelBtn = new javax.swing.JButton();
        age = new javax.swing.JLabel();
        membership = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        locationField = new javax.swing.JTextField();
        gender = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        genderBox = new javax.swing.JComboBox<>();
        memberBox = new javax.swing.JComboBox<>();
        addIdError = new javax.swing.JLabel();
        addNameError = new javax.swing.JLabel();
        addLocationError = new javax.swing.JLabel();
        addAgeError = new javax.swing.JLabel();
        addError = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        navlogo = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        navhome = new javax.swing.JLabel();
        navadmin = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        admin = new javax.swing.JPanel();
        adminDashboard = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        memberDatabase = new javax.swing.JTable();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        adminError = new javax.swing.JLabel();
        confirmation = new javax.swing.JLabel();
        addVerify = new javax.swing.JLabel();
        updateMembers = new javax.swing.JPanel();
        CancelBtnUp = new javax.swing.JButton();
        ageUp = new javax.swing.JLabel();
        membershipUp = new javax.swing.JLabel();
        idUp = new javax.swing.JLabel();
        nameUp = new javax.swing.JLabel();
        namefieldUp = new javax.swing.JTextField();
        agefieldUp = new javax.swing.JTextField();
        idfieldUp = new javax.swing.JTextField();
        addbtnUp = new javax.swing.JButton();
        locationfieldUp = new javax.swing.JTextField();
        locationUp = new javax.swing.JLabel();
        genderUp = new javax.swing.JLabel();
        genderboxUp = new javax.swing.JComboBox<>();
        updateIdErorr = new javax.swing.JLabel();
        updateLocationErorr = new javax.swing.JLabel();
        updateNameErorr = new javax.swing.JLabel();
        updateAgeErorr = new javax.swing.JLabel();
        memberboxUp = new javax.swing.JComboBox<>();
        updateErorr = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        bg_pic = new javax.swing.JLabel();
        Sub_login = new javax.swing.JPanel();
        loginname = new javax.swing.JLabel();
        loginnamefield = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameError = new javax.swing.JLabel();
        passwordError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        home.setBackground(new java.awt.Color(163, 73, 5));
        home.setPreferredSize(new java.awt.Dimension(920, 660));

        intro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        intro.setForeground(new java.awt.Color(255, 255, 255));
        intro.setText("INTRODUCTION");

        homepic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/homePic.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html>\nThis system is designed to simplify and automate the daily operations of a gym. It \nhelps manage members, track attendance, and handle administrative tasks efficiently. By\nproviding separate access for admins and users, the system ensures secure management, \naccurate records, and a smoother experience for both gym staff and members.\n</html>\n");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome to the Gym Management System");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(intro, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homepic, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(intro)
                        .addGap(12, 12, 12)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homeLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(homeLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(homepic, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        addMembers.setBackground(new java.awt.Color(163, 73, 5));
        addMembers.setPreferredSize(new java.awt.Dimension(882, 501));
        addMembers.setLayout(null);

        CancelBtn.setBackground(new java.awt.Color(163, 73, 5));
        CancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(255, 255, 204));
        CancelBtn.setText("Cancel");
        CancelBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        addMembers.add(CancelBtn);
        CancelBtn.setBounds(16, 14, 102, 40);

        age.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setText("Age");
        addMembers.add(age);
        age.setBounds(250, 200, 144, 37);

        membership.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        membership.setForeground(new java.awt.Color(255, 255, 255));
        membership.setText("MembershipType");
        addMembers.add(membership);
        membership.setBounds(490, 200, 203, 37);

        location.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        location.setForeground(new java.awt.Color(255, 255, 255));
        location.setText("Location");
        addMembers.add(location);
        location.setBounds(250, 313, 144, 37);

        name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name");
        addMembers.add(name);
        name.setBounds(500, 70, 144, 37);

        nameField.setBackground(new java.awt.Color(163, 73, 5));
        nameField.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addMembers.add(nameField);
        nameField.setBounds(490, 140, 218, 43);

        ageField.setBackground(new java.awt.Color(163, 73, 5));
        ageField.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        ageField.setForeground(new java.awt.Color(255, 255, 255));
        ageField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addMembers.add(ageField);
        ageField.setBounds(250, 252, 218, 43);

        idField.setBackground(new java.awt.Color(163, 73, 5));
        idField.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        idField.setForeground(new java.awt.Color(255, 255, 255));
        idField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addMembers.add(idField);
        idField.setBounds(250, 140, 218, 43);

        clearBtn.setBackground(new java.awt.Color(163, 73, 5));
        clearBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 204));
        clearBtn.setText("CLEAR");
        clearBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        addMembers.add(clearBtn);
        clearBtn.setBounds(250, 433, 220, 40);

        addBtn.setBackground(new java.awt.Color(163, 73, 5));
        addBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("ADD");
        addBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        addMembers.add(addBtn);
        addBtn.setBounds(490, 433, 220, 40);

        locationField.setBackground(new java.awt.Color(163, 73, 5));
        locationField.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        locationField.setForeground(new java.awt.Color(255, 255, 255));
        locationField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        locationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationFieldActionPerformed(evt);
            }
        });
        addMembers.add(locationField);
        locationField.setBounds(250, 363, 218, 43);

        gender.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setText("Gender");
        addMembers.add(gender);
        gender.setBounds(490, 313, 144, 37);

        id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID");
        addMembers.add(id);
        id.setBounds(250, 80, 144, 37);

        genderBox.setBackground(new java.awt.Color(163, 73, 5));
        genderBox.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        genderBox.setForeground(new java.awt.Color(255, 255, 255));
        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        genderBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addMembers.add(genderBox);
        genderBox.setBounds(490, 363, 220, 40);

        memberBox.setBackground(new java.awt.Color(163, 73, 5));
        memberBox.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        memberBox.setForeground(new java.awt.Color(255, 255, 255));
        memberBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Premium" }));
        memberBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addMembers.add(memberBox);
        memberBox.setBounds(486, 249, 222, 45);

        addIdError.setForeground(new java.awt.Color(255, 255, 51));
        addMembers.add(addIdError);
        addIdError.setBounds(250, 190, 210, 10);

        addNameError.setForeground(new java.awt.Color(255, 255, 0));
        addMembers.add(addNameError);
        addNameError.setBounds(490, 190, 220, 10);

        addLocationError.setForeground(new java.awt.Color(255, 255, 0));
        addMembers.add(addLocationError);
        addLocationError.setBounds(250, 410, 220, 10);

        addAgeError.setForeground(new java.awt.Color(255, 255, 0));
        addMembers.add(addAgeError);
        addAgeError.setBounds(250, 300, 220, 10);

        addError.setForeground(new java.awt.Color(255, 255, 0));
        addMembers.add(addError);
        addError.setBounds(490, 480, 220, 10);

        main.setBackground(new java.awt.Color(163, 73, 5));
        main.setPreferredSize(new java.awt.Dimension(920, 660));

        navbar.setBackground(new java.awt.Color(163, 73, 5));

        logout.setBackground(new java.awt.Color(163, 73, 5));
        logout.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 204));
        logout.setText("LOG OUT");
        logout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("GYM PRO  ");

        navhome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        navhome.setForeground(new java.awt.Color(255, 255, 255));
        navhome.setText("HOME");
        navhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navhomeMouseClicked(evt);
            }
        });

        navadmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        navadmin.setForeground(new java.awt.Color(255, 255, 255));
        navadmin.setText("ADMIN");
        navadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navadminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navhome, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(navadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navhome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(navbarLayout.createSequentialGroup()
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(navbarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body.setBackground(new java.awt.Color(163, 73, 5));

        admin.setBackground(new java.awt.Color(163, 73, 5));

        adminDashboard.setBackground(new java.awt.Color(163, 73, 5));

        memberDatabase.setBackground(new java.awt.Color(163, 73, 5));
        memberDatabase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        memberDatabase.setForeground(new java.awt.Color(255, 255, 255));
        memberDatabase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member_ID", "Name", "Age", "Membership_Type", "Location", "Gender"
            }
        ));
        jScrollPane2.setViewportView(memberDatabase);

        update.setBackground(new java.awt.Color(163, 73, 5));
        update.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update Member");
        update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(163, 73, 5));
        delete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete Member");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(163, 73, 5));
        add.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add Member");
        add.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("To add new members ,click the button below");

        adminError.setForeground(new java.awt.Color(255, 255, 0));

        confirmation.setForeground(new java.awt.Color(255, 255, 0));

        addVerify.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout adminDashboardLayout = new javax.swing.GroupLayout(adminDashboard);
        adminDashboard.setLayout(adminDashboardLayout);
        adminDashboardLayout.setHorizontalGroup(
            adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminDashboardLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminDashboardLayout.createSequentialGroup()
                            .addGroup(adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, adminDashboardLayout.createSequentialGroup()
                                    .addGroup(adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(adminError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, adminDashboardLayout.createSequentialGroup()
                                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)))))
        );
        adminDashboardLayout.setVerticalGroup(
            adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminDashboardLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(confirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout adminLayout = new javax.swing.GroupLayout(admin);
        admin.setLayout(adminLayout);
        adminLayout.setHorizontalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminLayout.setVerticalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        updateMembers.setBackground(new java.awt.Color(163, 73, 5));
        updateMembers.setPreferredSize(new java.awt.Dimension(882, 501));
        updateMembers.setLayout(null);

        CancelBtnUp.setBackground(new java.awt.Color(163, 73, 5));
        CancelBtnUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelBtnUp.setForeground(new java.awt.Color(255, 255, 204));
        CancelBtnUp.setText("Cancel");
        CancelBtnUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        CancelBtnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnUpActionPerformed(evt);
            }
        });
        updateMembers.add(CancelBtnUp);
        CancelBtnUp.setBounds(16, 14, 102, 40);

        ageUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ageUp.setForeground(new java.awt.Color(255, 255, 255));
        ageUp.setText("Age");
        updateMembers.add(ageUp);
        ageUp.setBounds(230, 190, 144, 37);

        membershipUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        membershipUp.setForeground(new java.awt.Color(255, 255, 255));
        membershipUp.setText("MembershipType");
        updateMembers.add(membershipUp);
        membershipUp.setBounds(470, 200, 203, 37);

        idUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        idUp.setForeground(new java.awt.Color(255, 255, 255));
        idUp.setText("ID");
        updateMembers.add(idUp);
        idUp.setBounds(240, 80, 144, 37);

        nameUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nameUp.setForeground(new java.awt.Color(255, 255, 255));
        nameUp.setText("Name");
        updateMembers.add(nameUp);
        nameUp.setBounds(480, 80, 144, 37);

        namefieldUp.setBackground(new java.awt.Color(163, 73, 5));
        namefieldUp.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        namefieldUp.setForeground(new java.awt.Color(255, 255, 255));
        namefieldUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        namefieldUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namefieldUpActionPerformed(evt);
            }
        });
        updateMembers.add(namefieldUp);
        namefieldUp.setBounds(460, 120, 218, 43);

        agefieldUp.setBackground(new java.awt.Color(163, 73, 5));
        agefieldUp.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        agefieldUp.setForeground(new java.awt.Color(255, 255, 255));
        agefieldUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        updateMembers.add(agefieldUp);
        agefieldUp.setBounds(230, 240, 218, 43);

        idfieldUp.setBackground(new java.awt.Color(163, 73, 5));
        idfieldUp.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        idfieldUp.setForeground(new java.awt.Color(255, 255, 255));
        idfieldUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        updateMembers.add(idfieldUp);
        idfieldUp.setBounds(230, 120, 218, 43);

        addbtnUp.setBackground(new java.awt.Color(163, 73, 5));
        addbtnUp.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        addbtnUp.setForeground(new java.awt.Color(255, 255, 255));
        addbtnUp.setText("Update");
        addbtnUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addbtnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnUpActionPerformed(evt);
            }
        });
        updateMembers.add(addbtnUp);
        addbtnUp.setBounds(470, 420, 220, 40);

        locationfieldUp.setBackground(new java.awt.Color(163, 73, 5));
        locationfieldUp.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        locationfieldUp.setForeground(new java.awt.Color(255, 255, 255));
        locationfieldUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        updateMembers.add(locationfieldUp);
        locationfieldUp.setBounds(230, 350, 218, 43);

        locationUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        locationUp.setForeground(new java.awt.Color(255, 255, 255));
        locationUp.setText("Location");
        updateMembers.add(locationUp);
        locationUp.setBounds(230, 310, 144, 37);

        genderUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        genderUp.setForeground(new java.awt.Color(255, 255, 255));
        genderUp.setText("Gender");
        updateMembers.add(genderUp);
        genderUp.setBounds(480, 300, 144, 37);

        genderboxUp.setBackground(new java.awt.Color(163, 73, 5));
        genderboxUp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        genderboxUp.setForeground(new java.awt.Color(255, 255, 255));
        genderboxUp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        genderboxUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        updateMembers.add(genderboxUp);
        genderboxUp.setBounds(470, 350, 220, 40);

        updateIdErorr.setForeground(new java.awt.Color(255, 255, 0));
        updateMembers.add(updateIdErorr);
        updateIdErorr.setBounds(230, 170, 210, 0);

        updateLocationErorr.setForeground(new java.awt.Color(255, 255, 0));
        updateMembers.add(updateLocationErorr);
        updateLocationErorr.setBounds(230, 410, 210, 20);

        updateNameErorr.setForeground(new java.awt.Color(255, 255, 0));
        updateMembers.add(updateNameErorr);
        updateNameErorr.setBounds(460, 170, 210, 20);

        updateAgeErorr.setForeground(new java.awt.Color(255, 255, 0));
        updateMembers.add(updateAgeErorr);
        updateAgeErorr.setBounds(230, 290, 210, 20);

        memberboxUp.setBackground(new java.awt.Color(163, 73, 5));
        memberboxUp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        memberboxUp.setForeground(new java.awt.Color(255, 255, 255));
        memberboxUp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Premium" }));
        memberboxUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        updateMembers.add(memberboxUp);
        memberboxUp.setBounds(470, 240, 210, 40);

        updateErorr.setForeground(new java.awt.Color(255, 255, 0));
        updateMembers.add(updateErorr);
        updateErorr.setBounds(470, 470, 210, 20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(930, 660));
        setMinimumSize(new java.awt.Dimension(930, 660));
        setPreferredSize(new java.awt.Dimension(930, 660));

        Login.setBackground(new java.awt.Color(163, 73, 5));
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loginPic.jpg"))); // NOI18N
        Login.add(bg_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 650));

        Sub_login.setBackground(new java.awt.Color(255, 255, 255));

        loginname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginname.setText("Name");

        loginnamefield.setBackground(new java.awt.Color(239, 239, 239));

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setText("Password");

        passwordField.setBackground(new java.awt.Color(239, 239, 239));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        login.setBackground(new java.awt.Color(96, 91, 80));
        login.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 91, 80));
        jLabel4.setText("Secured login portal ");

        nameError.setForeground(new java.awt.Color(204, 0, 0));

        passwordError.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout Sub_loginLayout = new javax.swing.GroupLayout(Sub_login);
        Sub_login.setLayout(Sub_loginLayout);
        Sub_loginLayout.setHorizontalGroup(
            Sub_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sub_loginLayout.createSequentialGroup()
                .addGroup(Sub_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Sub_loginLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Sub_loginLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel4))
                    .addGroup(Sub_loginLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(Sub_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password)
                            .addComponent(loginname, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginnamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(passwordField)
                            .addComponent(nameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        Sub_loginLayout.setVerticalGroup(
            Sub_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sub_loginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(loginname)
                .addGap(18, 18, 18)
                .addComponent(loginnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(nameError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addGap(32, 32, 32))
        );

        Login.add(Sub_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GYM PRO");
        Login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 240, 80));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png"))); // NOI18N
        Login.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 160, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        clearDashboardError();
        // getting the selected table row
        int tableIndex = memberDatabase.getSelectedRow();

        // if no row is selected, then show error message
        if (tableIndex == -1) {
            adminError.setText("One row from the table should be selected to Update");
        } else {
            // in case of sorted data, extract the index of the selected data from the sorted arraylist
            int listIndex = memberDatabase.convertRowIndexToModel(tableIndex);

            // get the object of the Member from the arraylist
            Member member = logicController.getMemberList().get(listIndex);
            // using getter methods to extract values from the arraylist
            String id = member.getMemberId();
            String name = member.getName();
            String age = String.valueOf(member.getAge());
            String location = member.getLocation();
            String gender = member.getGender();
            String membership = member.getMembershipType();

            // Clearing errors in the update page
            clearUpdateError();

            // setting the getting values from the selected object of Member 
            changingAdminPanels("AdminUpdateMembers");
            idfieldUp.setText(id);
            namefieldUp.setText(name);
            agefieldUp.setText(age);
            locationfieldUp.setText(location);

            // Setting the values for JComboBoxes
            genderboxUp.setSelectedItem(gender);
            memberboxUp.setSelectedItem(membership);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void namefieldUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namefieldUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namefieldUpActionPerformed
    /**
     * Authenticating user by validating credentials entered by the user
     *
     * @param evt the mouse event triggered after clicking on login label
     */
    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        // extracting username and password from the fields
        String username = loginnamefield.getText();
        String password = new String(passwordField.getPassword());

        //Setting the errors to empty
        nameError.setText("");
        passwordError.setText("");
        // check if username is empty
        if (username.isEmpty()) {
            nameError.setText("Username Required");
        }

// check if password is empty
        if (password.isEmpty()) {
            passwordError.setText("Password Required");
        }

// validate username and password only if both are filled
        if (!username.isEmpty() && !password.isEmpty()) {

            // correct login
            if (username.equals("admin") && password.equals("admin")) {
                loginnamefield.setText("");
                passwordField.setText("");
                changingMainPanels("MainPanel");

            } else {
                // username incorrect
                if (!username.equals("admin")) {
                    nameError.setText("Username not found");
                }

                // password incorrect
                if (username.equals("admin") && !password.equals("admin")) {
                    passwordError.setText("Password Incorrect");
                }
            }
        }
    }//GEN-LAST:event_loginMouseClicked

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // ask for confirmation
        int response = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to log out?",
                "CONFIRMATION",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

// if logout confirmed
        if (response == JOptionPane.YES_OPTION) {

            // switch back to login panel
            changingMainPanels("LoginPanel");
        }

    }//GEN-LAST:event_logoutActionPerformed

    private void locationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationFieldActionPerformed

    private void navhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navhomeMouseClicked
        // changes the page to home page.
        loadHomePage();
    }//GEN-LAST:event_navhomeMouseClicked

    private void navadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navadminMouseClicked
        // loads the admin page with default admin dashboard page
        loadAdminPage();
    }//GEN-LAST:event_navadminMouseClicked

    private void addbtnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnUpActionPerformed
        // clear all errors after clicking the button
        clearUpdateError();
        try {
            // Get the updated data from the text fields and combo boxes
            String id = idfieldUp.getText();
            String name = namefieldUp.getText();
            String ageStr = agefieldUp.getText();
            String location = locationfieldUp.getText();
            String membership = memberboxUp.getSelectedItem().toString();
            String gender = genderboxUp.getSelectedItem().toString();

            boolean empty = false;
            boolean valid = true;

            // validating ID (Internal validation without .util)
            if (id == null || id.trim().isEmpty()) {
                updateIdErorr.setText("Member ID required");
                empty = true;
            } else if (!id.matches("^Mem\\d{3}$")) {
                updateIdErorr.setText("Invalid. Eg: Mem001");
                valid = false;
            }

            // validating Name
            if (name == null || name.trim().isEmpty()) {
                updateNameErorr.setText("Member name required");
                empty = true;
            } else if (!name.matches("^[a-zA-Z\\s]+$")) {
                updateNameErorr.setText("Invalid. Should be Alphabets");
                valid = false;
            }

            // validating Age
            if (ageStr == null || ageStr.trim().isEmpty()) {
                updateAgeErorr.setText("Age required.");
                empty = true;
            } else {
                try {
                    int numAge = Integer.parseInt(ageStr);
                    if (numAge < 16 || numAge > 100) {
                        updateAgeErorr.setText("Invalid. Age must be 16-100");
                        valid = false;
                    }
                } catch (NumberFormatException ex) {
                    updateAgeErorr.setText("Should be a number.");
                    valid = false;
                }
            }

            // if any fields are empty or invalid, stop the process
            if (empty || !valid) {
                return;
            }

            // get the index of the object in the table
            int tableIndex = memberDatabase.getSelectedRow();
            int listIndex = memberDatabase.convertRowIndexToModel(tableIndex);

            // Retrieve the Member object from the ArrayList
            Member member = logicController.getMemberList().get(listIndex);

            // While updating, the ID should remain the same
            if (member.getMemberId().equals(id)) {
                // Check if any changes were actually made
                if (member.getName().equals(name)
                        && member.getAge() == Integer.parseInt(ageStr)
                        && member.getMembershipType().equals(membership)
                        && member.getLocation().equals(location)
                        && member.getGender().equals(gender)) {
                    updateErorr.setText("Please alter something to update.");
                } else {
                    // ask for confirmation
                    int response = JOptionPane.showConfirmDialog(this,
                            "Update member: " + id + "?"
                            + "\nName: " + name + "\nAge: " + ageStr
                            + "\nMembership: " + membership + "\nLocation: " + location
                            + "\nGender: " + gender,
                            "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        // Update the Member object
                        member.setName(name);
                        member.setAge(Integer.parseInt(ageStr));
                        member.setMembershipType(membership);
                        member.setLocation(location);
                        member.setGender(gender);

                        // Updating the table row based on your specific column order
                        memberDatabase.setValueAt(id, tableIndex, 0);         // ID
                        memberDatabase.setValueAt(name, tableIndex, 1);       // Name
                        memberDatabase.setValueAt(ageStr, tableIndex, 2);     // Age
                        memberDatabase.setValueAt(membership, tableIndex, 3); // Membership
                        memberDatabase.setValueAt(location, tableIndex, 4);   // Location
                        memberDatabase.setValueAt(gender, tableIndex, 5);     // Gender

                        memberDatabase.revalidate();

                        clearDashboardError();

                        // Switch back to dashboard
                        changingAdminPanels("AdminDashboard");
                        confirmation.setText("Member Information has been successfully updated.");
                    }
                }
            } else {
                updateErorr.setText("Member Id cannot be changed.");
            }
        } catch (Exception ex) {
            // Handle unexpected errors
        }
    }//GEN-LAST:event_addbtnUpActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        clearDashboardError();
        // extracting the index of selected row from the table
        int tableIndex = memberDatabase.getSelectedRow();

        // if no row is selected, display error message
        if (tableIndex == -1) {
            adminError.setText("One row from the table should be selected to Delete");
        } else {
            // ask for confirmation of row deletion 
            int response = JOptionPane.showConfirmDialog(this, "Do you want to proceed?",
                    "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            // if deletion confirmed then
            if (response == JOptionPane.YES_OPTION) {
                // in case of table being sorted, extract the index of the sorted list
                int listIndex = memberDatabase.convertRowIndexToModel(tableIndex);

                // remove the element from the arraylist
                Member member = logicController.getMemberList().get(listIndex);

                // typecasting the table to DefaultTableModel
                DefaultTableModel table = (DefaultTableModel) memberDatabase.getModel();
                // removing the row from the table
                table.removeRow(tableIndex);

                // display confirmation message
                confirmation.setText("Member information has been successfully deleted");
                adminError.setText("");
            } else {
                // data deletion cancellation message
                confirmation.setText("Member information deletion has been cancelled");
                adminError.setText("");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        changingAdminPanels("AdminAddMembers");
    }//GEN-LAST:event_addActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // clearing textfields and error in add panel
        clearAddText();
        clearAddError();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        clearAddError();

        // using try catch for checking if age is a number
        try {
            // extracting texts from the textfields and values from comboboxes
            String id = idField.getText();
            String name = nameField.getText();
            String ageStr = ageField.getText();
            String membership = memberBox.getSelectedItem().toString();
            String location = locationField.getText();

            // Extracting from JComboBox using your field names
            String gender = genderBox.getSelectedItem().toString();

            // declaring and initializing empty and valid as false and true
            boolean empty = false;
            boolean valid = true;

            // validating id (Built-in validation)
            if (id == null || id.trim().isEmpty()) {
                addIdError.setText("Member ID required.");
                empty = true;
            } else if (!id.matches("^Mem\\d{3}$")) {
                addIdError.setText("Invalid. Eg: Mem001");
                valid = false;
            }

            // validating name (Built-in validation)
            if (name == null || name.trim().isEmpty()) {
                addNameError.setText("Name required.");
                empty = true;
            } else if (!name.matches("^[a-zA-Z\\s]+$")) {
                addNameError.setText("Invalid. Should contain only Alphabets.");
                valid = false;
            }

            // validating age (Built-in validation)
            if (ageStr == null || ageStr.trim().isEmpty()) {
                addAgeError.setText("Age required.");
                empty = true;
            } else {
                try {
                    int numAge = Integer.parseInt(ageStr);
                    if (numAge < 16 || numAge > 80) {
                        addAgeError.setText("Invalid. Age must be 16 to 80.");
                        valid = false;
                    }
                } catch (NumberFormatException ex) {
                    addAgeError.setText("Should be a number");
                    valid = false;
                }
            }

            // validating location
            if (location == null || location.trim().isEmpty()) {
                addLocationError.setText("Location required.");
                empty = true;
            }

            // if any fields are empty or validation error, stop the process
            if (empty || !valid) {
                return;
            }

            // Check if Member ID already exists in the array list
            boolean found = false;
            for (Member member : logicController.getMemberList()) {
                if (member.getMemberId().equals(id)) {
                    found = true;
                    break;
                }
            }

            // If the member is not found, then add the member to the arraylist and also to the table.
            if (!found) {
                // creating new object of Member
                Member newMember = new Member(
                        id,
                        name,
                        Integer.parseInt(ageStr),
                        membership,
                        location,
                        gender);

                // registering or adding the object to the table and array list
                registerNewMember(newMember);

                // clearing text fields and resetting comboboxes
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                locationField.setText("");
                genderBox.setSelectedIndex(0);
                memberBox.setSelectedIndex(0);

                clearAddError();

                // Changing admin panels to admin dashboard
                changingAdminPanels("AdminDashboard");

                confirmation.setText("Member Information has been successfully Added");
            } else if (found && valid) {
                // display already exists message if the member id is found.
                addError.setText("This member ID already exists.");
            }
        } catch (Exception ex) {
            // General catch for unexpected errors
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // ask for confirmation of cancel adding
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel adding?",
                "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // if confirmed to cancel then
        if (response == JOptionPane.YES_OPTION) {
            changingAdminPanels("AdminDashboard");
            clearAddText();
            clearAddError();
            confirmation.setText("New medicine data creation has been cancelled.");
        }
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void CancelBtnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnUpActionPerformed
        // ask for confirmation of cancel adding
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel adding?",
                "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // if confirmed to cancel then
        if (response == JOptionPane.YES_OPTION) {
            changingAdminPanels("AdminDashboard");
            clearAddText();
            clearAddError();
            confirmation.setText("New medicine data update has been cancelled.");
        }
    }//GEN-LAST:event_CancelBtnUpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GYM_PRO().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CancelBtnUp;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Sub_login;
    private javax.swing.JButton add;
    private javax.swing.JLabel addAgeError;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addError;
    private javax.swing.JLabel addIdError;
    private javax.swing.JLabel addLocationError;
    private javax.swing.JPanel addMembers;
    private javax.swing.JLabel addNameError;
    private javax.swing.JLabel addVerify;
    private javax.swing.JButton addbtnUp;
    private javax.swing.JPanel admin;
    private javax.swing.JPanel adminDashboard;
    private javax.swing.JLabel adminError;
    private javax.swing.JLabel age;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageUp;
    private javax.swing.JTextField agefieldUp;
    private javax.swing.JLabel bg_pic;
    private javax.swing.JPanel body;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel confirmation;
    private javax.swing.JButton delete;
    private javax.swing.JLabel gender;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JLabel genderUp;
    private javax.swing.JComboBox<String> genderboxUp;
    private javax.swing.JPanel home;
    private javax.swing.JLabel homepic;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idUp;
    private javax.swing.JTextField idfieldUp;
    private javax.swing.JLabel intro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel location;
    private javax.swing.JTextField locationField;
    private javax.swing.JLabel locationUp;
    private javax.swing.JTextField locationfieldUp;
    private javax.swing.JButton login;
    private javax.swing.JLabel loginname;
    private javax.swing.JTextField loginnamefield;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logout;
    private javax.swing.JPanel main;
    private javax.swing.JComboBox<String> memberBox;
    private javax.swing.JTable memberDatabase;
    private javax.swing.JComboBox<String> memberboxUp;
    private javax.swing.JLabel membership;
    private javax.swing.JLabel membershipUp;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameUp;
    private javax.swing.JTextField namefieldUp;
    private javax.swing.JLabel navadmin;
    private javax.swing.JPanel navbar;
    private javax.swing.JLabel navhome;
    private javax.swing.JLabel navlogo;
    private javax.swing.JLabel password;
    private javax.swing.JLabel passwordError;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel title;
    private javax.swing.JButton update;
    private javax.swing.JLabel updateAgeErorr;
    private javax.swing.JLabel updateErorr;
    private javax.swing.JLabel updateIdErorr;
    private javax.swing.JLabel updateLocationErorr;
    private javax.swing.JPanel updateMembers;
    private javax.swing.JLabel updateNameErorr;
    // End of variables declaration//GEN-END:variables
}
