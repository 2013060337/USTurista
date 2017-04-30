package iics.ust.com.usturista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marvin on 26/04/2017.
 */

public class LandmarkAdapter extends ArrayAdapter<LandmarkBaseAdapter> {

    public LandmarkAdapter(Context context, ArrayList<LandmarkBaseAdapter> landmarkBaseAdapter) {
        super(context, 0, landmarkBaseAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LandmarkBaseAdapter landmarkBaseAdapter = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.landmark_name);

        name.setText(landmarkBaseAdapter.landmark_name);
        name.setBackgroundResource(landmarkBaseAdapter.landmark_image);
       return convertView;
    }
}
