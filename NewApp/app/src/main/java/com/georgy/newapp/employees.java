package com.georgy.newapp;

import android.support.annotation.NonNull;

import java.util.List;

public class Employees implements Comparable<Employees>{
    public String name;
    public int phone_number;
    public List<String> skills;
    public String stringSkills;

    public Employees() {

    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(@NonNull Employees obj) {
        return getName().compareTo(obj.getName());
    }


    public void skillsGetAsString() {
        String result = "";
        List<String> list = skills;
        
        for(int i=0; i < list.size(); i++) {
            if(list.size() - i > 1)
                result += (list.get(i) + ", ");
            else
                result += list.get(i);
        }
        this.stringSkills = result;
    }
}
