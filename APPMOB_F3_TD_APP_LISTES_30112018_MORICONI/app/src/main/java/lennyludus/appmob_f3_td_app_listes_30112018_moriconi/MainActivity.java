package lennyludus.appmob_f3_td_app_listes_30112018_moriconi;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView MaListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Androidversion> androidList = new ArrayList<Androidversion>();
        initList(androidList);
        androidAdapter adapter = new androidAdapter(this, R.layout.items, androidList);
        final ListView list = (ListView) findViewById(R.id.maListe);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Androidversion selectedItem = (Androidversion) adapter.getItemAtPosition(position);
                Log.v("ListePersoe", "Element selectionné : " + selectedItem.getVersionName());
            }
        });
    }


    private void initList(ArrayList<Androidversion> androidList) {

        Resources res = getResources();
        String[] s_val = res.getStringArray(R.array.t_planet);
        String[] s_desc = res.getStringArray(R.array.t_desc);

        for (int i = 0; i < s_val.length; i++) {
            Androidversion version = new Androidversion();
            version.setVersionName(s_val[i]);
            version.setVersionNumber(s_desc[i]);
            androidList.add(version);
        }
    }
}
