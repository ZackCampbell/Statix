package MVC.Widgets;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class Widget {

    private int rowIndex;      // The x coordinate of the widget
    private int colIndex;      // The y coordinate of the widget
    int rowSpan;       // The number of rows taken up by this widget
    int colSpan;       // The number of columns taken up by this widget
    String name;
    String listName;
    private boolean draggable;
    private boolean editEnabled;
    private boolean isSelected = false;
    private boolean visible;
    private AnchorPane root = new AnchorPane();
    WIDGET_TYPE type;        // Standard or Custom

    public enum WIDGET_TYPE {
        STANDARD, CUSTOM
    }

    abstract void setName();
    abstract void setType();
    abstract void setRowSpan();
    abstract void setColSpan();

    public WIDGET_TYPE getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getListName() {
        return this.listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public boolean isEditEnabled() {
        return editEnabled;
    }

    public void setEditEnabled(boolean enabled) {
        this.editEnabled = enabled;
        if (enabled) {
            this.getPane().getStyleClass().removeAll("widget-edit-disabled");
            this.getPane().getStyleClass().addAll("widget-edit-enabled");
        } else {
            this.getPane().getStyleClass().removeAll("widget-edit-enabled");
            this.getPane().getStyleClass().addAll("widget-edit-disabled");
        }
    }

    public AnchorPane getPane() {
        return this.root;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public int getColIndex() {
        return this.colIndex;
    }

    public void setRowIndex(int i) {
        this.rowIndex = i;
    }

    public void setColIndex(int i) {
        this.colIndex = i;
    }

    public int getRowSpan() {
        return this.rowSpan;
    }

    public int getColSpan() {
        return this.colSpan;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean b) {
        this.isSelected = b;
    }
}
