package com.twobro.footballteams.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.twobro.footballteams.R;
import com.twobro.footballteams.model.Clubs;

import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ClubsViewHolder> {

    Context context;
    List<Clubs> clubs;

    public ClubsAdapter(Context context, List<Clubs> clubs) {
        this.context = context;
        this.clubs = clubs;
    }

    @NonNull
    @Override
    public ClubsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View clubItems = LayoutInflater.from(context).inflate(R.layout.club_item, parent, false);
        return new ClubsAdapter.ClubsViewHolder(clubItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsViewHolder holder, int position) {
        holder.ClubBG.setBackgroundColor(Color.parseColor(clubs.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(clubs.get(position).getImg(),"drawable", context.getPackageName());
        holder.clubItem.setImageResource(imageId);

        holder.clubTrainerID.setText(clubs.get(position).getTrainer());
        holder.clubCountry.setText(clubs.get(position).getCountry());
        holder.clubName.setText(clubs.get(position).getClubName());

    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public static final class ClubsViewHolder extends RecyclerView.ViewHolder {

        CardView ClubBG;
        ImageView clubItem;
        TextView clubName, clubCountry, clubTrainerID;



        public ClubsViewHolder(@NonNull View itemView) {
            super(itemView);

            ClubBG = itemView.findViewById(R.id.ClubBG);
            clubItem = itemView.findViewById(R.id.clubItem);
            clubName = itemView.findViewById(R.id.clubTitle);
            clubCountry = itemView.findViewById(R.id.clubCountry);
            clubTrainerID = itemView.findViewById(R.id.TrainerID);
        }
    }
}
