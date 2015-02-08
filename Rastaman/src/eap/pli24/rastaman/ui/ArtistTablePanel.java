package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.entities.Artist;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author malamas
 */
public class ArtistTablePanel extends javax.swing.JPanel {

    /**
     * Creates new form ArtistTablePanel
     */
    public ArtistTablePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new BindingGroup();

        RastamanPUEntityManager = Beans.isDesignTime() ? null : Persistence.createEntityManagerFactory("RastamanPU").createEntityManager();
        artistQuery = Beans.isDesignTime() ? null : RastamanPUEntityManager.createQuery("SELECT a FROM Artist a");
        artistList = Beans.isDesignTime() ? Collections.emptyList() : artistQuery.getResultList();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        newButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        exitButton = new JButton();

        setLayout(new BorderLayout());

        jTable2.getTableHeader().setReorderingAllowed(false);

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, artistList, jTable2);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Επίθετο");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${artisticname}"));
        columnBinding.setColumnName("Καλιτεχνικό Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${greekSex}"));
        columnBinding.setColumnName("Φύλο");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${birthday}"));
        columnBinding.setColumnName("Ημ. Γέννησης");
        columnBinding.setColumnClass(Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${birthplace}"));
        columnBinding.setColumnName("Τόπος Γέννησης");
        columnBinding.setColumnClass(Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${muscigenreid.name}"));
        columnBinding.setColumnName("Είδος Μουσικής");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, BorderLayout.CENTER);

        jLabel1.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Καλλιτέχνες");
        jLabel1.setPreferredSize(new Dimension(0, 30));
        add(jLabel1, BorderLayout.PAGE_START);

        newButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/adduser22.png"))); // NOI18N
        newButton.setText("Εισαγωγή");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        editButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/edit22.png"))); // NOI18N
        editButton.setText("Επεξεργασία");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/deleteuser22.png"))); // NOI18N
        deleteButton.setText("Διαγραφή");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        exitButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/home22.png"))); // NOI18N
        exitButton.setPreferredSize(new Dimension(80, 23));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(newButton)
                .addGap(5, 5, 5)
                .addComponent(editButton)
                .addGap(5, 5, 5)
                .addComponent(deleteButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1, BorderLayout.PAGE_END);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        controller.hidePanel(this);
    }//GEN-LAST:event_exitButtonActionPerformed

    
    //Νέα εγγραφή Καλλιτέχνη  ***********************
    private void newButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
       
        controller.hidePanel(this);
        controller.showPanel(MainFrameController.Panel.EDIT_ARTIST_TABLE);
    }//GEN-LAST:event_newButtonActionPerformed
    
    //Επεξεργασία Εγγραφής Καλιτέχνη  ****************
    private void editButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        try{
            int selectedIndex= jTable2.getSelectedRow();
            if (selectedIndex == -1 ) throw new Exception("Δεν Επιλέχθηκε Καλλιτέχνης");
          
            Artist a = artistList.get(selectedIndex);
            System.out.println(a.getLastname());
            controller.hidePanel(this);
            controller.showPanel(MainFrameController.Panel.EDIT_ARTIST_TABLE);         
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }

    }//GEN-LAST:event_editButtonActionPerformed
    //Διαγραφή Εγγραφής Καλιτέχνη  ****************
    private void deleteButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try{
            int selectedIndex= jTable2.getSelectedRow();
            if (selectedIndex == -1 ) throw new Exception("Δεν Επιλέχθηκε Καλλιτέχνης");
            Artist a = artistList.get(selectedIndex);
            if (a.getAlbumList().isEmpty()){
                if (a.getMusicgroupList().isEmpty()){
                    Object[] options = {"Ναι",
                                       "Όχι"};
                    int n = JOptionPane.showOptionDialog(new JFrame(),
                         "Να διαγραφεί ο Καλιτέχνης" + a.getLastname() + " " + a.getFirstname() + ";",
                         "Επιβεβαίωση Διαγραφής",
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE,
                         null,     //do not use a custom Icon
                         options,  //the titles of buttons
                         options[1]); //default button title
                    if (n==0) {
                        RastamanPUEntityManager.getTransaction().begin();
                        try{
                           Query q=RastamanPUEntityManager.createQuery("DELETE FROM Artist art WHERE art.artistid=:artistID ", 
                                                                   Artist.class).setParameter("artistID", a.getArtistid());
                           q.executeUpdate();  
                           RastamanPUEntityManager.getTransaction().commit();
                           artistList.remove(selectedIndex);
                           jTable2.updateUI();
                        } catch (Exception e){
                           e.printStackTrace();
                           RastamanPUEntityManager.getTransaction().rollback();   
                        }
                    } 
                }
                else{
                    Object[] options = {"ΟΚ"};
                    int n = JOptionPane.showOptionDialog(new JFrame(),
                         "Ο καλλιτέχνης συμμετέχει σε συγκρότημα \n"
                         + "πρέπει πρώτα να διαγραφεί απο αυτό",
                         "Διαγραφή Καλλιτέχνη",
                         JOptionPane.NO_OPTION,
                         JOptionPane.INFORMATION_MESSAGE,
                         null,     //do not use a custom Icon
                         options,  //the titles of buttons
                         options[0]); //default button title
                }
            } 
            else {
                if (a.getMusicgroupList().isEmpty()){
                    Object[] options = {"ΟΚ"};
                    int n = JOptionPane.showOptionDialog(new JFrame(),
                         "Υπάρχει άλμπουμ για τον συγκεκριμένο καλλιτέχνη \n"
                         + "πρέπει πρώτα να διαγραφεί αυτό",
                         "Διαγραφή Καλλιτέχνη",
                         JOptionPane.NO_OPTION,
                         JOptionPane.INFORMATION_MESSAGE,
                         null,     //do not use a custom Icon
                         options,  //the titles of buttons
                         options[0]); //default button title
                    }
                else{
                    Object[] options = {"ΟΚ"};
                    int n = JOptionPane.showOptionDialog(new JFrame(),
                         "Ο καλλιτέχνης συμμετέχει σε συγκρότημα  και\n" 
                         +"υπάρχει άλμπουμ για τον συγκεκριμένο καλλιτέχνη \n"
                         + "πρέπει πρώτα να διαγραφεί το άλμπουμ και να διαγραφεί απο το συγκρότημα",
                         "Διαγραφή Καλλιτέχνη",
                         JOptionPane.NO_OPTION,
                         JOptionPane.INFORMATION_MESSAGE,
                         null,     //do not use a custom Icon
                         options,  //the titles of buttons
                         options[0]); //default button title
                }
                
            }
            
       
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private EntityManager RastamanPUEntityManager;
    private List<Artist> artistList;
    private Query artistQuery;
    private JButton deleteButton;
    private JButton editButton;
    private JButton exitButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
    private JButton newButton;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private MainFrameController controller;

    public void setController(MainFrameController controller) {
        this.controller = controller;
    }
}
