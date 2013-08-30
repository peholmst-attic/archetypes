#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ui.components.client;

import ${package}.ui.components.PromptListenerForTextField;
import ${package}.ui.components.PromptListenerForTextFieldServerRpc;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.FocusWidget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

@Connect(PromptListenerForTextField.class)
public class PromptListenerForTextFieldConnector extends AbstractExtensionConnector implements KeyUpHandler {

    @Override
    protected void extend(ServerConnector serverConnector) {
        FocusWidget widget = (FocusWidget) ((ComponentConnector) serverConnector).getWidget();
        widget.addKeyUpHandler(this);
        widget.addStyleName("prompt-field");
    }

    @Override
    public void onKeyUp(KeyUpEvent keyUpEvent) {
        if (keyUpEvent.isControlKeyDown() && keyUpEvent.getNativeKeyCode() == 32) {
            getRpcProxy(PromptListenerForTextFieldServerRpc.class).openPrompt();
        }
    }
}
