package com.raulmora.petagram;


import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.raulmora.petagram.adapter.MascotaAdaptador;
import com.raulmora.petagram.adapter.PageAdapter;
import com.raulmora.petagram.fragment.PerfilMascotaFragment;
import com.raulmora.petagram.fragment.RecyclerViewFragment;
import com.raulmora.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        setUpViewPager();

        if(miActionBar !=null){
            setSupportActionBar(miActionBar);
        }
    }

    /**Métodos**/

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    private void setUpViewPager (){
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_dog_profile);
    }

    public void irActividadDetalleMascota(){
        Intent intent = new Intent(this,DetalleMascotasFavoritas.class);
        startActivity(intent);
    }

    public void irActividadContacto(){
        Intent intent = new Intent(this,Contacto.class);
        startActivity(intent);
    }

    public void irActividadAbout(){
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favoritos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.acc5estrellas:
                irActividadDetalleMascota();
                return true;
            case R.id.mContacto:
                irActividadContacto();
                return true;
            case R.id.mAbout:
                irActividadAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
