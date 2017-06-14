package com.runsystem.dungpt1.recyclerviewa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dungpt1 on 07-Jun-17.
 */

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<MultiTypeBean> multiTypeBeanList;
    OnItemClick onItemClick;
    OnItemClickIem onItemClickIem;

    public void setOnItemClickIem(OnItemClickIem onItemClickIem) {
        this.onItemClickIem = onItemClickIem;
    }

    public void setOnItemClick(OnItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

    public MultiTypeAdapter(List<MultiTypeBean> multiTypeBeanList){
        this.multiTypeBeanList = multiTypeBeanList;
    }

    @Override
    public int getItemViewType(int position){
        return multiTypeBeanList.get(position).viewType;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case MultiTypeBean.HEADER:
                return new HeaderViewHolder(layoutInflater.inflate(HeaderViewHolder.LAYOUT_ID, parent, false));
            case MultiTypeBean.ITEM:
                return new ItemViewHolder(layoutInflater.inflate(ItemViewHolder.LAYOUT_ID, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case MultiTypeBean.HEADER:
                ((HeaderViewHolder) holder).bind(multiTypeBeanList.get(position));
                break;
            case MultiTypeBean.ITEM:
                ((ItemViewHolder) holder).bind(multiTypeBeanList.get(position));
                ((ItemViewHolder) holder).setOnItemClick(onItemClick);
                ((ItemViewHolder) holder).setOnItemClickIem(onItemClickIem);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return multiTypeBeanList.size();
    }


}
