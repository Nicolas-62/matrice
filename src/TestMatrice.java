

public class TestMatrice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		Double[][] matrice;
//		System.out.println("veuillez saisir l'ordre de votre matrice carr�e : ");
//		int ordre = sc.nextInt();
		Double[][] mat = {{1d,2d},{3d,4d}};
		MatCar uneMatCar = new MatCar(2, mat);
		System.out.println("resultat : "+uneMatCar.calculerDet());
		
		Double[][] mat2 = {{3d,2d,1d},{9d,3d,1d},{36d,6d,1d}};
		MatCar uneMatCar2 = new MatCar(3, mat2);
		System.out.println("resultat 2 : "+uneMatCar2.calculerDet());
		
		Double[][] mat3 = {{3d,0d,2d,-1d},{1d,2d,0d,-2d},{4d,0d,6d,-3d},{5d,0d,2d,0d}};
		MatCar uneMatCar3 = new MatCar(3, mat3);
		System.out.println("resultat 3 : "+uneMatCar3.calculerDet());
	}

}