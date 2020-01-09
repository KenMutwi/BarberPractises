package com.ken.mypractises;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText it1,ct1,barber11,barber12,barber13,itemId;
    Button btnAddData1,btnViewData1,btnDelete;
    String itHolder, ctHolder,barbar1Holder,barbar2Holder,barber3Holder;
    Boolean EditTextEmptyHold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        it1 = (EditText)findViewById(R.id.T_issued);
        ct1 = (EditText) findViewById(R.id.Tcollected);
        barber11=(EditText) findViewById(R.id.Barber1Amount);
        barber12=(EditText) findViewById(R.id.Barber2amount);
        barber13 = (EditText) findViewById(R.id.Barber3Amount);
        itemId=(EditText) findViewById(R.id.editTextId);

        btnAddData1 = (Button) findViewById(R.id.data1);
        btnViewData1=(Button) findViewById(R.id.view1);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        
        AddData1();
        ViewData1();
        DeleteData();

    }
    public void DeleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData(itemId.getText().toString());
                if(deleteRows>0)
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not found", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void AddData1(){
        btnAddData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextStatus();

                if (EditTextEmptyHold == true) {
                    boolean isInserted1 = myDb.insertData1(it1.getText().toString(),
                            ct1.getText().toString(),
                            barber11.getText().toString(),
                            barber12.getText().toString(),
                            barber13.getText().toString()
                    );
                    EmptyEditTextAfterDataInsert();
                    CallDisplay();
                    if (isInserted1 = true)
                        Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(MainActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

                }
            }


        });
    }

    private void CallDisplay() {
        Intent intent= new Intent(MainActivity.this,DisplayList.class);
        startActivity(intent);

    }

    private void EmptyEditTextAfterDataInsert() {
        it1.getText().clear();

        ct1.getText().clear();
        barber11.getText().clear();

        barber12.getText().clear();
        barber13.getText().clear();

    }

    private void CheckEditTextStatus() {
        itHolder = it1.getText().toString() ;
        ctHolder = ct1.getText().toString();
        barbar1Holder= barber11.getText().toString();
        barbar2Holder= barber12.getText().toString();
        barber3Holder= barber13.getText().toString();

        if(TextUtils.isEmpty(itHolder) || TextUtils.isEmpty(ctHolder) || TextUtils.isEmpty(barbar1Holder)|| TextUtils.isEmpty(barbar2Holder)|| TextUtils.isEmpty(barber3Holder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void ViewData1(){
        btnViewData1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= myDb.getAllData1();

                if(res.getCount()==0){
//                    //Show message if no data
                    showMessage("Error","No Data from Shop 1");
                    return;
                }
                StringBuffer buffer= new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("TowelIssued :"+ res.getString(1)+"\n");
                    buffer.append("TowelCollected :"+ res.getString(2)+"\n");
                    buffer.append("Barber1Activity :"+ res.getString(3)+"\n");
                    buffer.append("Barber2Activity :"+ res.getString(4)+"\n");
                    buffer.append("Barber3Activity :"+ res.getString(5)+"\n\n");

                }
                //Show all data
                showMessage("SHOP1DATA",buffer.toString());

            }
        });
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setTitle(Message);
        builder.show();
    }
}
