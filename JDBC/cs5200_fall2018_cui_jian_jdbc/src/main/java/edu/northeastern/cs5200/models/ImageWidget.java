package edu.northeastern.cs5200.models;

public class ImageWidget extends Widget {

	private int widgetId;
	private String src;
	private String type = "IMAGE";
	
	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle,
			String text, int order, String src) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.src = src;
		this.widgetId = id;
	}



	public int getWidgetId() {
		return widgetId;
	}
	
	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getType() {
		return type;
	}
}
