package facture;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

public class Facture {
    private Client destinataire;
    private Date emission;
    private int numero;
    private ArrayList<LigneFacture> liste;

    public Facture(Client destinataire, Date emission, int numero) {
         this.destinataire = destinataire;
         this.emission = emission;
         this.numero = numero;
         liste = new ArrayList();
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return this.emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
       return this.destinataire;
    }


    
    public void ajouteLigne(Article a, int nombre, float remise) {
        LigneFacture l = new LigneFacture(nombre, this, a, remise);
        liste.add(l);
   }
    
   public float montantTTC(float tauxTVA) {
         float ret = 0;
         for (LigneFacture l : liste){
             ret += l.montantLigne()*tauxTVA + l.montantLigne();
         }
         return ret;
   }
   
   public void print(PrintStream out, float tva) {
         String ret ="";
         for (LigneFacture l : liste){
             ret += "Nom : "+l.getArticleFacture().getNom() + ",  quantité : "+ l.getNombre() +", PRIX LIGNE TTC : "+ (l.getArticleFacture().getPrix()*l.getNombre()*tva +l.getArticleFacture().getPrix()*l.getNombre())  +"/n";
         }
         ret += "/n Prix total TTC : "+ this.montantTTC(tva);
         System.out.println(ret);
   }
   
}
