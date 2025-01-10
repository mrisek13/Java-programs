package xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XML {

    public static void main(String[] args) {
        try {
            // 1. Učitavanje XML datoteke
            File inputFile = new File("bookstore.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // 2. Ispis podataka iz XML-a
            NodeList bookList = doc.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    System.out.println("Category: " + bookElement.getAttribute("category"));
                    System.out.println("Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Author: " + bookElement.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Year: " + bookElement.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println("Price: " + bookElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("-----------------------------------");
                }
            }

            // 3. Dodavanje novog elementa
            Element newBook = doc.createElement("book");
            newBook.setAttribute("category", "NEW");
            Element newTitle = doc.createElement("title");
            newTitle.setAttribute("lang", "en");
            newTitle.setTextContent("New Java Book");
            Element newAuthor = doc.createElement("author");
            newAuthor.setTextContent("John Doe");
            Element newYear = doc.createElement("year");
            newYear.setTextContent("2025");
            Element newPrice = doc.createElement("price");
            newPrice.setTextContent("45.00");

            newBook.appendChild(newTitle);
            newBook.appendChild(newAuthor);
            newBook.appendChild(newYear);
            newBook.appendChild(newPrice);

            doc.getDocumentElement().appendChild(newBook);
            System.out.println("New book added!");

            // 4. Mijenjanje postojećeg elementa
            Node firstBook = bookList.item(0);
            if (firstBook.getNodeType() == Node.ELEMENT_NODE) {
                Element firstBookElement = (Element) firstBook;
                firstBookElement.getElementsByTagName("price").item(0).setTextContent("25.00");
                System.out.println("Price of the first book updated!");
            }

            // 5. Brisanje elementa
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    Node yearNode = bookElement.getElementsByTagName("year").item(0);
                    if (yearNode != null) {
                        bookElement.removeChild(yearNode);
                        System.out.println("Year removed from book " + (i + 1));
                    }
                }
            }

            // 6. Zapisivanje modificiranog XML-a u novu datoteku
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("modified_bookstore.xml"));
            transformer.transform(source, result);

            System.out.println("Modified XML file saved as 'modified_bookstore.xml'!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
