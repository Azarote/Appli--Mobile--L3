package androidm2.partageservices;

import android.app.Application;

import org.sakdavong.partagedeservices.Metier.Contexte;

public class PartageServiceApplication extends Application {
    private Contexte contexte;

    @Override
    public void onCreate() {
        super.onCreate();
        contexte = new Contexte();

    }

    public Contexte getContexte() {
        return contexte;
    }
}
