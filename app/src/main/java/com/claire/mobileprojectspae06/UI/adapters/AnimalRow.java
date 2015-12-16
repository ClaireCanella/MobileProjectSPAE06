package com.claire.mobileprojectspae06.UI.adapters;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.claire.mobileprojectspae06.Model.Animal;
import com.claire.mobileprojectspae06.R;

/**
 * Created by Claire on 15/12/2015.
 */
public class AnimalRow extends RelativeLayout {

    private TextView animalNameTextView;
    //private TextView movieRankTextView;

    public AnimalRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AnimalRow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimalRow(Context context) {
        super(context);
    }

    public static AnimalRow createFromView(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        AnimalRow animalRow = (AnimalRow) layoutInflater.inflate(R.layout.animal_row, viewGroup, false);

        animalRow.animalNameTextView = (TextView) animalRow.findViewById(R.id.row_animal_name_textview);
        //animalRow.animalPictureTextView = (TextView) movieRow.findViewById(R.id.row_animal_picture_textview);

        return animalRow;
    }

    public void setAnimal(Animal animal) {
        animalNameTextView.setText(animal.getName());
        //movieRankTextView.set(""+animal.getScore());
    }
}
