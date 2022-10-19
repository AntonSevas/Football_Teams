package com.twobro.footballteams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.twobro.footballteams.adapter.CategoryAdapter;
import com.twobro.footballteams.adapter.ClubsAdapter;
import com.twobro.footballteams.model.Category;
import com.twobro.footballteams.model.Clubs;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, clubsRecycler;
    ClubsAdapter clubsAdapter;
    CategoryAdapter categoryAdapter;


    @Override0
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Клубы"));
        categoryList.add(new Category(3,"Тренер"));
        categoryList.add(new Category(4,"Чемп"));

        setCategoryRecycler(categoryList);

        List<Clubs> clubsList = new ArrayList<>();
        clubsList.add(new Clubs(1,"manchester_logo","Manchester","Англия", "Эрик тен Хаг", "#EC5252"));
        clubsList.add(new Clubs(2,"zenit","Zenit", "Россия", "Сергей Богданович Семак", "#40BDC5"));
        clubsList.add(new Clubs(3,"manchester_logo","Manchester","Англия", "Эрик тен Хаг", "#EC5252"));


        setClubsRecycler(clubsList);

    }

    private void setClubsRecycler(List<Clubs> clubsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        clubsRecycler = findViewById(R.id.clubsRecycler);
        clubsRecycler.setLayoutManager(layoutManager);

        clubsAdapter = new ClubsAdapter(this,clubsList);
        clubsRecycler.setAdapter(clubsAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);



    }
}