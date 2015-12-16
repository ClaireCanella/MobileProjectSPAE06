package com.claire.mobileprojectspae06.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claire on 15/12/2015.
 */
public class Animal implements Parcelable {

    private String name;


    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = name;
    }


    //Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //Ecriture dans le même ordre que la lecture

        parcel.writeString(name);
    }

    public static final Parcelable.Creator<Animal> CREATOR
            = new Parcelable.Creator<Animal>() {

        //à la réception (à l'unité)
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        //à la réception (pour plusieurs = tableau)
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    //Constructeur privé
    private Animal(Parcel in) {
        //Lecture dans le même ordre que l'écriture

        name = in.readString();  //lis le premier paramètre en tant que String
    }
}
