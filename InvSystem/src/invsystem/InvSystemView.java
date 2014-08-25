/*
 * 
 */

package invsystem;

import invsystem.entities.WarehouseEntityClass;
import invsystem.util.WarehousesInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.TaskMonitor;


public class InvSystemView extends FrameView {
    private JDialog warehousesBox;
    private JDialog aboutBox;
    private JDialog productsBox;
    List<WarehouseEntityClass> listLimits;

    public InvSystemView(SingleFrameApplication app) {
        super(app);
        
        JFrame mainFrame = InvSystemApp.getApplication().getMainFrame();
        WarehousesInterface  warehousesInterface = new WarehousesBox(mainFrame);
        EntityManager   warehousesEntityManager  = warehousesInterface.getEntityManager();
        Query           myQuery                  = warehousesEntityManager.createNamedQuery("WarehouseEntityClass.findAll");
    
        listLimits = myQuery.getResultList();     
        
        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        
        
    }
   
    
   
//    @Override
//    public void cellRenderingHook(int row, int col, boolean isSelected, Component renderer, String ColumnName, String value, recordClass record, KLogClass log) throws KExceptionClass {
//        
//        boolean updateRenderer = false;
//
//            // -----------------------------------------------------------------------                                    
//            if( ColumnName.equals( status_envio_SICOP) ) {
//
//                if( 
//                        //value.equals( EquEquipmentClass.STATUS_ALTA_PENDIENTE ) ||
//                        value.equals( EquEquipmentClass.STATUS_ALTA_ENVIADA ) ||
//                        //value.equals( EquEquipmentClass.STATUS_CAMBIO_PENDIENTE ) ||
//                        value.equals( EquEquipmentClass.STATUS_CAMBIO_ENVIADO ) ||
//                        value.equals( EquEquipmentClass.STATUS_BORR_ENVIADA )                         
//                        ){ 
//
//                    renderer.setBackground( Color.yellow ); 
//
//                    updateRenderer = true;
//                }
//
//                
//                if( 
//                        value.equals( EquEquipmentClass.STATUS_ENVIO_OK ) 
//                        ){ 
//
//                    renderer.setBackground( Color.green ); 
//
//                    updateRenderer = true;
//                }
//                
//                if( 
//                        value.equals( EquEquipmentClass.STATUS_ERROR_DEL_SICOP ) ||
//                        value.equals( EquEquipmentClass.STATUS_ERROR_INS_SICOP ) ||
//                        value.equals( EquEquipmentClass.STATUS_ERROR_MOD_SICOP ) 
//                        ){ 
//
//                    renderer.setBackground( Color.red ); 
//
//                    updateRenderer = true;
//                }
//                
//            }                
//            // -----------------------------------------------------------------------            
//
//    }

        

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = InvSystemApp.getApplication().getMainFrame();
            aboutBox = new InvSystemAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        InvSystemApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportJTable = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                int onStock = Integer.parseInt(String.valueOf(getValueAt(row, 2)));
                int sold    = Integer.parseInt(String.valueOf(getValueAt(row, 3)));
                int total   = Integer.parseInt(String.valueOf(getValueAt(row, 4)));

                JComponent c = (JComponent) super.prepareRenderer(renderer, row, column);

                c.setBackground(Color.LIGHT_GRAY);

                for(WarehouseEntityClass entity : listLimits){

                    if( entity.getName().equals(String.valueOf(getValueAt(row, 5))) ){

                        if( (onStock < entity.getMinProduct()) && column==2 ){
                            c.setBackground(Color.RED);
                        }else if( (onStock > entity.getMaxProduct()) && column==2){
                            c.setBackground(Color.YELLOW);
                        }else if( (onStock >= entity.getMaxProduct()) && column==2){
                            c.setBackground(Color.GREEN);
                        }
                    }
                }

                return c;
            }
        };
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        warehousesMenuItem = new javax.swing.JMenuItem();
        productsMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        reportEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cellfusionPU").createEntityManager();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(invsystem.InvSystemApp.class).getContext().getResourceMap(InvSystemView.class);
        queryReport = java.beans.Beans.isDesignTime() ? null : reportEntityManager.createQuery(resourceMap.getString("queryReport.query")); // NOI18N
        reportList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryReport.getResultList());

        mainPanel.setName("mainPanel"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        reportJTable.setName("reportJTable");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, reportList, reportJTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idproduct}"));
        columnBinding.setColumnName("Idproduct");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodname}"));
        columnBinding.setColumnName("Prodname");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${onstock}"));
        columnBinding.setColumnName("Onstock");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sold}"));
        columnBinding.setColumnName("Sold");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalqty}"));
        columnBinding.setColumnName("Totalqty");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(reportJTable);
        if (reportJTable.getColumnModel().getColumnCount() > 0) {
            reportJTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("reportJTable.columnModel.title0")); // NOI18N
            reportJTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("reportJTable.columnModel.title1")); // NOI18N
            reportJTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("reportJTable.columnModel.title2")); // NOI18N
            reportJTable.getColumnModel().getColumn(2).setCellRenderer(null);
            reportJTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("reportJTable.columnModel.title3")); // NOI18N
            reportJTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("reportJTable.columnModel.title4")); // NOI18N
            reportJTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("reportJTable.columnModel.title5")); // NOI18N
        }

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(invsystem.InvSystemApp.class).getContext().getActionMap(InvSystemView.class, this);
        warehousesMenuItem.setAction(actionMap.get("warehousesMenuClick")); // NOI18N
        warehousesMenuItem.setText(resourceMap.getString("warehousesMenuItem.text")); // NOI18N
        warehousesMenuItem.setName("warehousesMenuItem"); // NOI18N
        fileMenu.add(warehousesMenuItem);

        productsMenuItem.setAction(actionMap.get("productsMenuClick")); // NOI18N
        productsMenuItem.setText(resourceMap.getString("productsMenuItem.text")); // NOI18N
        productsMenuItem.setName("productsMenuItem"); // NOI18N
        fileMenu.add(productsMenuItem);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 431, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    //Open WarehousesBox
    @Action
    public void warehousesMenuClick() {
        if (warehousesBox == null) {
            JFrame mainFrame = InvSystemApp.getApplication().getMainFrame();
            warehousesBox = new WarehousesBox(mainFrame);
            warehousesBox.setLocationRelativeTo(mainFrame);
        }
        InvSystemApp.getApplication().show(warehousesBox);
    }

    //Open ProductsBox
    @Action
    public void productsMenuClick() {
        if (productsBox == null) {
            JFrame mainFrame = InvSystemApp.getApplication().getMainFrame();
            productsBox = new ProductsBox(mainFrame);
            productsBox.setLocationRelativeTo(mainFrame);
        }
        InvSystemApp.getApplication().show(productsBox);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem productsMenuItem;
    private javax.swing.JProgressBar progressBar;
    private javax.persistence.Query queryReport;
    private javax.persistence.EntityManager reportEntityManager;
    private javax.swing.JTable reportJTable;
    private java.util.List reportList;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenuItem warehousesMenuItem;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;


    
}
