package androidm2.partageservices;

import android.os.Bundle;

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

        PartageServiceApplication partageServiceApplication = (PartageServiceApplication) getApplication();

        RecyclerView recyclerView = findViewById(R.id.recycler_chercher_service);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterListeService adapter = new AdapterListeService(partageServiceApplication.getContexte().getServiceList());
        recyclerView.setAdapter(adapter);
    }
}