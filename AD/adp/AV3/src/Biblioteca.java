import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Biblioteca {

	/**
	 * crear un nou llibre com a XML a partir de les dades proporcionades per
	 * l�usuari
	 * 
	 * @param llibre
	 * @return Torna l�identificador del llibre
	 */
	public int crearLlibre(Llibre llibre) {

		// TODO crearLlibre

		try {
			
			DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = newDocumentBuilder.parse("Biblioteca.xml");
			Element root = doc.getDocumentElement();
			
			Element llibres = doc.createElement("llibre");
			Element identificador = doc.createElement("identificador");
			Element titol = doc.createElement("titol");
			Element autor = doc.createElement("autor");
			Element anyPublicacio = doc.createElement("anyPublicacio");
			Element editorial = doc.createElement("editorial");
			Element nombrePagines = doc.createElement("nombrePagines");
			
			identificador.setTextContent(String.valueOf(llibre.getIdentificador()));
			titol.setTextContent(llibre.getTitol());
			autor.setTextContent(llibre.getAutor());
			anyPublicacio.setTextContent(String.valueOf(llibre.getAnyPublicacio()));
			editorial.setTextContent(llibre.getEditorial());
			nombrePagines.setTextContent(String.valueOf(llibre.getNombrePagines()));
			
			llibres.appendChild(identificador);
			llibres.appendChild(titol);
			llibres.appendChild(autor);
			llibres.appendChild(anyPublicacio);
			llibres.appendChild(editorial);
			llibres.appendChild(nombrePagines);
			
			root.appendChild(llibres);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return llibre.getIdentificador();

	}

	/**
	 * @param identificador
	 * @return Torna un objecte llibre a partir d�un identificador
	 */
	public Llibre recuperarLlibre(int identificador) {

		ArrayList<Llibre> llista = recuperarTots();
		Llibre llibre = new Llibre();
		
		for (int i = 0; i < llista.size(); i++) {
			
			if (llista.get(i).getIdentificador() == identificador) {
				
				llibre = llista.get(i);
				
			}
			
		}

		return llibre;

	}

	/**
	 * mostra els atributs del llibre per pantalla
	 * 
	 * @param llibre
	 */
	public void mostrarLlibre(Llibre llibre) {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Biblioteca.xml"));

			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("llibre");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);
				System.out.println("");

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;
					System.out.println("Identificador : " + eElement.getElementsByTagName("identificador").item(0).getTextContent());
					System.out.println("Titol : " + eElement.getElementsByTagName("titol").item(0).getTextContent());
					System.out.println("Autor : " + eElement.getElementsByTagName("autor").item(0).getTextContent());
					System.out.println("Any de publicaci� : " + eElement.getElementsByTagName("anyPublicacio").item(0).getTextContent());
					System.out.println("Editorial : " + eElement.getElementsByTagName("editorial").item(0).getTextContent());
					System.out.println("Nombre de pagines : " + eElement.getElementsByTagName("nombrePagines").item(0).getTextContent());

				}
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}

	/**
	 * borra un objecte llibre a partir d�un identificador
	 * 
	 * @param identificador
	 */
	public void borrarLlibre(int identificador) {

		// TODO borrarLlibre
		try {
						
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Biblioteca.xml"));
			
			NodeList items = document.getElementsByTagName("libro");
			for (int i = 0; i < items.getLength(); i++) {
			    Element element = (Element) items.item(i);
			    // elejir un elemento especifico por algun atributo
			    if (element.getAttribute("identificador").equals(identificador)) {
			        // borrar elemento
			        element.getParentNode().removeChild(element);
			    }
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		

	}

	/**
	 * Modifica la informaci� d�un objecte llibre a partir d�un identificador
	 * 
	 * @param identificador
	 */
	public void actualitzaLlibre(int identificador) {
		Scanner sc = new Scanner(System.in);
		
		Llibre llibre = recuperarLlibre(identificador);
		
		System.out.println("Introduiu el titol : ");
		String titol = sc.next();
		llibre.setTitol(titol);
		
		System.out.println("Introduiu l'autor : ");
		String autor = sc.next();
		llibre.setAutor(autor);
		
		System.out.println("Introduiu l'any de publicaci� : ");
		int anyPublicacio = sc.nextInt();
		llibre.setAnyPublicacio(anyPublicacio);
		
		System.out.println("Introduiu l'editorial : ");
		String editorial = sc.next();
		llibre.setEditorial(editorial);
		
		System.out.println("Introduiu el nombre de pagines : ");
		int nombrePagines = sc.nextInt();
		llibre.setNombrePagines(nombrePagines);
		
		

	}

	/**
	 * @return Torna una llista amb tots els llibres de la biblioteca
	 */
	public ArrayList<Llibre> recuperarTots() {

		// TODO recuperarTots
		ArrayList<Llibre> llista = new ArrayList<>();
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Biblioteca.xml"));

			NodeList nodeList = document.getElementsByTagName("llibre");
			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;
					int identificador = Integer
							.valueOf(eElement.getElementsByTagName("identificador").item(0).getTextContent());
					String titol = eElement.getElementsByTagName("titol").item(0).getTextContent();
					String autor = eElement.getElementsByTagName("autor").item(0).getTextContent();
					int anyPublicacio = Integer
							.valueOf(eElement.getElementsByTagName("anyPublicacio").item(0).getTextContent());
					String editorial = eElement.getElementsByTagName("editorial").item(0).getTextContent();
					int nombrePagines = Integer
							.valueOf(eElement.getElementsByTagName("nombrePagines").item(0).getTextContent());

					Llibre llibre = new Llibre(identificador, titol, autor, anyPublicacio, editorial, nombrePagines);

					llista.add(llibre);

				}

			}

		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();

		}

		return llista;

	}

}
