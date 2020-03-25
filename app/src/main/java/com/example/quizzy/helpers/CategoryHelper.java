package com.example.quizzy.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CategoryHelper {
    private static Map<Integer, String> mCategories;

    static {
        mCategories = new HashMap<>();
        mCategories.put(21, "Sports");
        mCategories.put(18, "Science: Computers");
        mCategories.put(9, "General Knowledge");
        mCategories.put(22, "Geography");
        mCategories.put(23, "History");
        mCategories.put(15, "Video Games");
    }

    public static String getCategoryName(Integer id) {
        return mCategories.get(id);
    }


    public static int getCategoryId(String name) {
        for (Integer key : mCategories.keySet())
            if (mCategories.get(key).equals(name))
                return key;
        return -1;
    }

    public static Integer getRandomCategoryId() {
        Integer[] keys = mCategories.keySet().toArray(new Integer[0]);
        int randomKey = keys[new Random().nextInt(keys.length)];
        return randomKey;
    }
}
