package dev.gustavo.operacao_calculada.view.quimica;

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

public class Menu_Quimica extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_quimica);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout =findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);

        toogle.syncState();

        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Alcool_Gasolina_Fragmento()).commit();
            navigationView.setCheckedItem(R.id.nav_gas_alcool);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_gas_alcool) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Alcool_Gasolina_Fragmento()).commit();

        } else if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_ph) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Escalar_Ph_Fragmento()).commit();

        }  else if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_lem_beber_agua) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Beber_Agua()).commit();

        } else if (item.getItemId() == dev.gustavo.operacao_calculada.R.id.nav_logout) {

            Intent intent = new Intent(Menu_Quimica.this, Apresentacao.class);
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