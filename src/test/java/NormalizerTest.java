import Normalizer.Normalizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NormalizerTest {
    @ParameterizedTest(name = "Given \"{0}\", when normalized, then should be \"{1}\"")
    @DisplayName("Tests Jaccard algorithm to various inputs")
    @CsvSource({
            "Java engineer,Software engineer",
            "C# engineer,Software engineer",
            "Full stack software engineer,Software engineer",
            "Software backend engineer Java,Software engineer",
            "Accountant,Accountant",
            "Chief Accountant,Accountant",
            "Super Accountant Senior,Accountant",
            "Junior Accountant,Accountant",
            "Senior quantity surveyor senior,Quantity surveyor",
            "Quantity surveyor accountant,Quantity surveyor",
            "Quantity surveyor,Quantity surveyor",
            "Quantity expert surveyor,Quantity surveyor",
            "Solution architect,Architect",
            "Senior architect,Architect",
            "Civil architect,Architect",
            "Senior architecture expert,Architect"
    })
    public void testsJaccardNormalizer(String input, String expected) {
        final Normalizer normalizer = new Normalizer("Jaccard");

        Assertions.assertEquals(expected, normalizer.normalize(input));
    }

    @ParameterizedTest(name = "Given \"{0}\", when normalized, then should be \"{1}\"")
    @DisplayName("Tests Lavenshtein algorithm to various inputs")
    @CsvSource({
            "Java engineer,Software engineer",
            "C# engineer,Software engineer",
            "Full stack software engineer,Software engineer",
            "Software backend engineer Java,Software engineer",
            "Accountant,Accountant",
            "Chief Accountant,Accountant",
            "Super Accountant Senior,Accountant",
            "Junior Accountant,Accountant",
            "Senior quantity surveyor senior,Quantity surveyor",
            "Quantity surveyor accountant,Quantity surveyor",
            "Quantity surveyor,Quantity surveyor",
            "Quantity expert surveyor,Quantity surveyor",
            "Solution architect,Architect",
            "Senior architect,Architect",
            "Civil architect,Architect",
            "Senior architecture expert,Architect"
    })
    public void testsLavenshteinNormalizer(String input, String expected) {
        final Normalizer normalizer = new Normalizer("Lavenshtein");

        Assertions.assertEquals(expected, normalizer.normalize(input));
    }
}