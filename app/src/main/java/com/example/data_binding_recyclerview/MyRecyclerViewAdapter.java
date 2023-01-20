package com.example.data_binding_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.data_binding_recyclerview.databinding.ItemRowBinding;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements CustomClickListener {

    private List<DataModel> dataModelList;
    private Context context;

    private int count = 0;

    public MyRecyclerViewAdapter(List<DataModel> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_row, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setItemClickListener(this);

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public void cardClicked(DataModel f) {
        Toast.makeText(context, "You clicked " + f.androidName, Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemRowBinding itemRowBinding;

        public ViewHolder(@NonNull ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(DataModel obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}
