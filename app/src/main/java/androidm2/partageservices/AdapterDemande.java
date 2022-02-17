package androidm2.partageservices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.sakdavong.partagedeservices.Metier.Contexte;
import org.sakdavong.partagedeservices.Metier.Reservation;

import java.util.List;

public class AdapterDemande extends RecyclerView.Adapter<ViewHolderDemandes> {
    private List<Reservation> listeServicesReserves;
    Contexte contexte;

    public AdapterDemande(Contexte contexte) {
        this.listeServicesReserves = contexte.getListeMesReservations();
    }


    @NonNull
    @Override
    public ViewHolderDemandes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_reservation, parent, false);
        return new ViewHolderDemandes(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDemandes holder, int position) {
        Reservation reservation = listeServicesReserves.get(position);

        holder.textViewTitreServiceR.setText(contexte.findServiveByUid(reservation.getServiceUid()).getNom());
        holder.textViewResumeServiceR.setText(contexte.findServiveByUid(reservation.getServiceUid()).getResume());
        holder.textCoutServiceR.setText((int) (reservation.getQuantite()* contexte.findServiveByUid(reservation.getServiceUid()).getCout()));
        holder.dateR.setText(reservation.getDateTime());
    }

    @Override
    public int getItemCount() {
        return listeServicesReserves.size();
    }
}
