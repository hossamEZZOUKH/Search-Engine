package m2i;
import java.util.List;

import org.tartarus.snowball.ext.EnglishStemmer;
import org.tartarus.snowball.ext.FrenchStemmer;

import AlKhalil2.morphology.analyzer.AnalyzerTokens;
import AlKhalil2.morphology.result.model.Result;

public class Stemming {
	
	public static String stemmer(String mot,String lang) {
		mot=mot.trim();
		if(lang.equals("ar")) {
	   	 AnalyzerTokens at = new AnalyzerTokens();
	     List<Result> liste = at.analyzerToken(mot);
	     String stem="";
	     if(!liste.isEmpty()) {
	    	  stem = liste.get(0).getStem().toString();
	    	  stem=new NormalizerArab(stem).getOutput();
	     }	
		 return stem;
		 }
		else if(lang.equals("fr")) {
			FrenchStemmer stem = new FrenchStemmer() ;
			stem.setCurrent (mot) ;
			stem.stem() ;
			return stem.getCurrent() ;
		}
		else if(lang.equals("en")){
			EnglishStemmer stem = new EnglishStemmer() ;
			stem.setCurrent (mot) ;
			stem.stem() ;
			return stem.getCurrent() ;
			}
		else {
			return "";
		}
	    }
	
	
	
	
	 public static void main(String[] args) {
		 	System.out.println(stemmer(" يمارسونهاِ ","ar"));
		}

}
