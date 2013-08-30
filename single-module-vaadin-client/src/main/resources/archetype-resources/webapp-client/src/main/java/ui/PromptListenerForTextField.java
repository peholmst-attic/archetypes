#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ui.components;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.AbstractTextField;

import java.util.HashSet;
import java.util.Set;

public class PromptListenerForTextField extends AbstractExtension {

    private Set<Listener> listeners = new HashSet<>();

    public interface Listener {
        void openPrompt(PromptListenerForTextField sender);
    }

    private final PromptListenerForTextFieldServerRpc rpc = new PromptListenerForTextFieldServerRpc() {
        @Override
        public void openPrompt() {
            for (Listener listener : new HashSet<>(listeners)) {
                listener.openPrompt(PromptListenerForTextField.this);
            }
        }
    };

    public PromptListenerForTextField(AbstractTextField target) {
        registerRpc(rpc);
        extend(target);
    }

    public void addPromptListener(Listener listener) {
        listeners.add(listener);
    }

    public void removePromptListener(Listener listener) {
        listeners.remove(listener);
    }
}
