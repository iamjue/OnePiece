package com.iamjue.onepiece;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewOnepieceAdapter extends RecyclerView.Adapter<CardViewOnepieceAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Onepiece> listOnepiece;

    public ArrayList<Onepiece> getListOnepiece() {
        return listOnepiece;
    }

    public void setListOnepiece(ArrayList<Onepiece> listOnepiece) {
        this.listOnepiece = listOnepiece;
    }

    public CardViewOnepieceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_onepiece, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        final Onepiece onepiece = getListOnepiece().get(i);
        Glide.with(context).load(onepiece.photo).into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(onepiece.name);
        cardViewViewHolder.tvNickname.setText(onepiece.nickname);
        cardViewViewHolder.tvBounty.setText(onepiece.bounty);

        cardViewViewHolder.btnFav.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemCLicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListOnepiece().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemCLicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListOnepiece().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListOnepiece().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvNickname, tvBounty;
        ImageButton btnFav, btnShare;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvName = itemView.findViewById(R.id.tv_name);
            tvBounty = itemView.findViewById(R.id.tv_bounty);
            tvNickname = itemView.findViewById(R.id.tv_nickname);
            btnFav = itemView.findViewById(R.id.btn_favorite);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}
