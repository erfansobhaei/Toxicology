package com.tetha.toxicologyandpoisoning.model;

import java.util.ArrayList;

public class LinkerModel {
    int parentId;
    ArrayList<CategoryModel> items = new ArrayList<>();

    public LinkerModel(int parentId, ArrayList<CategoryModel> items) {
        this.parentId = parentId;
        this.items = items;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public ArrayList<CategoryModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<CategoryModel> items) {
        this.items = items;
    }
}
