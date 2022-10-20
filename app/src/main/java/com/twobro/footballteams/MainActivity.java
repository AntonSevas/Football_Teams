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
    CategoryAdapter categoryAdapter;
    static ClubsAdapter clubsAdapter;
    static List<Clubs> clubsList = new ArrayList<>();



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
        clubsList.add(new Clubs(1,"manchester_logo","Manchester","Англия", "Эрик тен Хаг", "#DA020E","Test", 1));
        clubsList.add(new Clubs(2,"zenit","Zenit", "Россия", "Сергей Богданович Семак", "#40BDC5","Test",2));
        clubsList.add(new Clubs(3,"bvb","Borussia Dortmund","Германия", "Эдин Терзич", "#424345","Test", 3));


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

    public static void showClubsByCategory(int category){

        List<Clubs> filterClubs = new ArrayList<>();

        for(Clubs c: clubsList) {
            if(c.getClub() == category);  //getClubs ошибка
                 filterClubs.add(c);
        }

        clubsList.clear();
        clubsList.addAll(filterClubs);

        clubsAdapter.notifyDataSetChanged();

    }

}