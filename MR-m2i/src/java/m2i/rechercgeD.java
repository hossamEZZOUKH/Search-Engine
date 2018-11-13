package m2i;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import static m2i.toknization.document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class rechercgeD {
    	static org.jdom2.Document document;

	public static String rech(String nom,String lang,String lang1 ,String la) throws Exception {
            
            if(lang.equals("Ar"))nom=new NormalizerArab(nom).getOutput();
            else nom=Normalisation.Normalizer(nom);
            
            
            
            
            
            
            
            
            
            
            
            
            
              if(!lang.equals("Ar")){
         StringTokenizer text2=new StringTokenizer(nom.trim());
		while (text2.hasMoreElements()) {
			 if(la.equals("")){nom=(text2.nextToken().trim());}
                         else if(la.equals("Stemme")){
String ss=text2.nextToken().trim();
                      //   System.out.println(ss);

                      String s=Stemming.stemmer(ss,lang.toLowerCase());
                       //  System.out.println(s);
                         nom=s;
                         }else{
                          String s=Lemme.lemme(text2.nextToken().trim());
nom=s;
                    }
		}}else{
             
           //  text1=new NormalizerArab(text1).getOutput();
       AlKhalil2.text.tokenization.Tokenization text5 =new AlKhalil2.text.tokenization.Tokenization();
  text5.setTokenizationString(nom);

for(int i=0;i<text5.getAllTokens().size();i++) {
    if(la.equals("")){nom=text5.getAllTokens().toArray()[i].toString();}else{
            String t=text5.getAllTokens().toArray()[i].toString();
            t=Stemming.stemmer(t,lang.toLowerCase());
            nom=t;
            }
    
}
       
            
              }   
            
            
            
            
            HashSet<String> hash=new HashSet<String>();
		String url="";
		 InputStream ipx=new FileInputStream("C:\\Users\\med\\eclipse-workspace\\Testt\\Index\\Index_"+lang.toLowerCase()+""+la.trim()+".txt");
		 InputStreamReader ipsxr=new InputStreamReader(ipx,"UTF-8");
		 BufferedReader brx=new BufferedReader(ipsxr);
		// for(String nomk:nom) {
                   //  System.out.println("||||||||||||||||||||||||");
		 String ligne;
		 while ((ligne=brx.readLine())!=null){
			 String[] lign=ligne.split(",");
			 if(nom.equals(lign[0])) {
				 int ind=Integer.parseInt(lign[1]);
				 File f=new File("C:\\Users\\med\\eclipse-workspace\\Testt\\MultedCorpus");
				 File[]Ff=f.listFiles();
			//	if(!rem.re(hash,"<h2><a href=\"C:\\Users\\med\\eclipse-workspace\\Testt\\MultedCorpus\\"+Ff[ind-1].getName()+"\">"+Ff[ind-1].getName()+"</a></br></h2>")){
                                    String tttt="\n </br><h2><a href='C:\\Users\\med\\eclipse-workspace\\Testt\\MultedCorpus\\"+Ff[ind-1].getName().replaceAll(" ", "%20")+"'>"+Ff[ind-1].getName()+"</a></h2>";
                               SAXBuilder sxb = new SAXBuilder();
                                    document = sxb.build(Ff[ind-1]);
                                    Element racine = document.getRootElement();
                                    	List<Element> listeTalk = racine.getChildren("Talk");
		
	for (Element talk : listeTalk) {
                                List<Element> segs = talk.getChildren("Segment");
			for (Element seg : segs) {
				String id=seg.getAttributeValue("id");
                                if(id.equals(lign[2].trim())){
                                    
                                    
                                    
                                   
                                    List<Element> transO = seg.getChildren("Original_text");
				for (Element tran : transO) {
				if(tran.getAttributeValue("lang").equals(lang1.toLowerCase())) {
						// System.out.println("\n <br><h3>"+tran.getText()+"</h3></br>");
						
                                    tttt=tttt+"\n<br>"+tran.getText()+"</br>";
                                    
                                        }	
					
					
					
				
				}
				List<Element> trans = seg.getChildren("Translation");
				for (Element tran : trans) {
					if(tran.getAttributeValue("lang").equals(lang1.toLowerCase())) {
						
                                    tttt=tttt+"\n <br><h3>"+tran.getText()+"</h3></br>";
                                    
                                        }
                                
                                }
                                    
                                    
                                    
                                }
                                }}
                                hash.add(tttt);
                                
			
                         }}//}
	           Iterator it=hash.iterator();
                   while(it.hasNext())
                 url=url+" "+it.next();
		return url;
	}
    public static void main(String[] args) throws Exception {
        String []text=new String[4];
       text[0]="أخلاقه"; 


// String non="لا" ;


        System.out.println(""+rech(text[0],"Ar","En","Stemme"));     }
}
