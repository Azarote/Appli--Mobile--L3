package partageServices.partageservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button b_proposer_service = findViewById(R.id.proposer);
        b_proposer_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancer_proposer = new Intent(MainActivity.this, ProposerServiceActivity.class);
                startActivity(lancer_proposer);
            }
        });

        Button b_chercher_service = findViewById(R.id.chercher);
        b_chercher_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancer_chercher = new Intent(MainActivity.this, ChercherServiceActivity.class);
                startActivity(lancer_chercher);
            }
        });
    }
}