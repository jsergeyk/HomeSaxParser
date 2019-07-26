package ua.itea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SergeyK
 */
public class Plugin {
	
	private String artifactId;
	private String version;
	private List<Map<String, String>> configuration = new ArrayList<>();
	private List<Map<String, String>> executions = new ArrayList<>();

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void addConfiguration(Map<String, String> configuration) {
		this.configuration.add(configuration);
	}

	public List<Map<String, String>> getConfiguration() {
		return configuration;
	}
	
	public void addExecutions(Map<String, String> executions) {
		this.executions.add(executions);
	}
	
	public List<Map<String, String>> getExecutions() {
		return executions;
	}

	public void setExecutions(List<Map<String, String>> executions) {
		this.executions = executions;
	}

	@Override
	public String toString() {
		return "Plugin [artifactId=" + artifactId + ", version=" + version + ", configuration=" + configuration
				+ ", executions=" + executions + "]";
	}
}