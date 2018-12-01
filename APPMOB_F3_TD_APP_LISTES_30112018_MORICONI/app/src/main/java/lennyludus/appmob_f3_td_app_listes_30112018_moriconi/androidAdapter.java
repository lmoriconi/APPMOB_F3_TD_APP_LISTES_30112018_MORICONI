package lennyludus.appmob_f3_td_app_listes_30112018_moriconi;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class androidAdapter extends ArrayAdapter<Androidversion> {


    private final ArrayList<Androidversion> AndroidVersionList;
    private final Context context;
    private final Resources res;
    private final int viewRes;

    public androidAdapter(Context context, int textViewResourceId, ArrayList<Androidversion> versions){
        super(context,textViewResourceId,versions);
        this.AndroidVersionList = versions;
        this.context = context;
        this.res = context.getResources();
        this.viewRes = textViewResourceId;
    }

    static class ViewHolder {
        TextView title;
        TextView desc;
        ImageView iv;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
            holder = new ViewHolder();
            holder.title= (TextView) view.findViewById(R.id.planet_name);
            holder.desc = (TextView) view.findViewById(R.id.desc);
            holder.iv = (ImageView) view.findViewById(R.id.planet_img);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        final Androidversion androidVersion = AndroidVersionList.get(position);

        if (androidVersion != null) {
            final String versionName = String.format("%s", androidVersion.getVersionName());
            holder.title.setText(versionName);
            final String versionNumber = String.format("Dist moy: %s kms", androidVersion.getVersionNumber());
            holder.desc.setText(versionNumber);
            switch (versionName){
                case "Mercure" : holder.iv.setBackgroundResource(R.drawable.mercure); break;
                case "Venus" : holder.iv.setBackgroundResource(R.drawable.venus); break;
                case "Terre" : holder.iv.setBackgroundResource(R.drawable.terre); break;
                case "Mars" : holder.iv.setBackgroundResource(R.drawable.mars); break;
                case "Jupiter" : holder.iv.setBackgroundResource(R.drawable.jupiter); break;
                case "Saturne" : holder.iv.setBackgroundResource(R.drawable.saturn); break;
                case "Uranus" : holder.iv.setBackgroundResource(R.drawable.uranus); break;
                case "Neptune" : holder.iv.setBackgroundResource(R.drawable.neptune); break;
                case "Pluton" : holder.iv.setBackgroundResource(R.drawable.pluton); break;
            }
        }
        return view;
    }

    public int getCount() {
        return AndroidVersionList.size();
    }
}
