package Mise_Situation;

 /**
  * Première classe du programme
  * @author PC12
  * @version 1.0
  * 
  */
import java.util.Scanner;

public class Conditions {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner clavier = new Scanner(System.in);
		String nom;
		String prenom;
		String age;
		String dateDeNaissance;
		byte nombrePersonne = 0;
		
		while (nombrePersonne < 2) { // boucle while pour avoir la saisie de 2 personnes 
		// Je crée ma saisie clavier
		System.out.println("Bonjour");
		System.out.println("Quel est votre nom ?");
		nom = clavier.nextLine();
		System.out.println("Quel est votre prenom ?");
		prenom = clavier.nextLine();
		System.out.println("Quel est votre âge ?");
		age = clavier.nextLine();
		System.out.println("Quel est votre date de naissance ?");
		dateDeNaissance = clavier.nextLine();
		System.out.println("Merci pour ces informations");
		System.out.println("Voici le récapitulatif de vos informations : ");
		nombrePersonne++; // incrémentation de +1 jusqu'à avoir 2 personnes

		
		// Je crée mon tableau
		String[] Informations = new String[4];
		Informations[0] = nom;
		Informations[1] = prenom;
		Informations[2] = age;
		Informations[3] = dateDeNaissance;

		for (String tableau : Informations) {
			System.out.println(tableau);

		}
		
		
		// information sur la majorité
		if (Integer.parseInt(age) >=18) {
			System.out.println(nom + " " + prenom + " est majeur.");
		}

		else {
			System.out.println(nom + " " + prenom + " est mineur. ");
		}
		
		}
			 
	System.out.println("Le nombre de personne ayant entrée leurs informations à atteint son maximum !");
		
	}
	

}
