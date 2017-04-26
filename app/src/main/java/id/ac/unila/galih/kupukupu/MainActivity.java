package id.ac.unila.galih.kupukupu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import id.ac.unila.galih.kupukupu.fragment.BantuanFragment;
import id.ac.unila.galih.kupukupu.fragment.BerandaFragment;
import id.ac.unila.galih.kupukupu.fragment.CariKupuKupuFragment;
import id.ac.unila.galih.kupukupu.fragment.InfoKupuKupuFragment;
import id.ac.unila.galih.kupukupu.fragment.KategoriFragment;
import id.ac.unila.galih.kupukupu.fragment.TentangFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("Beranda");
        navigationView.setCheckedItem(R.id.nav_beranda);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new BerandaFragment());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        int id = item.getItemId();
        switch (id){
            case R.id.nav_beranda:
                getSupportActionBar().setTitle("Beranda");
                transaction.replace(R.id.container, new BerandaFragment());
                break;
            case R.id.nav_kupu_kupu:
                getSupportActionBar().setTitle("Daftar Kupu-kupu");
                transaction.replace(R.id.container, new CariKupuKupuFragment());
                break;
            case R.id.nav_kategori:
                getSupportActionBar().setTitle("Kategori Kupu-kupu");
                transaction.replace(R.id.container, new KategoriFragment());
                break;
            case R.id.nav_info:
                getSupportActionBar().setTitle("Info");
                transaction.replace(R.id.container, new InfoKupuKupuFragment());
                break;
            case R.id.nav_tentang:
                getSupportActionBar().setTitle("Tentang");
                transaction.replace(R.id.container, new TentangFragment());
                break;
            case R.id.nav_bantuan:
                getSupportActionBar().setTitle("Bantuan");
                transaction.replace(R.id.container, new BantuanFragment());
                break;
            default:
        }

        drawer.closeDrawer(GravityCompat.START);

        transaction.commit();

        return true;
    }
}
