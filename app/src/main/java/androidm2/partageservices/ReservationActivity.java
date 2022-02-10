package androidm2.partageservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.sakdavong.partagedeservices.Metier.DatePickerHelper;
import org.sakdavong.partagedeservices.Metier.Reservation;
import org.sakdavong.partagedeservices.Metier.Service;
import org.sakdavong.partagedeservices.Metier.Utilisateur;

import java.util.Timer;
import java.util.TimerTask;

public class ReservationActivity extends AppCompatActivity {
    private boolean demanderAnnulation = false;

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

        nom_service.setText(s.getNom());
        resume_service.setText(s.getResume());
        prix_service.setText(String.valueOf(s.getCout()) + "€" + " par " + s.getUniteLocation());

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
        date_reserv.setOnClickListener(v -> DatePickerHelper.showDatePicker(this, new DatePickerHelper.OnDateSelectedListener() {
            @Override
            public void onDateSelected(String date) {
                date_reserv.setText(date);

            }
        }, true));

        //Déclaration bouton annuler et reserver
        Button button_reserver = findViewById(R.id.button_demander_reservation);
        Button button_annuler = findViewById(R.id.button_annuler_reservation);

        button_reserver.setOnClickListener(v -> {
                    if (date_reserv.getText().length() != 0 && quantite_reservee.getText().length() != 0) {
                        Reservation reservation = new Reservation();
                        reservation.setDateTime(date_reserv.getText().toString());
                        reservation.setQuantite(Integer.parseInt(quantite_reservee.getText().toString()));
                        Utilisateur utilisateurConnecte = app.getContexte().getUtilisateur();
                        reservation.setUid(uuid);
                        reservation.setUtilisateurUid(utilisateurConnecte.getUid());

                        //Cacher le clavier virtuel
                        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                        //Affichage d'un snackbar qui précise que la création ve etre faite
                        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator_reservation),
                                R.string.snackbar_confirmation_reserver_service, Snackbar.LENGTH_LONG);
                        snackbar.setAction(R.string.snack_boutton_annulation, view1 -> demanderAnnulation = true);
                        snackbar.show();
                        //Mise en place d'un timer
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {

                            @Override
                            public void run() {
                                if (demanderAnnulation) {
                                    snackbar.dismiss();
                                    finish();
                                    demanderAnnulation = false;
                                    return;
                                }
                                //Ajout au contexte (objet metier)
                                app.getContexte().ajouterReservation(reservation);
                                finish();
                            }
                        }, 3000);
                    } else {
                        return;
                    }

                }
        );
        //Action du bouton annuler
        button_annuler.setOnClickListener(v -> finish());
    }
}