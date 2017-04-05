package de.florianstendel.apps.microservices.ui;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * Created by Florian on 03.04.2017.
 */
public class SampleUi extends UI {


    protected void init(VaadinRequest vaadinRequest) {

        Page.getCurrent().setTitle("Dokumentenverwaltung");

        VerticalLayout leftPanel = new VerticalLayout();
        VerticalLayout rightPanel = new VerticalLayout();
        HorizontalSplitPanel pageContent = new HorizontalSplitPanel(leftPanel,rightPanel);
        //  VerticalLayout pageContent = new VerticalLayout();
        pageContent.setSplitPosition(200,Unit.PIXELS,false);


        pageContent.setSizeFull();
        setContent(pageContent);

        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Menu",
                new MenuBar.Command() {
                    public void menuSelected(MenuBar.MenuItem menuItem) {
                        System.out.println("Menu clicked.");
                    }
                });

        leftPanel.addComponent(new Label("Übersicht"));
        leftPanel.addComponent(new Label("Templates"));
        leftPanel.addComponent(new Label("Dokumentarchiv"));
        rightPanel.addComponent(new Button("Drück mich"));
    }
}
