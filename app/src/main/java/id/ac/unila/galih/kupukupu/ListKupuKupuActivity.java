package id.ac.unila.galih.kupukupu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.parceler.Parcels;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.adapter.KupuKupuAdapter;
import id.ac.unila.galih.kupukupu.model.KupuKupu;
import id.ac.unila.galih.kupukupu.util.OnItemClickListener;

public class ListKupuKupuActivity extends AppCompatActivity {

    public static final String WARNA_PARCEL = "WARNA_PARCEL";
    public static final String WARNA_DOMINAN_PARCEL = "WARNA_DOMINAN_PARCEL";
    public static final String FAMILI_PARCEL = "FAMILI_PARCEL";

    private id.ac.unila.galih.kupukupu.active_record.KupuKupu modelKupuKupu;
    private List<KupuKupu> mKupuKupu = new ArrayList<>();
    private KupuKupuAdapter mAdapter;

    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kupu_kupu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List Kupu-kupu");

        modelKupuKupu = new id.ac.unila.galih.kupukupu.active_record.KupuKupu(this);
        List<KupuKupu> kupuKupuFiltered = new ArrayList<KupuKupu>();

        Intent intent = getIntent();

        // Get the extras (if there are any)
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey(WARNA_PARCEL)) {
                String filterWarna = extras.getString(WARNA_PARCEL);
                kupuKupuFiltered.addAll(modelKupuKupu.findAllByWarna(filterWarna));
            }else if(extras.containsKey(WARNA_DOMINAN_PARCEL)){
                String filterWarnaDominan = getIntent().getStringExtra(WARNA_DOMINAN_PARCEL);
                kupuKupuFiltered.addAll(modelKupuKupu.findAllByWarnaDominan(filterWarnaDominan));
            }else if(extras.containsKey(FAMILI_PARCEL)){
                String filterFamili = getIntent().getStringExtra(FAMILI_PARCEL);
                kupuKupuFiltered.addAll(modelKupuKupu.findAllByFamili(filterFamili));
            }
        }

        mKupuKupu.addAll(kupuKupuFiltered);

        ButterKnife.bind(this);

        mAdapter = new KupuKupuAdapter(this, mKupuKupu);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                KupuKupu selectedKupuKupu = mKupuKupu.get(position);
                bundle.putParcelable(KupuKupuDetailActivity.KUPU_KUPU_PARCEL, Parcels.wrap(selectedKupuKupu));
                Intent i = new Intent(ListKupuKupuActivity.this, KupuKupuDetailActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
