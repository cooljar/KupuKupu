package id.ac.unila.galih.kupukupu.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TentangFragment extends Fragment {

    @BindView(R.id.email) ImageButton ibEmail;
    @BindView(R.id.facebook) ImageButton ibFb;
    @BindView(R.id.pStore) ImageButton ibPstore;

    public TentangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tentang, container, false);

        ButterKnife.bind(this, v);

        ibEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        ibFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/zuck"));
                startActivity(intent);
            }
        });

        ibPstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                //Copy App URL from Google Play Store.
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=id.ac.unila.galih.kupukupu"));
                startActivity(intent);
            }
        });

        return v;
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"galihiimam@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Komentar Aplikasi Kupu-kupu Of Unila");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Isi komentar anda");

        try {
            startActivity(Intent.createChooser(emailIntent, "Mengirim email..."));
            //finish();
            Log.i("Finished sending email", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Log.i("Finished sending email", "");
        }
    }
}
