package com.example.kapzan.inventoryapp1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.NAME;

import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.PRICE;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.QUANTITY;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.SUPLIER_CONTACT;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.SUPLIER_NAME;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.TABLE;

public class MainActivity extends AppCompatActivity {

    TextView d_data;
    LibDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          d_data=findViewById(R.id.name);
        dbHelper=new LibDBHelper(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.insert:
                ContentValues contentValues=new ContentValues();
                contentValues.put(NAME,"Udacity");
                contentValues.put(PRICE,"2000");
                contentValues.put(QUANTITY,"1");
                contentValues.put(SUPLIER_NAME,"Suplier");
                contentValues.put(SUPLIER_CONTACT,"08765");


                SQLiteDatabase database=dbHelper.getWritableDatabase();
                database.insert(TABLE,null,contentValues);
                Toast.makeText(this, "insert new row", Toast.LENGTH_SHORT).show();
                break;
            case R.id.refresh:
                displayData();
                break;

        }
        return true;
    }

    private void displayData() {
        d_data.setText(null);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor= database.query(TABLE,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String name=cursor.getString(cursor.getColumnIndex(NAME));
                String price=cursor.getString(cursor.getColumnIndex(PRICE));
                String quantity=cursor.getString(cursor.getColumnIndex(QUANTITY));
                String suplier_name=cursor.getString(cursor.getColumnIndex(SUPLIER_NAME));
                String suplier_contact=cursor.getString(cursor.getColumnIndex(SUPLIER_CONTACT));


                String data = name+"\t"+price+"\t"+quantity+"\t"+suplier_name+"\t"+suplier_contact+"\n";

                d_data.append(data);
            }while (cursor.moveToNext());
        }
        cursor.close();

        Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show();
    }
}
