package partageServices.partageservices;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.sakdavong.partagedeservices.Metier.Service;

import java.util.ArrayList;

public class ChercherServiceActivity extends AppCompatActivity {
    private AdapterListeService adapter;
    private RecyclerView recyclerView;
    private ArrayList<Service> services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chercher_service);

        PartageServiceApplication partageServiceApplication = (PartageServiceApplication) getApplication();

        recyclerView = findViewById(R.id.recycler_view_chercher_service);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListeService(partageServiceApplication.getContexte().getServiceList());
        recyclerView.setAdapter(adapter);
    }
}