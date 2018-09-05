package com.example.android.miwok;

public class Word {

    /**
     * Image resource ID for the word
     */
    private int mTranslationImage = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = 0;

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * Resource ID for the sound file
     */
    private int mSound;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation   is the word in the Miwok language
     *      * @param soundID is the sound resource ID associated with the correct audio file
     */
    public Word(String defaultTranslation, String miwokTranslation, int soundID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSound = soundID;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation   is the word in the Miwok language
     * @param translationImageID is the image resource ID associated with correct Miwok word
     * @param soundID is the sound resource ID associated with the correct audio file
     */
    public Word(int translationImageID, String defaultTranslation, String miwokTranslation, int soundID) {
        mTranslationImage = translationImageID;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSound = soundID;
    }

    /**
     * Get the image ID of the word.
     */
    public int getImageResourceID() {
        return mTranslationImage;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mTranslationImage != NO_IMAGE_PROVIDED;
    }

    public int getSoundResourceID() {
        return mSound;
    }
}