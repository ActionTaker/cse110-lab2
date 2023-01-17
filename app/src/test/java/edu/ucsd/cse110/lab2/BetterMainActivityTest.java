package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {

    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            var btn1 = (Button) activity.findViewById(R.id.btn_one);
            var btn2 = (Button) activity.findViewById(R.id.btn_plus);
            var eq = (Button) activity.findViewById(R.id.btn_equals);
            var view = (TextView) activity.findViewById(R.id.display);

            btn1.performClick();
            btn2.performClick();
            btn1.performClick();
            eq.performClick();
            assertEquals("2", view.getText().toString());

        });
    }
}
