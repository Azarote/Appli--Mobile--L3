package androidm2.partageservices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.sakdavong.partagedeservices.Metier.Service;

import java.util.List;

public class AdapterListeService extends RecyclerView.Adapter<ViewHolderCelluleService> {
    private List<Service> listeServices;

    public AdapterListeService(List<Service> listeServices) {
        this.listeServices = listeServices;
    }


    @NonNull
    @Override
    public ViewHolderCelluleService onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_service, parent, false);
        return new ViewHolderCelluleService(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCelluleService holder, int position) {
        Service service = listeServices.get(position);

        holder.textViewTitreService.setText(service.getNom());
        holder.textViewResumeService.setText(service.getResume());
        holder.textViewPrixService.setText(service.getCout() + " € "+ "par "+ service.getUniteLocation());
    }

    @Override
    public int getItemCount() {
        return listeServices.size();
    }
}
