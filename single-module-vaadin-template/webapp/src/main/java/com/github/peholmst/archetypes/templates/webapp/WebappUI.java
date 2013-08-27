package com.github.peholmst.archetypes.templates.webapp;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

@Widgetset("com.github.peholmst.archetypes.templates.webapp.widgetset.WebappWidgetset")
@Theme("WebappTheme")
public class WebappUI extends UI {

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = WebappUI.class, productionMode = false)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(new Label("Hello World"));
    }
}
