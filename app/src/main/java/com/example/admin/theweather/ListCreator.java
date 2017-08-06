package com.example.admin.theweather;

import com.example.admin.theweather.data.Item;

import java.util.ArrayList;

/**
 * Created by Admin on 02.08.2017.
 */

public class ListCreator {
    public ArrayList<Item> createMenu(){
        ArrayList<Item> list = new ArrayList<>();

        list.add(new Item(android.R.drawable.ic_menu_view, "Welcome"));
        list.add(new Item(android.R.drawable.ic_menu_mapmode, "Weather"));
        list.add(new Item(android.R.drawable.ic_menu_add, "Add city"));
        list.add(new Item(android.R.drawable.ic_dialog_info, "Info"));
        return list;
    }

    public ArrayList<String> createCityList(){
        ArrayList<String> list = new ArrayList<>();

        list.add("London");
        list.add("France");
        list.add("Kiev");
        list.add("New York");
        list.add("London");
        list.add("France");
        list.add("Kiev");
        list.add("New York");
        list.add("London");
        list.add("France");
        list.add("Kiev");
        list.add("New York");
        list.add("London");
        list.add("France");
        list.add("Kiev");
        list.add("New York");

        return list;
    }
}
