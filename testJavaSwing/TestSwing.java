import javax.swing.JOptionPane;

public class TestSwing{
    public static void main(String[] args){
        System.out.println("Test Java Swing");
        System.out.println("Versión de JDK: "+System.getProperty("java.version"));
        System.out.println("Máquina Virtual: "+System.getProperty("java.vm.name"));
        JOptionPane.showMessageDialog(null, "Hola a todos!!");

    }
}