package com.example.points;


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
    import java.util.zip.Inflater;


/**
     * Created by админ on 28.07.2017.
     */

    public class CustomListAdapter extends BaseAdapter {

        Context context;
        LayoutInflater lInflater;
        ArrayList<CheckModel> arrayList;
        int count;

        CustomListAdapter(Context context, ArrayList<CheckModel> arrayList, int count){
            this.context = context;
            this.arrayList = arrayList;
            this.count = count;

            lInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            Log.d("","");
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
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

            CheckModel model = getModel(position);

            ((TextView) view.findViewById(R.id.cost)).setText(model.prise +" P");
            ((TextView) view.findViewById(R.id.bonus)).setText(model.bonus +" P");
            ((TextView) view.findViewById(R.id.adress)).setText(model.adress);

            return view;
        }

        CheckModel getModel(int position){
            return ((CheckModel)getItem(position));
        }


    public  View createHeader() {
        View v = lInflater.inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.tvBalls)).setText(count + "");
        return v;
    }

   public View createFooter() {
        View v = lInflater.inflate(R.layout.footer, null);
        return v;
    }


}
