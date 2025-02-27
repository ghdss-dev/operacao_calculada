package dev.gustavo.operacao_calculada.view.fisica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.view.Apresentacao;
import dev.gustavo.operacao_calculada.view.matematica.Conversor_Moedas_Fragmento;
import dev.gustavo.operacao_calculada.view.matematica.Menu_Matematica;
import dev.gustavo.operacao_calculada.view.matematica.Tabuada_Fragmento;

public class Menu_Fisica extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fisica);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout =findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);

        toogle.syncState();

        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Conversor_Temperaturas_Fragmento()).commit();
            navigationView.setCheckedItem(R.id.nav_temperature);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_temperature) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Conversor_Temperaturas_Fragmento()).commit();

        } else if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_amperes) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Amperagem_Fragmento()).commit();

        } else if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_carga) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Carga_Maxima_Consumo_Fragmento()).commit();

        } else if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_logout) {

            Intent intent = new Intent(Menu_Fisica.this, Apresentacao.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();

        }
    }
}