package id.ac.unila.galih.kupukupu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by japra_awok on 30/09/2016.
 */

public class KupuKupuList {
    public ArrayList<KupuKupuOld> kupuKupu;

    public KupuKupuList() {
    }

    public KupuKupuList(ArrayList<KupuKupuOld> kupuKupu) {
        this.kupuKupu = kupuKupu;
    }

    public List<KupuKupuOld> getKupuKupu() {
        return kupuKupu;
    }

    public void setKupuKupu(ArrayList<KupuKupuOld> kupuKupu) {
        this.kupuKupu = kupuKupu;
    }
}
