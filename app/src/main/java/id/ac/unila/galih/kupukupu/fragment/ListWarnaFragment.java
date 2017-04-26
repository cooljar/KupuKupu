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

public class ListWarnaFragment extends Fragment implements View.OnClickListener{

    public ListWarnaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        View rootView = inflater.inflate(R.layout.fragment_list_warna, container, false);

        LinearLayout tvPutih, tvKuning, tvBiru, tvCoklat, tvHitam, tvOrange, tvHijau, tvCream, tvAbu;

        tvPutih = (LinearLayout) rootView.findViewById(R.id.tvPutih);
        tvPutih.setOnClickListener(this);

        tvKuning = (LinearLayout) rootView.findViewById(R.id.tvKuning);
        tvKuning.setOnClickListener(this);

        tvBiru = (LinearLayout) rootView.findViewById(R.id.tvBiru);
        tvBiru.setOnClickListener(this);

        tvCoklat = (LinearLayout) rootView.findViewById(R.id.tvCoklat);
        tvCoklat.setOnClickListener(this);

        tvHitam = (LinearLayout) rootView.findViewById(R.id.tvHitam);
        tvHitam.setOnClickListener(this);

        tvOrange = (LinearLayout) rootView.findViewById(R.id.tvOrange);
        tvOrange.setOnClickListener(this);

        tvHijau = (LinearLayout) rootView.findViewById(R.id.tvHijau);
        tvHijau.setOnClickListener(this);

        tvCream = (LinearLayout) rootView.findViewById(R.id.tvCream);
        tvCream.setOnClickListener(this);

        tvAbu = (LinearLayout) rootView.findViewById(R.id.tvAbu);
        tvAbu.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ListKupuKupuActivity.class);
        switch(view.getId()) {
            case R.id.tvPutih:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "putih");
                break;
            case R.id.tvKuning:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "kuning");
                break;
            case R.id.tvBiru:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "biru");
                break;
            case R.id.tvCoklat:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "coklat");
                break;
            case R.id.tvHitam:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "hitam");
                break;
            case R.id.tvOrange:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "orange");
                break;
            case R.id.tvHijau:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "hijau");
                break;
            case R.id.tvCream:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "cream");
                break;
            case R.id.tvAbu:
                intent.putExtra(ListKupuKupuActivity.WARNA_PARCEL, "abu-abu");
                break;
        }

        startActivity(intent);
    }
}
