package androidm2.partageservices;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderDemandes  extends RecyclerView.ViewHolder{
    public TextView textViewTitreServiceR;
    public TextView textViewResumeServiceR;
    public TextView textCoutServiceR;
    public TextView dateR;

    public ViewHolderDemandes(@NonNull View itemView) {
        super(itemView);
        textViewTitreServiceR = itemView.findViewById(R.id.nom_service_reserve);
        textViewResumeServiceR = itemView.findViewById(R.id.resume_service_reserve);
        textCoutServiceR = itemView.findViewById(R.id.cout_service_res);
        dateR = itemView.findViewById(R.id.view_date);
    }
}
