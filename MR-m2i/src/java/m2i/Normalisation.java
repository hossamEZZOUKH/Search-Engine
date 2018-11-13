package m2i;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Normalisation {
	public static String Normalizer(String text) {
		
		text=text.replaceAll("\\s+", " ").trim();
	text=text.toLowerCase();
	String R="";
String[] txt=text.split(" ");
for(int i=0;i<txt.length;i++) {
	txt[i]=txt[i].replaceAll("[^a-z0-9]", "");
	R=R+" "+txt[i];
	}
	
	
//	for(String ntext:txt) {
//	if((int)txt[i].charAt(0)>96 && (int)txt[i].charAt(0)<=122) {
//		newtxt=newtxt+" "+txt[i];
//	}i++;
//	}
		return R.trim();
	}
	public static void main(String[] args) {
	 	System.out.println(Normalizer("(2ter:)A gjhj"));
	}
	
}
