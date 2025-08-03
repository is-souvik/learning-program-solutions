package Design_Patterns_and_Principles.Exercise2;

public class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
