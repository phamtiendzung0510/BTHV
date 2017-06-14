package com.runsystem.dungpt1.recyclerviewa;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by dungpt1 on 07-Jun-17.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public static final int LAYOUT_ID = R.layout.header_layout;

    TextView tvHeader;
    ImageView imvHeader;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        tvHeader = (TextView) itemView.findViewById(R.id.tvHeader);
        imvHeader = (ImageView) itemView.findViewById(R.id.imvHeader);
    }

    public void bind(MultiTypeBean multiTypeBean){
        tvHeader.setText(multiTypeBean.title);
//        Glide.with(itemView.getContext()).load(multiTypeBean.image).into(imvHeader);
        Glide.with(itemView.getContext()).load(R.drawable.loading).into(imvHeader);
    }
}
