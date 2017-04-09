package de.florianstendel.apps.microservices.ui;

import com.vaadin.annotations.Title;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Florian on 03.04.2017.
 */
@Title("Dokumentenverwaltung")
public class MainUi extends UI {

    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout leftPanel = new VerticalLayout();
        VerticalLayout rightPanel = new VerticalLayout();
        HorizontalSplitPanel pageContent = new HorizontalSplitPanel(leftPanel,rightPanel);
        //  VerticalLayout pageContent = new VerticalLayout();
        pageContent.setSplitPosition(200,Unit.PIXELS,false);
        pageContent.setLocked(true);

        pageContent.setSizeFull();
        setContent(pageContent);

        Button button = new Button("Drück mich");

        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent clickEvent) {
                Notification.show("Document creation", "Client application requested new" +
                        "document of type: invoice.", Notification.Type.TRAY_NOTIFICATION);

            }
        });

        leftPanel.addComponent(new Label("Übersicht"));
        leftPanel.addComponent(new Label("Templates"));
        leftPanel.addComponent(new Label("Dokumentarchiv"));
        rightPanel.addComponent(button);
    }
}
