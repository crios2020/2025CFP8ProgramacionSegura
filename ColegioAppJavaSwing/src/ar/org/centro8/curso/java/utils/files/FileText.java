package ar.org.centro8.curso.java.utils.files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.stream.Stream;
public class FileText implements I_File {
    
    private File file;

    public FileText(File file) {
        this.file = file;
    }

    public FileText(String file){
        this.file = new File(file);
    }
    
    @Override
    public String getText() {
        int car;
        //String texto="";
        StringBuilder sb=new StringBuilder();
        try(FileReader in=new FileReader(file);){
            while((car=in.read())!=-1){
                //texto+=(char)car;
                sb.append((char)car);
            }
        }catch(Exception e){ e.printStackTrace(); }
        return sb.toString();
    }

    @Override
    public void setText(String text) {
        try(FileWriter in=new FileWriter(file);){
            in.write(text);
        }catch(Exception e) { e.printStackTrace(); } 
    }

    @Override
    public void append(String text) {
        try(FileWriter in=new FileWriter(file,true);){
            in.write(text);
        }catch(Exception e) { e.printStackTrace(); }  
    }

    @Override
    public Stream<String> getStream() {
        try {
            return new BufferedReader(new FileReader(file)).lines();
        } catch (Exception e) {
            return null;
        }
    }


    
}