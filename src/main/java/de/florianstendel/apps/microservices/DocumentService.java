package de.florianstendel.apps.microservices;

import de.florianstendel.apps.microservices.entities.FileType;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Florian on 01.04.2017.
 */
@WebService
public class DocumentService {

    @WebMethod
    public void createDocument(FileType fileType, String content){


    }
}
