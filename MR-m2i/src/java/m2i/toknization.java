package m2i;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import sun.util.locale.StringTokenIterator;

public class toknization {

    static org.jdom2.Document document;

    public static void tokn() throws IOException {
        System.out.println("111111");
        BufferedWriter fr = null;
        BufferedWriter en = null;
        BufferedWriter ar = null;
        File file = new File("MultedCorpus");
        File[] F = file.listFiles();
        File ToknAr = new File("tokn\\ar");
        File ToknFr = new File("tokn\\fr");
        File ToknEn = new File("tokn\\en");
        Normalisation N = new Normalisation();

        SAXBuilder sxb = new SAXBuilder();
        for (File Ffile : F) {

            try {
                document = sxb.build(Ffile);
                System.out.println("222222");
            } catch (Exception e) {
                System.out.println("1111113333");
                e.printStackTrace();
            }

            Element racine = document.getRootElement();

            List<Element> listeTalk = racine.getChildren("Talk");

            for (Element talk : listeTalk) {
                // br = new BufferedReader(new FileReader(Ffile));
                ar = new BufferedWriter(new FileWriter("tokn\\ar\\" + Ffile.getName().replaceAll(".xml", ".txt")));
                fr = new BufferedWriter(new FileWriter("tokn\\fr\\" + Ffile.getName().replaceAll(".xml", ".txt")));
                en = new BufferedWriter(new FileWriter("tokn\\en\\" + Ffile.getName().replaceAll(".xml", ".txt")));

                List<Element> segs = talk.getChildren("Segment");
                for (Element seg : segs) {
                    Integer id = Integer.parseInt(seg.getAttributeValue("id"));
                    List<Element> transO = seg.getChildren("Original_text");
                    for (Element tran : transO) {
                        String motTalk = Normalisation.Normalizer(tran.getText().toLowerCase());
                        StringTokenizer text = new StringTokenizer(motTalk);

                        while (text.hasMoreElements()) {

                            en.write("\n" + text.nextToken() + "," + id);
                        }

                    }
                    List<Element> trans = seg.getChildren("Translation");
                    for (Element tran : trans) {
                        String motTalk = tran.getText().toLowerCase();

                        if (tran.getAttributeValue("lang").equals("ar")) {

                            motTalk = new NormalizerArab(motTalk).getOutput();
                            AlKhalil2.text.tokenization.Tokenization text = new AlKhalil2.text.tokenization.Tokenization();
                            text.setTokenizationString(motTalk);

                            for (int i = 0; i < text.getAllTokens().size(); i++) {
                                ar.write("\n" + text.getAllTokens().toArray()[i].toString() + "," + id);
                            }

                        } else if (tran.getAttributeValue("lang").equals("fr")) {
                            motTalk = Normalisation.Normalizer(motTalk);

                            StringTokenizer text = new StringTokenizer(motTalk);
                            while (text.hasMoreElements()) {

                                fr.write("\n" + text.nextToken().trim() + "," + id);
                            }
                        }
                    }
                }
            }
            ar.close();
            fr.close();
            en.close();
            System.out.println("fin de toknisation");
        }
    }

    public static String supprimmeMotVide(String lang, String chaine) {
        String[] mot = chaine.split(" ");
        ArrayList<String> mots = new ArrayList<String>();
        String chaineN = "";
        try {
            for (int i = 0; i < mot.length; i++) {
                mots.add(mot[i]);
            }
            for (int i = 0; i < mot.length; i++) {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\med\\Documents\\NetBeansProjects\\MR-m2i\\stopwords\\stopwords_" + lang.toLowerCase() + ".txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    if (mot[i].equals(line)) {
                        mots.remove(mot[i]);
                    }
                }
                br.close();
            }

            for (int i = 0; i < mots.size(); i++) {
                chaineN += mots.get(i) + " ";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return chaineN;
    }

    public static void main(String[] args) throws Exception {

        tokn();

    }
}
