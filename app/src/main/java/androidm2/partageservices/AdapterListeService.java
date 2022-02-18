package androidm2.partageservices;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.sakdavong.partagedeservices.Metier.Service;

import java.util.List;

public class AdapterListeService extends RecyclerView.Adapter<ViewHolderCelluleService> implements Filterable {
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
        holder.textViewPrixService.setText(service.getCout() + " € " + "par " + service.getUniteLocation());

        holder.buttonReserver.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ReservationActivity.class);
            intent.putExtra("service", service.getUid());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Service> filteredList = null;

                if (constraint == null || constraint.length() == 0) {
                    filteredList = listeServices;
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    filter(filterPattern);
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listeServices = (List<Service>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return listeServices.size();
    }
}
