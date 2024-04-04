package com.example.android.testing.espresso.BasicSample;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    private void clearTextInEditText() {
        // Clear the text in the EditText
        onView(withId(R.id.editTextUserInput)).perform(clearText());
    }

    @Test
    public void validateTextView() {
        // Validate correct strings in the TextView in the main activity.
        onView(withId(R.id.textToBeChanged)).check(matches(withText("Hello Espresso!")));
    }

    @Test
    public void validateEditText() {
        // Enter "123" and press Change Text button, and test the string
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
        clearTextInEditText();

        // Enter "123" and press Open Activity and Change Text button, and test the string in ShowTextActivity
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
        onView(isRoot()).perform(ViewActions.pressBack());
        clearTextInEditText();

        // Without entering anything and press Change Text button and test the string (empty/null)
        onView(withId(R.id.editTextUserInput)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
        clearTextInEditText();

        // Without entering anything and press Open Activity and Change Text button, and test the string in ShowTextActivity (null).
        onView(withId(R.id.editTextUserInput)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
        onView(isRoot()).perform(ViewActions.pressBack());
        clearTextInEditText();

        
    }
}
