# TestProjekt – Ordinationssystem

Dette projekt er et tværfagligt testprojekt lavet i forbindelse med **Programmering 2 (PRO2)** og **Systemudvikling 2 (SU2)** på **Datamatiker 2. semester**.

Projektet handler om at udvikle og teste et simpelt system til håndtering af **medicinordinationer for patienter**.

## Gruppe

Projektet er lavet af:

- Nicklas  
- Gustav  
- Lucas  

Datamatiker – 2. semester  

## Formål

Formålet med projektet er at:

- Implementere dele af et objektorienteret system i **Java**
- Arbejde med **Unit Tests** ved hjælp af **JUnit**
- Udføre **black box test** baseret på ækvivalensklasser og grænseværdier
- Udarbejde og udføre **systemtest** på en use case

## Projektets indhold

Projektet indeholder test af flere klasser i systemet:

### PN
Test af metoder:
- `forskelFørsteOgSidste()`
- `givDosis(LocalDate givesDen)`

### DagligFast
Test af metoder:
- `samletDosis()`
- `setDoser(double morgenAntal, double middagAntal, double aftenAntal, double natAntal)`

### DagligSkaev
Test af metoder:
- `medicinPaaDag()`
- `samletDosis()`

Testene kontrollerer blandt andet:
- Gyldige og ugyldige input
- Grænseværdier
- Forventede outputs

## Systemtest

Der er også lavet systemtest af use casen:

**Opret ordination**

Her testes forskellige flows:
- PN ordination
- Daglig skæv ordination
- Daglig fast ordination
- Exceptional flows (fejlsituationer)

## Teknologier

Projektet er udviklet med:

- **Java**
- **JUnit**
- **Git & GitHub**

## Repository

GitHub repository: https://github.com/GustavFL2000/TestProjekt.git


