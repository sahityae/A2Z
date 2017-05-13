package shehack.speedx.function;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import shehack.speedx.R;

/**
 * Created by Sahitya on 5/13/2017.
 */

public class ItenaryAdapter extends RecyclerView.Adapter<ItenaryAdapter.MyViewHolder> {
    private List<ItenaryItem> itenaryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView driverName, agencyName, address, num;

        public MyViewHolder(View view) {
            super(view);
            driverName = (TextView) view.findViewById(R.id.driverName);
            agencyName = (TextView) view.findViewById(R.id.agencyName);
            address = (TextView) view.findViewById(R.id.address);
            num = (TextView) view.findViewById(R.id.num);
        }
    }


    public ItenaryAdapter(List<ItenaryItem> itenaryList) {
        this.itenaryList = itenaryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itenary_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItenaryItem item = itenaryList.get(position);
        holder.driverName.setText(item.getDriverName());
        holder.agencyName.setText(item.getAgency());
        holder.address.setText(item.getAddress());
        holder.num.setText(item.getContact());
    }

    @Override
    public int getItemCount() {
        return itenaryList.size();
    }
}
