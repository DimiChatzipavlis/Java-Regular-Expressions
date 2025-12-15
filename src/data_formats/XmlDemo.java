import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XmlDemo.java
 * 
 * This class demonstrates XML parsing and XSD Validation.
 * 
 * Concepts:
 * 1. Validating XML against an XSD schema.
 * 2. Parsing XML using DOM Parser.
 */
public class XmlDemo {
    public static void main(String[] args) {
        String xmlFile = "student.xml";
        String xsdFile = "student.xsd";

        System.out.println("=== XML Demo with XSD Validation ===");
        
        // 1. Validate XML against XSD
        boolean isValid = validateXMLSchema(xsdFile, xmlFile);
        
        if (isValid) {
            System.out.println("✅ XML is valid against the XSD.");
            // 2. Parse the XML if valid
            parseXML(xmlFile);
        } else {
            System.out.println("❌ XML is NOT valid.");
        }
    }
    
    private static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            return true;
        } catch (Exception e) {
            System.out.println("Validation Error: " + e.getMessage());
            return false;
        }
    }
    
    private static void parseXML(String xmlPath) {
        try {
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            System.out.println("\n--- Parsed Data ---");
            Element root = doc.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());
            
            String id = root.getElementsByTagName("id").item(0).getTextContent();
            String name = root.getElementsByTagName("name").item(0).getTextContent();
            String course = root.getElementsByTagName("course").item(0).getTextContent();
            
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Course: " + course);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
