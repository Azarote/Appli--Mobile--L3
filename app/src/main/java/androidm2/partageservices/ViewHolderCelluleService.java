package androidm2.partageservices;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderCelluleService extends RecyclerView.ViewHolder {
    public TextView textViewTitreService;
    public TextView textViewResumeService;
    public TextView textViewPrixService;
    public Button buttonReserver;

    public ViewHolderCelluleService(@NonNull View itemView) {
        super(itemView);
        textViewTitreService = itemView.findViewById(R.id.nom_service);
        textViewResumeService = itemView.findViewById(R.id.resume_service);
        textViewPrixService = itemView.findViewById(R.id.prix_service);
        buttonReserver = itemView.findViewById(R.id.button_reserver);
    }
}
