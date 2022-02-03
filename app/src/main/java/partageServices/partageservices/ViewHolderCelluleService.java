package partageServices.partageservices;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderCelluleService extends RecyclerView.ViewHolder {
    public TextView textViewTitreService;
    public TextView textViewResumeService;

    public ViewHolderCelluleService(@NonNull View itemView){
        super(itemView);
        textViewTitreService = itemView.findViewById(R.id.text_nom_service_VH);
        textViewResumeService = itemView.findViewById(R.id.text_resume_service_VH);

    }
}
