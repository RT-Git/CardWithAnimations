package com.wordpress.obliviouscode.cardwithanimations;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ravi on 13-01-2017.
 */

class Item
{
    private String leftHead;
    private String rightHead;

    public Item(String l, String r)
    {
        leftHead=l;
        rightHead =r;
    }

    public String getLeftHead() {return leftHead;}
    public String getRightHead() {return rightHead;}
}


public class CustomList extends ArrayAdapter<Item> {

    private ArrayList<Item> objects;


    public CustomList(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        Item i = objects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView leftHead = (TextView) v.findViewById(R.id.leftHead);
            TextView rightHead = (TextView) v.findViewById(R.id.rightHead);

            if (leftHead != null)
                leftHead.setText(i.getLeftHead());

            if (rightHead != null)
                rightHead.setText(i.getRightHead());
        }

        return v;
    }
}
