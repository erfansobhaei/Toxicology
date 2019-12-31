package com.tetha.toxicologyandpoisoning.model;

import java.util.ArrayList;

public class CategoryModel {
    boolean expanded = false;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    String title;
    int type;
    ArrayList<ItemModel> items = new ArrayList<>();

    public CategoryModel(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public void addItem(ItemModel itemModel){
        items.add(itemModel);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ItemModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemModel> items) {
        this.items = items;
    }

    public int getSize() {
        return this.items.size();
    }
}
