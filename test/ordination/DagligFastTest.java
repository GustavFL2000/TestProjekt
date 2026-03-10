package ordination;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DagligFastTest {

    private Patient patient;
    private Laegemiddel laegemiddel;
    private DagligFast dagligFast;

    @BeforeEach
    void setUp() {
        // Arange
        patient = new Patient("123456-7890", "Fornavn Efternavn", 86.5);
        laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        dagligFast = new DagligFast(startDato, endDato, laegemiddel);
    }

    /*
    ---------***---------***---------***---------***---------***---------***---------***---------***---------***-------
     */

    @Test
    void samletDosisTC1IngenDoserPaaAlleTidspunkter() {
        // Arrange
        double morgenAntal = 0;
        double middagAntal = 0;
        double aftenAntal = 0;
        double natAntal = 0;
        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Act

        double expected = 0;
        double actual = dagligFast.samletDosis();

        // Assert

        assertEquals(expected, actual);

    }

    @Test
    void samletDosisTC2EnDosisHvertTidspunkt() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 1;
        double aftenAntal = 1;
        double natAntal = 1;
        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Act

        double expected = 40;
        double actual = dagligFast.samletDosis();

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void samletDosisTC3ForskelligDoserAlleTidspunkter() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 2;
        double aftenAntal = 3;
        double natAntal = 4;
        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Act

        double expected = 100;
        double actual = dagligFast.samletDosis();

        // Assert

        assertEquals(expected, actual);
    }

    /*
    ---------***---------***---------***---------***---------***---------***---------***---------***---------***-------
     */

    @Test
    void setDoserTC1Normal() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 1;
        double aftenAntal = 1;
        double natAntal = 1;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC2Morgen0() {
        // Arrange
        double morgenAntal = 0;
        double middagAntal = 1;
        double aftenAntal = 1;
        double natAntal = 1;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC3Middag0() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 0;
        double aftenAntal = 1;
        double natAntal = 1;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC4Aften0() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 1;
        double aftenAntal = 0;
        double natAntal = 1;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC5Nat0() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 1;
        double aftenAntal = 1;
        double natAntal = 0;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC6Flere0() {
        // Arrange
        double morgenAntal = 1;
        double middagAntal = 0;
        double aftenAntal = 0;
        double natAntal = 1;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC7Alle0() {
        // Arrange
        double morgenAntal = 0;
        double middagAntal = 0;
        double aftenAntal = 0;
        double natAntal = 0;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC8Decimal() {
        // Arrange
        double morgenAntal = 0.5;
        double middagAntal = 1.5;
        double aftenAntal = 2;
        double natAntal = 0.25;


        // Act

        dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert

        assertEquals(morgenAntal, dagligFast.getDoser()[0].getAntal());
        assertEquals(middagAntal, dagligFast.getDoser()[1].getAntal());
        assertEquals(aftenAntal, dagligFast.getDoser()[2].getAntal());
        assertEquals(natAntal, dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void setDoserTC9Negativ() {
        // Arrange
        double morgenAntal = -1;
        double middagAntal = 1;
        double aftenAntal = 1;
        double natAntal = 1;

        // Act + Assert

        assertThrows(IllegalArgumentException.class, () -> dagligFast.setDoser(morgenAntal, middagAntal, aftenAntal, natAntal));

    }
}