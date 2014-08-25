
package invsystem.util;

import invsystem.entities.WarehouseEntityClass;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author saul
 */
public class ReportRender extends DefaultTableCellRenderer{
    
    List<WarehouseEntityClass> list;
    int lastRow = -1;
    int onStock = 0;
    int sold    = 0;
    int total   = 0;
    String value = "";
    Component cell;
    public ReportRender(List<WarehouseEntityClass> listParam) {
        this.list = listParam;
    }
    
    
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) {
        Component c     = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(Color.WHITE);
        if(lastRow != row)
            lastRow = row; //next row
        
        if(column == 2){
            onStock=Integer.parseInt(String.valueOf(value));
            cell = c;
        }
        
        if(column == 3)
            sold=Integer.parseInt(String.valueOf(value));
        
        if(column == 4)
            total=Integer.parseInt(String.valueOf(value));
        
        if(column == 5){
//            //set color
            
            for(WarehouseEntityClass entity : list){
                if(entity.getName().equals(String.valueOf(value))){
                    
                    if( (total-sold) < entity.getMinProduct() ){
                        c.setBackground(Color.RED);
                        cell.setBackground(Color.RED);
                    }else if( (total-sold) > entity.getMaxProduct() ){
                        c.setBackground(Color.YELLOW);
                    }else if( (total-sold) >= entity.getMaxProduct()){
                        c.setBackground(Color.GREEN);
                    }
                }
            }
//            System.out.println("--------------------------------------------------");
//            System.out.println("Column Name:" + table.getColumnName(column) );
//            System.out.println("Value:" + value);
//            System.out.println("Row:" + row);
//            System.out.println("Column:" + column);
//            System.out.println("--------------------------------------------------");

//            c.setBackground(new java.awt.Color(0, 0, 255)); 
        }

        return c; 
    }
    
}
