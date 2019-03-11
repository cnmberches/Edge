package app.helianthus.edge;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View myView;

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragmentHome = new FragmentHome();
    Fragment fragmentJournal = new FragmentJournal();
    Fragment fragmentReads = new FragmentReads();
    Fragment fragmentHelplines = new FragmentHelplines();
    Fragment fragmentActive = fragmentHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager.beginTransaction().add(R.id.main_fragment_container, fragmentHome, "1").commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /* FloatingActionButton myFab = myView.findViewById(R.id.floating_action_button);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivitySplashScreen.class);
                startActivity(intent);
            }
        }); */
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction fragmentTransaction;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.anim_fragment_enter, R.anim.anim_fragment_exit);
                    fragmentTransaction.replace(R.id.main_fragment_container, fragmentHome, "1").commit();
                    fragmentActive = fragmentHome;
                    return true;
                case R.id.navigation_journal:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.anim_fragment_enter, R.anim.anim_fragment_exit);
                    fragmentTransaction.replace(R.id.main_fragment_container, fragmentJournal, "2").commit();
                    fragmentActive = fragmentJournal;
                    return true;
                case R.id.navigation_reads:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.anim_fragment_enter, R.anim.anim_fragment_exit);
                    fragmentTransaction.replace(R.id.main_fragment_container, fragmentReads, "3").commit();
                    fragmentActive = fragmentReads;
                    return true;
                case R.id.navigation_helplines:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.anim_fragment_enter, R.anim.anim_fragment_exit);
                    fragmentTransaction.replace(R.id.main_fragment_container, fragmentHelplines, "4").commit();
                    fragmentActive = fragmentHelplines;
                    return true;
            }
            return false;
        }
    };

}
