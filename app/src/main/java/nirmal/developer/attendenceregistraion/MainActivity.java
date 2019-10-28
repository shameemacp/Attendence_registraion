package nirmal.developer.attendenceregistraion;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText ed1,ed2;
    String n,r;
    SharedPreferences.Editor editor;
     String MyPREFERENCES="My";
   String name="nameKey";
   String  regno="regKey";

 SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);

        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View view) {
                if (ed1.getText().toString().isEmpty()||ed2.getText().toString().isEmpty())
                {

                    Toast.makeText(MainActivity.this,"Empty Field",Toast.LENGTH_LONG).show();

                }
                else
                {

                    n=ed1.getText().toString();
                    r=ed2.getText().toString();
                    editor = sharedPreferences.edit();
                    editor.putString(name,n);
                    editor.putString(regno,r);
                    editor.apply();
                    Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }



            }
        });

    }
}