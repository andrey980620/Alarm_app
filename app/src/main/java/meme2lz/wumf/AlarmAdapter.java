package meme2lz.wumf;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlarmAdapter extends ArrayAdapter<AlarmModel> {

    public AlarmAdapter(Context context, ArrayList<AlarmModel> objects){
        super(context,0,objects);
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        //Get the date item for this position
        AlarmModel alarmModel = getItem(position);

        //Check if the existing view is being reused, otherwise inflate a new view from custom_row layout
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.element_contents, parent, false);
            viewHolder = new ViewHolder();
            //Casting of views from the custom_row layout
            viewHolder.el_id = (TextView)convertView.findViewById(R.id.el_id);
            viewHolder.el_time = (TextView)convertView.findViewById(R.id.el_time);
            viewHolder.el_isActive = (TextView)convertView.findViewById(R.id.el_isActive);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Filling each views values
        viewHolder.el_id.setText( String.valueOf(alarmModel.getId()));
        viewHolder.el_time.setText(alarmModel.getTime());
        viewHolder.el_isActive.setText((alarmModel.isActive()!=0)?"enabled":"disabled");

        return convertView;
    }

    static class ViewHolder{
        TextView el_id, el_time, el_isActive;
    }


}
