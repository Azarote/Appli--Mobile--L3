package androidm2.partageservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button proposeBouton = findViewById(R.id.proposeButton);
        proposeBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProposerServiceActivity.class);
                startActivity(intent);
            }
        });
        Button rechercheBouton = findViewById(R.id.searchButton);
        rechercheBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecherche = new Intent(MainActivity.this, ChercherServiceActivity.class);
                startActivity(intentRecherche);
            }
        });
    }
}