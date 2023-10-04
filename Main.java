import java.math.BigDecimal;

public class Main {
    public static void main (String[] args){
        System.out.println("Démarrage");

        //Test de la méthode toString
        //Fraction fraction = new Fraction(3, 4);
        //System.out.println(fraction.toString()); // Affiche: Je suis une fraction.

        // Test du constructeur avec numérateur et dénominateur
        Fraction fraction1 = new Fraction(3, 4);
        assert fraction1.toString().equals("3/4");

        // Test du constructeur avec juste le numérateur (dénominateur égal à 1)
        Fraction fraction2 = new Fraction(2);
        assert fraction2.toString().equals("2/1");

        // Test du constructeur sans argument (numérateur égal à 0 et dénominateur égal à 1)
        Fraction fraction3 = new Fraction();
        assert fraction3.toString().equals("0/1");

        // Création d'objets Fraction avec les constantes
        Fraction zero = new Fraction(Fraction.ZERO_NUM, Fraction.ZERO_DENOM); //Fraction zero = new Fraction(0,0)
        Fraction un = new Fraction(Fraction.UN_NUM, Fraction.UN_DENOM); //Fraction un = newFraction(1,1)

        // Utilisation des getters pour obtenir le numérateur et le dénominateur
        System.out.println("ZERO Numérateur : " + zero.getNumerateur());
        System.out.println("ZERO Dénominateur : " + zero.getDenominateur());
        System.out.println("UN Numérateur : " + un.getNumerateur());
        System.out.println("UN Dénominateur : " + un.getDenominateur());

        // Utilisation de doubleValue() pour obtenir la valeur en virgule flottante
        double zeroValeur = zero.doubleValue();
        double uneValeur = un.doubleValue();

        // Assertions pour tester la conversion
        assert zeroValeur == 0.0 : "Erreur : zeroValeur ne devrait pas être différent de 0.0";
        assert uneValeur == 1.0 : "Erreur : oneValeur ne devrait pas être différent de 1.0";

        System.out.println("ZERO en valeur double : " + zeroValeur);
        System.out.println("UN en valeur double : " + uneValeur);

        // Addition de deux fractions
        Fraction result = zero.add(un);

        // Assertions pour tester l'addition
        assert result.getNumerateur() == 1 : "Erreur : le numérateur du résultat devrait être égal à 1";
        assert result.getDenominateur() == 1 : "Erreur : le dénominateur du résultat devrait être égal à 1";
        System.out.println("Résultat de l'addition : " + result.getNumerateur() + "/" + result.getDenominateur());

        // Test d'égalité entre fractions
        assert zero.equals(new Fraction(0, 1)) : "Erreur : zero devrait être égal à 0/1";
        assert un.equals(new Fraction(1, 1)) : "Erreur : one devrait être égal à 1/1";
        System.out.println("Test d'égalité réussi !");

        // Test de comparaison entre fractions
        assert zero.compareTo(new Fraction(0, 1)) == 0 : "Erreur : zero est égal à 0/1";
        assert un.compareTo(new Fraction(1, 1)) == 0 : "Erreur : one est égal à 1/1";
        assert zero.compareTo(un) < 0 : "Erreur : zero est inférieur à one";
        System.out.println("Test de comparaison réussi !");

        // Test avec les nombres
        Number aNumber = BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);
        double resultat = aNumber.doubleValue() + anotherNumber.doubleValue();
        // Vérification
        assert Math.abs(resultat - 1.5) < 1E-8 : "Erreur : la somme n'est pas égale à 1.5";
        System.out.println("Test réussi !");

    }
}
