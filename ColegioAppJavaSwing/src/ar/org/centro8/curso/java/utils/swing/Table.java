package ar.org.centro8.curso.java.utils.swing;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Table <E> {
    public void cargar(JTable tbl, List<E> list){
        if(tbl==null) return;
        DefaultTableModel dtm=new DefaultTableModel();
        tbl.setModel(dtm);
        if(list==null || list.isEmpty()) return;
        E e=list.get(0);
        Field[] campos=e.getClass().getDeclaredFields();
        for(Field f:campos) dtm.addColumn(f.getName());
        for(E ee:list){
            Object[] registro=new Object[campos.length];
            for(int a=0;a<campos.length;a++){
                Field f=campos[a];
                String metodo="get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
                //System.out.println(metodo);
                try {
                    registro[a]=e.getClass().getMethod(metodo, null).invoke(ee, null);
                } catch (Exception ex) { ex.printStackTrace();}
            }
            dtm.addRow(registro);
        }
    }
}
