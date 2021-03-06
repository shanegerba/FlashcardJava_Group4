/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import static flashcards.DisplayCards.fs;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.FileUserDictionary;
import java.awt.Dimension;

/**
 *
 * @author rusty
 */
public class WriteFlashCardsGUI extends javax.swing.JFrame {

    private static ArrayList<cardClass> cards = new ArrayList<>();
    private static int index = 0;
    Image openFile;
    Image saveFile;
    Image flashcards;
    Image flashcardsLogo;
    Toolkit tools;
    static BufferedReader tempReader; // reads the file one line at a time, caches upcoming lines
    static InputStream tempIn = null;
    static Path pathToFile; //access to the file

    public void loadImages() {
        openFile = tools.getImage(getClass().getResource("openFile.png"));
        saveFile = tools.getImage(getClass().getResource("saveFile.jpg"));
        flashcards = tools.getImage(getClass().getResource("flashcards.png"));
        flashcardsLogo = tools.getImage(getClass().getResource("ptc icon.jpg"));
    }

    public ImageIcon getImage(Image theImage) {
        Image scaledAlblum = theImage.getScaledInstance(20, 20, Image.SCALE_FAST);
        return new ImageIcon(scaledAlblum);
    }

    public void newCard() {
        cardClass newCard = new cardClass();
        newCard.setId(index + 1);
        newCard.setQuestion("");
        newCard.setAnswer("");
        cards.add(newCard);
        showCard();
    }

    public void exampleCard() {
        cardClass exCard = new cardClass();
        try {
            exCard.setId(1);
            exCard.setQuestion("Question text goes here");
            exCard.setAnswer("Answer text goes here");

            cards.add(exCard);

        } catch (NumberFormatException numberFormatException) {
            //do nothing - skip error
        }

    }

    public void showCard() {
        this.questionTextArea.setText(cards.get(index).getQuestion());
        this.answerTextArea.setText(cards.get(index).getAnswer());

        this.setTitle("Card #" + (index + 1) + " of " + cards.size());
    }

    public void initializeSpellChecker() {
        String userDictionaryPath = "/dictionary/";
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath));
        SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "en");
        SpellChecker.register(answerTextArea);
        SpellChecker.register(questionTextArea);
    }

    public void updateCard() {
        cards.get(index).setId(index + 1);
        cards.get(index).setQuestion(this.questionTextArea.getText());
        cards.get(index).setAnswer(this.answerTextArea.getText());

    }

    /**
     * Creates new form WriteFlashCardsGUI
     */
    public WriteFlashCardsGUI() {
        initComponents();

        tools = Toolkit.getDefaultToolkit();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setTitle("Flashcards Program");
        loadImages();
        //put a file open picture for the file open button
        openMenu.setIcon(getImage(openFile));
        saveMenu.setIcon(getImage(saveFile));
        flashcardsMenu.setIcon(getImage(flashcards));
         this.setIconImage(flashcardsLogo);

        exampleCard();
        showCard();
        initializeSpellChecker();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        firstBtn = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        saveMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        flashcardsMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 540));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Question");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Answer");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setMinimumSize(new java.awt.Dimension(375, 260));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 260));

        questionTextArea.setColumns(20);
        questionTextArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        questionTextArea.setLineWrap(true);
        questionTextArea.setRows(5);
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        questionTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionTextAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(questionTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setMinimumSize(new java.awt.Dimension(375, 260));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 260));

        answerTextArea.setColumns(20);
        answerTextArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        answerTextArea.setLineWrap(true);
        answerTextArea.setRows(5);
        answerTextArea.setWrapStyleWord(true);
        answerTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        answerTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerTextAreaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(answerTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("1. Type questions and their answers into the text fields on the appropriate cards");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("2. You can use the left and right arrows to move back and forth between created cards");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("3. If you click previous, clicking next causes a new card to be made in the position after this card, click end to go to the end");

        prevBtn.setText("<");
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        nextBtn.setText(">");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        firstBtn.setText("<|");
        firstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstBtnActionPerformed(evt);
            }
        });

        lastButton.setText("|>");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("4. Once done, just close the window, your file to be used in the Flashcard application will be in your C drive in the data folder ");

        jMenu1.setText("File");

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openMenu);

        flashcardsMenu.setText("Display Flashcards");
        flashcardsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flashcardsMenuActionPerformed(evt);
            }
        });
        jMenu1.add(flashcardsMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(151, 151, 151))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
        updateCard();
        try {

            String fileName = cards.get(index).getQuestion() + ".txt";
            File saveFile = new File(fileName);

            //jfile chooser
            JFileChooser save = new JFileChooser();
            save.setSelectedFile(saveFile); //puts file name in the box

            int button = save.showSaveDialog(this); // hold onto which button was pressed
            if (button == JFileChooser.APPROVE_OPTION) {
                //save
                fileName = save.getSelectedFile().toString();
                FileOutputStream qrSave = new FileOutputStream(fileName);

                //MatrixToImageWriter.writeToStream(QRmatrix, "gif", qrSave);
                //QRimage = tools.createImage(QRBuffered.getSource());
                String outputLine = "";
                File outFile = new File(fileName);

                try {
                    FileWriter write = new FileWriter(outFile);

                    for (int x = 0; x < cards.size(); x++) {

                        //%d = int
                        //%f = float or double
                        //%s = string
                        outputLine = String.format("%d,,%s,,%s\n", cards.get(x).getId(), cards.get(x).getQuestion(), cards.get(x).getAnswer());
                        write.write(outputLine);
                    }//end of for
                    write.flush();
                    write.close();
                } catch (IOException ex) {
                    //   Logger.getLogger(CompanyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Cannot write company\n" + ex.getMessage(),
                            "FileIO Error", JOptionPane.ERROR_MESSAGE);
                }

                qrSave.close();
            } else {
                //cancel
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "QR save failed" + ex.toString());
        }


    }//GEN-LAST:event_saveMenuActionPerformed

    private void firstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstBtnActionPerformed
        // TODO add your handling code here:
        index = 0;
        showCard();
    }//GEN-LAST:event_firstBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        updateCard();
        if (index == cards.size() - 1) {
            index++;
            newCard();
        } else {
            index++;
            showCard();
        }


    }//GEN-LAST:event_nextBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //writeToFile();
    }//GEN-LAST:event_formWindowClosing

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        // TODO add your handling code here:
        updateCard();
        if (index > 0) {
            index--;
            showCard();
        }
    }//GEN-LAST:event_prevBtnActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        // TODO add your handling code here:
        index = cards.size() - 1;
        showCard();
    }//GEN-LAST:event_lastButtonActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
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
                showCard();
            } catch (IOException ex) {
                System.out.println("Cannot open file " + pathToFile.getFileName());
                System.exit(0);//die if file does not open
            }
        }
    }//GEN-LAST:event_openMenuActionPerformed

    private void questionTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionTextAreaMouseClicked
        // TODO add your handling code here:
        if (questionTextArea.getText().equals("Question text goes here")) {
            questionTextArea.setText("");
        }

    }//GEN-LAST:event_questionTextAreaMouseClicked

    private void answerTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerTextAreaMouseClicked
        // TODO add your handling code here:
        if (answerTextArea.getText().equals("Answer text goes here")) {
            answerTextArea.setText("");
        }
    }//GEN-LAST:event_answerTextAreaMouseClicked

    private void flashcardsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flashcardsMenuActionPerformed
        // TODO add your handling code here:
        DisplayCards displayCards = new DisplayCards();
        displayCards.setVisible(true);
        WriteFlashCardsGUI.this.setVisible(false);
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
            java.util.logging.Logger.getLogger(WriteFlashCardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteFlashCardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteFlashCardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteFlashCardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriteFlashCardsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answerTextArea;
    private javax.swing.JButton firstBtn;
    private javax.swing.JMenuItem flashcardsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton nextBtn;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JButton prevBtn;
    private javax.swing.JTextArea questionTextArea;
    private javax.swing.JMenuItem saveMenu;
    // End of variables declaration//GEN-END:variables
}
