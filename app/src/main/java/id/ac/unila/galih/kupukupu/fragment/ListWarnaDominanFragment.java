package id.ac.unila.galih.kupukupu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import id.ac.unila.galih.kupukupu.ListKupuKupuActivity;
import id.ac.unila.galih.kupukupu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListWarnaDominanFragment extends Fragment implements View.OnClickListener {


    public ListWarnaDominanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        View rootView = inflater.inflate(R.layout.fragment_list_corak, container, false);

        LinearLayout tvPutih, tvKuning, tvCoklat, tvHitam, tvOrange, tvCream;

        tvPutih = (LinearLayout) rootView.findViewById(R.id.tvPutih);
        tvPutih.setOnClickListener(this);

        tvKuning = (LinearLayout) rootView.findViewById(R.id.tvKuning);
        tvKuning.setOnClickListener(this);

        tvCoklat = (LinearLayout) rootView.findViewById(R.id.tvCoklat);
        tvCoklat.setOnClickListener(this);

        tvHitam = (LinearLayout) rootView.findViewById(R.id.tvHitam);
        tvHitam.setOnClickListener(this);

        tvOrange = (LinearLayout) rootView.findViewById(R.id.tvOrange);
        tvOrange.setOnClickListener(this);

        tvCream = (LinearLayout) rootView.findViewById(R.id.tvCream);
        tvCream.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ListKupuKupuActivity.class);
        switch(view.getId()) {
            case R.id.tvPutih:
                intent.putExtra(ListKupuKupuActivity.WARNA_DOMINAN_PARCEL, "putih");
                break;
            case R.id.tvKuning:
                intent.putExtra(ListKupuKupuActivity.WARNA_DOMINAN_PARCEL, "kuning");
                break;
            case R.id.tvCoklat:
                intent.putExtra(ListKupuKupuActivity.WARNA_DOMINAN_PARCEL, "coklat");
                break;
            case R.id.tvHitam:
                intent.putExtra(ListKupuKupuActivity.WARNA_DOMINAN_PARCEL, "hitam");
                break;
            case R.id.tvOrange:
                intent.putExtra(ListKupuKupuActivity.WARNA_DOMINAN_PARCEL, "orange");
                break;
            case R.id.tvCream:
                intent.putExtra(ListKupuKupuActivity.WARNA_DOMINAN_PARCEL, "cream");
                break;
        }

        startActivity(intent);
    }
}
