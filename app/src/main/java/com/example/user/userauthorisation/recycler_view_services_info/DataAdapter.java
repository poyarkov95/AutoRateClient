package com.example.user.userauthorisation.recycler_view_services_info;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.model.Service;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private Service[] autoServices = new Service[]{};

    public void setAutoServices(Service[] autoServices) {
        this.autoServices = autoServices;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.service_card_view, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView descriptionTextView = (TextView)cardView.findViewById(R.id.service_name_text_view);
        descriptionTextView.setText(autoServices[position].getServiceName());
        TextView categoryTextView = (TextView)cardView.findViewById(R.id.service_description_text_view);
        categoryTextView.setText(autoServices[position].getCategory());
        TextView priceTextView = (TextView)cardView.findViewById(R.id.service_cost_text_view);
        priceTextView.setText(String.valueOf(autoServices[position].getPrice()));
    }

    @Override
    public int getItemCount() {
        return autoServices.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView card) {
            super(card);
            cardView = card;
        }
    }

}
