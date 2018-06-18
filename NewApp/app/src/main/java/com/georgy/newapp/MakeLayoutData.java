package com.georgy.newapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MakeLayoutData {

    public static ArrayList<Map<String, Object>> makeData(HST companyOne, String ATRIBUTE_NAME, String ATRIBUTE_PHONE, String ATRIBUTE_SKILLS) {


        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        for (employees employee : companyOne.company.employees) {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put(ATRIBUTE_NAME, employee.name);
            m.put(ATRIBUTE_PHONE, "Phone number: " + employee.phone_number);
            employee.skillsGetAsString();
            m.put(ATRIBUTE_SKILLS, "skills: " + employee.stringSkills);
            data.add(m);
        }

        return data;
    }

}
