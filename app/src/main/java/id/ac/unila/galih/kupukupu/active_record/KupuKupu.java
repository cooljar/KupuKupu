package id.ac.unila.galih.kupukupu.active_record;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by japra_awok on 16/04/2017.
 */

public class KupuKupu {

    private Context context;
    public List<id.ac.unila.galih.kupukupu.model.KupuKupu> allKupuKupu;

    public KupuKupu(Context context) {
        this.context = context;
        this.allKupuKupu = findAll();
    }


    private List<id.ac.unila.galih.kupukupu.model.KupuKupu> findAll(){
        String kupuKupuJson = loadJSONFromAsset();
        Gson gson = new Gson();
        Type list = new TypeToken<List<id.ac.unila.galih.kupukupu.model.KupuKupu>>(){}.getType();
        List<id.ac.unila.galih.kupukupu.model.KupuKupu> kupukupulist = gson.fromJson(kupuKupuJson, list);

        Collections.sort(kupukupulist, KupuKupuNameComparatorNamaLokal);
        return kupukupulist;
    }

    public List<id.ac.unila.galih.kupukupu.model.KupuKupu> findAllByName(String queryName){
        List<id.ac.unila.galih.kupukupu.model.KupuKupu> kupuKupuFiltered = new ArrayList<id.ac.unila.galih.kupukupu.model.KupuKupu>();

        for (id.ac.unila.galih.kupukupu.model.KupuKupu kupukupu : allKupuKupu) {
            if (queryName.length() > 0){
                if(kupukupu.nama_lokal.toLowerCase().contains(queryName.toLowerCase())){
                    kupuKupuFiltered.add(kupukupu);
                }
            }
        }

        Collections.sort(kupuKupuFiltered, KupuKupuNameComparatorNamaLokal);
        return kupuKupuFiltered;
    }

    public List<id.ac.unila.galih.kupukupu.model.KupuKupu> findAllByFamili(String queryName){
        List<id.ac.unila.galih.kupukupu.model.KupuKupu> kupuKupuFiltered = new ArrayList<id.ac.unila.galih.kupukupu.model.KupuKupu>();

        for (id.ac.unila.galih.kupukupu.model.KupuKupu kupukupu : allKupuKupu) {
            if (queryName.length() > 0){
                if(kupukupu.famili.toLowerCase().equals(queryName.toLowerCase())){
                    kupuKupuFiltered.add(kupukupu);
                }
            }
        }

        Collections.sort(kupuKupuFiltered, KupuKupuNameComparatorNamaLokal);
        return kupuKupuFiltered;
    }

    public List<id.ac.unila.galih.kupukupu.model.KupuKupu> findAllByWarna(String queryName){
        List<id.ac.unila.galih.kupukupu.model.KupuKupu> kupuKupuFiltered = new ArrayList<id.ac.unila.galih.kupukupu.model.KupuKupu>();

        for (id.ac.unila.galih.kupukupu.model.KupuKupu kupukupu : allKupuKupu) {
            if (queryName.length() > 0){
                String[] warnas = kupukupu.warna;
                for(String warna : warnas){
                    if(warna.toLowerCase().equals(queryName.toLowerCase())){
                        kupuKupuFiltered.add(kupukupu);
                        break;
                    }
                }
            }
        }

        Collections.sort(kupuKupuFiltered, KupuKupuNameComparatorNamaLokal);
        return kupuKupuFiltered;
    }

    public List<id.ac.unila.galih.kupukupu.model.KupuKupu> findAllByWarnaDominan(String queryName){
        List<id.ac.unila.galih.kupukupu.model.KupuKupu> kupuKupuFiltered = new ArrayList<id.ac.unila.galih.kupukupu.model.KupuKupu>();

        for (id.ac.unila.galih.kupukupu.model.KupuKupu kupukupu : allKupuKupu) {
            if (queryName.length() > 0){
                if(kupukupu.warna_dominan.toLowerCase().equals(queryName.toLowerCase())){
                    kupuKupuFiltered.add(kupukupu);
                }
            }
        }

        Collections.sort(kupuKupuFiltered, KupuKupuNameComparatorNamaLokal);
        return kupuKupuFiltered;
    }

    public id.ac.unila.galih.kupukupu.model.KupuKupu findAllByWarna(){
        return null;
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("kupu-kupu.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /*Untuk sortir ASC*/
    public static Comparator<id.ac.unila.galih.kupukupu.model.KupuKupu> KupuKupuNameComparatorNamaLokal = new Comparator<id.ac.unila.galih.kupukupu.model.KupuKupu>() {

        public int compare(id.ac.unila.galih.kupukupu.model.KupuKupu kp1, id.ac.unila.galih.kupukupu.model.KupuKupu kp2) {
            String KupuName1 = kp1.nama_lokal.toUpperCase();
            String KupuName2 = kp2.nama_lokal.toUpperCase();

            //ascending order
            return KupuName1.compareTo(KupuName2);
        }
    };

    /*Untuk sortir ASC*/
    public static Comparator<id.ac.unila.galih.kupukupu.model.KupuKupu> KupuKupuNameComparatorWarnaDominan = new Comparator<id.ac.unila.galih.kupukupu.model.KupuKupu>() {

        public int compare(id.ac.unila.galih.kupukupu.model.KupuKupu kp1, id.ac.unila.galih.kupukupu.model.KupuKupu kp2) {
            String KupuName1 = kp1.nama_lokal.toUpperCase();
            String KupuName2 = kp2.nama_lokal.toUpperCase();

            //ascending order
            return KupuName1.compareTo(KupuName2);
        }
    };
}
