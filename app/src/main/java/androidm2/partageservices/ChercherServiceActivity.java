package androidm2.partageservices;

import android.os.Bundle;

import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChercherServiceActivity extends AppCompatActivity {
    private PartageServiceApplication partageServiceApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chercher_service);
        setTitle(R.string.chercher_service_titre);
        SearchView searchView = findViewById(R.id.barre_recherche);
        searchView.setMaxWidth(Integer.MAX_VALUE);


        PartageServiceApplication partageServiceApplication = (PartageServiceApplication) getApplication();

        RecyclerView recyclerView = findViewById(R.id.recycler_chercher_service);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterListeService adapter = new AdapterListeService(partageServiceApplication.getContexte().getServiceList());
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}