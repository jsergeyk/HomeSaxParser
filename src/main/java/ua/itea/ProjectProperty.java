package ua.itea;

/**
 * @author SergeyK
 */
public class ProjectProperty {
	
	private String Encoding;
	private String source;
	private String target;	
	
	public ProjectProperty() {
	}

	public String getEncoding() {
		return Encoding;
	}

	public void setEncoding(String encoding) {
		Encoding = encoding;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "ProjectProperty [Encoding=" + Encoding + ", source=" + source + ", target=" + target + "]";
	}


}
