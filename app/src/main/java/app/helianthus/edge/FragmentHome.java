package app.helianthus.edge;

import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.BarChart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FragmentHome extends Fragment {

    private FragmentHomeViewModel mViewModel;

    public static FragmentHome newInstance() {
        return new FragmentHome();
    }

    View view;
    BarChart barChart;
    androidx.appcompat.widget.Toolbar mTopToolbar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        mTopToolbar = view.findViewById(R.id.home_toolbar);
        mTopToolbar.inflateMenu(R.menu.home_app_bar_menu);

        String date_n = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(new Date());
        TextView date = view.findViewById(R.id.home_date);
        date.setText(date_n);

        //barChart = (BarChart) view.findViewById(R.id.mood_bar_chart);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel.class);
        // TODO: Use the ViewModel
    }

}
