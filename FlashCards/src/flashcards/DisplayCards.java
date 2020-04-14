/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author DylanCarfley
 */
public class DisplayCards extends javax.swing.JFrame {

    static ArrayList<cardClass> cards = new ArrayList<>();
    static ArrayList<cardClass> revisits = new ArrayList<>();
    static FileSystem fs;
    static Path pathToFile; //access to the file
    static File theFile; //file operations like create, delete
    static BasicFileAttributes attributes;
    static BufferedReader tempReader; // reads the file one line at a time, caches upcoming lines
    static InputStream tempIn = null;
    static int index = 0, current = 0, Cardnum = 1, highRevisit  = cards.size()-1, lowRevisit = 0;
    Image openFile;
    Image flashcards;
    Toolkit tools;
    Random rand = new Random();

    /**
     * Creates new form DisplayCards
     */
    public void loadImages() {
        openFile = tools.getImage(getClass().getResource("openFile.png"));
        flashcards =  tools.getImage(getClass().getResource("flashcards.png"));
    }

    public ImageIcon getImage(Image theImage) {
        Image scaledAlblum = theImage.getScaledInstance(20, 20, Image.SCALE_FAST);
        return new ImageIcon(scaledAlblum);
    }

//    public static void openfile() {
//        fs = FileSystems.getDefault();
//        pathToFile = fs.getPath("c:\\data\\flashcards.txt");
//
//        try {
//            tempIn = Files.newInputStream(pathToFile);
//            tempReader = new BufferedReader(new InputStreamReader(tempIn));
//        } catch (IOException ex) {
//            System.out.println("Cannot open file " + pathToFile.getFileName());
//            System.exit(0);//die if file does not open
//        }
//        cardClass aCard;
//        String line;
//        try {
//            while ((line = tempReader.readLine()) != null) {
//                String cardInfo[] = line.split(",,");
//                aCard = new cardClass();
//
//                try {
//                    aCard.setId(Integer.parseInt(cardInfo[0]));
//                    aCard.setQuestion(cardInfo[1]);
//                    aCard.setAnswer(cardInfo[2]);
//
//                    cards.add(aCard);
//
//                } catch (NumberFormatException numberFormatException) {
//                    //do nothing - skip error
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(DisplayCards.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void showRecord() {

        if (showRevisitsCheck.isSelected() == true && cards.get(index).getRevisit() == true) {
            this.cardNumLabel.setText("Card #" + Cardnum + " out of " + cards.size());
            this.cardInfoLabel.setText("<html><body><p>" + cards.get(index).getQuestion() + "</p></body></html>");
            this.sideLabel.setText("Side: Question");
            if (cards.get(index).getRevisit() == true) {
                this.revisitCheck.setSelected(true);
            } else if (cards.get(index).getRevisit() == false) {
                this.revisitCheck.setSelected(false);
            }
            repaint();
        } else if (showRevisitsCheck.isSelected() == false) {
            this.cardNumLabel.setText("Card #" + Cardnum + " out of " + cards.size());
            this.cardInfoLabel.setText("<html><body><p>" + cards.get(index).getQuestion() + "</p></body></html>");
            this.sideLabel.setText("Side: Question");
            if (cards.get(index).getRevisit() == true) {
                this.revisitCheck.setSelected(true);
            } else if (cards.get(index).getRevisit() == false) {
                this.revisitCheck.setSelected(false);
            }
            repaint();
        }
        
        //force jframe to resize to fix graphics bug
        this.setSize(800, 541);
        this.setSize(800, 540);
    }
    public DisplayCards() {
        initComponents();
        tools = Toolkit.getDefaultToolkit();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setTitle("Flashcards Program");
        loadImages();
        //put a file open picture for the file open button
        fileOpenMenu.setIcon(getImage(openFile));
        flashcardsMenu.setIcon(getImage(flashcards));

        //openfile();

        //showRecord();

        repaint();
        // drawStuff();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        int y = 22;
        int x = 22;
        g = this.cardPanel.getGraphics();
        g.setColor(Color.WHITE);
        //g.fillRect(0, 0, this.cardPanel.getWidth(), this.cardPanel.getHeight());
        g.setColor(Color.blue);
        for (int i = 0; i < 9; i++) {
            g.drawLine(0, y, this.cardPanel.getWidth(), x);
            x += 20;
            y += 20;
        }
        g.setColor(Color.red);
        g.drawLine(0, 22, this.cardPanel.getWidth(), 22);
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
        revisitCheck = new javax.swing.JCheckBox();
        showRevisitsCheck = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        fileOpenMenu = new javax.swing.JMenuItem();
        flashcardsMenu = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 540));

        firstButton.setText("|<");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        prevButton.setText("<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        lastButton.setText(">|");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        randButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        randButton.setText("Random");
        randButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randButtonActionPerformed(evt);
            }
        });

        sideLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sideLabel.setText("Side:");

        cardNumLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cardNumLabel.setText("Card:");

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setMaximumSize(new java.awt.Dimension(350, 150));
        cardPanel.setMinimumSize(new java.awt.Dimension(350, 150));
        cardPanel.setPreferredSize(new java.awt.Dimension(350, 150));
        cardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardPanelMouseClicked(evt);
            }
        });

        cardInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cardInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardInfoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cardInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        revisitCheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        revisitCheck.setText("Revisit Card");
        revisitCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revisitCheckActionPerformed(evt);
            }
        });

        showRevisitsCheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        showRevisitsCheck.setText("Show only Revisits");
        showRevisitsCheck.setEnabled(false);
        showRevisitsCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRevisitsCheckActionPerformed(evt);
            }
        });

        menu.setText("File");

        fileOpenMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpenMenu.setText("File Open");
        fileOpenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenMenuActionPerformed(evt);
            }
        });
        menu.add(fileOpenMenu);

        flashcardsMenu.setText("Create Flashcards");
        flashcardsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flashcardsMenuActionPerformed(evt);
            }
        });
        menu.add(flashcardsMenu);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cardNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(randButton)
                                .addGap(31, 31, 31)
                                .addComponent(revisitCheck)
                                .addGap(18, 18, 18)
                                .addComponent(showRevisitsCheck))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(firstButton)
                        .addGap(18, 18, 18)
                        .addComponent(prevButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextButton)
                        .addGap(18, 18, 18)
                        .addComponent(lastButton)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sideLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstButton)
                    .addComponent(prevButton)
                    .addComponent(nextButton)
                    .addComponent(lastButton))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randButton)
                    .addComponent(revisitCheck)
                    .addComponent(showRevisitsCheck))
                .addGap(93, 93, 93))
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
            cards.removeAll(cards);// clear out previous cards from list
            try {
                tempIn = Files.newInputStream(pathToFile);
                tempReader = new BufferedReader(new InputStreamReader(tempIn));

                while ((line = tempReader.readLine()) != null) {
                    String cardInfo[] = line.split(",,");
                    aCard = new cardClass();

                    try {
                        aCard.setId(Integer.parseInt(cardInfo[0]));
                        aCard.setQuestion(cardInfo[1]);
                        aCard.setAnswer(cardInfo[2]);

                        cards.add(aCard);
                    } catch (NumberFormatException numberFormatException) {
                        //do nothing - skip error
                    }
                }

                showRecord();
                repaint();

            } catch (IOException ex) {
                System.out.println("Cannot open file " + pathToFile.getFileName());
                System.exit(0);//die if file does not open
            }

        }
    }//GEN-LAST:event_fileOpenMenuActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        // TODO add your handling code here:
        if (showRevisitsCheck.isSelected() == false) {
            index = 0;
            Cardnum = 1;
            showRecord();
            repaint();
        } else if (showRevisitsCheck.isSelected() == true && lowRevisit != index) {
            int change = 0;
            
               for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getRevisit() == true) {
                    index = i;
                    change++;
                    break;
                }
            }
            Cardnum = lowRevisit + 1;
            showRecord();
            repaint();
            
        }
    }//GEN-LAST:event_firstButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        if (index > 0) {
            if (showRevisitsCheck.isSelected() == false) {
                index--;
                Cardnum--;
                showRecord();
                repaint();
            } else if (showRevisitsCheck.isSelected() == true && lowRevisit != index) {
                do {
                    index--;
                    Cardnum--;
                }while (cards.get(index).getRevisit() == false);
                showRecord();
                repaint();
            }
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if (index < cards.size() - 1) {
            if (showRevisitsCheck.isSelected() == false) {
                index++;
                Cardnum++;
                showRecord();
                repaint();
            } else if (showRevisitsCheck.isSelected() == true && highRevisit != index) {
                do{
                    index++;
                    Cardnum++;
                }while (cards.get(index).getRevisit() == false) ;
                showRecord();
                repaint();
            }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        // TODO add your handling code here:
        if (showRevisitsCheck.isSelected() == false) {
            index = cards.size() - 1;
            Cardnum = cards.size();
            showRecord();
            repaint();
        } else if (showRevisitsCheck.isSelected() == true && highRevisit != index) {
            int change = 0;

            for (int i = cards.size()-1; i < cards.size(); i--) {
                if (cards.get(i).getRevisit() == true) {
                    index = i;
                    ;
                    break;
                }
            }
            Cardnum = highRevisit + 1;
            showRecord();
            repaint();
        }
    }//GEN-LAST:event_lastButtonActionPerformed

    private void randButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randButtonActionPerformed
        // TODO add your handling code here:
        if (showRevisitsCheck.isSelected() == false) {
        Collections.shuffle(cards);
        //index = rand.nextInt(cards.size()-1);
        showRecord();
        repaint();
        }
        else if(showRevisitsCheck.isSelected() == true){
            do{
            Collections.shuffle(cards);
            for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRevisit() == true){
                highRevisit = i;
            }
        }
         for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRevisit() == true){
               lowRevisit = i;
               break;
            }
        }
        showRecord();
        repaint();
            }while(cards.get(index).getRevisit() == false);//keeps on shuffling until it hits a valid card
        }
    }//GEN-LAST:event_randButtonActionPerformed

    private void cardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardPanelMouseClicked
        // TODO add your handling code here:
        if ((this.cardInfoLabel.getText()).equals("<html><body><p>" + cards.get(index).getQuestion() + "</p></body></html>")) {
            this.cardInfoLabel.setText("<html><body><p>" + cards.get(index).getAnswer() + "</p></body></html>");
            this.sideLabel.setText("Side: Answer");

        } else if (this.cardInfoLabel.getText().equals("<html><body><p>" + cards.get(index).getAnswer() + "</p></body></html>")) {
            this.cardInfoLabel.setText("<html><body><p>" + cards.get(index).getQuestion() + "</p></body></html>");
            this.sideLabel.setText("Side: Question");
        }
        
        repaint();
         
        //force jframe to resize to fix graphics bug
        this.setSize(800, 541);
        this.setSize(800, 540);
    }//GEN-LAST:event_cardPanelMouseClicked

    private void revisitCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisitCheckActionPerformed
        // TODO add your handling code here:
//        if(revisitCheck.isSelected()){
//            revisits.add(cards.get(index));
//        }
//        else if(!revisitCheck.isSelected()){
//            for(int i = 0; i < cards.size(); i++){
//                for(int x = 0; x < revisits.size(); x++){
//                    if(cards.get(i) == revisits.get(x)){
//                        revisits.remove(x);
//                        break;
//                    }
//                }
//            }
//        }
        int valid = 0;//make sure at least one card can be revisited
        if (revisitCheck.isSelected()) {
            cards.get(index).setRevisit(true);
              valid++;
        } else if (!revisitCheck.isSelected()) {
            cards.get(index).setRevisit(false);
            valid--;
        }
        
        if(valid > 0){
            showRevisitsCheck.setEnabled(true);
        }
        else if(valid == 0){
            showRevisitsCheck.setEnabled(false);
        }
        
        //make sure user cannot remove last valid card while showing only revisits
        if(valid == 1 && showRevisitsCheck.isSelected()){
            revisitCheck.setEnabled(false);
        }
        else if(valid > 1 || !showRevisitsCheck.isSelected()){
            revisitCheck.setEnabled(true);
        }
        
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRevisit() == true){
                highRevisit = i;
            }
        }
         for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRevisit() == true){
               lowRevisit = i;
               break;
            }
        }

    }//GEN-LAST:event_revisitCheckActionPerformed

    private void showRevisitsCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRevisitsCheckActionPerformed
        // TODO add your handling code here:
        if(!showRevisitsCheck.isSelected()){
            revisitCheck.setEnabled(true);
        }
    }//GEN-LAST:event_showRevisitsCheckActionPerformed

    private void flashcardsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flashcardsMenuActionPerformed
        // TODO add your handling code here:
        WriteFlashCardsGUI writecards = new WriteFlashCardsGUI();
        writecards.setVisible(true);
        DisplayCards.this.setVisible(false);
    }//GEN-LAST:event_flashcardsMenuActionPerformed

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
    private javax.swing.JMenuItem fileOpenMenu;
    private javax.swing.JButton firstButton;
    private javax.swing.JMenuItem flashcardsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton lastButton;
    private javax.swing.JMenu menu;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton randButton;
    private javax.swing.JCheckBox revisitCheck;
    private javax.swing.JCheckBox showRevisitsCheck;
    private javax.swing.JLabel sideLabel;
    // End of variables declaration//GEN-END:variables
}
