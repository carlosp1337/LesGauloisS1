package personnages;
 
public class Gaulois {
    private String nom;
    private int force;
    private int nbtrophees;
    private int effetPotion=1;
    private Equipement[] trophee = new Equipement[100];
 
    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }
 
    public String getNom() {
        return nom;
    }
   
    public void parler(String texte) {
        System.out.println(prendreParole() + "«" + texte + "» ");
    }
   
    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
        }
   
//  private String prendreParole() {
//      return "Le gaulois " + nom +" : ";
//  }
   
//  public void frapper(Romain romain, int effetPotion) {
//      System.out.println(nom + "envoie un grand coup dans la machoire de " + romain.getNom());
//      romain.recevoirCoup((force/3) * effetPotion);
//     
//  }
   
    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }
   
    public void boirePotion(int forcePotion) {
        this.effetPotion = forcePotion;
        parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
    }
   
    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Asterix",8);
        System.out.println(asterix.getNom());
        System.out.println(asterix);
       
        System.out.println(asterix.prendreParole());
       
        asterix.parler("Bonjour");
       
        asterix.boirePotion(5);
    }
   
   
    public void frapper(Romain romain) {
        System.out.println(nom + "envoie un grand coup dans la mâchoire de " + romain.getNom());
        Equipement[] trophe = romain.recevoirCoup((force / 3) *
        effetPotion);
        for (int i = 0; trophe != null && i < trophe.length; i++,
        nbtrophees++) {
            this.trophee[nbtrophees] = trophe[i];
            }
        }
}