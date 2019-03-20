import java.text.DecimalFormat;

public final class MatCar {
	public int ordre;
	public Double[][] mat;
	public double determinant;
	public int test;
	public MatCar matInverse;
	public MatCar matUnite;

	public MatCar() {
	}

	public MatCar(int unOrdre) {
		this.ordre = unOrdre;
		this.mat = new Double[this.ordre][this.ordre];
	}

	public MatCar(int unOrdre, Double[][] uneMat) {
		this.ordre = unOrdre;
		this.mat = uneMat;
		this.matInverse = null;
		this.determinant = this.calculerDet();
		System.out.println(this);
		try {
			this.calculerMatriceInverse();
			System.out.println(this.matInverse);
			this.calculerMatriceUnite();
			System.out.println(this.matUnite);
		} catch (InversibleException e) {
			e.getMessage();
		}
	}

	public double calculerDet() {
		double val = 0;
		if (this.ordre == 1) {
			return this.mat[0][0];
		} else if (this.ordre > 1) {
			int indiceMatSup = 0;
			int operateur = 0;
			// création des matrices d'ordre inferieur
			for (int i = 0; i < this.ordre; i++) {
				MatCar uneMatCar = new MatCar(this.ordre - 1);
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
//						System.out.println("indiceMatSup : "+indiceMatSup);
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

	public boolean isInversible() {
		if (this.determinant != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void calculerMatriceInverse() throws InversibleException {
		if (!isInversible()) {
			throw new InversibleException();
		} else {
			// Cration du tableau de valeurs de la matrice inverse
			MatCar matInverse = new MatCar(this.ordre);
			int indiceY = 0;
			int indiceX = 0;
			// pour chaque ligne y de la matrice
			for (int y = 0; y < matInverse.ordre; y++) {
				// pour chaque colonne x de la matrice
				for (int x = 0; x < matInverse.ordre; x++) {

					MatCar sousMat = new MatCar(matInverse.ordre - 1);

					indiceY = 0;
					// pour chaque ligne i de la comatrice
					for (int sy = 0; sy < sousMat.ordre; sy++) {
						// on saute la ligne x de la matrice
						if (sy == x && x < sousMat.ordre) {
							indiceY++;
						}
						indiceX = 0;
						// pour chaque colonne j de la comatrice
						for (int sx = 0; sx < sousMat.ordre; sx++) {
							// on saute la colonne y de la matrice
							if (sx == y && y < sousMat.ordre) {
								indiceX++;
							}
							sousMat.mat[sy][sx] = this.mat[indiceY][indiceX];
//							System.out.println("y : "+y+"  x : "+x+"  sy : "+sy+"  sx : "+sx+" indiceY : "+indiceY+" indiceX : "+indiceX);
							indiceX++;
						}
						indiceY++;
					}
//					System.out.println("val "+y+" "+x+" : "+Math.pow(-1, y + x) * sousMat.calculerDet());
					matInverse.mat[y][x] = (1 / this.determinant) * Math.pow(-1, y + x) * sousMat.calculerDet();
				}
			}
			this.matInverse = matInverse;
		}
	}

	public void calculerMatriceUnite() {
		MatCar matUnit = new MatCar(this.ordre);
		double val = 0;
		for (int y = 0; y < matUnit.ordre; y++) {
			for (int x = 0; x < matUnit.ordre; x++) {
				val = 0;
				for (int i = 0; i < matUnit.ordre; i++) {
					val += this.mat[y][i] * this.matInverse.mat[i][x];
				}
				matUnit.mat[y][x] = val;
			}
		}
		this.matUnite = matUnit;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
		df.setMinimumFractionDigits(2);

		String str = "";
		str += "ordre : " + this.ordre + "\n";
		str += "determinant : " + this.determinant + "\n";
		str += "valeurs : \n";
		for (int i = 0; i < this.ordre; i++) {
			for (int j = 0; j < this.ordre; j++) {
				str += df.format(this.mat[i][j]) + " ";
			}
			str += "\n";
		}
		return str;
	}
}
