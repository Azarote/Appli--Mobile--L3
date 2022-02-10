package androidm2.partageservices;

import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.sakdavong.partagedeservices.Metier.DatePickerHelper;
import org.sakdavong.partagedeservices.Metier.Service;

public class ReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        setTitle(R.string.reserver_service_titre);
        findViewById(R.id.service_include_reser).findViewById(R.id.button_reserver).setVisibility(Button.GONE);
        Intent intent = getIntent();
        String uuid = intent.getStringExtra("service");
        PartageServiceApplication app = (PartageServiceApplication) getApplication();

        Service s = app.getContexte().findServiveByUid(uuid);

        //Récupère les infos de la cardview
        TextView nom_service = findViewById(R.id.service_include_reser).findViewById(R.id.nom_service);
        TextView resume_service = findViewById(R.id.service_include_reser).findViewById(R.id.resume_service_constraint_layout);
        TextView prix_service = findViewById(R.id.service_include_reser).findViewById(R.id.prix_par_unite);

        //Ajoute le coût de réservation
        TextView quantite_reservee = findViewById(R.id.quantite_reservee);
        quantite_reservee.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable edit) {
                TextView reservation_price = findViewById(R.id.cout_reserv_2);
                if (!quantite_reservee.getText().toString().equals("")) {
                    reservation_price.setText("Coût de la réservation: " + String.valueOf(s.getCout() * Float.parseFloat(quantite_reservee.getText().toString()) + " €"));
                } else
                    reservation_price.setText("Coût de la réservation:");

            }
        });


        TextView date_reserv = findViewById(R.id.date_reservation);
        date_reserv.setFocusable(false);
        date_reserv.setOnClickListener(v -> {

            DatePickerHelper.showDatePicker(this, new DatePickerHelper.OnDateSelectedListener() {
                @Override
                public void onDateSelected(String date) {
                    date_reserv.setText(date);

                }
            }, true);
        });


        nom_service.setText(s.getNom());
        resume_service.setText(s.getResume());
        prix_service.setText(String.valueOf(s.getCout()) + "€" + " par " + s.getUniteLocation());

        Button button_reserver = findViewById(R.id.button_demander_reservation);
        Button button_annuler = findViewById(R.id.button_annuler_reservation);

        button_reserver.setOnClickListener(v -> {
                    // Intent intent1 = new Intent(ReservationActivity.this, ReservationConfirmationActivity.class);
                    //intent1.putExtra("service", uuid);
                    //startActivity(intent1);
                }
        );
        button_annuler.setOnClickListener(v -> finish());
    }
}