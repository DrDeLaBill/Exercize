package com.georgy.newapp;

import com.google.gson.Gson;

public class TransformFromJson {

    HST companyOne = new HST();

    public TransformFromJson() {

    }

    public TransformFromJson(String line) {

        Gson gson = new Gson();
        this.companyOne = gson.fromJson(line, HST.class);

    }

    public HST returnCompany() {
        return this.companyOne;
    }
}
