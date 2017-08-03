package com.example.admin.theweather.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.theweather.Item;
import com.example.admin.theweather.R;
import com.example.admin.theweather.listeners.OnItemChoosingListener;

import java.util.ArrayList;

/**
 * Created by Admin on 02.08.2017.
 */

public class MenuAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Item> itemsList;
    private OnItemChoosingListener onItemChoosingListener;

    private Integer choosingPosition = 0;

    public MenuAdapter(Context context, ArrayList<Item> itemsList, OnItemChoosingListener onItemChoosingListener) {
        this.context = context;
        this.itemsList = itemsList;
        this.onItemChoosingListener = onItemChoosingListener;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        choosingPosition = position;
        onItemChoosingListener.onItemChoose(position);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        ImageView iconItem;
        TextView textItem;
    }


    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_menu, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.iconItem = (ImageView) view.findViewById(R.id.icon_item);
            viewHolder.textItem = (TextView) view.findViewById(R.id.text_item);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Item item = (Item) getItem(position);
        viewHolder.iconItem.setImageResource(item.getIcon());
        viewHolder.textItem.setText(item.getTitle());

        if(choosingPosition.equals(position)) {
            viewHolder.textItem.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }else {
            viewHolder.textItem.setTextColor(context.getResources().getColor(R.color.colorPrimaryText));
        }

        return view;
    }

}
