package com.solvd.laba.PoliceProject.exceptions;

public class SuspectIsAlreadyInSystem extends Exception {
    public SuspectIsAlreadyInSystem() {
        super("Suspect already added to the system.");
    }
}
