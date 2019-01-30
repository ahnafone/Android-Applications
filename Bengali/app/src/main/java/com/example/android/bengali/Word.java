package com.example.android.bengali;

public class Word {

    private String mDefaultTranslation;
    private String mBengaliTranslation;

    public Word (String defaultTranslation, String bengaliTranslation) {
        mDefaultTranslation = defaultTranslation;
        mBengaliTranslation = bengaliTranslation;
    }//constructor

    //getters
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }//getDefaultTranslation

    public String getBengaliTranslation() {
        return mBengaliTranslation;
    }//getBengaliTranslation

}
