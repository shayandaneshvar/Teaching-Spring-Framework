import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class I18NTests {

    @Test
    public void testLocales() throws ParseException {
        Locale[] locales = Calendar.getAvailableLocales();
        System.out.println(locales.length);
        System.out.println(Arrays.toString(locales));
        locales = NumberFormat.getAvailableLocales();
        System.out.println(locales.length);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMAN);
        Number number = numberFormat.parse("1000,25");
        System.out.println(number);
        DateFormat dateFormat = DateFormat.getDateInstance(2, Locale.US);
        System.out.println(dateFormat.format(new Date()));
    }

    @Test
    public void testLocales2() {
        Locale locale = new Locale("en", "US");
        locale = new Locale.Builder().setRegion("US").setLanguage("en")
//                .setLanguageTag("en-US")
                .build();
    }

    @Test
    public void testResourceBundle() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Help", Locale.US);
        System.out.println(resourceBundle.getObject("text"));

        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("Help", Locale.UK);
        System.out.println(resourceBundle1.getObject("text"));

        ResourceBundle resourceBundle2 = ResourceBundle
                .getBundle("Help", new Locale.Builder().setLanguage("fa").build());
        System.out.println(new String(resourceBundle2.getObject("name").toString().getBytes(StandardCharsets.UTF_8)));

        ResourceBundle resourceBundle3 = ResourceBundle.getBundle("Help", Locale.FRENCH);
        System.out.println(resourceBundle3.getObject("name"));

        ResourceBundle listResourceBundle = ListResourceBundle.getBundle("Help",Locale.FRENCH);
        System.out.println(listResourceBundle.getObject("name"));
    }

    @Test
    public void testPropertyResourceBundle() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/Help_fa.properties");
        ResourceBundle resourceBundle = new PropertyResourceBundle(fileInputStream);
        System.out.println(resourceBundle.getObject("name"));
    }
}
