package ordination;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DagligSkaevTest {

    private Patient patient;
    private Laegemiddel laegemiddel;
    private DagligSkaev dagligSkaev;

    @BeforeEach
    void setUp() {
        // Arange
        patient = new Patient("123456-7890", "Fornavn Efternavn", 86.5);
        laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
    }

    /*
    ---------***---------***---------***---------***---------***---------***---------***---------***---------***-------
     */

    @Test
    void medicinPåDagTC1IngenMedicin() {
        // Arrange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);

        // Act
        double expected = 0;
        double actual = dagligSkaev.medicinPåDag();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void medicinPåDagTC2ToDoser() {
        // Arrange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);

        LocalTime tid1 = LocalTime.of(10, 00);
        LocalTime tid2 = LocalTime.of(12, 00);
        dagligSkaev.opretDosis(tid1, 1);
        dagligSkaev.opretDosis(tid2, 1);

        // Act
        double expected = 2;
        double actual = dagligSkaev.medicinPåDag();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void medicinPåDagTC3TreDoser() {
        // Arrange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);

        LocalTime tid1 = LocalTime.of(10, 00);
        LocalTime tid2 = LocalTime.of(12, 00);
        LocalTime tid3 = LocalTime.of(14, 00);
        dagligSkaev.opretDosis(tid1, 1);
        dagligSkaev.opretDosis(tid2, 4);
        dagligSkaev.opretDosis(tid3, 1);

        // Act
        double expected = 6;
        double actual = dagligSkaev.medicinPåDag();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void medicinPåDagTC4EnNegativDosis() {
        // Arrange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);

        LocalTime tid1 = LocalTime.of(10, 00);
        dagligSkaev.opretDosis(tid1, -1);

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> dagligSkaev.medicinPåDag());
    }

    @Test
    void medicinPåDagTC5ToDoserEnNegativ() {
        // Arrange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,10);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);

        LocalTime tid1 = LocalTime.of(10, 00);
        LocalTime tid2 = LocalTime.of(12, 00);
        dagligSkaev.opretDosis(tid1, 1);
        dagligSkaev.opretDosis(tid2, -3);

        // Act + Assert

        assertThrows(IllegalArgumentException.class, () -> dagligSkaev.medicinPåDag());
    }


    /*
    ---------***---------***---------***---------***---------***---------***---------***---------***---------***-------
     */

    @Test
    void samletDosisTC1MedicinPaaDagGrænse() {
        // Arange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,2);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);


        LocalTime tid1 = LocalTime.of(10, 00);
        int dosis = 0;
        dagligSkaev.opretDosis(tid1, dosis);

        // Act

        double expected = 0;
        double actual = dagligSkaev.samletDosis();

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void samletDosisTC2AntalDageGrænse() {
        // Arange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,1);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);


        LocalTime tid1 = LocalTime.of(10, 00);
        int dosis = 2;
        dagligSkaev.opretDosis(tid1, dosis);

        // Act

        double expected = 2;
        double actual = dagligSkaev.samletDosis();

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void samletDosisTC3NormalMedicinPaaDagOgNormalAntalDage() {
        // Arange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,6);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);


        LocalTime tid1 = LocalTime.of(10, 00);
        int dosis = 5;
        dagligSkaev.opretDosis(tid1, dosis);

        // Act

        double expected = 30;
        double actual = dagligSkaev.samletDosis();

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void samletDosisTC4UgyldigAntalvMedicinPaaDag() {
        // Arange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2020, 1,2);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);


        LocalTime tid1 = LocalTime.of(10, 00);
        int dosis = -1;
        dagligSkaev.opretDosis(tid1, dosis);

        // Act + Assert

        assertThrows(IllegalArgumentException.class, () -> dagligSkaev.samletDosis());

    }

    @Test
    void samletDosisTC5UgyldigAntalDage() {
        // Arange

        LocalDate startDato =  LocalDate.of(2020, 1, 1);
        LocalDate endDato =  LocalDate.of(2019, 12,31);
        dagligSkaev = new DagligSkaev(startDato, endDato, laegemiddel);


        LocalTime tid1 = LocalTime.of(10, 00);
        int dosis = 3;
        dagligSkaev.opretDosis(tid1, dosis);

        // Act + Assert

        assertThrows(IllegalArgumentException.class, () -> dagligSkaev.samletDosis());
    }
}