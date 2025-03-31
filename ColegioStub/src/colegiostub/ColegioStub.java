/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colegiostub;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.gui.ColegioApp;

public class ColegioStub{
    
    
    //private static AlumnoRepository2 ar=new AlumnoRepository2(Connector.getConnection());
    public static void main(String[] args) {
        
        ColegioApp c=new ColegioApp();
        FormAlumnos2 a=new FormAlumnos2();
        c.desktop.add(a);
        a.setVisible(true);
        c.setVisible(true);
        
        //ar.remove(new Alumno(1, "", "", 1, 1));
        
        
        
    }
    
   
    
}
