package krunal.com.example.acer.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 15-02-2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {

    private List<Heros> listtodisplay = new ArrayList<>();
    private Context context;
    private LayoutInflater minflater;

    RecycleAdapter(Context context, List<Heros> listtodisplay){
        this.context = context;
        this.listtodisplay = listtodisplay;
        this.minflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= minflater.inflate(R.layout.item_list,parent,false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.nametext.setText(listtodisplay.get(position).getName());
        holder.realname.setText(listtodisplay.get(position).getRealname());
    }

    @Override
    public int getItemCount() {
        return listtodisplay.size();
    }


    static class RecycleViewHolder extends RecyclerView.ViewHolder{

        private TextView nametext;
        private TextView realname;

         RecycleViewHolder(View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.textView);
            realname = itemView.findViewById(R.id.textView2);
        }
    }
}
