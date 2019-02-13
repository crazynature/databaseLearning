package edu.northeastern.cs5200.daos;

import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.models.Widget;

public interface Widgetlmpl {
	public void createWidgetForPage(int pageId, Widget widget)throws SQLException, ClassNotFoundException;
	public Collection<Widget> findAllWidgets()throws SQLException, ClassNotFoundException;
	public Widget findWidgetById(int widgetId)throws SQLException, ClassNotFoundException;
	public Collection<Widget> findWidgetsForPage(int pageId)throws SQLException, ClassNotFoundException;
	public int updateWidget(int widgetId, Widget widget)throws SQLException, ClassNotFoundException;
	public int deleteWidget(int widgetId)throws SQLException, ClassNotFoundException;
}
