package ZBC.Assignment.valuta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] spinnerTitles;
    int[] spinnerImages;
    Spinner mSpinner;
    ListView simpleList;
    CustomAdapter mCustomAdapter;
    boolean isUserInteracting = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.mSpinner);
        simpleList = findViewById(R.id.simpleListView);


        spinnerTitles = new String[]{"Euro", "Ethiopian Birr", "Dkk", "Sek", "Dollar"};
        spinnerImages = new int[]{R.drawable.ic_022_european_union
                , R.drawable.ic_001_ethiopia
                , R.drawable.ic_072_denmark
                , R.drawable.ic_073_sweden
                , R.drawable.ic_153_united_states_of_america};




        mCustomAdapter = new CustomAdapter(MainActivity.this, spinnerTitles, spinnerImages);

        mSpinner.setAdapter(mCustomAdapter);

        CustomListAdapter customListAdapter = new CustomListAdapter(getApplicationContext(), spinnerTitles, spinnerImages);

        simpleList.setAdapter(customListAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
                if (isUserInteracting) {
                    Toast.makeText(MainActivity.this, spinnerTitles[i], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        });
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        isUserInteracting = true;
    }


}
