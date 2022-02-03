package androidm2.partageservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ChercherServiceActivity extends AppCompatActivity {
    private PartageServiceApplication partageServiceApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chercher_service);

        PartageServiceApplication partageServiceApplication = (PartageServiceApplication) getApplication();

        RecyclerView recyclerView = findViewById(R.id.recycler_chercher_service);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterListeService adapter = new AdapterListeService(partageServiceApplication.getContexte().getServiceList());
        recyclerView.setAdapter(adapter);
    }
}