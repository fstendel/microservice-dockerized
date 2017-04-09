package de.florianstendel.apps.microservices.document;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.Matrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Florian on 09.04.2017.
 */
public class PDFCreator {



    public ByteArrayOutputStream create(final String message){
        // the document
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PDDocument doc = null;
        try {
            doc = new PDDocument();

            PDFont font = PDType1Font.TIMES_BOLD_ITALIC;
            PDPage page = new PDPage(PDRectangle.A4);
            page.setRotation(90);
            doc.addPage(page);
            PDRectangle pageSize = page.getMediaBox();
            float pageWidth = pageSize.getWidth();
            float fontSize = 100;
            float stringWidth = font.getStringWidth(message) * fontSize / 1000f;
            float startX = 100;
            float startY = 100;
            PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.OVERWRITE, false);
            // add the rotation using the current transformation matrix
            // including a translation of pageWidth to use the lower left corner as 0,0 reference
            contentStream.transform(new Matrix(0, 1, -1, 0, pageWidth, 0));
            contentStream.setFont(font, fontSize);
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText(message);
            contentStream.endText();


            contentStream.close();

            doc.save(outputStream);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) {
                try {
                    doc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return outputStream;
    }
}
