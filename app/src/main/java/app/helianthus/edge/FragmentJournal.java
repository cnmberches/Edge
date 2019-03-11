package app.helianthus.edge;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentJournal extends Fragment {

    private FragmentJournalViewModel mViewModel;

    public static FragmentJournal newInstance() {
        return new FragmentJournal();
    }

    View view;
    androidx.appcompat.widget.Toolbar mTopToolbar;

    private boolean isChecked = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_journal, container, false);

        mTopToolbar = view.findViewById(R.id.journal_toolbar);
        mTopToolbar.inflateMenu(R.menu.journal_app_bar_menu);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentJournalViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem gridCheck = menu.findItem(R.id.journal_menu_grid_toggle);
        gridCheck.setChecked(isChecked);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.journal_menu_grid_toggle:
                isChecked = !item.isChecked();
                item.setChecked(isChecked);
                return true;
            default:
                return false;
        }
    }

}
