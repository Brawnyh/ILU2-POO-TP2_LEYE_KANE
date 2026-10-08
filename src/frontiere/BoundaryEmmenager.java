package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2= new StringBuilder();
					System.out.println("Bienvenue villageois" + nomVisiteur);
					question2.append("Quelle est votre force?  \n");
					int force = Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Quelle est votre force ?\n");
		int force =Clavier.entrerEntier(question.toString());
		int effetPotionMin=1;
		int effetPotionMax=-1;
		while(effetPotionMax<effetPotionMin) {
			StringBuilder question2 = new StringBuilder();
			question2.append("Quelle est la force de potion la plus faible que vous produissez? ");
			effetPotionMin= Clavier.entrerEntier(question2.toString());
			StringBuilder question3 = new StringBuilder();
			question3.append("Quelle est la force de potion la plus forte que vous produissez ?");
			effetPotionMax= Clavier.entrerEntier(question3.toString());
			
			if (effetPotionMin > effetPotionMax) {
				System.out.println("Attention Druide,vous vous êtes trompéé entre le minimum et le maximum");
				break;
			}
			
			
		}
		
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
