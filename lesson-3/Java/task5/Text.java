package task5;

public class Text implements Printable {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
