package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class invertedIndex {

	private static ArrayList<Integer> documentsWithBothTerms;

	public static void main(String[] args) {

		documentsWithBothTerms = new ArrayList<>();

		ArrayList<Integer> bananaDocumentId = new ArrayList<>(Arrays.asList(3, 6, 44, 86, 721));
		ArrayList<Integer> orangeDocumentId = new ArrayList<>(Arrays.asList(7, 44, 56, 721, 1021));

		findDocumentWithBothTerms(bananaDocumentId, orangeDocumentId);

		System.out.println("The ID of the documents that contain both terms are "
				+ Arrays.toString(documentsWithBothTerms.toArray()));

	}

	private static void findDocumentWithBothTerms(ArrayList<Integer> bananaDocumentId,
			ArrayList<Integer> orangeDocumentId) {

		int commonID;
		int pointerOne = 0;
		int pointerTwo = 0;

		System.out.println("Iterator");
		Iterator<Integer> iterOne = bananaDocumentId.iterator();
		Iterator<Integer> iterTwo = orangeDocumentId.iterator();

		while (iterOne.hasNext() & iterTwo.hasNext()) {
			System.out.println("pointerOne is pointing at the id " + bananaDocumentId.get(pointerOne));
			System.out.println("pointerTwo is pointing at the id " + orangeDocumentId.get(pointerTwo));

			if (bananaDocumentId.get(pointerOne).equals(orangeDocumentId.get(pointerTwo))) {
				commonID = bananaDocumentId.get(pointerOne);
				documentsWithBothTerms.add(commonID);

				pointerOne++; iterOne.next();
				pointerTwo++; iterTwo.next();
				System.out.println("both pointers advanced");
			} else if (bananaDocumentId.get(pointerOne) < orangeDocumentId.get(pointerTwo)) {
				System.out.println("pointerOne moved because the id " + 
							bananaDocumentId.get(pointerOne) + " is smaller");
				pointerOne++;
				iterOne.next();
			} else {
				System.out.println("pointerTwo moved because the id " + 
							orangeDocumentId.get(pointerTwo) + " is smaller");
				pointerTwo++;
				iterTwo.next();
			}
		}
	}
}
