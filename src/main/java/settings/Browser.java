package settings;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String text;

    Browser(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
