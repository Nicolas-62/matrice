
public class TestMatrice {
	public static void main(String[] args) {

		// --------------------------------------------------------------//
		// variables..
		int lignes;
		int colonnes;
		boolean flag = true;

		// debut du programme :
		while (flag) {
			System.out.println("Veuillez saisir la dimension de la matrice :");
			System.out.println("nombre de lignes : ");
			lignes = Clavier.readInt();
			System.out.println("nombre de colonnes : ");
			colonnes = Clavier.readInt();
			System.out.println("Saisie des valeurs de la matrice: \n");
			Double[][] valeursMat = new Double[lignes][colonnes];
			for (int i = 1; i <= lignes; i++) {
				System.out.println("Veuillez saisir la ligne " + i);
				for (int j = 1; j <= colonnes; j++) {
					System.out.print("val " + j + " : ");
					valeursMat[i - 1][j - 1] = Clavier.readDouble();
				}
			}
			// si c'est une matrice carre..
			if (lignes == colonnes) {
				System.out.println("Votre Matrice est une Matrice carre");
				MatCar matriceCarre = new MatCar(valeursMat);
				// affichage de la matrice et de sa transposée
				System.out.println(matriceCarre);
				try {
					matriceCarre.calculerMatriceInverse();
					System.out.println("La matrice est inversible");
					System.out.println("Matrice inverse : ");
					System.out.println(matriceCarre.matInverse);
					matriceCarre.calculerMatriceUnite();
					System.out.println("Matrice unité : ");
					System.out.println(matriceCarre.matUnite);
				} catch (InversibleException e) {
					e.getMessage();
				}
			} else {
				Matrice uneMatrice = new Matrice(valeursMat);
				System.out.println(uneMatrice);
			}
			System.out.println("Voulez vous effectuer un autre calcul ? Saisir un chiffre, 1 pour arrêter");
			int val = 0;
			val = Clavier.readInt();
			if (val == 1) {
				System.exit(1);
			}
		} // fin du programme

		// essais...
//		System.out.println("-----------------------------------");
//		Double[][] uneMat = {{1d,2d,3d},{4d,5d,6d},{7d,8d,9d}};
//		MatCar matEssai = new MatCar(uneMat);
//		Matrice matrice = new Matrice(uneMat);
//		System.exit(1);
//
//		System.out.println("-----------------------------------");		
//		Double[][] mat2 = {{3d,2d,1d},{9d,3d,1d},{36d,6d,1d}};
//		MatCar uneMatCar2 = new MatCar(mat2);
//
//		System.out.println("-----------------------------------");		
//		Double[][] mat3 = {{3d,0d,2d,-1d},{1d,2d,0d,-2d},{4d,0d,6d,-3d},{5d,0d,2d,0d}};
//		MatCar uneMatCar3 = new MatCar(mat3);
//		
//		System.out.println("-----------------------------------");
//		Double[][] mat4 = {{0d}};
//		MatCar uneMatCar4 = new MatCar(mat4);

	}

}
