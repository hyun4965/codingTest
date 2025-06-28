package lab.text;

public abstract class TextDecorator implements TextComponent {
    protected TextComponent component;
    public TextDecorator(TextComponent component) {
        this.component = component;
    }

}
