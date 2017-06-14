package com.runsystem.dungpt1.recyclerviewexample;

/**
 * Created by dungpt1 on 02-Jun-17.
 */

public class Person {
    private String name;
    private boolean isMale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Person(String name, boolean isMale)
    {
        this.name = name;
        this.isMale = isMale;
    }

}
