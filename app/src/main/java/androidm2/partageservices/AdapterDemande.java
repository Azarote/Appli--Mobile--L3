package androidm2.partageservices;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.sakdavong.partagedeservices.Metier.Service;

import java.util.List;

public class AdapterDemande extends RecyclerView.Adapter<ViewHolderCelluleService> {
    private List<Service> listeServicesReserves;

    public AdapterDemande(List<Service> listeServicesReserves) {
        this.listeServicesReserves = listeServicesReserves;
    }


    @NonNull
    @Override
    public ViewHolderDemandes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_reservation, parent, false);
        return new ViewHolderDemandes(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDemandes holder, int position) {
        Service service = listeServicesReserves.get(position);

        holder.textViewTitreServiceR.setText(service.getNom());
        holder.textViewResumeServiceR.setText(service.getResume());
        holder.textCoutServiceR.setText("22");
        holder.dateR.setText(service);
    }

    @Override
    public int getItemCount() {
        return listeServices.size();
    }
}
