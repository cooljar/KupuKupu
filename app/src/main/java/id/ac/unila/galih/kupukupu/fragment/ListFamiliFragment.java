package id.ac.unila.galih.kupukupu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.KupuKupuDetailActivity;
import id.ac.unila.galih.kupukupu.ListKupuKupuActivity;
import id.ac.unila.galih.kupukupu.R;
import id.ac.unila.galih.kupukupu.adapter.FamilyAdapter;
import id.ac.unila.galih.kupukupu.model.KupuKupu;
import id.ac.unila.galih.kupukupu.util.OnItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFamiliFragment extends Fragment{

    List<String> families = new ArrayList<String>();
    FamilyAdapter mAdapter;

    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

    public ListFamiliFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_sort_nama, container, false);

        addFamiliData();

        ButterKnife.bind(this, rootView);

        mAdapter = new FamilyAdapter(getActivity(), families);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(getActivity(), ListKupuKupuActivity.class);
                i.putExtra(ListKupuKupuActivity.FAMILI_PARCEL, families.get(position));
                startActivity(i);
            }
        });

        return rootView;
    }

    private void addFamiliData(){
        families.add("HESPERIIDAE");
        families.add("NYMPHALIDAE");
        families.add("PAPILIONIDAE");
        families.add("PIERIDAE");
    }
}
