package Mise_Situation;

import java.util.Scanner;

/**
 *
 * première classe du programme
 * 
 * @author PC12 Version 1.1
 * 
 */

public class Correction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tableau en 2D qui représente mes utilisateurs
		Object[][] informationsUtilisateur = new Object[2][4];

		// Je créé mon clavier
		Scanner clavier = new Scanner(System.in);

		// Je déclare sans initialiser 3 variables du même type
		String nom, prenom, dateDeNaissance;

		// Je fais une boucle pour créer les 2 utilisateurs
		// On connait les bornes de la boucle. [0;2[
		for (int utilisateursCrees = 0; utilisateursCrees < 2; utilisateursCrees++) {
			
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererdateDeNaissance(clavier);
			String dateToday = "15/03/2018";
			
			// On calcule l'age
			byte age = calculerAge(dateToday, dateDeNaissance);
			System.out.println("\n" + prenom + " " + nom + " a " + age + " ans."); 
			
			// On affiche la majorité de la personne
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
	 * Calcule la différence entre d'années entre 2 dates
	 * 
	 * @param dateTodayCopie
	 *            Date d'aujourd'hui
	 * @param dateDeNaissanceCopie
	 *            Date d'anniversaire
	 * @return Age calculé
	 */
	private static byte calculerAge(String dateTodayCopie, String dateDeNaissanceCopie) {
		// récupérer la dernière cellule du tableau (sois la date séparé par les champs
		// séparateurs (/) de chaine de caractère
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]);
		short anneeToday = Short.parseShort(dateTodayCopie.split("/")[2]);
		return (byte) (anneeToday - anneeDeNaissance);
	}

	/**
	 * Récupérer la date de naissance
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
	 * Récupérer le nom d'une personne
	 * 
	 * @param clavierCopie
	 *            Objet de type Scanner
	 * @return Nom de l'utilisateur
	 */
	private static String recupererNom(Scanner clavierCopie) {
		// Vérifier qu'un nom est au bon format.
		boolean verificateur = false;
		String lastName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le vérificateur est faux.
		do {
			System.out.print("\nEntrez votre nom : ");
			lastName = clavierCopie.nextLine();

			// Si le nom est composé d'au moins 3 lettres....
			if (lastName.length() >= 3) {
				// On vérifie que le nom ne contient que des lettres
				verificateur = lastName.chars().allMatch(Character::isLetter);

			}

			else {
				System.out.println("\nEntrez au moins 3 lettres");
			}

		} while (verificateur != true);

		return lastName;

	}

	/**
	 * Récupérer le prénom d'une personne.
	 * 
	 * @param clavierCopie
	 *            Objet de type Scanner
	 * @return Prénom de l'utilisateur
	 */
	static String recupererPrenom(Scanner clavierCopie) {
		boolean verificateur = false;
		String firstName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le vérificateur est faux.
		do {
			System.out.print("\nEntrez votre prénom : ");
			firstName = clavierCopie.nextLine();

			// Si le prénom est composé d'au moins 3 lettres....
			if (firstName.length() >= 3) {
				// On vérifie que le prénom ne contient que des lettres
				verificateur = firstName.chars().allMatch(Character::isLetter);

			} else {
				System.out.println("\nEntrez au moins 3 lettres");
			}

		} while (verificateur != true);

		return firstName;
	}
}
