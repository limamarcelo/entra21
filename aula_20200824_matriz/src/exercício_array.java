class exercício_array {
	public static void main(String args[]) {

		int array1[] = new int[3];
		int array2[] = array1;
		int array3[] = array1;

		array1[0] = 10;
		array2[1] = 100;
		array3[2] = 1000;

		for (int valor : array1) {
			System.out.println(valor);
		}
	}
}