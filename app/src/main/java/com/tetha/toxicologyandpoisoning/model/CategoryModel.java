package com.tetha.toxicologyandpoisoning.model;

import java.util.ArrayList;

public class CategoryModel {
    String title;
    ArrayList<ItemModel> items = new ArrayList<>();

    public CategoryModel(String title) {
        this.title = title;
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
}
