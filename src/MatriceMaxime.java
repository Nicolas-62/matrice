import java.util.Arrays;

/**
 * Matrice partie Maxime
 * @author Maxime
 *
 */
public class MatriceMaxime {
	
	public static void main(String[] args) {
		
		Double[][] mat = {{1d,2d},{3d,4d},{5d,6d}};

		System.out.println("|"+mat[0][0]+" "+mat[0][1]+"|");
		System.out.println("|"+mat[1][0]+" "+mat[1][1]+"|");
		System.out.println("|"+mat[2][0]+" "+mat[2][1]+"|");
		
		System.out.println("------------------------------------------------------");
		
		Double[][] mat2 = {{1d,2d,3d},{4d,5d,6d}};
		System.out.println("|"+mat2[0][0]+" "+mat2[0][1]+" "+mat2[0][2]+"|");
		System.out.println("|"+mat2[1][0]+" "+mat2[1][1]+" "+mat2[1][2]+"|");
		
		System.out.println("-----------------------------------------------------");
		
		Double[][] mat3 = {{1d,4d},{2d,5d},{3d,6d}};
		System.out.println("|"+mat3[0][0]+" "+mat3[0][1]+"|");
		System.out.println("|"+mat3[1][0]+" "+mat3[1][1]+"|");
		System.out.println("|"+mat3[2][0]+" "+mat3[2][1]+"|");
	}

}
