package com.example.ea6news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    private final int numberTabs;

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        numberTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new GeneralActivity();
        }
        else if(position == 1){
            return new TechActivity();

        }
        else if(position == 2){
            return new FinancialsActivity();

        }
        else if(position == 3){
            return new SportsActivity();

        }
        else if(position == 4){
            return new HealthActivity();

        }
        else if(position == 5){
            return new MusicActivity();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberTabs;
    }
}
