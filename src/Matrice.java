import java.text.DecimalFormat;

public class Matrice {

	public int[] dimension = new int[2];
	public Double[][] mat;
	public Matrice transpose;

	public Matrice() {
	}

	public Matrice(Double[][] mat) {
		// nombre de lignes de la matrice
		this.dimension[0] = mat.length;
		// nombre de colonnes de la matrice (on prend la première ligne comme reference)
		this.dimension[1] = mat[0].length;
		this.mat = mat;
		this.transpose = new Matrice();
		this.creationTranspose();
	}

	public void creationTranspose() {
		// si dimension(matrice) = [m,n] alors dimension(transpose) = [n,m]
		this.transpose.dimension[0] = this.dimension[1];
		this.transpose.dimension[1] = this.dimension[0];

		// creation du tableau de valeurs de la matrice transposée
		this.transpose.mat = new Double[this.transpose.dimension[0]][this.transpose.dimension[1]];
		// remplissage du tableau de la transposée avec les valeurs de la matrice
		// initiale
		for (int i = 0; i < this.transpose.dimension[0]; i++) {
			for (int j = 0; j < this.transpose.dimension[1]; j++) {
				this.transpose.mat[i][j] = this.mat[j][i];
			}
		}
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
		df.setMinimumFractionDigits(2);

		String str = "";
		str += "dimension : (" + this.dimension[0] + " , " + this.dimension[1] + ")\n";
		str += "valeurs : \n";
		for (int i = 0; i < this.dimension[0]; i++) {
			for (int j = 0; j < this.dimension[1]; j++) {
				str += df.format(this.mat[i][j]) + " ";
			}
			str += "\n";
		}
		if (this.transpose != null) {
			str += "transposée : \n";
			for (int i = 0; i < this.transpose.dimension[0]; i++) {
				for (int j = 0; j < this.transpose.dimension[1]; j++) {
					str += df.format(this.transpose.mat[i][j]) + " ";
				}
				str += "\n";
			}
		}
		return str;
	}
}
