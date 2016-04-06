package andoresu.tagealoestudiante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListOfActivitiesActivity extends AppCompatActivity {

    private ListView activitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_activities);

        activitiesList = (ListView) findViewById(R.id.activityList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.activityList));

        activitiesList.setAdapter(adapter);

        activitiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent mapsIntent = new Intent(view.getContext(), MapsActivity.class);
                startActivity(mapsIntent);
            }
        });
    }
}
