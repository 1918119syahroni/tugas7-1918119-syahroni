package com.example.tugas7_1918119;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Design> Design;
    public CustomListAdapter(Activity activity, List<Design> Design) {
        this.activity = activity;
        this.Design = Design;
    }
    @Override
    public int getCount() {
        return Design.size();
    }
    @Override
    public Object getItem(int location) {
        return Design.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView tagline = (TextView)
                convertView.findViewById(R.id.text_tagline);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Design m = Design.get(position);
        nama.setText("Nama : "+ m.get_logo());
        tagline.setText("Kelas : "+ m.get_tagline());
        return convertView;
    }
}
