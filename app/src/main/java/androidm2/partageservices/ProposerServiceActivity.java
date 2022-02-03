package androidm2.partageservices;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.sakdavong.partagedeservices.Metier.Service;
import org.sakdavong.partagedeservices.Metier.Utilisateur;

import java.util.Timer;
import java.util.TimerTask;

public class ProposerServiceActivity extends AppCompatActivity {
    EditText editTexteTitle, editTextResume, editTextCoutUniteLocation;
    private PartageServiceApplication partageServiceApplication;
    private Spinner spi_unite_location;

    private boolean demanderAnnulation = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposer_service);
        setTitle(R.string.proposer_service_titre);

        //Récuperation des informations metier
        partageServiceApplication = (PartageServiceApplication) getApplication();

        //recuperation des references aux champs de saisie et au spinner

        editTexteTitle = findViewById(R.id.titre_service);
        editTextResume = findViewById(R.id.resume_service);
        editTextCoutUniteLocation = findViewById(R.id.cout_unite);
        spi_unite_location = findViewById(R.id.spinnerProposeService);

        //Configuration du spinner
        String[] items = new String[]{"Heure", "Minute", "Jour", "Demi-journée", "Semaine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        spi_unite_location.setAdapter(adapter);
        spi_unite_location.setSelection(0);


        //Mise en place des écouteurs
        Button creerService = findViewById(R.id.buttonCreateService);
        creerService.setOnClickListener(view -> {
            //verfification que les champs soient bien remplis
            if (editTexteTitle.getText().length() != 0 && editTextResume.getText().length() != 0 && editTextCoutUniteLocation.getText().length() != 0) {
                //Creation du service
                Service service = new Service();

                Utilisateur utilisateurConnecte = partageServiceApplication.getContexte().getUtilisateur();

                service.setFournisseurUid(utilisateurConnecte.getUid());
                service.setNom(editTexteTitle.getText().toString());
                service.setResume(editTextResume.getText().toString());
                service.setUniteLocation(spi_unite_location.getSelectedItem().toString());
                service.setCout(Float.parseFloat(editTextCoutUniteLocation.getText().toString()));

                //Cacher le clavier virtuel
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                //Affichage d'un snackbar qui précise que la création ve etre faite
                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator),
                        R.string.snackbar_confirmation_creation_service, Snackbar.LENGTH_LONG);
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
                        partageServiceApplication.getContexte().ajouterService(service);
                        finish();
                    }
                }, 3000);

            }
        });

        Button annuler = findViewById(R.id.buttonCancelService);
        annuler.setOnClickListener(view -> finish());


    }
}