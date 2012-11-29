package ru.devpad.absolutelayout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExampleActivity2 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("AbsoluteLayout programmatically");

        Button btn1 = new Button(this);
        btn1.setLayoutParams(new AbsoluteLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                convertDpToPixel(20, this), /* x coord */
                convertDpToPixel(20, this)  /* y coord */
        ));
        btn1.setText("Coord 20x20");

        Button btn2 = new Button(this);
        btn2.setLayoutParams(new AbsoluteLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                convertDpToPixel(120, this), /* x coord */
                convertDpToPixel(20, this)  /* y coord */
        ));
        btn2.setText("Coord 120x20");

        ImageView image = new ImageView(this);
        image.setLayoutParams(new AbsoluteLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                convertDpToPixel(50, this), /* x coord */
                convertDpToPixel(100, this) /* y coord */
        ));
        image.setImageResource(R.drawable.ic_launcher);

        TextView text = new TextView(this);
        text.setLayoutParams(new AbsoluteLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                convertDpToPixel(40, this), /* x coord */
                convertDpToPixel(150, this)  /* y coord */
        ));
        text.setText("DevPad.RU");

        AbsoluteLayout absoluteLayout = new AbsoluteLayout(this);
        absoluteLayout.setLayoutParams(
                new AbsoluteLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT,
                        0, /* begin x coord */
                        0 /* begin y coord */
                )
        );
        absoluteLayout.addView(btn1);
        absoluteLayout.addView(btn2);
        absoluteLayout.addView(image);
        absoluteLayout.addView(text);

        setContentView(absoluteLayout);
    }

    public static int convertDpToPixel(int dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }
}