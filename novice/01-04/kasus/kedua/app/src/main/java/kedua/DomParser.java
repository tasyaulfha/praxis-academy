/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kedua;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;



public class DomParser {


    static Document parseDoc(String doc) throws ParserConfigurationException, SAXException, IOException{
        /* 1. Get the instance of BuilderFactory class. */
        DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();

        /* 2. Instantiate DocumentBuilder object. */
        DocumentBuilder docBuilder = builder.newDocumentBuilder();

        /* Get the Document object  */
        Document document = docBuilder.parse("employee.xml");

        return document;
    }

    static void addNewEmployee(Document doc, Employee emp){
        Element employee = doc.createElement("employee");
        employee.setAttribute("id", emp.getId());
        employee.setAttribute("type", emp.getType());

        /* Create firstname elment and add it to employee element */
        Element firstName = doc.createElement("firstname");
        firstName.setTextContent(emp.getFirstName());
        employee.appendChild(firstName);

        /* Create lastname elment and add it to employee element */
        Element lastName = doc.createElement("lastname");
        lastName.setTextContent(emp.getLastName());
        employee.appendChild(lastName);

        /* Create firstname elment and add it to employee element */
        Element address = doc.createElement("address");
        address.setAttribute("type", emp.getAddrees().getType());
        employee.appendChild(address);

        /* Create firstname elment and add it to employee element */
        Element area = doc.createElement("area");
        area.setTextContent(emp.getAddrees().getArea());
        address.appendChild(area);

        /* Create firstname elment and add it to employee element */
        Element city = doc.createElement("city");
        city.setTextContent(emp.getAddrees().getCity());
        address.appendChild(city);

        /* Create firstname elment and add it to employee element */
        Element state = doc.createElement("state");
        state.setTextContent(emp.getAddrees().getState());
        address.appendChild(state);

        /* Create firstname elment and add it to employee element */
        Element country = doc.createElement("country");
        country.setTextContent(emp.getAddrees().getCountry());
        address.appendChild(country);

        doc.getElementsByTagName("employees").item(0).appendChild(employee);
    }

    static void saveDocument(Document doc) throws TransformerConfigurationException, TransformerException{
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        Result output = new StreamResult(new File("output.xml"));
        Source input = new DOMSource(doc);
        transformer.transform(input, output);
    }

    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
        
        /* Get the document */
        Document document = parseDoc("employee.xml");

        /* Populate Employee and adress properties */
        Address addr = new Address();
        addr.setArea("Laxmi circle");
        addr.setCity("Guntur");
        addr.setCountry("India");
        addr.setState("Andhra Pradesh");
        addr.setType("permanent");

        Employee emp = new Employee();
        emp.setAddrees(addr);
        emp.setFirstName("Murali Krishna");
        emp.setLastName("Bachu");
        emp.setId("4");
        emp.setType("permanent");
        
        /* Add Employee to document */
        addNewEmployee(document, emp);

        /* Save the document */
        saveDocument(document);
    }
}