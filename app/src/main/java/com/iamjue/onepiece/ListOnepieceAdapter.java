package com.iamjue.onepiece;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListOnepieceAdapter extends RecyclerView.Adapter<ListOnepieceAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Onepiece> listOnepiece;

    public ArrayList<Onepiece> getListOnepiece() {
        return listOnepiece;
    }

    public void setListOnepiece(ArrayList<Onepiece> listOnepiece) {
        this.listOnepiece = listOnepiece;
    }

    public ListOnepieceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_onepiece, viewGroup, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        listViewHolder.tvName.setText(getListOnepiece().get(i).name);
        listViewHolder.tvBounty.setText(getListOnepiece().get(i).bounty);
        Glide.with(context)
                .load(getListOnepiece().get(i).getPhoto())
                .into(listViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListOnepiece().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvBounty;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvName = itemView.findViewById(R.id.tv_name);
            tvBounty = itemView.findViewById(R.id.tv_bounty);
        }
    }
}
