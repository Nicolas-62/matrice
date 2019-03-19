
public final class MatCar {
	public int ordre;
	public Double[][] mat;
	public double determinant;

	public MatCar() {
	}

	public MatCar(int unOrdre) {
		this.ordre = unOrdre;
		this.mat = new Double[this.ordre][this.ordre];
	}

	public MatCar(int unOrdre, Double[][] uneMat) {
		this.ordre = unOrdre;
		this.mat = uneMat;
	}

	public double calculerDet() {
		double val = 0;
		if (this.ordre == 2) {
			return this.mat[0][0];
		} else if (this.ordre > 2) {
			int indiceMatSup = 0;
			int operateur = 0;
			// cr�ation des matrices d'ordre inferieur
			for (int i = 0; i < this.ordre; i++) {
				MatCar uneMatCar = new MatCar(ordre - 1);
				// remplissage des lignes
				for (int j = 0; j < uneMatCar.ordre; j++) {
					// remplissage des colonnes sauf celle qui vaut i
					indiceMatSup = 0;
					for (int k = 0; k < uneMatCar.ordre; k++) {
						// on saute la colonne d'indice i
						if (k == i && i < uneMatCar.ordre) {
							indiceMatSup++;
						}
						uneMatCar.mat[j][k] = this.mat[j + 1][indiceMatSup];
						indiceMatSup++;
					}
				}
				if (i % 2 == 0) {
					operateur = 1;
				} else {
					operateur = -1;
				}
				val += this.mat[0][i] * operateur * uneMatCar.calculerDet();
			}
		}
		return val;
	}
}
