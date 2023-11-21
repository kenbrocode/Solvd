package com.solvd.laba.PoliceProject.interfaces;

import com.solvd.laba.PoliceProject.people.personnel.Staff;

public interface Identifiable {
    int getID(Staff staff);

    String generateID(Staff staff);
}
