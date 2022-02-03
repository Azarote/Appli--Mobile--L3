package partageServices.partageservices;

import android.app.Application;

import org.sakdavong.partagedeservices.Metier.Contexte;

public class PartageServiceApplication extends Application {
    private Contexte contexte;

    @Override
    public void onCreate() {
        super.onCreate();
        this.contexte = new Contexte();
    }

    public Contexte getContexte() {
        return contexte;
    }
}