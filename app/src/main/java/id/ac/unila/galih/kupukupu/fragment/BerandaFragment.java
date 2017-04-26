package id.ac.unila.galih.kupukupu.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {

    private ImageView ivLogo;

    @BindView(R.id.tvContent) TextView mContent;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_beranda, container, false);

        ButterKnife.bind(this, v);

        mContent.setText("Kupu-Kupu ialah jenis serangga yang yang masuk dalam golongan ordo Lepidoptera yaitu serangga bersayap sisik. Kupu-Kupu memiliki warna cerah yang indah dan beragam. Kupu-Kupu merupakan hewan diurnal atau hewan yang aktif pada siang hari. Kupu-Kupu mampu hidup selama seminggu atau setengah bulan tergantung spesiesnya. Kupu-Kupu dapat mengalami metamorfosis yaitu suatu proses perkembangan biologi pada hewan yang melibatkan perubahan penampilan fisik atau struktur setelah kelahiran atau penetasan.\n" +
                "\n" +
                "Kupu-Kupu biasanya menghisap nektar atau madu bunga tetapi ada beberapa jenis yang suka terhadap cairan yang di hisap seperti dari buah busuk yang telah jatuh ke tanah, bangkai, kotoran burung serta tanah basah, sedangkan pada saat menjadi ulat, ulat hanya memakan daun-daunan.");

        ivLogo = (ImageView) v.findViewById(R.id.ivLogo);
        Picasso.with(getActivity()).load(R.drawable.logo)
                .resize(250, 250)
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                //.placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(ivLogo);

        return v;
    }

}
