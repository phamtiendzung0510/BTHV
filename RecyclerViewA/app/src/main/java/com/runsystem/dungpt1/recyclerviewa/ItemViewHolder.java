package com.runsystem.dungpt1.recyclerviewa;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by dungpt1 on 07-Jun-17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final int LAYOUT_ID = R.layout.item_layout;

    TextView tvRank;
    TextView tvDescription;
    TextView tvTitle;
    ImageView imvItem;

    public ItemViewHolder(View itemView) {
        super(itemView);
        tvRank = (TextView) itemView.findViewById(R.id.tvRank);
        tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitleItem);
        imvItem = (ImageView) itemView.findViewById(R.id.imvItem);
//        itemView.setOnClickListener(this);
        tvRank.setOnClickListener(this);
        tvDescription.setOnClickListener(this);
        tvTitle.setOnClickListener(this);
        imvItem.setOnClickListener(this);
    }

    public void bind(MultiTypeBean multiTypeBean){
        tvTitle.setText(multiTypeBean.title);
        tvDescription.setText(multiTypeBean.description);
        Glide.with(itemView.getContext()).load(R.drawable.loading).into(imvItem);
        tvRank.setText(String.format("%d",getAdapterPosition()+1));
    }

    OnItemClick onItemClick;

    OnItemClickIem onItemClickIem;

    public void setOnItemClickIem(OnItemClickIem onItemClickIem) {
        this.onItemClickIem = onItemClickIem;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    @Override
    public void onClick(View v) {
//        if (onItemClick !=null){
//            onItemClick.onItemClick(v, getAdapterPosition());
//        }
        if (onItemClickIem!= null){
            onItemClickIem.onItemClickItem(v.getId());
        }
    }
}
