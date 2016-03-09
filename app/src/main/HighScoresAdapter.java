import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.Override;

public class HighScoresAdapter extends BaseAdapter {
    private static LayoutInflater inflater;

    private Context context;
    private int[] positions;
    private Couple<String, Long>[] tuples;
    
    public HighScoresAdapter(Context ctx, int[] positions, Couple<String, Long>[] tuples) {
        this.context = ctx;
        this.positions = positions;
        this.tuples = tuples;
        
        inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public int getCount() {
        return positions.length;
    }
    
    @Override
    public Object getItem(int position) {
        return tuples[position];
    }
    
    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public View getView(int position, View previousView, ViewGroup parent) {
        View previous = previousView;
        
        if (previous == null)
            previous = inflater.inflate(R.layout.line, null);
        
        TextView pseudo = (TextView) previous.findViewById(R.id.pseudo);
        pseudo.setText(tuples[position].getFirstObject());
        
        TextView score = (TextView) previous.findViewById(R.id.score);
        score.setText(Long.toString(tuples[position].getSecObject()));
        
        return previous;
    }
}
