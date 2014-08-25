/*
 * 
 */

package invsystem;

import invsystem.entities.ProductsEntityClass;
import invsystem.entities.WarehouseEntityClass;
import invsystem.util.WarehousesInterface;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.application.Action;

public class WarehousesBox extends javax.swing.JDialog implements WarehousesInterface{

    public WarehousesBox(java.awt.Frame parent) {
        super(parent);
        initComponents();
        getRootPane().setDefaultButton(closeButton);
        
        saveJButton.setEnabled(false);
        updateJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        
        //Add warehousesJTable Selection Listener
        warehousesjTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            //Set the selected data to the text boxes
            public void valueChanged(ListSelectionEvent evt) {
                nameField.setText(String.valueOf(warehousesjTable.getValueAt(warehousesjTable.getSelectedRow(), 1)));
                minProductField.setText(String.valueOf(warehousesjTable.getValueAt(warehousesjTable.getSelectedRow(), 2)));
                maxProductField.setText(String.valueOf(warehousesjTable.getValueAt(warehousesjTable.getSelectedRow(), 3)));
                
                saveJButton.setEnabled(false);
                updateJButton.setEnabled(true);
                deleteJButton.setEnabled(true);
            }
        });
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        warehousesEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cellfusionPU").createEntityManager();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(invsystem.InvSystemApp.class).getContext().getResourceMap(WarehousesBox.class);
        queryWarehouses = java.beans.Beans.isDesignTime() ? null : warehousesEntityManager.createQuery(resourceMap.getString("queryWarehouses.query")); // NOI18N
        warehouseslist = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryWarehouses.getResultList());
        closeButton = new javax.swing.JButton();
        warehousesScrollPane = new javax.swing.JScrollPane();
        warehousesjTable = new javax.swing.JTable();
        minProductField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        maxProductField = new javax.swing.JTextField();
        minProductLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        maxProductLabel = new javax.swing.JLabel();
        newJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(resourceMap.getString("title")); // NOI18N
        setModal(true);
        setName("aboutBox"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(invsystem.InvSystemApp.class).getContext().getActionMap(WarehousesBox.class, this);
        closeButton.setAction(actionMap.get("closeWarehousesBox")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        warehousesScrollPane.setName("warehousesScrollPane"); // NOI18N

        warehousesjTable.setName("warehousesjTable"); // NOI18N
        warehousesjTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, warehouseslist, warehousesjTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idWarehouse}"));
        columnBinding.setColumnName("Id Warehouse");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${minProduct}"));
        columnBinding.setColumnName("Min Product");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${maxProduct}"));
        columnBinding.setColumnName("Max Product");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        warehousesjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warehousesjTableMouseClicked(evt);
            }
        });
        warehousesScrollPane.setViewportView(warehousesjTable);
        if (warehousesjTable.getColumnModel().getColumnCount() > 0) {
            warehousesjTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("warehousesjTable.columnModel.title3")); // NOI18N
            warehousesjTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("warehousesjTable.columnModel.title0")); // NOI18N
            warehousesjTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("warehousesjTable.columnModel.title1")); // NOI18N
            warehousesjTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("warehousesjTable.columnModel.title2")); // NOI18N
        }

        minProductField.setName("minProductField"); // NOI18N

        nameField.setName("nameField"); // NOI18N

        maxProductField.setName("maxProductField"); // NOI18N

        minProductLabel.setText(resourceMap.getString("minProductLabel.text")); // NOI18N
        minProductLabel.setName("minProductLabel"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        maxProductLabel.setText(resourceMap.getString("maxProductLabel.text")); // NOI18N
        maxProductLabel.setName("maxProductLabel"); // NOI18N

        newJButton.setAction(actionMap.get("newButtonClick")); // NOI18N
        newJButton.setText(resourceMap.getString("newJButton.text")); // NOI18N
        newJButton.setName("newJButton"); // NOI18N
        newJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        saveJButton.setAction(actionMap.get("saveButtonClick")); // NOI18N
        saveJButton.setText(resourceMap.getString("saveJButton.text")); // NOI18N
        saveJButton.setName("saveJButton"); // NOI18N
        saveJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        deleteJButton.setAction(actionMap.get("deleteButtonClick")); // NOI18N
        deleteJButton.setText(resourceMap.getString("deleteJButton.text")); // NOI18N
        deleteJButton.setName("deleteJButton"); // NOI18N
        deleteJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        updateJButton.setAction(actionMap.get("updateButtonClick")); // NOI18N
        updateJButton.setText(resourceMap.getString("updateJButton.text")); // NOI18N
        updateJButton.setName("updateJButton"); // NOI18N
        updateJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(minProductLabel)
                            .addComponent(maxProductLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(minProductField)
                            .addComponent(maxProductField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(warehousesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(warehousesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minProductLabel)
                    .addComponent(minProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxProductLabel)
                    .addComponent(maxProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(newJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void warehousesjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warehousesjTableMouseClicked
        
        int fila = warehousesjTable.rowAtPoint(evt.getPoint());
        
        if (fila > -1){
            nameField.setText(String.valueOf(warehousesjTable.getValueAt(fila, 1)));
            minProductField.setText(String.valueOf(warehousesjTable.getValueAt(fila, 2)));
            maxProductField.setText(String.valueOf(warehousesjTable.getValueAt(fila, 3)));
            
            saveJButton.setEnabled(false);
            updateJButton.setEnabled(true);
            deleteJButton.setEnabled(true);
            
        }
        
    }//GEN-LAST:event_warehousesjTableMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        clearFields();
        updateJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        saveJButton.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated

    
    
            
    @Action
    public void closeWarehousesBox() {
        dispose();
    }

    @Action
    public void saveButtonClick() {
        if( nameField.getText().length() > 0 &&
            minProductField.getText().length() > 0 &&
            maxProductField.getText().length() > 0 ){
            
                try{
                    warehousesEntityManager.getTransaction().begin();
                    
                    WarehouseEntityClass    warehouseEntity = new WarehouseEntityClass();

                    warehouseEntity.setName(nameField.getText());
                    warehouseEntity.setMinProduct( Integer.parseInt(minProductField.getText()) );
                    warehouseEntity.setMaxProduct( Integer.parseInt(maxProductField.getText()) );

                    warehousesEntityManager.persist(warehouseEntity);
                    warehouseslist.add(warehouseEntity);
                    int row = warehouseslist.size() - 1;
                    warehousesjTable.setRowSelectionInterval(row, row);
                    warehousesjTable.scrollRectToVisible(warehousesjTable.getCellRect(row, 0, true));

                    warehousesEntityManager.getTransaction().commit();
                    
                    saveJButton.setEnabled(false);
                    updateJButton.setEnabled(false);
                    deleteJButton.setEnabled(false);
                }catch(Exception error){
                    warehousesEntityManager.getTransaction().rollback();
                }
                
        }else{
            JOptionPane.showMessageDialog(  null,
                                            "There are empty fields.\nPlease, complete all fields.",
                                            "Empty fields",
                                            JOptionPane.ERROR_MESSAGE,
                                            null);
        }
    }

    @Action
    public void newButtonClick() {
        clearFields();
        saveJButton.setEnabled(true);
        updateJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
    }
    
    public void clearFields(){
        nameField.setText("");
        minProductField.setText("");
        maxProductField.setText("");
        nameField.requestFocus();
    }

    @Action
    public void deleteButtonClick() {
        
        try{
            warehousesEntityManager.getTransaction().begin();
            
            int[] selected = warehousesjTable.getSelectedRows();
            int[] toEliminate = new int[selected.length] ;
            for (int idx = 0; idx < selected.length; idx++) {
                WarehouseEntityClass record = warehousesEntityManager.getReference(WarehouseEntityClass.class, warehousesjTable.getValueAt(selected[idx], 0));
                warehousesEntityManager.remove(record);
                toEliminate[idx] = selected[idx];
            }
            warehousesEntityManager.getTransaction().commit();
            
            for (int idx = 0; idx < toEliminate.length; idx++) 
                warehouseslist.remove(idx);
            
            clearFields();
            saveJButton.setEnabled(false);
            updateJButton.setEnabled(false);
            deleteJButton.setEnabled(false);
        }catch(Exception error){
            warehousesEntityManager.getTransaction().rollback();
            error.printStackTrace();
        }
    }

    @Action
    public void updateButtonClick() {
        try{
            warehousesEntityManager.getTransaction().begin();
            
            int[] selected = warehousesjTable.getSelectedRows();
            
            for (int idx = 0; idx < selected.length; idx++) {
                WarehouseEntityClass currentRecord = warehousesEntityManager.getReference(WarehouseEntityClass.class, warehousesjTable.getValueAt(selected[idx], 0));
                
                currentRecord.setName(nameField.getText());
                currentRecord.setMinProduct(Integer.parseInt(minProductField.getText()));
                currentRecord.setMaxProduct(Integer.parseInt(maxProductField.getText()));
                
                warehousesEntityManager.merge(currentRecord);
                
                warehousesjTable.setValueAt(currentRecord.getName(), selected[idx], 1);
                warehousesjTable.setValueAt(currentRecord.getMinProduct(), selected[idx], 2);
                warehousesjTable.setValueAt(currentRecord.getMaxProduct(), selected[idx], 3);
            }
            warehousesEntityManager.getTransaction().commit();
            
            clearFields();
            saveJButton.setEnabled(false);
            updateJButton.setEnabled(false);
            deleteJButton.setEnabled(false);
            
        }catch(Exception error){
            warehousesEntityManager.getTransaction().rollback();
            error.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JTextField maxProductField;
    private javax.swing.JLabel maxProductLabel;
    private javax.swing.JTextField minProductField;
    private javax.swing.JLabel minProductLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newJButton;
    private javax.persistence.Query queryWarehouses;
    private javax.swing.JButton saveJButton;
    private javax.swing.JButton updateJButton;
    private javax.persistence.EntityManager warehousesEntityManager;
    private javax.swing.JScrollPane warehousesScrollPane;
    private javax.swing.JTable warehousesjTable;
    private java.util.List warehouseslist;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public EntityManager getEntityManager() {
        return warehousesEntityManager;
    }

    

}