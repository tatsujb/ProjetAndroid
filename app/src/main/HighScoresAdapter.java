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
    private Couple<String, Long>[] tuples;

    public HighScoresAdapter(Context ctx, Couple<String, Long>[] tuples) {
        this.context = ctx;
        this.tuples = tuples;
        
        inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tuples.length;
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return tuples[position];
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * @param position
     * @param previousView
     * @param parent
     * @return
     */
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
