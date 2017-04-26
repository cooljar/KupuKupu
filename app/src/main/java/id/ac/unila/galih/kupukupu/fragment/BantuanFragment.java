package id.ac.unila.galih.kupukupu.fragment;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BantuanFragment extends Fragment {

    @BindView(R.id.webView) WebView mWebview;

    public BantuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bantuan, container, false);

        ButterKnife.bind(this, v);

        WebSettings webSetting = mWebview.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);

        AssetManager mgr = getActivity().getBaseContext().getAssets();

        try {
            InputStream in = mgr.open("html/bantuan.html", AssetManager.ACCESS_BUFFER);
            String htmlContentInStringFormat = StreamToString(in);
            in.close();
            mWebview.loadDataWithBaseURL(null, htmlContentInStringFormat, "text/html", "utf-8", null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return v;
    }

    public static String StreamToString(InputStream in) throws IOException {
        if(in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }
}
