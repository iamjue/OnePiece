package com.iamjue.onepiece;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GirdOnepieceAdapter extends RecyclerView.Adapter<GirdOnepieceAdapter.GirdViewHolder> {
    private Context context;
    private ArrayList<Onepiece> girdOnepiece;

    public ArrayList<Onepiece> getGirdOnepiece() {
        return girdOnepiece;
    }

    public void setGirdOnepiece(ArrayList<Onepiece> girdOnepiece) {
        this.girdOnepiece = girdOnepiece;
    }

    public GirdOnepieceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GirdViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gird_onepiece, viewGroup, false);
        return new GirdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GirdViewHolder girdViewHolder, int i) {
        Glide.with(context).load(getGirdOnepiece().get(i).getPhoto())
                .into(girdViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getGirdOnepiece().size();
    }

    public class GirdViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GirdViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
