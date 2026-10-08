package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal");
			Boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}else {
				installerVendeur(nomVendeur);
				
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder questions = new StringBuilder();
		questions.append("C'est parfait,il me reste un étal pour vous!\n");
		questions.append("Il me faudrait quelques renseignments : \n");
		questions.append("Quels produits souhaitez-vous en vendre?");
		String produit= Clavier.entrerChaine(questions.toString());
		questions.append("Combien de produit souhaitez vous en vendre? ");
		int nbProduit = Clavier.entrerEntier(questions.toString());
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur " +nomVendeur+" s'est installe  a l'étal n°"+numeroEtal);
		}
	}
}
