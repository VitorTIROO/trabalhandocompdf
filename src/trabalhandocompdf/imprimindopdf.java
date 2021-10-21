package trabalhandocompdf;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PageRanges;
import javax.print.attribute.standard.Sides;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;

/**
 *
 * @author Vitor Ribeiro dos Santos
 */
public class ImprimindoPDF {

    public static void main(String args[]){

        String arquivo = "C:\\Users\\Botuvera.MTZTI03\\Desktop\\Pecuaria\\2020-05-11 VO JOVITA.pdf";
        try {
            PDDocument doc = PDDocument.load(new File(arquivo));

            imprimindo(doc);
            printWithPaper(doc);
        } catch (Exception e) {
            System.out.println("Erro ao imprimir: " + e.getMessage());
        }
    }

    private static void imprimindo(PDDocument doc) throws PrinterException {

        PrinterJob job = PrinterJob.getPrinterJob();

        job.setPageable(new PDFPageable(doc));
        job.print();

    }

    private static void printWithPaper(PDDocument document) throws PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(new PDFPageable(document));

        // define custom paper
        Paper paper = new Paper();
        paper.setSize(306, 396); // 1/72 inch
        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins

        // custom page format
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper);

        // override the page format
        Book book = new Book();
        // append all pages
        book.append(new PDFPrintable(document), pageFormat, document.getNumberOfPages());
        job.setPageable(book);

        job.print();
        
    }

}
