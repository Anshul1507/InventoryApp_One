package com.example.kapzan.inventoryapp1;

import android.provider.BaseColumns;


public class LibContract {

    public static class BookEntry implements BaseColumns {
        public static final String TABLE = "course_university";

        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String QUANTITY = "quantity";
        public static final String SUPLIER_NAME = "suplier_name";
        public static final String SUPLIER_CONTACT = "suplier_contact";


    }
}

