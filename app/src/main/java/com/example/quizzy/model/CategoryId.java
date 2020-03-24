package com.example.quizzy.model;

import com.example.quizzy.exception.InvalidCategory;

public class CategoryId {
    private Integer categoryId;
    private final Integer MIN_CATEGORY_ID = 9;
    private final Integer MAX_CATEGORY_ID = 32;

    public CategoryId(Integer categoryId) {
        if (categoryId >= MIN_CATEGORY_ID && categoryId <= MAX_CATEGORY_ID)
            this.categoryId = categoryId;
        else{
            this.categoryId = MIN_CATEGORY_ID;
            try {
               throw new InvalidCategory();
            }
            catch (InvalidCategory e) {
                e.printStackTrace();
            }
        }
    }



    public Integer getCategoryId() {
        return categoryId;
    }
}
