package m2i;
import java.util.List;

import AlKhalil2.morphology.analyzer.AnalyzerTokens;
import AlKhalil2.morphology.result.model.Result;

public class Lemme {
	
	 public static String lemme (String str) {
	   	 AnalyzerTokens at = new AnalyzerTokens();
	     List<Result> liste = at.analyzerToken(str.trim());
	
	     String lem="";
	     if(!liste.isEmpty()) {
	    	 lem = liste.get(0).getLemma().toString();
	    	 lem=new NormalizerArab(lem).getOutput();
	     }	
		 return lem;

	    }
	 public static void main(String[] args) {
		 	System.out.println(lemme("مهندس"));
		}

}
