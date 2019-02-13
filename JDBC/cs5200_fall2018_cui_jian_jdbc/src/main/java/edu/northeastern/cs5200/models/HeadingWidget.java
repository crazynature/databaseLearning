package edu.northeastern.cs5200.models;

public class HeadingWidget extends Widget{
	
	private int widgetId;
	private int size;
	private String type ="HEADING";

	public HeadingWidget(int id, String name,
			int width, int height, String cssClass, 
			String cssStyle, String text, int order, int size) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.size = size;
		this.widgetId = id;
	}

	public int getWidgetId() {
		return widgetId;
	}
	
	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}
}
