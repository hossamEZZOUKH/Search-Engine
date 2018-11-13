package m2i;

import com.sun.xml.xsom.impl.scd.Iterators;
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

public class recherche {

    static org.jdom2.Document document;

    public static String rech(String nom, String lang, String la) throws Exception {
        HashSet<String> hash = new HashSet<String>();
        String url = "";
        InputStream ipx = new FileInputStream("C:\\Users\\med\\eclipse-workspace\\Testt\\Index\\Index_" + lang.toLowerCase().trim() + "" + la.trim() + ".txt");
        InputStreamReader ipsxr = new InputStreamReader(ipx, "UTF-8");
        BufferedReader brx = new BufferedReader(ipsxr);
        // for(String nomk:nom) {
        //  System.out.println("||||||||||||||||||||||||");
        String ligne;
        while ((ligne = brx.readLine()) != null) {
            String[] lign = ligne.split(",");
            //   System.err.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

            if (nom.trim().equals(lign[0].trim())) {
                int ind = Integer.parseInt(lign[1].trim());
                File f = new File("C:\\Users\\med\\eclipse-workspace\\Testt\\MultedCorpus");
                File[] Ff = f.listFiles();
                String tttt = "\n <a href=\"C:" + File.separator + "Users" + File.separator + "med" + File.separator + "eclipse-workspace" + File.separator + "Testt" + File.separator + "MultedCorpus" + File.separator + "" + Ff[ind - 1].getName() + "\"  > <h1>" + Ff[ind - 1].getName() + "</h1></a>";
                //     System.out.println(tttt);
                SAXBuilder sxb = new SAXBuilder();
                document = sxb.build(Ff[ind - 1]);
                Element racine = document.getRootElement();
                List<Element> listeTalk = racine.getChildren("Talk");

                for (Element talk : listeTalk) {
                    List<Element> segs = talk.getChildren("Segment");
                    for (Element seg : segs) {
                        String id = seg.getAttributeValue("id");
                        if (id.equals(lign[2].trim())) {

                            List<Element> transO = seg.getChildren("Original_text");
                            for (Element tran : transO) {
                                if (tran.getAttributeValue("lang").equals(lang.toLowerCase())) {
                                    //	System.out.println("\n <br><h3>"+tran.getText()+"</h3></br>");

                                    tttt = tttt + "\n<h2>" + tran.getText() + "</h2></br>";

                                }

                            }
                            List<Element> trans = seg.getChildren("Translation");
                            for (Element tran : trans) {
                                if (tran.getAttributeValue("lang").equals(lang.toLowerCase())) {

                                    tttt = tttt + "\n <h2>" + tran.getText() + "</h2></br>";

                                }

                            }

                        }
                    }
                }
                hash.add(tttt);
                //        System.out.println("1111"+tttt);

            }
        }//}
        Iterator it = hash.iterator();
        while (it.hasNext()) {
            url = url + " " + it.next();
        }
        if (url.equals("")) {
            return "pas de resultat";
        }
        return url;
    }

    public static void main(String[] args) throws Exception {
        //  System.out.println("1111");

        HashSet<String> tra = traduction.tra("gets", "En", "Ar", "Stemme");
        HashSet<String> urel = new HashSet<String>();
        Iterator<String> it = tra.iterator();
        while (it.hasNext()) {
            String te = it.next();
            String[] yyy = rech(te, "Ar", "Stemme").split("</br>");
            for (String g : yyy) {
                urel.add(g);
            }
        }
        String url = "";
        for (String t : urel) {
            url = url + "" + t;
        }
        System.out.println("" + url);
        System.out.println("" + rech("informed", "En", ""));

    }
}
