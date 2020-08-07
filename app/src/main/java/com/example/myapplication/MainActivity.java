package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameET,surnameET,marksET,idET;
    Button add_button,button_viewall,button_update,button_delete;
    DatabaseHelper databaseHelper;
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper=new DatabaseHelper(this);

        initData();
    }

    private void initData() {

        nameET=findViewById(R.id.nameET);
        surnameET=findViewById(R.id.surnameET);
        marksET=findViewById(R.id.marksET);
        idET=findViewById(R.id.id_ET);

        add_button=findViewById(R.id.button_add);
        button_viewall=findViewById(R.id.button_viewall);
        button_update=findViewById(R.id.button_update);
        button_delete=findViewById(R.id.button_delete);

        add_button.setOnClickListener(this);
        button_viewall.setOnClickListener(this);
        button_update.setOnClickListener(this);
        button_delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.button_add:

               boolean isInserted= databaseHelper.insertData(nameET.getText().toString(), surnameET.getText().toString(), marksET.getText().toString());

               if(isInserted == true)
               {
                   Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
               }
               else {

                   Toast.makeText(this, "sorryy", Toast.LENGTH_SHORT).show();
               }

               Intent i=new Intent(MainActivity.this,MainActivity2.class);
               i.putExtra("value", val);
               startActivity(i);

                break;

            case R.id.button_viewall:

                Cursor res = databaseHelper.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append("Marks :"+ res.getString(3)+"\n\n");
                }

                // Show all data
                showMessage("Data",buffer.toString());

                break;

            case R.id.button_update:

//                boolean isUpdate = databaseHelper.updateData(idET.getText().toString(),
//                        nameET.getText().toString(),
//                        surnameET.getText().toString(),marksET.getText().toString());
//                if(isUpdate == true)
//                    Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();

                break;

            case R.id.button_delete:


//                Integer deletedRows = databaseHelper.deleteData(idET.getText().toString());
//                if(deletedRows > 0)
//                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();


                break;
            default:

                break;
        }
    }

    private void showMessage(String title, String Message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
