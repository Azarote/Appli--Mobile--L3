package androidm2.partageservices;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderCelluleService extends RecyclerView.ViewHolder {
    public TextView textViewTitreService;
    public TextView textViewResumeService;
    public TextView textViewPrixService;

    public ViewHolderCelluleService(@NonNull View itemView) {
        super(itemView);
        textViewTitreService = itemView.findViewById(R.id.nom_service);
        textViewResumeService = itemView.findViewById(R.id.resume_service_constraint_layout);
        textViewPrixService = itemView.findViewById(R.id.prix_par_unite);
    }
}
