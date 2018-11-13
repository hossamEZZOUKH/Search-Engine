/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author student
 */
public class Tradu {
    
    
     public Tradu() {
    }
    
public static String tra(String text,String lang1,String lang2) throws Exception {
         String text1="";
        
        if(lang1.equals(lang2)){
            return text;
        }else{
 
      
        
        InputStream ipx=new FileInputStream("C:\\Users\\med\\eclipse-workspace\\Testt\\Dict\\dico-"+lang1.trim()+""+lang2.trim()+".csv");
	 InputStreamReader ipsxr=new InputStreamReader(ipx,"UTF-8");
	 BufferedReader brx=new BufferedReader(ipsxr);
	 String ligne="";
        
         brx.readLine();
	 while ((ligne=brx.readLine())!=null){
             if(!ligne.equals("")){
                 ligne=ligne.replaceAll("\"", "");
		 String[] lign=ligne.split(",");
              String [] rrr=lign[3].split(" ");
              for(String e:rrr){
             if(e.equals(text)){
                text1=text1+"<br >"+lign[3]+"\t"+lign[5]+"</br>\n";
}}}
         }}
return text1;
}

public static void main(String[] args) throws Exception{
        
    System.out.println(tra("ياردة", "Ar", "En"));
      } }

        
    
        
