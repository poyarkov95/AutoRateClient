package com.example.user.userauthorisation.recyclerview_all_services;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.model.AutoService;
//import com.squareup.picasso.Picasso;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private AutoService[] autoServices = new AutoService[]{};
    private Context context;

    private Listener listener;

    public static interface Listener{
        public void onClick(String autoServiceName);
    }

    //TODO check how to properly set data on view from presenter
    public void setAutoServices(AutoService[] autoServices) {
        this.autoServices = autoServices;
    }

    public DataAdapter(Context context) {
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.auto_service_card_view, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Glide.with(context).load(autoServices[position].getImageURL()).into(imageView);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(autoServices[position].getServiceName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onClick(autoServices[position].getServiceName());
                }
            }
        });
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

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
