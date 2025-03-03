public class Klant {
    // Attributes
    private int diensTyd;   // Nano sekondes
    private String naam;

    // Constructors
        // Default
        public Klant() {
            this.diensTyd = 500;
        }
        // Custom
        public Klant(int diensTyd, String naam) {
            setDiensTyd(diensTyd);
            setNaam(naam);
        }

    // Getters and Setters
        // Getters
        public int getDiensTyd() {
            return this.diensTyd;
        }

        public String getNaam() {
            return this.naam;
        }

        // Setters
        public void setDiensTyd(int diensTyd) {
            this.diensTyd = diensTyd;
        }

        public void setNaam(String naam) {
            this.naam = naam;
        }
}
