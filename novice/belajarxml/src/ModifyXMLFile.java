import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModifyXMLFile {

        public ModifyXMLFile() {
            try{
                String filepath = "Mahasiswa.xml";
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);

                //Root elemet
                Node root= doc.getFirstChild();

                //Mengambil elemen berdasarkan tag
                Node staff = doc.getElementsByTagName("mahasiswa").item(0);

                //Mengubah atribut id pada elemen Mahasiswa
                NamedNodeMap attr = staff.getAttributes();
                Node nodeAttr = attr.getNamedItem("id");
                nodeAttr.setTextContent("4");

                //Menambahkan elemen umur
                Element age = doc.createElement("umur");
                age.appendChild(doc.createTextNode("21"));
                staff.appendChild(age);

                NodeList list = staff.getChildNodes();

                //looping mencari nama elemen
                for (int i =0; i<list.getLength();i++){
                    Node node = list.item(i);

                    //jika nama node ditemukan, update value
                    if("nama".equals(node.getNodeName())){
                        node.setTextContent("Pizaini, ST");
                    }
                }
                //Menulis data ke file xml
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result =  new StreamResult(new File(filepath));
                transformer.transform(source, result);

            }catch(ParserConfigurationException pce){
                System.out.print(pce.getMessage());
            }catch(TransformerException tfe){
                System.out.print(tfe.getMessage());
            }catch(IOException ioe){
                System.out.print(ioe.getMessage());
            }catch(SAXException sae){
                System.out.print(sae.getMessage());
            }
        }
        public static void main(String argv[]) {
            ModifyXMLFile mLFile = new ModifyXMLFile();
        }
    }
