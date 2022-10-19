package com.twobro.footballteams.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.twobro.footballteams.ClubPage;
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
        holder.ClubBG.setCardBackgroundColor(Color.parseColor(clubs.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(clubs.get(position).getImg(),"drawable", context.getPackageName());
        holder.clubItem.setImageResource(imageId);

        holder.clubTrainerID.setText(clubs.get(position).getTrainer());
        holder.clubCountry.setText(clubs.get(position).getCountry());
        holder.clubName.setText(clubs.get(position).getClubName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ClubPage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity)  context,
                        new Pair<View, String>(holder.clubItem, "clubImage"));



                intent.putExtra("clubBG",Color.parseColor(clubs.get(position).getColor()));
                intent.putExtra("clubImage",imageId);
                intent.putExtra("clubTitle",clubs.get(position).getClubName());
                intent.putExtra("clubCountry",clubs.get(position).getCountry());
                intent.putExtra("clubTrainer",clubs.get(position).getTrainer());
                intent.putExtra("clubText",clubs.get(position).getText());

                context.startActivity(intent, options.toBundle());
            }
        });

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
