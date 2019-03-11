package app.helianthus.edge;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<GameModel> gameModelArrayList;

    public GameAdapter(Context ctx, ArrayList<GameModel> gameModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.gameModelArrayList = gameModelArrayList;

    }

}
