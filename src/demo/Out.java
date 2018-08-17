package demo;

public class Out {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (j == i) {
					continue;
				} else {
					for (int j2 = 1; j2 < 5; j2++) {
						if (j2 == j || j2 == i) {
							continue;
						} else {
							System.out.print(i);
							System.out.print(j);
							System.out.print(j2);
							System.out.print(" ");
							count++;
							if (count == 5) {
								System.out.println();
								count = 0;
							}
						}
					}
				}
			}
		}
	}
}
