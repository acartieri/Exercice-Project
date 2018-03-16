package Mise_Situation;

import java.util.Scanner;

/**
 *
 * premi�re classe du programme
 * 
 * @author PC12 Version 1.1
 * 
 */

public class Correction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tableau en 2D qui repr�sente mes utilisateurs
		Object[][] informationsUtilisateur = new Object[2][4];

		// Je cr�� mon clavier
		Scanner clavier = new Scanner(System.in);

		// Je d�clare sans initialiser 3 variables du m�me type
		String nom, prenom, dateDeNaissance;

		// Je fais une boucle pour cr�er les 2 utilisateurs
		// On connait les bornes de la boucle. [0;2[
		for (int utilisateursCrees = 0; utilisateursCrees < 2; utilisateursCrees++) {
			
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererdateDeNaissance(clavier);
			String dateToday = "15/03/2018";
			
			// On calcule l'age
			byte age = calculerAge(dateToday, dateDeNaissance);
			System.out.println("\n" + prenom + " " + nom + " a " + age + " ans."); 
			
			// On affiche la majorit� de la personne
			verifierMajorite(nom, prenom, age);
			
			// On initialise le tableau en fonction de l'utilisateur
			informationsUtilisateur[utilisateursCrees][0] = nom;
			informationsUtilisateur[utilisateursCrees][1] = prenom;
			informationsUtilisateur[utilisateursCrees][2] = dateDeNaissance;
			informationsUtilisateur[utilisateursCrees][3] = age;
			
			}
		
		afficherTableau2D(informationsUtilisateur);
		

	}


	private static void afficherTableau2D(Object[][] informationsUtilisateur) {
		for (int index = 0; index < informationsUtilisateur.length; index++) {
			for (Object information : informationsUtilisateur[index]) {
				System.out.print("\n" + information);
			
			}
		}
	}


	private static void verifierMajorite(String nom, String prenom, byte age) {
		if (age < 18) {

			System.out.println("\n" + prenom + " " + nom + " n'est pas majeur.");
		}

		else {
			System.out.println("\n" + prenom + " " + nom + " est majeur.");
		}
	}

		/**
	 * Calcule la diff�rence entre d'ann�es entre 2 dates
	 * 
	 * @param dateTodayCopie
	 *            Date d'aujourd'hui
	 * @param dateDeNaissanceCopie
	 *            Date d'anniversaire
	 * @return Age calcul�
	 */
	private static byte calculerAge(String dateTodayCopie, String dateDeNaissanceCopie) {
		// r�cup�rer la derni�re cellule du tableau (sois la date s�par� par les champs
		// s�parateurs (/) de chaine de caract�re
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]);
		short anneeToday = Short.parseShort(dateTodayCopie.split("/")[2]);
		return (byte) (anneeToday - anneeDeNaissance);
	}

	/**
	 * R�cup�rer la date de naissance
	 * 
	 * @param clavierCopie
	 * @return Date de naissance
	 */
	private static String recupererdateDeNaissance(Scanner clavierCopie) {
		String date;
		System.out.print("\nEnter votre date de naissance (XX/XX/XXXX) : ");
		date = clavierCopie.nextLine();
		return date;
	}

	/**
	 * R�cup�rer le nom d'une personne
	 * 
	 * @param clavierCopie
	 *            Objet de type Scanner
	 * @return Nom de l'utilisateur
	 */
	private static String recupererNom(Scanner clavierCopie) {
		// V�rifier qu'un nom est au bon format.
		boolean verificateur = false;
		String lastName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le v�rificateur est faux.
		do {
			System.out.print("\nEntrez votre nom : ");
			lastName = clavierCopie.nextLine();

			// Si le nom est compos� d'au moins 3 lettres....
			if (lastName.length() >= 3) {
				// On v�rifie que le nom ne contient que des lettres
				verificateur = lastName.chars().allMatch(Character::isLetter);

			}

			else {
				System.out.println("\nEntrez au moins 3 lettres");
			}

		} while (verificateur != true);

		return lastName;

	}

	/**
	 * R�cup�rer le pr�nom d'une personne.
	 * 
	 * @param clavierCopie
	 *            Objet de type Scanner
	 * @return Pr�nom de l'utilisateur
	 */
	static String recupererPrenom(Scanner clavierCopie) {
		boolean verificateur = false;
		String firstName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le v�rificateur est faux.
		do {
			System.out.print("\nEntrez votre pr�nom : ");
			firstName = clavierCopie.nextLine();

			// Si le pr�nom est compos� d'au moins 3 lettres....
			if (firstName.length() >= 3) {
				// On v�rifie que le pr�nom ne contient que des lettres
				verificateur = firstName.chars().allMatch(Character::isLetter);

			} else {
				System.out.println("\nEntrez au moins 3 lettres");
			}

		} while (verificateur != true);

		return firstName;
	}
}
