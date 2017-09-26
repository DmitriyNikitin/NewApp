package com.example.retrofit;


/**
 * Created by админ on 12.09.2017.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
     * Created by админ on 28.07.2017.
     */

    public class CustomListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    List<RecipeModel> list;


    CustomListAdapter(Context context, List<RecipeModel> list) {
        this.context = context;
        this.list = list;

        lInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("", "");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        RecipeModel model = getModel(position);

        ((TextView) view.findViewById(R.id.cost)).setText(" " + model.cookingTime + " Минут");
        ((TextView) view.findViewById(R.id.bonus)).setText(model.countLike + " Like");
        ((TextView) view.findViewById(R.id.adress)).setText(" " + model.title +" " + model.subtitle);

        return view;
    }

    RecipeModel getModel(int position) {
        return ((RecipeModel) getItem(position));
    }


}
