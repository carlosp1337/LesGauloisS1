package personnages;
 
public class Romain {
    private String nom;
    private int force;
    private int nbEquipement=0;
    private Equipement[] equipements;
   
    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        equipements = new Equipement[2];
    }
   
    public String getNom() {
        return nom;
    }
   
    public int getForce() {
        return force;
    }
   
    public void parler(String texte) {
        System.out.println(prendreParole() + "«" + texte + "»");
    }
   
    private String prendreParole() {
        return "Le romain " + nom +" : ";
    }
   
//  public void recevoirCoup(int forceCoup) {
//      assert force>0;
//      int t=force;
//      force -= forceCoup;
//      if (force > 0) {
//          parler("Aie");
//      }else {
//          parler("J'abandonne...");
//      }
//      assert force<t;
//  }
   
 
   
    public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        // précondition
        assert force > 0;
        int oldForce = force;
        forceCoup = calculResistanceEquipement(forceCoup);
        force -= forceCoup;
        // if (force > 0) {
        // parler("Aïe");
        // } else {
        // equipementEjecte = ejecterEquipement();
        // parler("J'abandonne...");
        // }
        if (force==0) {
            parler("Aïe");
        }else {
            equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
            }
            // post condition la force a diminuée
            assert force < oldForce;
            return equipementEjecte;
            }
   
   
   
    private int calculResistanceEquipement(int forceCoup) {
        String texte;
        texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0) {
        texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
        for (int i = 0; i < nbEquipement;i++) {
        if (equipements[i] != null &&
        equipements[i].equals(Equipement.BOUCLIER)) {
        resistanceEquipement += 8;
        } else {
        System.out.println("Equipement casque");
        resistanceEquipement += 5;
        }
        }
        texte += resistanceEquipement + "!";
        }
        parler(texte);
        forceCoup -= resistanceEquipement;
        return forceCoup;
        }
 
   
   
    private Equipement[] ejecterEquipement() {
        Equipement[] equipementEjecte = new Equipement[nbEquipement];
        System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
        //TODO
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] != null) {
                equipementEjecte[nbEquipementEjecte] =
                equipements[i];
                nbEquipementEjecte++;
                equipements[i] = null;
                }
            }
        return equipementEjecte;
        }
 
       
   
   
    public void sEquiper(Equipement equipement){
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0]==equipement) {
                    System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement + " !");
                    break;
                }
                else {
                    equipements[1] = equipement;
                    nbEquipement+=1;
                    System.out.println("Le soldat " + getNom() + " s'équipe d'un " + equipement + ".");
                    break;
                }
            case 0:
                equipements[0]=equipement;
                nbEquipement+=1;
                System.out.println("Le soldat " + getNom() + " s'équipe d'un " + equipement + ".");
                break;
            default:
                break;
        }
    }
   
    public static void main(String[] args) {
        Romain minus = new Romain ("Minus",6);
        System.out.println(minus.prendreParole());
        minus.parler("Bonjour");
       
        minus.recevoirCoup(5);
       
        //System.out.println(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.BOUCLIER);
    }
}