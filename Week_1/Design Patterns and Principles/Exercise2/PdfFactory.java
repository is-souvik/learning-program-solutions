package Design_Patterns_and_Principles.Exercise2;

public class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
