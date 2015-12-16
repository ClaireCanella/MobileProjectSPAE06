package com.claire.mobileprojectspae06.UI.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.claire.mobileprojectspae06.Model.Animal;

import java.util.ArrayList;

/**
 * Created by Claire on 15/12/2015.
 */
public class AnimalsAdapter extends BaseAdapter {

    private ArrayList<Animal> animals = new ArrayList<>();

    public void refreshMovies(ArrayList<Animal> listAnimals) {
        animals.clear();
        animals.addAll(listAnimals);

        //prévenir la listView qu'un update UI est nécessaire
        this.notifyDataSetChanged();
    }

    public void addMovie(Animal animal) {
        this.animals.add(animal);

        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int index) {
        return animals.get(index);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View viewFromCache, ViewGroup viewGroup) {

        AnimalRow animalRow = (AnimalRow)viewFromCache;

        if(null==animalRow) {
            animalRow = AnimalRow.createFromView(viewGroup);
        }

        animalRow.setAnimal(animals.get(index));

        return animalRow;
    }
}
