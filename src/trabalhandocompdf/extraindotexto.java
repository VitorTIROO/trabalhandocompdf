package trabalhandocompdf;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ExtraindoTexto {

    public static void main(String args[]) {

        File file = null;

        String dirCurrent = System.getProperty("user.dir");
        String usuarioLogado = System.getProperty("user.home");
        System.out.println("Pasta corrente: " + dirCurrent);
        System.out.println("Pasta do Usuario Logado: " + usuarioLogado);

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setCurrentDirectory(new File(usuarioLogado + "\\Desktop"));
        jfc.setFileFilter(new FileNameExtensionFilter("Formatos Suportados(.pdf .xls .xlsx)", "pdf", "xls", "xlsx"));
        jfc.setAcceptAllFileFilterUsed(false);

        jfc.showDialog(null, "Selecionar");
        
        file = jfc.getSelectedFile();
        
        if (file != null) {
            
            System.out.println("Arquivo selecionado: " + file.getAbsolutePath());
            
            if (file.getAbsolutePath().endsWith(".pdf")) {
                System.out.println("Selecionado um arquivo .pdf!");
                lerPdf(file);
            } else if (file.getAbsolutePath().endsWith(".xls") || file.getAbsolutePath().endsWith(".xlsx")) {
                System.out.println("Selecionado um arquivo excel!");
            } else {
                System.out.println("Arquivo com formato não suportado!");
            }
        }

        //String arquivo = "C:\\Users\\Botuvera.MTZTI03\\Desktop\\Pecuaria\\BND - BM.pdf";
        /*            PDFTextStripper texto = new PDFTextStripper();

            for (int p = 1; p <= document.getNumberOfPages(); ++p) {
                // Set the page interval to extract. If you don't, then all pages would be extracted.
                texto.setStartPage(p);
                texto.setEndPage(p);

                // let the magic happen
                String text = texto.getText(document);

                // do some nice output with a header
                String pageStr = String.format("page %d:", p);
                System.out.println(pageStr);
                for (int i = 0; i < pageStr.length(); ++i) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.println(text.trim());
                System.out.println();

            }
            
         */
    }

    public static List<Gado> lerPdf(File file) {

        ArrayList<Gado> listaGado = new ArrayList<Gado>();
        try {

            PDDocument document = PDDocument.load(file);

            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);

            Rectangle rect = new Rectangle(0, 200, 450, 580);
            stripper.addRegion("class1", rect);
            String texto = "";
            for (int p = 0; p < document.getNumberOfPages(); ++p) {

                PDPage firstPage = document.getPage(p);
                stripper.extractRegions(firstPage);
                //System.out.println("Text in the area:" + rect);
                //System.out.print(stripper.getTextForRegion("class1"));
                texto += stripper.getTextForRegion("class1");
            }
            //System.out.println(texto);
            String[] linhas = texto.split(stripper.getLineSeparator());

            for (int i = 1; i < linhas.length; i++) {

                //System.out.println(i + " :" + linhas[i]);
                String[] infoAnimal = linhas[i].split(" ");
                //System.out.println("Qtd. Informações: " + infoAnimal.length);
                Gado g = new Gado();

                g.setBrinco(Long.parseLong(infoAnimal[0]));
                //System.out.println("Brinco: " + g.getBrinco());

                g.setDtNasc(infoAnimal[1]);
                //System.out.println("Dt. Nasc: " + g.getDtNasc());

                g.setRaca(infoAnimal[2]);
                //System.out.println("Raça: " + g.getRaca());

                g.setSexo(infoAnimal[3]);
                //System.out.println("Sexo: " + g.getSexo());

                g.setDtInclusao(infoAnimal[4]);
                //System.out.println("Dt. Inclusão: " + g.getDtInclusao());

                listaGado.add(g);
            }

            System.out.println("Qtd. Total de Animais: " + listaGado.size());

            return listaGado;

        } catch (Exception ex) {
            System.out.println("Erro ao importar dados .pdf: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivo .pdf: \n" + ex.getMessage(), "Impossivel prosseguir!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
