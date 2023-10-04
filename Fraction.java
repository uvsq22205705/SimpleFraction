
public class Fraction extends Number implements Comparable<Fraction>{
    // Déclaration des attributs
    private final int numerateur;
    private final int denominateur;
    // Déclaration des constantes
    final static int ZERO_NUM = 0;
    final static int ZERO_DENOM = 1;
    final static int UN_NUM = 1;
    final static int UN_DENOM = 1;

    // Constructeur avec numérateur et dénominateur
    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    // Getter pour le numérateur
    public int getNumerateur() {
        return numerateur;
    }

    // Getter pour le dénominateur
    public int getDenominateur() {
        return denominateur;
    }

    // Méthode pour obtenir la valeur en virgule flottante
    public double doubleValue() {
        return (double) numerateur / denominateur;
    }

    // Méthodes de l'interface Number à implémenter
    @Override
    public int intValue() {
        return numerateur / denominateur;
    }

    @Override
    public long longValue() {
        return (long) numerateur / denominateur;
    }

    @Override
    public float floatValue() {
        return (float) numerateur / denominateur;
    }

    @Override
    public short shortValue() {
        return (short) (numerateur / denominateur);
    }

    @Override
    public byte byteValue() {
        return (byte) (numerateur / denominateur);
    }

    // Constructeur avec juste le numérateur (dénominateur égal à 1)
    public Fraction(int numerateur) {
        this.numerateur = numerateur;
        this.denominateur = 1;
    }

    // Constructeur sans argument (numérateur égal à 0 et dénominateur égal à 1)
    public Fraction() {
        this.numerateur = 0;
        this.denominateur = 1;
    }

    public String toString() {
        //return "Je suis une fraction.";
        return numerateur + "/" + denominateur;
    }

    // Méthode pour additionner deux fractions
    public Fraction add(Fraction other) {
        int commonDenominator = this.denominateur * other.denominateur;
        int sumNumerator = (this.numerateur * other.denominateur) + (other.numerateur * this.denominateur);
        return new Fraction(sumNumerator, commonDenominator);
    }

    // Méthode pour tester l'égalité entre fractions
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Les références sont identiques, les fractions sont égales
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // L'objet n'est pas une instance de Fraction
        }
        Fraction other = (Fraction) obj;
        return this.numerateur * other.denominateur == other.numerateur * this.denominateur;
    }

    // Méthode pour comparer deux fractions selon l'ordre naturel
    @Override
    public int compareTo(Fraction other) {
        int thisNumeratorTimesOtherDenominator = this.numerateur * other.denominateur;
        int otherNumeratorTimesThisDenominator = other.numerateur * this.denominateur;

        // Compare les deux valeurs en multipliant par le dénominateur commun
        return Integer.compare(thisNumeratorTimesOtherDenominator, otherNumeratorTimesThisDenominator);
    }
}
