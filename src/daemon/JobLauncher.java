package daemon;

import formats.Format;
import formats.KV;
import formats.KVFormat;
import formats.TxtFormat;
import map.MapReduce;

import java.rmi.RemoteException;

public class JobLauncher {
    public static void startJob(MapReduce mr, int format, String fname) throws RemoteException {
        // Instancier et lancer le démon MapReduce

        Format dataFormat;

        // Instancier le format approprié en fonction du type spécifié
        if (format == Format.FMT_TXT) {
            dataFormat = new TxtFormat(fname);
        } else if (format == Format.FMT_KV) {
            dataFormat = new KVFormat(fname);
        } else {
            // Gérer d'autres formats si nécessaire
            throw new IllegalArgumentException("Format non pris en charge : " + format);
        }

        // Ouvrir le format en mode lecture
        dataFormat.open("R");

        // Puis vous pouvez lire les enregistrements
        KV kv;
        while ((kv = dataFormat.read()) != null) {
            // Faire quelque chose avec kv
        }

// Fermez le format après avoir terminé la lecture
        dataFormat.close();
        CallBack callBack = new CallBack() {
            @Override
            public void completed() throws RemoteException {

            }
        };



        // Fermer le format après le travail MapReduce
        dataFormat.close();
    }
}
