package ua.itea;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Пример парсинга простого "pom.xml"
 */
public class MySaxParser extends DefaultHandler	{
	
	private Project proj = new Project();	
	private Plugin plugin = new Plugin();
	private Dependency dependency;
	private ProjectProperty prop;
	private String thisElement;
	private boolean startBuildElement;
	private boolean startDependenciesElement;
	private Map<String, String> mapConfig = new HashMap<>();
	private Map<String, String> mapExecutions = new HashMap<>();

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		super.startElement(uri, localName, qName, atts);
		thisElement = qName;
		if (thisElement != null) {
			if (thisElement.equals("build")) {
				startBuildElement = true;
			} else if (thisElement.equals("dependencies")) {
				startDependenciesElement = true;
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (thisElement != null) {
			if (!startBuildElement && !startDependenciesElement) {
				switch (thisElement) {
					case "modelVersion": 
						proj.setModelVersion(new String(ch, start, length));	
						break;
					case "groupId":
						proj.setGroupId(new String(ch, start, length));	
						break;
					case "artifactId":
						proj.setArtifactId(new String(ch, start, length));	
						break;
					case "version":
						proj.setVersion(new String(ch, start, length));	
						break;
					case "name":
						proj.setName(new String(ch, start, length));	
						break;
					case "properties":
						prop = new ProjectProperty();
						proj.setProp(prop);
						break;
					case "project.build.sourceEncoding":
						if (proj != null) {
							prop.setEncoding(new String(ch, start, length));
						}
						break;
					case "maven.compiler.source":
						if (proj != null) {
							prop.setSource(new String(ch, start, length));
						}
						break;
					case "maven.compiler.target":
						if (proj != null) {
							prop.setTarget(new String(ch, start, length));
						}
						break;
					default:
						break;
				}
			} else if (startBuildElement) {
				switch (thisElement) {
					case "plugins":
						proj.setPlugin(plugin);
						break;
					case "artifactId":
						plugin.setArtifactId(new String(ch, start, length));
						break;
					case "version":
						plugin.setVersion(new String(ch, start, length));
						break;
					case "descriptorRef":						
						mapConfig.put("descriptorRef", new String(ch, start, length));						
						break;
					case "mainClass":
						mapConfig.put("mainClass", new String(ch, start, length));
						break;
					case "id":						
						mapExecutions.put("id", new String(ch, start, length));						
						break;
					case "phase":
						mapExecutions.put("phase", new String(ch, start, length));
						break;
					case "goal":
						mapExecutions.put("goal", new String(ch, start, length));
						break;
					default:
						break;
				}
			} else if (startDependenciesElement) {
				switch (thisElement) {
					case "dependency":
						dependency = new Dependency();
						break;
					case "groupId":
						dependency.setGroupId(new String(ch, start, length));
						break;
					case "artifactId":
						dependency.setArtifactId(new String(ch, start, length));
						break;
					case "version":
						dependency.setVersion(new String(ch, start, length));
						break;
					case "scope":
						dependency.setScope(new String(ch, start, length));
						break;
					default:
						break;
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName != null) {
			if (qName.equals("build")) {
				startBuildElement = false;
			} else if (qName.equals("dependencies")) {
				startDependenciesElement = false;
			}else if (qName.equals("dependency")) {
				proj.addDependency(dependency);
			}			
		}
		thisElement = null;
	}	
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		plugin.addConfiguration(mapConfig);
		plugin.addExecutions(mapExecutions);
		System.out.println(proj);
	}
}
