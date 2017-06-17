package com.earzate.excersice.login.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.earzate.excersice.R;
import com.earzate.excersice.common.AppContext;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by earzate on 6/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp(){
        AppContext.getInstance().setMock(true);
    }

    @Test
    public void testValidLogin(){
        onView(withId(R.id.email)).perform(typeText("emarzate"));
        onView(withId(R.id.password)).perform(typeText("password"));
        onView(withId(R.id.sign_in_button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("ABBC-2929-KKSK-CCCC")))
                .check(matches(isDisplayed()));
    }

}
