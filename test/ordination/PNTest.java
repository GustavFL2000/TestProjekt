package ordination;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    private Patient patient;
    private Laegemiddel laegemiddel;
    private PN pn;


    @BeforeEach
    void setUp() {
        // Arange
        patient = new Patient("123456-7890", "Fornavn Efternavn", 86.5);
        laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        pn = new PN(startDato, endDato, laegemiddel, 1);

    }

    @Test
    void forskelFørsteOgSidsteTC1IngenDosis() {
        // Arrange

        // Act

        int expected = -1;
        int actual = pn.forskelFørsteOgSidste();

        // Assert

        assertEquals(expected, actual);

    }

    @Test
    void forskelFørsteOgSidsteTC2EnDosis() {
        // Arrange

        pn.givDosis(LocalDate.of(2020, 1, 1));

        // Act

        int expected = 1;
        int actual = pn.forskelFørsteOgSidste();

        // Assert

        assertEquals(expected, actual);

    }

    @Test
    void forskelFørsteOgSidsteTC3ToDoser() {
        // Arrange

        pn.givDosis(LocalDate.of(2020, 1, 1));
        pn.givDosis(LocalDate.of(2020, 1, 10));

        // Act

        int expected = 10;
        int actual = pn.forskelFørsteOgSidste();

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void forskelFørsteOgSidsteTC4FemDoserTilfældigRækkefølge() {
        // Arrange

        pn.givDosis(LocalDate.of(2020, 1, 3));
        pn.givDosis(LocalDate.of(2020, 1, 1));
        pn.givDosis(LocalDate.of(2020, 1, 4));
        pn.givDosis(LocalDate.of(2020, 1, 10));
        pn.givDosis(LocalDate.of(2020, 1, 8));

        // Act

        int expected = 10;
        int actual = pn.forskelFørsteOgSidste();

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void givDosisTC1PaaStartdato() {
        // Arrange

        LocalDate givesDen = LocalDate.of(2020, 1, 1);

        // Act
        boolean actual = pn.givDosis(givesDen);

        // Assert

        assertTrue(actual);
    }

    @Test
    void givDosisTC2PaaSlutdato() {
        // Arrange

        LocalDate givesDen = LocalDate.of(2020, 1, 10);

        // Act
        boolean actual = pn.givDosis(givesDen);

        // Assert

        assertTrue(actual);
    }

    @Test
    void givDosisTC3MidtIPerioden() {
        // Arrange

        LocalDate givesDen = LocalDate.of(2020, 1, 5);

        // Act
        boolean actual = pn.givDosis(givesDen);

        // Assert

        assertTrue(actual);
    }

    @Test
    void givDosisTC4FørStartdato() {
        // Arrange

        LocalDate givesDen = LocalDate.of(2019, 12, 31);

        // Act
        boolean actual = pn.givDosis(givesDen);

        // Assert

        assertFalse(actual);
    }

    @Test
    void givDosisTC5EfterStartdato() {
        // Arrange

        LocalDate givesDen = LocalDate.of(2020, 1, 11);

        // Act
        boolean actual = pn.givDosis(givesDen);

        // Assert

        assertFalse(actual);
    }
}