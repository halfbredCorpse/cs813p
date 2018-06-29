/*
 * To change this li    @Override
    public int getWidth(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageProducer getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graphics getGraphics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProperty(String name, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
cense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapp;

import AppPackage.AnimationClass;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jasmin Rose
 */
public class MainFrame extends javax.swing.JFrame {
    
    CommonDesign cd;
    CardLayout cardLayout;
    Color hoverColor;
    Color selectedColor;
    Color textColor;
    ButtonGroup navBtnGroup;
    
    AnimationClass AC = new AnimationClass();
    
    int px,py;
    int slideCount = 0;
    
    private final String username;
    List<Object> user;
    
    /**
     * Creates new form MainFrame
     * @param username
     */
    public MainFrame(String username) {
        this.username = username;
        user = getAccountDetails(username);
        
        navBtnGroup = new ButtonGroup();
        cd = new CommonDesign(this);
        initComponents();
        
        cardLayout = (CardLayout) contentCards.getLayout();
        
        cd.changeAllFont(mainPanel, cd.createFont("fonts/CircularStd-Bold.otf", 14));
        
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(18F));
        
        selectedColor = new Color(221, 188, 149);
        hoverColor = new Color(205,205,192);
        textColor = new Color(98,109,113);
        
        btnHome.setBackground(selectedColor);
        btnHome.setForeground(Color.WHITE);
        
        /*
        JFXPanel webPanel = new JFXPanel();
     
        webPanel.setBounds(600, 50, 300, 500);
        jPanel2.add(webPanel);
        
        Platform.runLater(() -> { // FX components need to be managed by JavaFX
            WebView webView = new WebView();
            File file = new File("src/desktopapp/webApp/Home.html");
            webView.getEngine().load(file.toURI().toString());//("http://10.1.11.21:8080/hello1b_Aguas/");
            webPanel.setScene( new Scene( webView ) );
        });*/
        runSlideShow();
    }

    public void loopBtns(ButtonGroup btnGroup) {
        for (Enumeration<AbstractButton> buttons = btnGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                button.setSelected(false);
                button.setBackground(Color.WHITE);
                button.setForeground(textColor);
            } else {
                button.setSelected(true);
                button.setBackground(selectedColor);
                button.setSelected(true);
            }
        }
    }
    
    public void runSlideShow() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while(true){
                        switch(slideCount) {
                            case 0:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 10, 20, slide1);
                                AC.jLabelXLeft(1240, 0, 10, 20, slide2);
                                AC.jLabelXLeft(2480, 1240, 10, 20, slide3);
                                
                                slideCount = 1;
                                break;
                            case 1:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 10, 20, slide2);
                                AC.jLabelXLeft(1240, 0, 10, 20, slide3);
                                AC.jLabelXLeft(3720, 1240, 10, 20, slide4);
                                
                                slideCount = 2;
                                break;
                            case 2:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 10, 20, slide3);
                                AC.jLabelXLeft(1240, 0, 10, 20, slide4);
                                AC.jLabelXLeft(4960, 1240, 10, 20, slide5);     
                                
                                slideCount = 3;
                                break;
                            case 3:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 10, 20, slide4);
                                AC.jLabelXLeft(1240, 0, 10, 20, slide5);
                                        
                                slideCount = 4;
                                break;
                            case 4:
                                Thread.sleep(5000);
                                
                                AC.jLabelXRight(0, 1240, 10, 20, slide5);
                                AC.jLabelXRight(-1240, 0, 10, 20, slide4);

                                slideCount = 5;
                                break;
                            case 5:
                                Thread.sleep(5000);
                                
                                AC.jLabelXRight(0, 1240, 10, 20, slide4);
                                AC.jLabelXRight(-1240, 0, 10, 20, slide3);
                                
                                slideCount = 6;
                                break;
                            case 6:
                                Thread.sleep(5000);
                                
                                AC.jLabelXRight(0, 1240, 10, 20, slide3);
                                AC.jLabelXRight(-1240, 0, 10, 20, slide2);
                                
                                slideCount = 7;
                                break;
                            case 7:
                                Thread.sleep(5000);
                                
                                AC.jLabelXRight(0, 1240, 10, 20, slide2);
                                AC.jLabelXRight(-1240, 0, 10, 20, slide1);
                                
                                slideCount = 0;
                                break;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }.start();
    }
    
    public ImageIcon setHomeImageThumbnails(String path) {
        ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(115, 140, Image.SCALE_SMOOTH)); // "/desktopapp/img/ss.jpg"      
        
        return icon;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        titleBar = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        navMenu = new javax.swing.JPanel();
        welcomePanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        navBtns = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCategories = new javax.swing.JButton();
        btnMyCart = new javax.swing.JButton();
        btnMyOrders = new javax.swing.JButton();
        btnMyAccount = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        imgLogo = new javax.swing.JLabel();
        jXHyperlink6 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink7 = new org.jdesktop.swingx.JXHyperlink();
        lblCopyright1 = new javax.swing.JLabel();
        lblCopyright2 = new javax.swing.JLabel();
        contentCards = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        homePageTitle = new javax.swing.JPanel();
        lblHomePage = new javax.swing.JLabel();
        mainHomePagePanel = new javax.swing.JPanel();
        searchField = new org.jdesktop.swingx.JXSearchField();
        mainHomeContentPanel = new javax.swing.JPanel();
        lblNewArrivals = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        slidePanel = new javax.swing.JPanel();
        slide1 = new javax.swing.JLabel();
        slide2 = new javax.swing.JLabel();
        slide3 = new javax.swing.JLabel();
        slide4 = new javax.swing.JLabel();
        slide5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        imgBestSeller1 = new javax.swing.JLabel();
        btnAddToCart1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        imgBestSeller4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        imgBestSeller5 = new javax.swing.JLabel();
        categoriesPanel = new javax.swing.JPanel();
        cartPanel = new javax.swing.JPanel();
        ordersPanel = new javax.swing.JPanel();
        accountPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1216, Short.MAX_VALUE)
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(jXPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jXPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jXPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jXPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setIconImage(new ImageIcon("src/desktopapp/img/Book-o Shack Circle Logo@0,05x.png").getImage());
        setUndecorated(true);
        setResizable(false);

        titleBar.setBackground(new java.awt.Color(179, 136, 103));
        titleBar.setForeground(new java.awt.Color(169, 159, 60));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/Close Window_25px.png"))); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/Minimize Window_25px.png"))); // NOI18N
        btnMinimize.setBorderPainted(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimize))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 550));
        mainPanel.setLayout(new java.awt.BorderLayout());

        navMenu.setBackground(new java.awt.Color(255, 255, 255));
        navMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(205, 205, 192), null));
        navMenu.setPreferredSize(new java.awt.Dimension(220, 717));

        welcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        welcomePanel.setLayout(new java.awt.GridLayout());

        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome");
        welcomePanel.add(lblWelcome);

        navBtns.setBackground(new java.awt.Color(255, 255, 255));
        navBtns.setLayout(new java.awt.GridLayout(6, 0));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setForeground(new java.awt.Color(98, 109, 113));
        btnHome.setText("Home Page");
        btnHome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnHome);
        btnHome.setContentAreaFilled(false);
        btnHome.setOpaque(true);
        btnHome.setSelected(true);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        navBtns.add(btnHome);

        btnCategories.setBackground(new java.awt.Color(255, 255, 255));
        btnCategories.setForeground(new java.awt.Color(98, 109, 113));
        btnCategories.setText("Categories");
        btnCategories.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnCategories);
        btnCategories.setContentAreaFilled(false);
        btnCategories.setOpaque(true);
        btnCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCategoriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCategoriesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCategoriesMousePressed(evt);
            }
        });
        btnCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriesActionPerformed(evt);
            }
        });
        navBtns.add(btnCategories);

        btnMyCart.setBackground(new java.awt.Color(255, 255, 255));
        btnMyCart.setForeground(new java.awt.Color(98, 109, 113));
        btnMyCart.setText("My Cart");
        btnMyCart.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnMyCart);
        btnMyCart.setContentAreaFilled(false);
        btnMyCart.setOpaque(true);
        btnMyCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMyCartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMyCartMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMyCartMousePressed(evt);
            }
        });
        btnMyCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyCartActionPerformed(evt);
            }
        });
        navBtns.add(btnMyCart);

        btnMyOrders.setBackground(new java.awt.Color(255, 255, 255));
        btnMyOrders.setForeground(new java.awt.Color(98, 109, 113));
        btnMyOrders.setText("My Orders");
        btnMyOrders.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnMyOrders);
        btnMyOrders.setContentAreaFilled(false);
        btnMyOrders.setOpaque(true);
        btnMyOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMyOrdersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMyOrdersMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMyOrdersMousePressed(evt);
            }
        });
        btnMyOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyOrdersActionPerformed(evt);
            }
        });
        navBtns.add(btnMyOrders);

        btnMyAccount.setBackground(new java.awt.Color(255, 255, 255));
        btnMyAccount.setForeground(new java.awt.Color(98, 109, 113));
        btnMyAccount.setText("My Account");
        btnMyAccount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnMyAccount);
        btnMyAccount.setContentAreaFilled(false);
        btnMyAccount.setOpaque(true);
        btnMyAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMyAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMyAccountMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMyAccountMousePressed(evt);
            }
        });
        btnMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyAccountActionPerformed(evt);
            }
        });
        navBtns.add(btnMyAccount);

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setForeground(new java.awt.Color(98, 109, 113));
        btnLogout.setText("Log Out");
        btnLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnLogout);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setOpaque(true);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogoutMousePressed(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        navBtns.add(btnLogout);

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/Book-o Shack Circle Logo@0,05x.png"))); // NOI18N

        jXHyperlink6.setForeground(new java.awt.Color(179, 136, 103));
        jXHyperlink6.setText("About Us");
        jXHyperlink6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink6ActionPerformed(evt);
            }
        });

        jXHyperlink7.setForeground(new java.awt.Color(179, 136, 103));
        jXHyperlink7.setText("Contact Us");
        jXHyperlink7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink7ActionPerformed(evt);
            }
        });

        lblCopyright1.setForeground(new java.awt.Color(98, 109, 113));
        lblCopyright1.setText("© 2018 Book-Shack");

        lblCopyright2.setForeground(new java.awt.Color(98, 109, 113));
        lblCopyright2.setText("All rights reserved.");

        javax.swing.GroupLayout navMenuLayout = new javax.swing.GroupLayout(navMenu);
        navMenu.setLayout(navMenuLayout);
        navMenuLayout.setHorizontalGroup(
            navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBtns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXHyperlink7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXHyperlink6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(navMenuLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCopyright2)
                    .addComponent(lblCopyright1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(welcomePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navMenuLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(imgLogo)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        navMenuLayout.setVerticalGroup(
            navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(navBtns, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXHyperlink6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXHyperlink7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lblCopyright1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCopyright2)
                .addGap(7, 7, 7))
        );

        mainPanel.add(navMenu, java.awt.BorderLayout.LINE_START);

        contentCards.setBackground(new java.awt.Color(255, 255, 255));
        contentCards.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(255, 255, 255));

        homePageTitle.setBackground(new java.awt.Color(98, 109, 113));

        lblHomePage.setForeground(new java.awt.Color(255, 255, 255));
        lblHomePage.setText("Home Page");

        javax.swing.GroupLayout homePageTitleLayout = new javax.swing.GroupLayout(homePageTitle);
        homePageTitle.setLayout(homePageTitleLayout);
        homePageTitleLayout.setHorizontalGroup(
            homePageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePageTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHomePage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePageTitleLayout.setVerticalGroup(
            homePageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePageTitleLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblHomePage)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        mainHomePagePanel.setBackground(new java.awt.Color(255, 255, 255));

        searchField.setDropMode(javax.swing.DropMode.INSERT);
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        mainHomeContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblNewArrivals.setForeground(new java.awt.Color(98, 109, 113));
        lblNewArrivals.setText("NEW ARRIVALS");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        slidePanel.setPreferredSize(new java.awt.Dimension(1240, 340));
        slidePanel.setRequestFocusEnabled(false);

        slide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner1.jpg"))); // NOI18N

        slide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner2.jpg"))); // NOI18N

        slide3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner3.jpg"))); // NOI18N

        slide4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner4.jpg"))); // NOI18N

        slide5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner5.jpg"))); // NOI18N

        javax.swing.GroupLayout slidePanelLayout = new javax.swing.GroupLayout(slidePanel);
        slidePanel.setLayout(slidePanelLayout);
        slidePanelLayout.setHorizontalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addComponent(slide1)
                .addGap(0, 0, 0)
                .addComponent(slide2)
                .addGap(0, 0, 0)
                .addComponent(slide3)
                .addGap(0, 0, 0)
                .addComponent(slide4)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(slide5)
                .addGap(4, 4, 4))
        );
        slidePanelLayout.setVerticalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slide1)
            .addComponent(slide2)
            .addComponent(slide3)
            .addComponent(slide4)
            .addComponent(slide5)
        );

        slide1.setLayout(new FlowLayout(FlowLayout.CENTER));
        slide1.add(new JButton("hello"));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(98, 109, 113)));
        jPanel5.setForeground(new java.awt.Color(98, 109, 113));

        imgBestSeller1.setIcon(setHomeImageThumbnails("/desktopapp/img/ss.jpg")
        );

        btnAddToCart1.setBackground(new java.awt.Color(179, 136, 103));
        btnAddToCart1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart1.setText("Add to Cart");
        btnAddToCart1.setBorder(null);
        btnAddToCart1.setContentAreaFilled(false);
        btnAddToCart1.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddToCart1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddToCart1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(98, 109, 113)));
        jPanel8.setForeground(new java.awt.Color(98, 109, 113));

        imgBestSeller4.setIcon(setHomeImageThumbnails("/desktopapp/img/ss.jpg")
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller4, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(98, 109, 113)));
        jPanel9.setForeground(new java.awt.Color(98, 109, 113));

        imgBestSeller5.setIcon(setHomeImageThumbnails("/desktopapp/img/ss.jpg")
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller5, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainHomeContentPanelLayout = new javax.swing.GroupLayout(mainHomeContentPanel);
        mainHomeContentPanel.setLayout(mainHomeContentPanelLayout);
        mainHomeContentPanelLayout.setHorizontalGroup(
            mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainHomeContentPanelLayout.createSequentialGroup()
                .addGap(0, 658, Short.MAX_VALUE)
                .addComponent(lblNewArrivals)
                .addGap(577, 577, 577))
            .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainHomeContentPanelLayout.setVerticalGroup(
            mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNewArrivals)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainHomePagePanelLayout = new javax.swing.GroupLayout(mainHomePagePanel);
        mainHomePagePanel.setLayout(mainHomePagePanelLayout);
        mainHomePagePanelLayout.setHorizontalGroup(
            mainHomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainHomePagePanelLayout.createSequentialGroup()
                .addComponent(mainHomeContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainHomePagePanelLayout.setVerticalGroup(
            mainHomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainHomePagePanelLayout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainHomeContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainHomePagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addComponent(homePageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainHomePagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentCards.add(homePanel, "card1");

        javax.swing.GroupLayout categoriesPanelLayout = new javax.swing.GroupLayout(categoriesPanel);
        categoriesPanel.setLayout(categoriesPanelLayout);
        categoriesPanelLayout.setHorizontalGroup(
            categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        categoriesPanelLayout.setVerticalGroup(
            categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        contentCards.add(categoriesPanel, "card3");

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        contentCards.add(cartPanel, "card3");

        javax.swing.GroupLayout ordersPanelLayout = new javax.swing.GroupLayout(ordersPanel);
        ordersPanel.setLayout(ordersPanelLayout);
        ordersPanelLayout.setHorizontalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        ordersPanelLayout.setVerticalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        contentCards.add(ordersPanel, "card3");

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        contentCards.add(accountPanel, "card3");

        mainPanel.add(contentCards, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1559, Short.MAX_VALUE)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_titleBarMousePressed

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseDragged
        setLocation(getLocation().x + evt.getX() - px, getLocation().y + evt.getY() - py);
    }//GEN-LAST:event_titleBarMouseDragged

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setIcon(cd.getImageClose());
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setIcon(cd.getImageCloseHover());
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        cardLayout.show(contentCards, "card1");
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        if(!btnHome.isSelected()) {
            btnHome.setBackground(hoverColor);
            btnHome.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        if(!btnHome.isSelected()) {
            btnHome.setBackground(Color.WHITE);
            btnHome.setForeground(textColor);
        }
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        if(!btnHome.isSelected())
            loopBtns(navBtnGroup);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnMyOrdersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyOrdersMouseEntered
        if(!btnMyOrders.isSelected()) {
            btnMyOrders.setBackground(hoverColor);
            btnMyOrders.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnMyOrdersMouseEntered

    private void btnMyOrdersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyOrdersMouseExited
        if(!btnMyOrders.isSelected()) {
            btnMyOrders.setBackground(Color.WHITE);
            btnMyOrders.setForeground(textColor);
        }
    }//GEN-LAST:event_btnMyOrdersMouseExited

    private void btnMyOrdersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyOrdersMousePressed
         if(!btnHome.isSelected())
            loopBtns(navBtnGroup);
    }//GEN-LAST:event_btnMyOrdersMousePressed

    private void btnMyOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMyOrdersActionPerformed

    private void btnMyAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyAccountMouseEntered
        if(!btnMyAccount.isSelected()) {
            btnMyAccount.setBackground(hoverColor);
            btnMyAccount.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnMyAccountMouseEntered

    private void btnMyAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyAccountMouseExited
        if(!btnMyAccount.isSelected()) {
            btnMyAccount.setBackground(Color.WHITE);
            btnMyAccount.setForeground(textColor);
        }
    }//GEN-LAST:event_btnMyAccountMouseExited

    private void btnMyAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyAccountMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMyAccountMousePressed

    private void btnMyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMyAccountActionPerformed

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMousePressed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMyCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyCartActionPerformed
        cardLayout.show(contentCards, "card2");
    }//GEN-LAST:event_btnMyCartActionPerformed

    private void btnMyCartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyCartMousePressed
        if(!btnMyCart.isSelected())
            loopBtns(navBtnGroup);
    }//GEN-LAST:event_btnMyCartMousePressed

    private void btnMyCartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyCartMouseExited
        if(!btnMyCart.isSelected()) {
            btnMyCart.setBackground(Color.WHITE);
            btnMyCart.setForeground(textColor);
        }
    }//GEN-LAST:event_btnMyCartMouseExited

    private void btnMyCartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyCartMouseEntered
        if(!btnMyCart.isSelected()) {
            btnMyCart.setBackground(hoverColor);
            btnMyCart.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnMyCartMouseEntered

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setIcon(cd.getImageMinHover());
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        btnMinimize.setIcon(cd.getImageMin());
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnCategoriesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriesMouseEntered
        if(!btnCategories.isSelected()) {
            btnCategories.setBackground(hoverColor);
            btnCategories.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnCategoriesMouseEntered

    private void btnCategoriesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriesMouseExited
        if(!btnCategories.isSelected()) {
            btnCategories.setBackground(Color.WHITE);
            btnCategories.setForeground(textColor);
        }
    }//GEN-LAST:event_btnCategoriesMouseExited

    private void btnCategoriesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoriesMousePressed

    private void btnCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoriesActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void jXHyperlink6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink6ActionPerformed
        File file = new File("src/desktopapp/webApp/Home.html");
        cd.openSignUp(file.toURI());
    }//GEN-LAST:event_jXHyperlink6ActionPerformed

    private void jXHyperlink7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXHyperlink7ActionPerformed
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form *//*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPanel;
    private javax.swing.JButton btnAddToCart1;
    private javax.swing.JButton btnCategories;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnMyAccount;
    private javax.swing.JButton btnMyCart;
    private javax.swing.JButton btnMyOrders;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JPanel categoriesPanel;
    private javax.swing.JPanel contentCards;
    private javax.swing.JPanel homePageTitle;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel imgBestSeller1;
    private javax.swing.JLabel imgBestSeller4;
    private javax.swing.JLabel imgBestSeller5;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink6;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink7;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private javax.swing.JLabel lblCopyright1;
    private javax.swing.JLabel lblCopyright2;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblNewArrivals;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel mainHomeContentPanel;
    private javax.swing.JPanel mainHomePagePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navBtns;
    private javax.swing.JPanel navMenu;
    private javax.swing.JPanel ordersPanel;
    private org.jdesktop.swingx.JXSearchField searchField;
    private javax.swing.JLabel slide1;
    private javax.swing.JLabel slide2;
    private javax.swing.JLabel slide3;
    private javax.swing.JLabel slide4;
    private javax.swing.JLabel slide5;
    private javax.swing.JPanel slidePanel;
    private javax.swing.JPanel titleBar;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<java.lang.Object> getAccountDetails(java.lang.String username) {
        client.CustomerWS_Service service = new client.CustomerWS_Service();
        client.CustomerWS port = service.getCustomerWSPort();
        return port.getAccountDetails(username);
    }
}
