package m2i;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

public class Index {
public static  void index(String  log) throws Exception {
	ArrayList<String> list=new ArrayList<String>();
	ArrayList<String> listStemme=new ArrayList<String>();
	ArrayList<String> listlemme=new ArrayList<String>();
	File file=new File("tokn\\"+log);
	File[] F=file.listFiles();
	BufferedWriter bw=new BufferedWriter(new FileWriter(System.getProperty("\\user.dir\\") +"\\Testt\\Index\\Index_"+log+".txt"));
	BufferedWriter bw1=new BufferedWriter(new FileWriter(System.getProperty("\\user.dir\\") +"\\Testt\\Index\\Index_"+log+"Stemme.txt"));
        BufferedWriter bw2 = null;
 if(log.equals("ar")){
             FileWriter fr=new FileWriter("C:\\Users\\med\\eclipse-workspace\\Testt\\Index\\Index_arlemme.txt");

     bw2=new BufferedWriter(fr);
     
 }
	String ligne; int t=0;
	for(int i=0;i<F.length;i++) {
	BufferedReader br1=new BufferedReader(new FileReader(F[i]));
	
		 while(( ligne=br1.readLine())!=null){
			 if(!ligne.equals("")) {
			 String[] tst=ligne.split(",");
			 
			 String text=tst[0]+","+(i+1)+","+tst[1];
			 
			  list.add(text);
			  
			  
			  Stemming s=new Stemming();
			  String gg=s.stemmer(tst[0], log);
			  System.out.println(tst[0]+"\t"+gg);
			  if(gg.equals(""))gg=tst[0];
			  System.out.println(tst[0]+"\t"+gg);
			  String text1=gg+","+(i+1)+","+tst[1];
			  listStemme.add(text1);
			
			  
		if(log.equals("ar")){	  String ll=Lemme.lemme(tst[0]);
			  if(!ll.equals("")) {listlemme.add(ll+","+(i+1)+","+tst[1]);
			  System.out.println(tst[0]+"\t"+ll);}}
		 }
		 } 
		
	}
	for(int i=0;i<list.size();i++) {

		String test=""+list.get(i);
		for(int j=i+1;j<list.size();j++) {
			String[] test5=test.split(",");
				String[] test1=list.get(i).split(",");
                String[] test2=list.get(j).split(",");
                if(test1[0].equals(test2[0])&&test1[1].equals(test2[1])&&!(test5[test5.length-1].equals(test2[2]))) {
                	test=test+","+test2[2];
                	list.remove(j);
                	j--;
                } }
		bw.write(test);
		test="";
		bw.newLine();}
	
	
	
	
	
	for(int i=0;i<listStemme.size();i++) {

		String testS=""+listStemme.get(i);
		for(int j=i+1;j<listStemme.size();j++) {
			String[] test5=testS.split(",");
				String[] test3=listStemme.get(i).split(",");
                String[] test4=listStemme.get(j).split(",");
                if(test3[0].equals(test4[0])&&test3[1].equals(test4[1])&&!(test5[test5.length-1].equals(test4[2]))) {
                	testS=testS+","+test4[2];
                	listStemme.remove(j);
                	j--;
                }
			
	}
		bw1.write(testS);
		testS="";
		bw1.newLine();
		
	}
		
		
		
	if(log.equals("ar")) {	for(int i=0;i<listlemme.size();i++) {

			String testS=""+listlemme.get(i);
			for(int j=i+1;j<listlemme.size();j++) {
				String[] test5=testS.split(",");

					String[] test3=listlemme.get(i).split(",");
	                String[] test4=listlemme.get(j).split(",");
	                if(test3[0].equals(test4[0])&&test3[1].equals(test4[1])&&!(test5[test5.length-1].equals(test4[2]))) {
	                	testS=testS+","+test4[2];
	                	listlemme.remove(j);
	                	j--;
	                }
				
		}
		
		
		
		bw2.write(testS);
		testS="";
		bw2.newLine();
		
		}}
	
		if (log.equals("ar"))bw2.close();
	
	bw1.close();
	bw.close();
	
}
public boolean test(ArrayList<String> nom,String text) {
	for(String tst:nom)if(tst.equals(text))return true;
	return false;
}
public static  void main(String[] args) throws Exception {
double t=System.currentTimeMillis()/1000;
toknization.tokn();
 
	 index("fr");
 	index("en");
        index("ar");
	double tt=System.currentTimeMillis()/1000;

	System.out.println("fin\t"+(tt-t));
}
}
