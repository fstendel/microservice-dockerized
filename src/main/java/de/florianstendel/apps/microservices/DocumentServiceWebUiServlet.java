package de.florianstendel.apps.microservices;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import de.florianstendel.apps.microservices.ui.SampleUi;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Florian on 01.04.2017.
 */

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false,ui = SampleUi.class)
public class DocumentServiceWebUiServlet extends VaadinServlet{
}
