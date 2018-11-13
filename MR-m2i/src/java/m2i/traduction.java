/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i;

import com.sun.xml.xsom.impl.scd.Iterators;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author med
 */
public class traduction {
    
    
     public traduction() {
    }
    
public static HashSet<String> tra(String text,String lang1,String lang2,String la) throws Exception {
	HashSet<String> R=new HashSet<String>();
        String text1="";

        
          if(lang1.equals("Ar"))text=new NormalizerArab(text).getOutput();else text=Normalisation.Normalizer(text);
            text=toknization.supprimmeMotVide(lang1, text);
            text1=text;
        if(!lang1.equals(lang2)){
 text1="";
      
    String tst[]=text.split(" ");
        for(String tst1:tst){
            
             InputStream ipx=new FileInputStream("C:\\Users\\med\\eclipse-workspace\\Testt\\Dict\\dico-"+lang1.trim()+""+lang2.trim()+".csv");
	 InputStreamReader ipsxr=new InputStreamReader(ipx,"UTF-8");
	 BufferedReader brx=new BufferedReader(ipsxr);
	 String ligne="";
	 while ((ligne=brx.readLine())!=null){
		
            ligne=ligne.replaceAll("\"", "");
         if(!ligne.equals("")) {       String[] lign=ligne.split(",");
              		String[] lignS=lign[3].split(" ");

         for(String tsst:lignS) {  
                  if(lang1.equals("Ar"))tsst=new NormalizerArab(tsst).getOutput();else tsst=Normalisation.Normalizer(tsst);
             
             if(tsst.trim().equals(tst1.trim())){
                 String[] ttt=lign[5].split(";");
                 for(String nom:ttt){
                     if(lang2.equals("Ar"))nom=new NormalizerArab(nom).getOutput();else nom=Normalisation.Normalizer(nom);
                    text1=text1+" "+nom;
                }
            
             }}
         }}
        }
        
        }
        
        
        
        
        // toknisation text1
        
         if(!lang2.equals("Ar")){
             String textS=toknization.supprimmeMotVide(lang2,text1.trim());
         StringTokenizer text2=new StringTokenizer(textS);
		while (text2.hasMoreElements()) {
			 if(la.equals("")){ R.add(text2.nextToken().trim());
                           //  System.out.println(""+text2.nextToken().trim());
                    }else if(la.equals("Stemme")){
String ss=text2.nextToken().trim();
                      //   System.out.println(ss);

                      String s=Stemming.stemmer(ss,lang2.toLowerCase());
                       //  System.out.println(s);
                         R.add(s);
                         }
		}}else{
       AlKhalil2.text.tokenization.Tokenization text5 =new AlKhalil2.text.tokenization.Tokenization();
  text5.setTokenizationString(text1);

for(int i=0;i<text5.getAllTokens().size();i++) {
    if(la.trim().equals("")){
   R.add(toknization.supprimmeMotVide(lang2,text5.getAllTokens().toArray()[i].toString().trim()));
    }else if(la.trim().equals("Stemme")){
            String t=text5.getAllTokens().toArray()[i].toString().trim();
            t=Stemming.stemmer(t,lang2.toLowerCase());
            R.add(toknization.supprimmeMotVide(lang2,t));
            }else{
                          String s=Lemme.lemme(text5.getAllTokens().toArray()[i].toString().trim());
R.add(s);
                    }
    
}
             
             
         }
         
	return R;
}
  public static void main(String []a) throws Exception{
      HashSet<String> t=tra("ingénierie","Fr","Ar","lemme");
      Iterator<String> it=t.iterator();
      	while(it.hasNext())System.out.println(it.next());

  } 
}
