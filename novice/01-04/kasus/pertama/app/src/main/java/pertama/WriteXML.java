package pertama;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

    public class WriteXML{
        public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
 
            //root element
            Element rootElement = doc.createElement("employee details");
            doc.appendChild(rootElement);
 
            //employee element
            Element employee = doc.createElement("employee");
            doc.getDocumentElement().appendChild(employee);
            //rootElement.appendChild(employee);
 
            //setting atribute to element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            employee.setAttributeNode(attr);
 
 
            //firstname element
            Element firstName = doc.createElement("firstname");
            firstName.appendChild(doc.createTextNode("Tasya"));
            employee.appendChild(firstName);

            //lastname element
            Element lastName = doc.createElement("lastname");
            lastName.appendChild(doc.createTextNode("Ulfha"));
            employee.appendChild(lastName);
            //age element
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode("21"));
            employee.appendChild(age);

 
            //Menulis konten menjadi file xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("employee.xml"));
            transformer.transform(source, result);
 
            //output to console
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
 
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        catch (TransformerException tce){
            tce.printStackTrace();
        }
     }
 }
 

 