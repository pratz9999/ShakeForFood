package com.lifesum

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.lifesum.CustomMatchers.Companion.waitFor
import com.lifesum.presentation.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mainActivityTestRule = ActivityTestRule(
        MainActivity::class.java
    )

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mainActivityTestRule.launchActivity(Intent())
        Espresso.onView(ViewMatchers.isRoot()).perform(waitFor(3000))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    fun testFoodItemName_Success() {
        Espresso.onView(withId(R.id.tv_food_name))
            .check(ViewAssertions.matches(withText("Ricotta cheese")))
    }

    @Test
    fun testFoodItemNutritionInfo_Success() {
        Espresso.onView(withId(R.id.btn_more)).perform(click())
        Espresso.onView(withId(R.id.inc_calories))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFoodItemNutritionInfoAndBack_Success() {
        Espresso.onView(withId(R.id.btn_more)).perform(click())
        Espresso.onView(withId(R.id.inc_calories))
        Espresso.pressBack()
        Espresso.onView(withId(R.id.cl_food))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testMoreInfoClickWhileLoading_Success() {
        Espresso.onView(withId(R.id.btn_more)).perform(click())
        Espresso.onView(withId(R.id.inc_calories))
        Espresso.pressBack()
        Espresso.onView(withId(R.id.cl_food))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}