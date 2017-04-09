package de.florianstendel.apps.microservices;

import de.florianstendel.apps.microservices.document.PDFCreator;
import de.florianstendel.apps.microservices.entities.FileType;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.MTOM;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Created by Florian on 01.04.2017.
 */
@WebService
@MTOM
public class DocumentServiceJaxWsEndpoint {

    private PDFCreator pdfCreator = new PDFCreator();

    @WebMethod
    public DataHandler createDocument(String content){

        ByteArrayOutputStream outputStream = pdfCreator.create(content);

        DataHandler dataHandler = new DataHandler(outputStream.toByteArray(),"application/pdf");

        return dataHandler;

    }
}
