package id.ac.unila.galih.kupukupu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.R;
import id.ac.unila.galih.kupukupu.info_kupu_kupu.KontenInfoKupuActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoKupuKupuFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.llMengenalKupuKupu) LinearLayout llMengenalKupuKupu;
    @BindView(R.id.llKlasifikasi) LinearLayout llKlasifikasi;
    @BindView(R.id.llKeanekaragaman) LinearLayout llKeanekaragaman;
    @BindView(R.id.llPrilaku) LinearLayout llPrilaku;
    @BindView(R.id.llManfaat) LinearLayout llManfaat;
    @BindView(R.id.llMorfologi) LinearLayout llMorfologi;
    @BindView(R.id.llListKupu) LinearLayout llListKupu;
    @BindView(R.id.llCaraPotret) LinearLayout llCaraPotret;

    public InfoKupuKupuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_kupu_kupu, container, false);

        ButterKnife.bind(this, view);

        llMengenalKupuKupu.setOnClickListener(this);
        llKlasifikasi.setOnClickListener(this);
        llKeanekaragaman.setOnClickListener(this);
        llPrilaku.setOnClickListener(this);
        llManfaat.setOnClickListener(this);
        llMorfologi.setOnClickListener(this);
        llListKupu.setOnClickListener(this);
        llCaraPotret.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), KontenInfoKupuActivity.class);

        switch(view.getId()) {
            case R.id.llMengenalKupuKupu:
                intent.putExtra("TITLE", "Mengenal Kupu-kupu");
                intent.putExtra("HTML", "html/mengenal_kupu_kupu.html");
                break;
            case R.id.llKlasifikasi:
                intent.putExtra("TITLE", "Klasifikasi");
                intent.putExtra("HTML", "html/klasifikasi.html");
                break;
            case R.id.llKeanekaragaman:
                intent.putExtra("TITLE", "Keanekaragaman");
                intent.putExtra("HTML", "html/keanekaragaman.html");
                break;
            case R.id.llPrilaku:
                intent.putExtra("TITLE", "Perilaku");
                intent.putExtra("HTML", "html/perilaku.html");
                break;
            case R.id.llManfaat:
                intent.putExtra("TITLE", "Manfaat");
                intent.putExtra("HTML", "html/manfaat.html");
                break;
            case R.id.llMorfologi:
                intent.putExtra("TITLE", "Morfologi");
                intent.putExtra("HTML", "html/morfologi.html");
                break;
            case R.id.llListKupu:
                intent.putExtra("TITLE", "List Kupu-kupu");
                intent.putExtra("HTML", "html/list.html");
                break;
            case R.id.llCaraPotret:
                intent.putExtra("TITLE", "Cara Potret");
                intent.putExtra("HTML", "html/cara_potret.html");
                break;
        }

        getActivity().startActivity(intent);
    }
}
