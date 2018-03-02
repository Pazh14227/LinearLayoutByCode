package com.example.malai_pt1882.taskwithlinearlayout;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create a new Linear layout view group with background green color
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setBackgroundColor(Color.GREEN);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //Create width, height and weight as layout params and set it to linearlayout
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0);
        linearLayout.setLayoutParams(layoutParams);

        // create a image view and add it to linear layout
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.dice_image);
        imageView.setBackgroundColor(Color.BLACK);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 200, 10));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //TODO MAKE THE IMAGE TO FIT IN CENTER
        imageView.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
        imageView.setMinimumHeight(96);
        linearLayout.addView(imageView);

        // create 4 text view and add it to linear layout
        textView = new TextView(getApplicationContext());
        textView.setText("This is dice");
        textView.setTextSize(22); //48 SP
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "TextView is clicked!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        linearLayout.addView(textView);

        textView1 = new TextView(getApplicationContext());
        textView1.setGravity(Gravity.CENTER_HORIZONTAL);
        textView1.setTextSize(22);
        textView1.setText("There are 3 dice");
        linearLayout.addView(textView1);

        textView2 = new TextView(getApplicationContext());
        textView2.setText("One is red color");
        textView2.setTextSize(22);
        textView2.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.addView(textView2);

        textView3 = new TextView(getApplicationContext());
        textView3.setText("Another blue and green color");
        textView3.setTextSize(22);
        textView3.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.addView(textView3);
        //TODO Make the buttons with constant size
        //TODO create 4 buttons with 2 having onClickListener and other 2 having xml functions.

        LayoutInflater inflater = getLayoutInflater();
        View shortToastButton = inflater.inflate(R.layout.short_button, (ViewGroup) findViewById(R.id.short_button_id));
        linearLayout.addView(shortToastButton);

        LinearLayout subLayoutForButtons = new LinearLayout(getApplicationContext());
        subLayoutForButtons.setOrientation(LinearLayout.HORIZONTAL);

        Button showToast3 = new Button(getApplicationContext());
        showToast3.setText("Show toast3");
        showToast3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2));
        showToast3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),textView2.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
//        showToast3.setId(Integer.parseInt("showToast3"));

        Button showToast4 = new Button(getApplicationContext());
        showToast4.setText("Show toast4");
        showToast4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2));
        showToast4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),textView3.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
//        showToast4.setId(Integer.parseInt("showToast4"));


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            showToast3.setTextSize(8);
//            showToast4.setTextSize(8);

            Button showToast1 = (Button) shortToastButton.findViewById(R.id.showtoast1);
//            showToast1.setTextSize(8);
            Button showToast2 = (Button) shortToastButton.findViewById(R.id.showtoast2);
//            showToast2.setTextSize(8);
        }

        subLayoutForButtons.addView(showToast3);
        subLayoutForButtons.addView(showToast4);
        subLayoutForButtons.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.addView(subLayoutForButtons);
        linearLayout.setWeightSum(10);
        //Apply the created view

        setContentView(linearLayout);

    }


    public void showToast1Clicked(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), textView.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showToast2Clicked(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), textView1.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
