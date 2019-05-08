package com.example.achuth.dazlabs;

public class Obj {
    private String Name,number,about;

    Obj(String Name,String about)
    {
        this.Name=Name;
        this.about=about;
    }
    Obj(String Name,String about,String whatsaap)
    {
        this.Name=Name;
        this.number=whatsaap;
        this.about=about;
    }
    public String getName() {
        return Name;
    }

    public String getAbout() {
        return about;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
