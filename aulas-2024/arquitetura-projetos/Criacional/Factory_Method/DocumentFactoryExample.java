//package Criacional.Factory_Method;

// Produto abstrato.
interface Document {
    void open();
}

// Produtos concretos.
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abrindo documento Word.");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abrindo documento PDF.");
    }
}

// Fábrica abstrata.
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Fábricas concretas.
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Main para testar o padrão Factory Method.
public class DocumentFactoryExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
    }
}