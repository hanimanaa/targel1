package hanimanaa.targel1;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class Keyboard extends LinearLayout implements View.OnClickListener {

    Context context;
    EditText et;
    Button btsub;
    ScrollView  scrollView;
    LinearLayout linearLayout;

    public Keyboard(Context context) {
        super(context);
        this.context = context;

        et = new EditText(context);
        et.setTextColor(Color.BLUE);
        et.setTextDirection(View.TEXT_DIRECTION_ANY_RTL);


        btsub = new Button(context);
        btsub.setText("Submit");

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        this.setOrientation(VERTICAL);
        this.addView(et);
        this.addView(btsub);


        btsub.setOnClickListener(this);


    }

    public void loadButtons(int x)
    {
        scrollView =new ScrollView(context);
        scrollView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

        linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        layoutParams.setMargins(0,100,0,0);
        linearLayout.setLayoutParams(layoutParams);




        for(int i=1;i<=x;i++)
        {
            Button btn = new Button(context);
            btn.setText(String.valueOf(i));
            LayoutParams btnParam=new LayoutParams(600,300);
            btn.setLayoutParams(btnParam);
            scrollView.addView(btn);
        }

       // l.addView(scrollView);
        this.addView(scrollView);
    }

    @Override
    public void onClick(View view) {
        Button btn=(Button) view;
        if(btn==btsub)
        {
            int n = Integer.parseInt(et.getText().toString());
            loadButtons(n);
        }
    }
}
