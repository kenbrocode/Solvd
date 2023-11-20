package com.solvd.laba.hospitalProject.interfaces;

import com.solvd.laba.hospitalProject.people.personnel.Staff;

public interface Identifiable {
    int getID(Staff staff);

    String generateID(Staff staff);
}
