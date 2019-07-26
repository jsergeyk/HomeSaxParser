package ua.itea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SergeyK
 */
public class Project {
	
	private String modelVersion;
	private String groupId;
	private String artifactId;
	private String version;
	private String name;
	private ProjectProperty prop;
	private Plugin plugin;
	private List<Dependency> dependency = new ArrayList<>();

	public Project() {
		super();
	}
	
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProjectProperty getProp() {
		return prop;
	}

	public void setProp(ProjectProperty prop) {
		this.prop = prop;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void addDependency(Dependency dependency) {
		this.dependency.add(dependency);
	}

	public List<Dependency> getDependency() {
		return dependency;
	}

	public void setDependency(List<Dependency> dependency) {
		this.dependency = dependency;
	}

	@Override
	public String toString() {
		return "Project [modelVersion=" + modelVersion + ", groupId= " + groupId + ", artifactId=" + artifactId
				+ System.getProperty("line.separator") + ", version= " + version + ", name=" + name + ", prop=" + prop 
				+ System.getProperty("line.separator") + ", plugin= " + plugin 
				+ System.getProperty("line.separator") + ", dependency= " + dependency + "]";
	}
}
