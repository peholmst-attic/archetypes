#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ui.components;

import com.vaadin.shared.communication.ServerRpc;

public interface PromptListenerForTextFieldServerRpc extends ServerRpc {

    void openPrompt();

}
