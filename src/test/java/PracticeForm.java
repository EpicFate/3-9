import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void Form() {
        String firstName = "Dim",
                lastName = "Dyn",
                email = "dima@gmail.com",
                gender = "Male",
                mobile = "7999999999",
                dayOfBirth = "25",
                monthOfBirth = "January",
                yearOfBirth = "1995",
                subject1 = "Arts",
                subject2 = "Accounting",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "image.png",
                currentAddress = "adaa daa dada 11.22",
                state = "Haryana",
                city = "Karnal";

    open("https://demoqa.com/automation-practice-form");

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(email);
    $("#userNumber").setValue(mobile);
    $("#genterWrapper").$(byText(gender)).click();

    $("#dateOfBirthInput").click();
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption(yearOfBirth);
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption(monthOfBirth);
    $(".react-datepicker__day--0" + dayOfBirth).click();
    $("#subjectsInput").val(subject1);
    $(".subjects-auto-complete__menu").$(byText(subject1)).click();
    $("#subjectsInput").val(subject2);
    $(".subjects-auto-complete__menu").$(byText(subject2)).click();
    $("#hobbiesWrapper").$(byText(hobby1)).click();
    $("#hobbiesWrapper").$(byText(hobby2)).click();
    $("#hobbiesWrapper").$(byText(hobby3)).click();
    $("#uploadPicture").uploadFromClasspath(picture);
    $("#currentAddress").setValue(currentAddress);

    $("#state").click();
    $("#state").$(byText(state)).click();
    $("#city").click();
    $("#city").$(byText(city)).click();
    $("#submit").click();

    $(".table-responsive").shouldHave(text("Label Values"));
    $(".table-responsive").shouldHave(text("Student Name" +  " " + firstName + " " + lastName));
    $(".table-responsive").shouldHave(text("Student Email" + " " + email));
    $(".table-responsive").shouldHave(text("Gender" + " " + gender));
    $(".table-responsive").shouldHave(text("Mobile" + " " + mobile));
    $(".table-responsive").shouldHave(text("Date of Birth" + " " + dayOfBirth+ " " + monthOfBirth + "," + yearOfBirth));
    $(".table-responsive").shouldHave(text("Subjects" + " " + subject1 + ", " + subject2));
    $(".table-responsive").shouldHave(text("Hobbies" + " " + hobby1 + ", " + hobby2 + ", " + hobby3));
    $(".table-responsive").shouldHave(text("Picture" + " " + picture));
    $(".table-responsive").shouldHave(text("Address" + " " + currentAddress));
    $(".table-responsive").shouldHave(text("State and City" + " " + state + " " + city));




    }
}
