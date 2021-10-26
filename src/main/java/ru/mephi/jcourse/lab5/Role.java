package ru.mephi.jcourse.lab5;

enum Role{
    STAFF(0.1),
    MANAGER(0.2),
    EXECUTIVE(0.3);

    private final double multiplicator;

    Role(double v) {
        this.multiplicator = v;
    }

    public double getMult() {
        return multiplicator;
    }
}