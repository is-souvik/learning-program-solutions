package Design_Patterns_and_Principles.Exercise2;

public class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
