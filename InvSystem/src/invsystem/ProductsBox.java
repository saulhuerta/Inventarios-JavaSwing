/*
 * 
 */

package invsystem;

import invsystem.entities.ProductsEntityClass;
import invsystem.entities.WarehouseEntityClass;
import java.util.List;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.application.Action;

public class ProductsBox extends javax.swing.JDialog {

    public ProductsBox(java.awt.Frame parent) {
        super(parent);
        initComponents();
        getRootPane().setDefaultButton(closeButton);
        loadCombo();
        
        saveJButton.setEnabled(false);
        updateJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        
        //Add warehousesJTable Selection Listener
        productJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            //Set the selected data to the text boxes and combobox
            public void valueChanged(ListSelectionEvent evt) {
                
                nameField.setText(String.valueOf(productJTable.getValueAt(productJTable.getSelectedRow(), 1)));
                totalQtyField.setText(String.valueOf(productJTable.getValueAt(productJTable.getSelectedRow(), 2)));
                remainingQtyField.setText(String.valueOf(productJTable.getValueAt(productJTable.getSelectedRow(), 3)));
                String warehouseStr = String.valueOf(productJTable.getValueAt(productJTable.getSelectedRow(), 4));
                
                for(int index = 0; index < warehouseJComboBox.getItemCount(); index++){
                    if(warehouseStr.equals(warehouseJComboBox.getItemAt(index))){
                        warehouseJComboBox.setSelectedIndex(index);
                        break;
                    }
                }
                
                saveJButton.setEnabled(false);
                updateJButton.setEnabled(true);
                deleteJButton.setEnabled(true);
                
            }
        });
    }

public void loadCombo(){
    warehouseJComboBox.removeAllItems();
    Query myQuery = warehouseEntityManager.createNamedQuery("WarehouseEntityClass.findAll");
    List<WarehouseEntityClass> list = myQuery.getResultList();
    DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
    boxModel.addElement("Select a warehouse");
    for(WarehouseEntityClass w :list)
        boxModel.addElement(w.getIdWarehouse() + " - " + w.getName());
    
    warehouseJComboBox.setModel(boxModel);
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        productsEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cellfusionPU").createEntityManager();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(invsystem.InvSystemApp.class).getContext().getResourceMap(ProductsBox.class);
        queryProducts = java.beans.Beans.isDesignTime() ? null : productsEntityManager.createQuery(resourceMap.getString("queryProducts.query")); // NOI18N
        productList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryProducts.getResultList());
        warehouseEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cellfusionPU").createEntityManager();
        queryWarehouse = java.beans.Beans.isDesignTime() ? null : warehouseEntityManager.createQuery(resourceMap.getString("queryWarehouse.query")); // NOI18N
        warehouseList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryWarehouse.getResultList());
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productJTable = new javax.swing.JTable();
        totalQtyField = new javax.swing.JTextField();
        remainingQtyField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        remainingQtyLabel = new javax.swing.JLabel();
        warehouseIdLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        totalQtyLabel = new javax.swing.JLabel();
        warehouseJComboBox = new javax.swing.JComboBox();
        deleteJButton = new javax.swing.JButton();
        newJButton2 = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
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

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(invsystem.InvSystemApp.class).getContext().getActionMap(ProductsBox.class, this);
        closeButton.setAction(actionMap.get("closeProductsBox")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        productJTable.setName("productJTable"); // NOI18N
        productJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productList, productJTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduct}"));
        columnBinding.setColumnName("Id Product");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalQty}"));
        columnBinding.setColumnName("Total Qty");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${remainingQty}"));
        columnBinding.setColumnName("Remaining Qty");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idWarehouse.idWarehouse} - ${idWarehouse.name}"));
        columnBinding.setColumnName("Id Warehouse.id Warehouse} - ${id Warehouse.name");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        productJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productJTable);
        if (productJTable.getColumnModel().getColumnCount() > 0) {
            productJTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("productJTable.columnModel.title0")); // NOI18N
            productJTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("productJTable.columnModel.title1")); // NOI18N
            productJTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("productJTable.columnModel.title2")); // NOI18N
            productJTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("productJTable.columnModel.title3")); // NOI18N
            productJTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("productJTable.columnModel.title4")); // NOI18N
        }

        totalQtyField.setFont(resourceMap.getFont("nameField.font")); // NOI18N
        totalQtyField.setName("totalQtyField"); // NOI18N

        remainingQtyField.setFont(resourceMap.getFont("nameField.font")); // NOI18N
        remainingQtyField.setName("remainingQtyField"); // NOI18N

        nameField.setFont(resourceMap.getFont("nameField.font")); // NOI18N
        nameField.setName("nameField"); // NOI18N

        remainingQtyLabel.setText(resourceMap.getString("remainingQtyLabel.text")); // NOI18N
        remainingQtyLabel.setName("remainingQtyLabel"); // NOI18N

        warehouseIdLabel.setText(resourceMap.getString("warehouseIdLabel.text")); // NOI18N
        warehouseIdLabel.setName("warehouseIdLabel"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        totalQtyLabel.setText(resourceMap.getString("totalQtyLabel.text")); // NOI18N
        totalQtyLabel.setName("totalQtyLabel"); // NOI18N

        warehouseJComboBox.setFont(resourceMap.getFont("nameField.font")); // NOI18N
        warehouseJComboBox.setName("warehouseJComboBox"); // NOI18N

        deleteJButton.setAction(actionMap.get("deleteButtonClick")); // NOI18N
        deleteJButton.setName("deleteJButton"); // NOI18N
        deleteJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        newJButton2.setAction(actionMap.get("newButtonClick")); // NOI18N
        newJButton2.setName("newJButton2"); // NOI18N
        newJButton2.setPreferredSize(new java.awt.Dimension(60, 25));

        saveJButton.setAction(actionMap.get("saveButtonClick")); // NOI18N
        saveJButton.setName("saveJButton"); // NOI18N
        saveJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        updateJButton.setAction(actionMap.get("updateButtonClick")); // NOI18N
        updateJButton.setName("updateJButton"); // NOI18N
        updateJButton.setPreferredSize(new java.awt.Dimension(60, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(totalQtyLabel)
                                    .addComponent(remainingQtyLabel)
                                    .addComponent(warehouseIdLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField)
                                    .addComponent(totalQtyField)
                                    .addComponent(remainingQtyField)
                                    .addComponent(warehouseJComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalQtyLabel)
                    .addComponent(totalQtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remainingQtyLabel)
                    .addComponent(remainingQtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warehouseIdLabel)
                    .addComponent(warehouseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(closeButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productJTableMouseClicked
        int fila = productJTable.rowAtPoint(evt.getPoint());
        
        if (fila > -1){
            nameField.setText(String.valueOf(productJTable.getValueAt(fila, 1)));
            totalQtyField.setText(String.valueOf(productJTable.getValueAt(fila, 2)));
            remainingQtyField.setText(String.valueOf(productJTable.getValueAt(fila, 3)));
            String warehouseStr = String.valueOf(productJTable.getValueAt(fila, 4));
            
            for(int index = 0; index < warehouseJComboBox.getItemCount(); index++){
                if(warehouseStr.equals(warehouseJComboBox.getItemAt(index))){
                    warehouseJComboBox.setSelectedIndex(index);
                    break;
                }
                    
            }
            
            saveJButton.setEnabled(false);
            updateJButton.setEnabled(true);
            deleteJButton.setEnabled(true);
            
        }
        
    }//GEN-LAST:event_productJTableMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        loadCombo();
        clearFields();
        saveJButton.setEnabled(false);
        updateJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated

    @Action
    public void closeProductsBox() {
        dispose();
    }

    @Action
    public void newButtonClick() {
        clearFields();
        saveJButton.setEnabled(true);
        updateJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
    }
    
    private void clearFields() {
        nameField.setText("");
        totalQtyField.setText("");
        remainingQtyField.setText("");
        warehouseJComboBox.setSelectedIndex(0);
    }

    @Action
    public void saveButtonClick() {
        if( nameField.getText().length() > 0 &&
            totalQtyField.getText().length() > 0 &&
            remainingQtyField.getText().length() > 0 &&
            warehouseJComboBox.getSelectedIndex() > 0){
            
                try{
                    productsEntityManager.getTransaction().begin();
                    
                    ProductsEntityClass productsEntityClass = new ProductsEntityClass();

                    productsEntityClass.setName(nameField.getText());
                    productsEntityClass.setTotalQty(Integer.parseInt(totalQtyField.getText()) );
                    productsEntityClass.setRemainingQty(Integer.parseInt(remainingQtyField.getText()) );
                    String str = String.valueOf(warehouseJComboBox.getSelectedItem());
                    WarehouseEntityClass ware = new WarehouseEntityClass();
                    ware.setIdWarehouse(Integer.parseInt(str.substring(0,str.indexOf(" -"))));
                    ware.setName(str.substring(str.indexOf(" -") +3));
                    productsEntityClass.setIdWarehouse(ware);
                    
                    productsEntityManager.persist(productsEntityClass);
                    productList.add(productsEntityClass);
                    int row = productList.size() - 1;
                    productJTable.setRowSelectionInterval(row, row);
                    productJTable.scrollRectToVisible(productJTable.getCellRect(row, 0, true));

                    productsEntityManager.getTransaction().commit();
                    
                }catch(Exception error){
                    productsEntityManager.getTransaction().rollback();
                }
                
                clearFields();
                saveJButton.setEnabled(false);
                updateJButton.setEnabled(false);
                deleteJButton.setEnabled(false);
                
                
        }else{
            JOptionPane.showMessageDialog(  null,
                                            "There are empty fields.\nPlease, complete all fields.",
                                            "Empty fields",
                                            JOptionPane.ERROR_MESSAGE,
                                            null);
        }
    }

    @Action
    public void deleteButtonClick() {
        try{
            productsEntityManager.getTransaction().begin();
            
            int[] selected = productJTable.getSelectedRows();
            int[] toEliminate = new int[selected.length] ;
            for (int idx = 0; idx < selected.length; idx++) {
                ProductsEntityClass record = productsEntityManager.getReference(ProductsEntityClass.class, productJTable.getValueAt(selected[idx], 0));
                productsEntityManager.remove(record);
                toEliminate[idx] = selected[idx];
            }
            productsEntityManager.getTransaction().commit();
            
            for (int idx = 0; idx < toEliminate.length; idx++) 
                productList.remove(idx);
            
            clearFields();
            saveJButton.setEnabled(false);
            updateJButton.setEnabled(false);
            deleteJButton.setEnabled(false);
            
        }catch(Exception error){
            productsEntityManager.getTransaction().rollback();
            error.printStackTrace();
        }
    }

    @Action
    public void updateButtonClick() {
        try{
            productsEntityManager.getTransaction().begin();
            
            int[] selected = productJTable.getSelectedRows();
            
            ProductsEntityClass oldRecord;
            
            for (int idx = 0; idx < selected.length; idx++) {
                ProductsEntityClass currentRecord = productsEntityManager.getReference(ProductsEntityClass.class, productJTable.getValueAt(selected[idx], 0));
                oldRecord = currentRecord;
                currentRecord.setName(nameField.getText());
                currentRecord.setTotalQty(Integer.parseInt(totalQtyField.getText()));
                currentRecord.setRemainingQty(Integer.parseInt(remainingQtyField.getText()));
                String warehouse = String.valueOf(warehouseJComboBox.getItemAt(warehouseJComboBox.getSelectedIndex()) );
                WarehouseEntityClass w = new WarehouseEntityClass();
                w.setIdWarehouse( Integer.parseInt(warehouse.substring(0,warehouse.indexOf(" -"))) );
                currentRecord.setIdWarehouse(w);
                productsEntityManager.merge(currentRecord);
                productJTable.setValueAt(currentRecord.getName(), selected[idx], 1);
                productJTable.setValueAt(currentRecord.getTotalQty(), selected[idx], 2);
                productJTable.setValueAt(currentRecord.getRemainingQty(), selected[idx], 3);
                productJTable.setValueAt( warehouse, selected[idx], 4);
            }
            productsEntityManager.getTransaction().commit();
            
            clearFields();
            saveJButton.setEnabled(false);
            updateJButton.setEnabled(false);
            deleteJButton.setEnabled(false);
            
        }catch(Exception error){
            productsEntityManager.getTransaction().rollback();
            error.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newJButton2;
    private javax.swing.JTable productJTable;
    private java.util.List productList;
    private javax.persistence.EntityManager productsEntityManager;
    private javax.persistence.Query queryProducts;
    private javax.persistence.Query queryWarehouse;
    private javax.swing.JTextField remainingQtyField;
    private javax.swing.JLabel remainingQtyLabel;
    private javax.swing.JButton saveJButton;
    private javax.swing.JTextField totalQtyField;
    private javax.swing.JLabel totalQtyLabel;
    private javax.swing.JButton updateJButton;
    private javax.persistence.EntityManager warehouseEntityManager;
    private javax.swing.JLabel warehouseIdLabel;
    private javax.swing.JComboBox warehouseJComboBox;
    private java.util.List warehouseList;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

  
    
}
