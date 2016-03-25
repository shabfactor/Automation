package nz.co.maveros.auto.ghost.model.page;

public class EditorPage extends AbstractPage {
	private String content;

	public EditorPage(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}	
	
}
