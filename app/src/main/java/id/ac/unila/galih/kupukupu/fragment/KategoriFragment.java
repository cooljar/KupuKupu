package id.ac.unila.galih.kupukupu.fragment;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KategoriFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    private TabLayout.Tab tab;
    private AppBarLayout appBar;

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.relativeLayout) RelativeLayout relativeLayout;

    public KategoriFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kategori_kupu, container, false);

        ButterKnife.bind(this, view);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("WARNA"));
        tabLayout.addTab(tabLayout.newTab().setText("WARNA DOMINAN"));
        tabLayout.addTab(tabLayout.newTab().setText("FAMILI"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(this);

        tab = tabLayout.getTabAt(0);

        relativeLayout.removeView(tabLayout);

        appBar = (AppBarLayout) getActivity().findViewById(R.id.appBar);
        appBar.addView(tabLayout, 1);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_kategori, new ListWarnaFragment());
        transaction.commit();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("--", "onDestroyView()");
        appBar.removeView(tabLayout);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        final int tabPosition = tab.getPosition();
        switch(tabPosition) {
            case 0:
                transaction.replace(R.id.container_kategori, new ListWarnaFragment());
                break;
            case 1:
                transaction.replace(R.id.container_kategori, new ListWarnaDominanFragment());
                break;
            case 2:
                transaction.replace(R.id.container_kategori, new ListFamiliFragment());
                break;
            default:
        }

        transaction.commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
