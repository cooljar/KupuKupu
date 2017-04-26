package id.ac.unila.galih.kupukupu;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import id.ac.unila.galih.kupukupu.model.KupuKupu;

public class KupuKupuDetailActivity extends AppCompatActivity {

    public static String KUPU_KUPU_PARCEL = "kupu_kupu";

    private KupuKupu mKupuKupu;

    private TextView tvNamaLokal, tvFamily, tvSubFamily, tvGenus, tvSpesies, tvLebarSayap, tvKecepatanTerbang,
            tvDeskripsi, tvWarnaDominan, tvWarna;
    private LinearLayout llImageView;
    private ImageView ivA, ivB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kupu_kupu_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Detail Kupu-kupu");

        Intent intent = getIntent();
        mKupuKupu = Parcels.unwrap(intent.getParcelableExtra(KupuKupuDetailActivity.KUPU_KUPU_PARCEL));

        llImageView = (LinearLayout) findViewById(R.id.llImageView);
        ViewTreeObserver vto = llImageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int layoutWidth = llImageView.getWidth();

                Double imgHeight =  new Double(layoutWidth * 0.65); // 10% of screen.

                ivA = (ImageView) findViewById(R.id.ivA);
                ivA.getLayoutParams().height = imgHeight.intValue();

                ivB = (ImageView) findViewById(R.id.ivB);
                ivB.getLayoutParams().height = imgHeight.intValue();

                Picasso.with(KupuKupuDetailActivity.this).load("file:///android_asset/image/"+ mKupuKupu.gambar[0])
                        .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                        .fit()
                        .into(ivA);

                String image2 = mKupuKupu.gambar.length > 1 ? mKupuKupu.gambar[1] : mKupuKupu.gambar[0];

                Picasso.with(KupuKupuDetailActivity.this).load("file:///android_asset/image/"+ image2)
                        .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                        .fit()
                        .into(ivB);
            }
        });

        tvNamaLokal = (TextView) findViewById(R.id.tvNamaLokal);
        tvNamaLokal.setText(mKupuKupu.nama_lokal);

        tvFamily = (TextView) findViewById(R.id.tvFamily);
        tvFamily.setText(mKupuKupu.famili);

        tvSubFamily = (TextView) findViewById(R.id.tvSubFamily);
        tvSubFamily.setText(mKupuKupu.sub_famili);

        tvGenus = (TextView) findViewById(R.id.tvGenus);
        tvGenus.setText(mKupuKupu.genus);

        tvSpesies = (TextView) findViewById(R.id.tvSpesies);
        tvSpesies.setText(mKupuKupu.spesies);

        tvLebarSayap = (TextView) findViewById(R.id.tvLebarSayap);
        tvLebarSayap.setText(mKupuKupu.lebar_sayap);

        tvDeskripsi = (TextView) findViewById(R.id.tvDeskripsi);
        tvDeskripsi.setText(mKupuKupu.deskripsi);

        tvWarnaDominan = (TextView) findViewById(R.id.tvWarnaDominan);
        tvWarnaDominan.setText(mKupuKupu.warna_dominan);

        tvWarna = (TextView) findViewById(R.id.tvWarna);
        tvWarna.setText(TextUtils.join(", ", mKupuKupu.warna));
    }

}
