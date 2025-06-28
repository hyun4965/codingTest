package lab.text;

import org.w3c.dom.Text;

public class BoldText extends TextDecorator {
    BoldText(TextComponent t) {
        super(t);
    }
    @Override
    public String getText() {
        return "<b>" + component.getText()+"</b>";
    }
}
