package org.esiea.trochu_evenot.app_android;

/**
 * Created by alexandretrochu on 15/12/2016.
 */


import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Intent;
import android.R.color;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.Text;


public class RecyclerSimpleViewAdapter extends RecyclerView.Adapter<RecyclerSimpleViewAdapter.ViewHolder> {

    /**
     * List items
     */
    private List<String> items;
    /**
     * the resource id of item Layout
     */
    private int itemLayout;

    /**
     * Constructor RecyclerSimpleViewAdapter
     * @param items : the list items
     * @param itemLayout : the resource id of itemView
     */
    public RecyclerSimpleViewAdapter(List<String> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    /**
     * Create View Holder by Type
     * @param parent, the view parent
     * @param viewType : the type of View
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // get inflater and get view by resource id itemLayout
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        // return ViewHolder with View
        return new ViewHolder(v);
    }

    /**
     * Get the size of items in adapter
     * @return the size of items in adapter
     */
    @Override
    public int getItemCount() {
        return items.size();
    }
    /**
     * Bind View Holder with Items
     * @param holder: the view holder
     * @param position : the current position
     */
    @Override
    public void onBindViewHolder(RecyclerSimpleViewAdapter.ViewHolder holder, int position) {
        // find item by position
        String item = items.get(position);
        // save information in holder, we have one type in this adapter
        holder.primaryText.setText(item);
        holder.itemView.setTag(item);
       if ((position % 2) == 0) {
            holder.itemView.setBackgroundResource(color.holo_blue_bright);
        } else {
            holder.itemView.setBackgroundResource(color.holo_blue_light);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // TextViex
        public TextView primaryText;
        /**
         * Constructor ViewHolder
         * @param itemView: the itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            // link primaryText
            primaryText = (TextView) itemView.findViewById(android.R.id.text1);

        }

    }
}