package metodos;


import producto.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoma
 */
public class Metodos {
    
    Vector vPrinci = new Vector();
    
    
    
    public void guardar(Producto unProducto){
        vPrinci.addElement(unProducto);
    }
    
    public void guardarArchivo(Producto producto){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\thoma\\Documents\\NetBeansProjects\\MiniProyecto3\\src\\metodos\\Productos.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(producto.getCodigoProducto());
            pw.print("|"+producto.getNombre());
            pw.print("|"+producto.getPrecio());
            pw.print("|"+producto.getCategoria());
            bw.newLine();
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public DefaultTableModel listaProductos(){
        Vector cabecera = new Vector();
        cabecera.addElement("Codigo producto");
        cabecera.addElement("Nombre");
        cabecera.addElement("Precio");
        cabecera.addElement("Categoria");
        DefaultTableModel mdl = new DefaultTableModel(cabecera,0);
        
        try {
            FileReader fr = new FileReader("C:\\Users\\thoma\\Documents\\NetBeansProjects\\MiniProyecto3\\src\\metodos\\Productos.txt");
            BufferedReader br = new BufferedReader(fr);
            String b;
            while((b = br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer(b,"|");
                Vector x = new Vector();
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdl.addRow(x);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mdl;
    }
    
    
    
}
