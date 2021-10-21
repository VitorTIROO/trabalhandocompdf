package trabalhandocompdf;

/**
 *
 * @author Vitor Ribeiro dos Santos
 */
import java.io.*;
import java.util.Iterator;
import javax.swing.JFileChooser;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInputStream;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.text.PDFTextStripper;

public class UtilTexto {

    /**
     * Le o conteudo (texto) de um arquivo pdf
     *
     */
    public static String extraiTextoDoPDF(String caminho) {
        PDDocument pdfDocument = null;
        
        try {
            
            File file = new File(caminho);
            pdfDocument = PDDocument.load(file);
            
            PDFTextStripper stripper = new PDFTextStripper();
            
            String texto = stripper.getText(pdfDocument);
            
            System.out.println("Separador de linha: " + stripper.getLineSeparator());
            System.out.println("Article End: " + stripper.getArticleEnd());
            System.out.println("Article Start: " + stripper.getArticleStart());
            System.out.println("Page Start: " + stripper.getPageStart());
            System.out.println("Page End: " + stripper.getPageEnd());
            System.out.println("Paragraph Start: " + stripper.getParagraphStart());
            System.out.println("Paragraph End: " + stripper.getParagraphEnd());
            System.out.println("Start Bookmark: " + stripper.getStartBookmark());
            
            System.out.println("Nº de paginas: " + pdfDocument.getNumberOfPages());
            System.out.println("Document Information: " + pdfDocument.getDocumentInformation());
            System.out.println("Pages: " + pdfDocument.getPages());
            System.out.println("Page 2: " + pdfDocument.getPage(2));
            
            PDPageTree paginas = pdfDocument.getPages();
            
            
            
            for (int i=0; i < paginas.getCount(); i++) {
                PDPage pagina = paginas.get(i);
                
                PDAnnotation pda = (PDAnnotation) pagina.getAnnotations();
                
                InputStream is = pagina.getContents();
                System.out.println("is.toString(): " + is.toString());
               
                
                System.out.println("Contents page(" +i+") : " + pagina.getContents());
            }
            
            return texto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (pdfDocument != null) {
                try {
                    pdfDocument.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     *
     * Extrai o conteudo do arquivo indicado
     *
     */
    public static void main(String[] args) {
        
        //JFileChooser chooseFile = new JFileChooser();
        //chooseFile.showDialog(null, "Selecionar");
//        System.out.println("Caminho: " + chooseFile.getSelectedFile().getAbsolutePath());
//        String caminho = chooseFile.getSelectedFile().getAbsolutePath();
        String texto = extraiTextoDoPDF("C:\\Users\\Botuvera.MTZTI03\\Desktop\\Pecuaria\\2020-05-11 VO JOVITA.pdf");
        System.out.println(texto);
    }
}
