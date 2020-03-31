/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author DylanCarfley
 */
public class DisplayCards extends javax.swing.JFrame {

    static ArrayList<cardClass> cards = new ArrayList<>();
    static FileSystem fs;
    static Path pathToFile; //access to the file
    static File theFile; //file operations like create, delete
    static BasicFileAttributes attributes;
    static BufferedReader tempReader; // reads the file one line at a time, caches upcoming lines
    static InputStream tempIn = null;
    static int index = 0, max = cards.size(), current = 0;
    Image openFile;
    Toolkit tools;

    /**
     * Creates new form DisplayCards
     */
    public void loadImages() {
        openFile = tools.getImage(getClass().getResource("openFile.png"));
    }

    public ImageIcon getImage(Image theImage) {
        Image scaledAlblum = theImage.getScaledInstance(20, 20, Image.SCALE_FAST);
        return new ImageIcon(scaledAlblum);
    }
    
    public static void openfile() {
        fs = FileSystems.getDefault();
        pathToFile = fs.getPath("c:\\data\\flashcards.txt");

        try {
            tempIn = Files.newInputStream(pathToFile);
            tempReader = new BufferedReader(new InputStreamReader(tempIn));
        } catch (IOException ex) {
            System.out.println("Cannot open file " + pathToFile.getFileName());
            System.exit(0);//die if file does not open
        }
    }
    
    public void showRecord(){
       this.cardNumLabel.setText("Card #" + cards.get(index).getId() + "out of " + max);
       this.cardInfoLabel.setText(cards.get(index).getQuestion());
    }

    public DisplayCards() {
        initComponents();
        tools = Toolkit.getDefaultToolkit();
        this.setTitle("Flashcards Program");
        loadImages();

        //put a file open picture for the file open button
        fileOpenMenu.setIcon(getImage(openFile));

        showRecord();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        randButton = new javax.swing.JButton();
        sideLabel = new javax.swing.JLabel();
        cardNumLabel = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        cardInfoLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileOpenMenu = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstButton.setText("|<");

        prevButton.setText("<");

        nextButton.setText(">");

        lastButton.setText(">|");

        randButton.setText("Random");

        sideLabel.setText("Side:");

        cardNumLabel.setText("Card:");

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        fileMenu.setText("File");

        fileOpenMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpenMenu.setText("File Open");
        fileOpenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenMenuActionPerformed(evt);
            }
        });
        fileMenu.add(fileOpenMenu);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(cardNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(firstButton)
                        .addGap(18, 18, 18)
                        .addComponent(prevButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextButton)
                        .addGap(18, 18, 18)
                        .addComponent(lastButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(randButton)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sideLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstButton)
                    .addComponent(prevButton)
                    .addComponent(nextButton)
                    .addComponent(lastButton)
                    .addComponent(randButton))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileOpenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenMenuActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));//set initial directory to users home directory
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //test to make sure it works
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            
             fs = FileSystems.getDefault();
             pathToFile = fs.getPath(selectedFile.getAbsolutePath());
             cardClass aCard;
             String line;
        try {
            tempIn = Files.newInputStream(pathToFile);
            tempReader = new BufferedReader(new InputStreamReader(tempIn));
            
            while((line = tempReader.readLine()) !=null){
                String cardInfo[] = line.split(",");
                aCard = new cardClass();
                
                try {
                    aCard.setId(Integer.parseInt(cardInfo[0]));
                    aCard.setQuestion(cardInfo[1]);
                    aCard.setQuestion(cardInfo[2]);
                    
                    cards.add(aCard);
                } catch (NumberFormatException numberFormatException) {
                    //do nothing - skip error
                }
            }
            
            
        } catch (IOException ex) {
            System.out.println("Cannot open file " + pathToFile.getFileName());
            System.exit(0);//die if file does not open
        }
        
        }
    }//GEN-LAST:event_fileOpenMenuActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayCards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cardInfoLabel;
    private javax.swing.JLabel cardNumLabel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileOpenMenu;
    private javax.swing.JButton firstButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton randButton;
    private javax.swing.JLabel sideLabel;
    // End of variables declaration//GEN-END:variables
}
