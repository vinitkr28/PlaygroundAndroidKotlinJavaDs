package cheezy_code.unit_testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test

class AddNoteActivityTest {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<AddNoteActivity>()


    @Test
    fun testSubmitButton_expectedCorrectValueOnDisplayNoteActivity() {
        val note_title = "Some Espresso Note Title"
        val note_description = "Some Espresso Note Description"

        Intents.init()

        onView(withId(R.id.editTextAddNote)).perform(typeText(note_title))
        onView(withId(R.id.editTextDescriptionWrite)).perform(
            typeText(note_description),
            closeSoftKeyboard()
        )
        onView(withId(R.id.buttonSubmit)).perform(ViewActions.click())

        onView(withId(R.id.mainDisplayNoteActivity)).check(matches(isDisplayed()))

        onView(withId(R.id.textDisplayNote)).check(
            matches(
//                withText("Title: $note_title \n" + "Description: $note_description")
                withText("$note_title $note_description")
            )
        )

        intended(hasComponent(DisplayNoteActivity::class.java.name))

        pressBack()

        onView(withId(R.id.mainAddNoteActivity)).check(matches(isDisplayed()))
//        intended(hasComponent(AddNoteActivity::class.java.name))

        Intents.release()
    }
}