package id.ac.unila.galih.kupukupu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.parceler.Parcels;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.KupuKupuDetailActivity;
import id.ac.unila.galih.kupukupu.R;
import id.ac.unila.galih.kupukupu.adapter.KupuKupuAdapter;
import id.ac.unila.galih.kupukupu.model.KupuKupu;
import id.ac.unila.galih.kupukupu.util.OnItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class CariKupuKupuFragment extends Fragment implements SearchView.OnQueryTextListener{

    private id.ac.unila.galih.kupukupu.active_record.KupuKupu modelKupuKupu;
    private List<KupuKupu> allKupuKupu = new ArrayList<>();
    private List<KupuKupu> mKupuKupu = new ArrayList<>();
    private KupuKupuAdapter mAdapter;

    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

    public CariKupuKupuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        cariKupuKupu(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        cariKupuKupu(newText);
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cari_kupu_kupu, container, false);

        ButterKnife.bind(this, view);

        //modelKupuKupu = KupuKupu.newInstance(getActivity());
        modelKupuKupu = new id.ac.unila.galih.kupukupu.active_record.KupuKupu(getActivity());
        allKupuKupu.addAll(modelKupuKupu.allKupuKupu);
        mKupuKupu.addAll(allKupuKupu);

        mAdapter = new KupuKupuAdapter(getActivity(), mKupuKupu);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                KupuKupu selectedKupuKupu = mKupuKupu.get(position);
                bundle.putParcelable(KupuKupuDetailActivity.KUPU_KUPU_PARCEL, Parcels.wrap(selectedKupuKupu));
                Intent i = new Intent(getActivity(), KupuKupuDetailActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        return view;
    }

    private void cariKupuKupu(String queryName){
        mKupuKupu.clear();

        List<KupuKupu> kupuKupuFiltered = new ArrayList<KupuKupu>();

        if (queryName.length() > 0){
            kupuKupuFiltered.addAll(modelKupuKupu.findAllByName(queryName));
        }else{
            kupuKupuFiltered.addAll(allKupuKupu);
        }

        mKupuKupu.addAll(kupuKupuFiltered);
        mAdapter.notifyDataSetChanged();
    }
}
