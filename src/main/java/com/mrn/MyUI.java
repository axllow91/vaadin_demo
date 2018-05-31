package com.mrn;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();

        TextField userName = new TextField();
        userName.setCaption("Username");

        Label label = new Label();

        Button login = new Button("Login");

        login.addClickListener(clickEvent -> {
            label.setValue(userName.getValue());
            Notification.show("Welcome, " + userName.getValue());

        });

        // spacing
        verticalLayout.setMargin(true);
        verticalLayout.setSpacing(true);

        // connect elements to the layout (horizontal Layout)
        verticalLayout.addComponents(userName, login, label);


        // set content
        setContent(verticalLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
