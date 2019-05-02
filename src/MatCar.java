import java.text.DecimalFormat;

public final class MatCar extends Matrice{
	
	public int ordre;
	public double determinant;
	public MatCar matInverse;
	public MatCar matUnite;

	public MatCar() {
	}

	public MatCar(int unOrdre) {
		this.ordre = unOrdre;
		this.mat = new Double[this.ordre][this.ordre];
		this.dimension[0] = ordre;
		// nombre de colonnes de la matrice (on prend la première ligne comme reference)
		this.dimension[1] = ordre;
	}

	public MatCar(Double[][] uneMat) {
		super(uneMat);
		this.ordre = this.dimension[0];
		this.mat = uneMat;
		this.matInverse = null;
		this.determinant = this.calculerDet();
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

}
