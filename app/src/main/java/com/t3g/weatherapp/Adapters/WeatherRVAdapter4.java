package com.t3g.weatherapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.t3g.weatherapp.Modals.WeatherRVModal;
import com.t3g.weatherapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherRVAdapter4 extends RecyclerView.Adapter<WeatherRVAdapter4.ViewHolder> {
    private Context context;
    private ArrayList<WeatherRVModal> weatherRVModalArrayList4;

    public WeatherRVAdapter4(Context context, ArrayList<WeatherRVModal> weatherRVModalArrayList4) {
        this.context = context;
        this.weatherRVModalArrayList4 = weatherRVModalArrayList4;
    }

    @NonNull
    @Override
    public WeatherRVAdapter4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull WeatherRVAdapter4.ViewHolder holder, int position) {

        WeatherRVModal modal = weatherRVModalArrayList4.get(position);
        holder.temperatureTv.setText(modal.getTemperature() + "°C");
        Picasso.get().load(modal.getIcon()).into(holder.conditionTV);
//        holder.windTV.setText(modal.getWindSpeed() + "Km/hr");
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");
        try {
            Date t = input.parse(modal.getTime());
            assert t != null;
            holder.timeTV.setText(output.format(t));
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return weatherRVModalArrayList4.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView windTV, temperatureTv, timeTV;
        private ImageView conditionTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            windTV = itemView.findViewById(R.id.idTVWindSpeed);
            temperatureTv = itemView.findViewById(R.id.idTVTemperature);
            timeTV = itemView.findViewById(R.id.idTVTime);
            conditionTV = itemView.findViewById(R.id.idTVCondition);
        }
    }
}
