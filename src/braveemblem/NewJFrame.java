package braveemblem;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Chris
 */
public class NewJFrame extends javax.swing.JFrame {
    
    public static ImageIcon playerLeft = new ImageIcon("C:\\Users\\Chris\\Documents\\ProjectGame1\\src\\projectgame1\\BannedStory_SpriteSheet\\walk1_00.png");
//new ImageIcon("C:\\Users\\Chris\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\playerLeft.png");
    private static MainThread thread;
    
    public static int resX = 800; //1280x720, 1024x768, 800x600
    public static int resY = 600;
    
    public static int[][] footholds = new int[][]{{1590,293,1690,193}}; //x1,y1,x2,y2
    
    public static int newPanelX = 0;
    public static int playerX = 50;
    public static int playerY = 50;
    public static double playerVel = 5.0;
    public static double gravityRate = 1.0;
    public static boolean isJumping = false;
    public static boolean isInAir = false;
    public static double jumpTarget = 0.0;
    public static boolean isMovingRight = false;
    public static boolean isMovingLeft = false;
    public static boolean isOnAngle=false;
    
    public static BufferedImage mapBG;
    public static JLabel graphicsBackground = new JLabel();
    public static double graphicsBgX = 0.0;
    public static double graphicsBgY = 0.0;
    
    public static boolean test = false, test2=false;
    public static int testint = 0;
    long time;
    long time2;
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        thread = new MainThread();
        //setUndecorated(true);
        initComponents();

        graphicsBackground.setBounds(0,0,0,0);
        mapDraw();
        this.setBounds(0, 0, resX, resY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        jLabel1.setText("player");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(130, 120, 30, 14);

        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 30, 260, 14);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 500, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        jLabel1.setIcon(playerLeft);
        playerX = 0;
        
        //System.out.println("hi");
        //System.out.println(jPanel2.isFocusOwner());
        this.requestFocus();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE)
            if(!isJumping && !isInAir)
                isJumping(playerY, playerY-(10*playerVel));
            else
                ;
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
            isMovingRight=true;//playerX +=1;
        else if(evt.getKeyCode() == KeyEvent.VK_LEFT)
            isMovingLeft=true;//playerX -=1;
        
        if(evt.getKeyCode()==KeyEvent.VK_1) {
            playerVel+=1;
            jLabel2.setText("Player Velocity = "+playerVel);
        }
        if(evt.getKeyCode()==KeyEvent.VK_2) {
            playerVel-=1;
            jLabel2.setText("Player Velocity = "+playerVel);
        }
        
        //System.out.println(playerX);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT)
            isMovingRight=false;
        if(evt.getKeyCode()==KeyEvent.VK_LEFT)
            isMovingLeft=false;
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NewJFrame().setVisible(true);
            thread.start();
        });
    }

    public static void mapDraw()
    {
        File mapBGImg = new File("C:\\Users\\Chris\\Desktop\\novas-sanctuary2.png");
        try {
            mapBG = ImageIO.read(mapBGImg);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon mapBackGround = new ImageIcon(mapBG);
        
        jPanel2.setSize(mapBG.getWidth(), mapBG.getHeight());
        graphicsBackground.setSize(mapBG.getWidth(), mapBG.getHeight());
        graphicsBackground.setIcon(mapBackGround);
        jPanel2.add(graphicsBackground);
        jPanel2.setBounds(0,0,graphicsBackground.getWidth(), graphicsBackground.getHeight());
        
        //mapBG.flush();
    }
    
    public static boolean isJumping(double start, double target) {
        if(playerY > target) {
            isJumping=true;
            isInAir=true;
            jumpTarget=target;
            return true;
        }
        return false;
    }
    
    public static void checkBottomCollision() {
        
        for(int i=0; i<footholds.length; i++) {
            for(int j=0; j<footholds[i].length; j++) {
                double m = (footholds[i][3]-footholds[i][1]) / (footholds[i][2]-footholds[i][0]);
                double b = (footholds[i][0]-(m*footholds[i][1]));
                
                if(playerY+100 == ((int)m*playerX +(int)b) && playerX>=footholds[i][0] && playerX<=footholds[i][2]) {
                    playerY = (int)m*playerX+(int)b-100;
                    isInAir=false;
                    isJumping=false;
                    isOnAngle=true;
                    System.out.println("X:"+playerX+"  Y: "+playerY+" ; Platform");
                    i=99;
                    break;
                }
                else {
                    if(isOnAngle) {
                        isOnAngle=false;
                        isInAir=true;
                        //isJumping=true;
                    }
                }
            }
        }
        
        if(playerY+100 > 350)
            playerY=350-100;
    }
    
    public static void checkPOV(int oldX, int newX) {
        if(isMovingRight) {
            if(jLabel1.getX() > (resX/2) && jLabel1.getX() < (mapBG.getWidth()-(resX/2))) //center of screen, move view box
            {
                if(oldX!=newX) {
                    newPanelX = jPanel2.getX() - (newX-oldX);
                    //jPanel2.setBounds(jPanel2.getX() - (newX-oldX), jPanel2.getY(), jPanel2.getWidth(), jPanel2.getHeight());
                }
            }
            else if(jLabel1.getX() > mapBG.getWidth()-(resX/2)) 
                if(jPanel2.getX()!= 0-mapBG.getWidth()+resX-16)
                    newPanelX = 0-mapBG.getWidth()+resX-16;
                    //jPanel2.setBounds(0-mapBG.getWidth()+resX-16,jPanel2.getY(),jPanel2.getWidth(),jPanel2.getHeight());
        }
        else if(isMovingLeft) {
            if( jLabel1.getX() > ((resX/2)-16) && jLabel1.getX() < (mapBG.getWidth()-( (resX/2)-16 )) )
            {
                if(oldX!=newX) {
                    newPanelX = jPanel2.getX() - (newX-oldX);
                }
                if(newPanelX >=0 || jPanel2.getX() >= 0)
                    newPanelX=0;
            }
        }
    }
    
    public static void checkPOV()
    { //ISSUES with the jitter here
        //int diff = (int)Math.round(playerVel);
        int newX;
        if(isMovingRight)//Right
        {
            if( jLabel1.getX() > (resX/2) && jLabel1.getX() < (mapBG.getWidth()-(resX/2)) )
            {
                newX = 0-(jLabel1.getX()-(resX/2)+(int)playerVel);
                
                if(newX < 0-mapBG.getWidth()+resX-16) { //-16 is to Account for the stupid window frames, 8px on each side
                    newX=0-mapBG.getWidth()+resX-16; //Account for playerVelocity forcing POV too short
                    System.out.println("Used?");
                }
                
                jPanel2.setBounds(newX, jPanel2.getY(), jPanel2.getWidth(), jPanel2.getHeight());
                //jPanel2.setBounds(newX, jPanel2.getY(), jPanel2.getWidth(), jPanel2.getHeight());
                System.out.println("Moving thing");
            }
            else if(jLabel1.getX() > mapBG.getWidth()-(resX/2)) 
                if(jPanel2.getX()!= 0-mapBG.getWidth()+resX-16)
                    jPanel2.setBounds(0-mapBG.getWidth()+resX-16,jPanel2.getY(),jPanel2.getWidth(),jPanel2.getHeight());
        }
        else if(isMovingLeft)//Left
        {
            if( jLabel1.getX() > ((resX/2)-16) && jLabel1.getX() < (mapBG.getWidth()-( (resX/2)-16 )) )
            {
                newX = 0-(jLabel1.getX()-(resX/2)-(int)playerVel); 
                
                if(newX > 0) //Account for playerVelocity forcing POV too far
                    newX=0;
                
                
                if(jPanel2.getX()!=0)
                    jPanel2.setBounds(newX, jPanel2.getY(),
                                                    jPanel2.getWidth(), jPanel2.getHeight());
            }
        }
    }
    
    public static void update() {
        //update player
        double oldX = 0.0, oldY = 0.0;
        double newX = 0.0, newY = 0.0;
        if(isMovingRight) {
            if(isOnAngle) {
                playerY-=1*playerVel;
            }
            oldX = playerX;
            playerX+=1*playerVel;
            newX = playerX;
        }
        else if(isMovingLeft) {
            if(isOnAngle) {
                playerY+=1*playerVel;
            }
            oldX = playerX;
            playerX-=1*playerVel;
            newX = playerX;
        }
        
        if(playerX+52>mapBG.getWidth()) {
            oldX = playerX;
            playerX=mapBG.getWidth()-52;
            newX = playerX;
        }
        else if(playerX<0) {
            oldX = playerX;
            playerX=0;
            newX = 0;
        }
        
        
        checkPOV((int)oldX, (int)newX);
        
        //checkPOV();
        if(isInAir && !isJumping) {
            //check collision
            if(playerY+100 < 350)
                playerY +=1*gravityRate;
            else
                isInAir=false;
            
            checkBottomCollision();
        }
        
        if(isJumping) {
            
            if(playerY > jumpTarget)
                playerY -= 1*playerVel;
            else
                isJumping=false;
        }
        
        checkBottomCollision();
    }
    
    public static void draw() {
        //if(playerY % (int)playerY > 0.7)
        //    ;//playerY+=1;
        
        checkBottomCollision();
        
        if(jLabel1.getX() != playerX)
            jLabel1.setBounds((int)playerX, (int)playerY, 52, 100);
        if(jLabel1.getY() != playerY)
            jLabel1.setBounds((int)playerX, (int)playerY, 52, 100);
        
        if(newPanelX<=0-mapBG.getWidth()+resX-16)
            newPanelX=0-mapBG.getWidth()+resX-16;
        if(jPanel2.getX() != newPanelX)
            jPanel2.setBounds(newPanelX, jPanel2.getY(), jPanel2.getWidth(), jPanel2.getHeight());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
