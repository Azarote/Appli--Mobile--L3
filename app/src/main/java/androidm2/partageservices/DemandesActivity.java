package androidm2.partageservices;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DemandesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demandes);
        setTitle("Mes demandes");

        PartageServiceApplication partageServiceApplication = (PartageServiceApplication) getApplication();

        RecyclerView recyclerView = findViewById(R.id.recycler_mes_demandes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterDemande adapter = new AdapterDemande(partageServiceApplication.getContexte().getListeMesReservations());
        recyclerView.setAdapter(adapter);
    }
}