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
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        navBtnGroup = new ButtonGroup();
        initComponents();
        
        cd = new CommonDesign(this);
        
        cardLayout = (CardLayout) webViewCards.getLayout();
        
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
        
        System.out.println(slide4.getX() + "\n" + slide4.getY());
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
                                
                                AC.jLabelXLeft(0, -1240, 15, 8, slide1);
                                AC.jLabelXLeft(1240, 0, 15, 8, slide2);
                                AC.jLabelXLeft(2480, 1240, 15, 8, slide3);
                                
                                slideCount = 1;
                                break;
                            case 1:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 15, 8, slide2);
                                AC.jLabelXLeft(1240, 0, 15, 8, slide3);
                                AC.jLabelXLeft(3720, 1240, 15, 8, slide4);
                                
                                slideCount = 2;
                                break;
                            case 2:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 15, 8, slide3);
                                AC.jLabelXLeft(1240, 0, 15, 8, slide4);
                                
                                slideCount = 0;
                                break;
                                /*
                            case 3:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 15, 8, slide4);
                                AC.jLabelXLeft(1240, 0, 15, 8, slide5);
                                
                                slideCount = 4;
                                break;
                            case 5:
                                Thread.sleep(5000);
                                
                                AC.jLabelXLeft(0, -1240, 15, 8, slide5);
                                AC.jLabelXLeft(1240, 0, 15, 8, slide1);
                                
                                slideCount = 0;
                                break;*/
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
        slide5 = new javax.swing.JLabel();
        slide6 = new javax.swing.JLabel();
        slide7 = new javax.swing.JLabel();
        slide8 = new javax.swing.JLabel();
        titleBar = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        navMenu = new javax.swing.JPanel();
        navBtns = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnBrowseBooks = new javax.swing.JButton();
        btnMyCart = new javax.swing.JButton();
        btnMyOrders = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        imgLogo = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        webViewCards = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        homePageTitle = new javax.swing.JPanel();
        lblHomePage = new javax.swing.JLabel();
        mainHomePagePanel = new javax.swing.JPanel();
        searchField = new org.jdesktop.swingx.JXSearchField();
        mainHomeContentPanel = new javax.swing.JPanel();
        lblRecommendedProducts = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        imgBestSeller1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        slidePanel = new javax.swing.JPanel();
        slide1 = new javax.swing.JLabel();
        slide2 = new javax.swing.JLabel();
        slide3 = new javax.swing.JLabel();
        slide4 = new javax.swing.JLabel();

        slide5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner1.jpg"))); // NOI18N

        slide6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner2.jpg"))); // NOI18N

        slide7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner3.jpg"))); // NOI18N

        slide8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner5.jpg"))); // NOI18N

        jLayeredPane1.setLayer(slide5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(slide6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(slide7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(slide8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(slide5)
                .addComponent(slide6)
                .addGap(0, 0, 0)
                .addComponent(slide7)
                .addGap(0, 0, 0)
                .addComponent(slide8)
                .addGap(21, 21, 21))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(slide5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slide6)
                    .addComponent(slide7)
                    .addComponent(slide8))
                .addGap(0, 0, 0))
        );

        slide1.setLayout(new FlowLayout(FlowLayout.CENTER));
        slide1.add(new JButton("hello"));

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

        btnBrowseBooks.setBackground(new java.awt.Color(255, 255, 255));
        btnBrowseBooks.setForeground(new java.awt.Color(98, 109, 113));
        btnBrowseBooks.setText("Browse Books");
        btnBrowseBooks.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(btnBrowseBooks);
        btnBrowseBooks.setContentAreaFilled(false);
        btnBrowseBooks.setOpaque(true);
        btnBrowseBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBrowseBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBrowseBooksMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBrowseBooksMousePressed(evt);
            }
        });
        btnBrowseBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseBooksActionPerformed(evt);
            }
        });
        navBtns.add(btnBrowseBooks);

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

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setForeground(new java.awt.Color(98, 109, 113));
        jButton6.setText("Account");
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(jButton6);
        jButton6.setContentAreaFilled(false);
        jButton6.setOpaque(true);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        navBtns.add(jButton6);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setForeground(new java.awt.Color(98, 109, 113));
        jButton7.setText("Log Out");
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(205, 205, 192)));
        navBtnGroup.add(jButton7);
        jButton7.setContentAreaFilled(false);
        jButton7.setOpaque(true);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        navBtns.add(jButton7);

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/Book-o Shack Circle Logo@0,05x.png"))); // NOI18N

        lblWelcome.setForeground(new java.awt.Color(98, 109, 113));
        lblWelcome.setText("Welcome user!");

        javax.swing.GroupLayout navMenuLayout = new javax.swing.GroupLayout(navMenu);
        navMenu.setLayout(navMenuLayout);
        navMenuLayout.setHorizontalGroup(
            navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBtns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcome)
                    .addComponent(imgLogo))
                .addGap(45, 45, 45))
        );
        navMenuLayout.setVerticalGroup(
            navMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(navBtns, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        mainPanel.add(navMenu, java.awt.BorderLayout.LINE_START);

        webViewCards.setBackground(new java.awt.Color(255, 255, 255));
        webViewCards.setLayout(new java.awt.CardLayout());

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

        mainHomeContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblRecommendedProducts.setForeground(new java.awt.Color(98, 109, 113));
        lblRecommendedProducts.setText("RECOMMENDED PRODUCTS");

        jPanel5.setBackground(new java.awt.Color(98, 109, 113));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(98, 109, 113)));
        jPanel5.setForeground(new java.awt.Color(98, 109, 113));

        imgBestSeller1.setIcon(setHomeImageThumbnails("/desktopapp/img/ss.jpg")
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBestSeller1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        slide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner1.jpg"))); // NOI18N

        slide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner2.jpg"))); // NOI18N

        slide3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner3.jpg"))); // NOI18N

        slide4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopapp/img/banners/banner5.jpg"))); // NOI18N

        javax.swing.GroupLayout slidePanelLayout = new javax.swing.GroupLayout(slidePanel);
        slidePanel.setLayout(slidePanelLayout);
        slidePanelLayout.setHorizontalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(slide1)
                .addComponent(slide2)
                .addGap(0, 0, 0)
                .addComponent(slide3)
                .addGap(0, 0, 0)
                .addComponent(slide4)
                .addGap(21, 21, 21))
        );
        slidePanelLayout.setVerticalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addComponent(slide1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addGroup(slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slide2)
                    .addComponent(slide3)
                    .addComponent(slide4))
                .addGap(0, 0, 0))
        );

        slide1.setLayout(new FlowLayout(FlowLayout.CENTER));
        slide1.add(new JButton("hello"));

        javax.swing.GroupLayout mainHomeContentPanelLayout = new javax.swing.GroupLayout(mainHomeContentPanel);
        mainHomeContentPanel.setLayout(mainHomeContentPanelLayout);
        mainHomeContentPanelLayout.setHorizontalGroup(
            mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainHomeContentPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRecommendedProducts)
                .addGap(545, 545, 545))
            .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                .addGroup(mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        mainHomeContentPanelLayout.setVerticalGroup(
            mainHomeContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainHomeContentPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRecommendedProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainHomePagePanelLayout = new javax.swing.GroupLayout(mainHomePagePanel);
        mainHomePagePanel.setLayout(mainHomePagePanelLayout);
        mainHomePagePanelLayout.setHorizontalGroup(
            mainHomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
            .addGroup(mainHomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainHomePagePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainHomeContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mainHomePagePanelLayout.setVerticalGroup(
            mainHomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainHomePagePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(628, Short.MAX_VALUE))
            .addGroup(mainHomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainHomePagePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainHomeContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

        webViewCards.add(homePanel, "card1");

        mainPanel.add(webViewCards, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1550, Short.MAX_VALUE)
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
        cardLayout.show(webViewCards, "card1");
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

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnMyCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyCartActionPerformed
        cardLayout.show(webViewCards, "card2");
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

    private void btnBrowseBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseBooksMouseEntered
        if(!btnBrowseBooks.isSelected()) {
            btnBrowseBooks.setBackground(hoverColor);
            btnBrowseBooks.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnBrowseBooksMouseEntered

    private void btnBrowseBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseBooksMouseExited
        if(!btnBrowseBooks.isSelected()) {
            btnBrowseBooks.setBackground(Color.WHITE);
            btnBrowseBooks.setForeground(textColor);
        }
    }//GEN-LAST:event_btnBrowseBooksMouseExited

    private void btnBrowseBooksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseBooksMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseBooksMousePressed

    private void btnBrowseBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseBooksActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseBooks;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnMyCart;
    private javax.swing.JButton btnMyOrders;
    private javax.swing.JPanel homePageTitle;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel imgBestSeller1;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblRecommendedProducts;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel mainHomeContentPanel;
    private javax.swing.JPanel mainHomePagePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navBtns;
    private javax.swing.JPanel navMenu;
    private org.jdesktop.swingx.JXSearchField searchField;
    private javax.swing.JLabel slide1;
    private javax.swing.JLabel slide2;
    private javax.swing.JLabel slide3;
    private javax.swing.JLabel slide4;
    private javax.swing.JLabel slide5;
    private javax.swing.JLabel slide6;
    private javax.swing.JLabel slide7;
    private javax.swing.JLabel slide8;
    private javax.swing.JPanel slidePanel;
    private javax.swing.JPanel titleBar;
    private javax.swing.JPanel webViewCards;
    // End of variables declaration//GEN-END:variables
}
