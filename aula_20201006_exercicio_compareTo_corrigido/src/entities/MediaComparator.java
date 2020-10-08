package entities;

import java.util.Comparator;

public class MediaComparator implements Comparator<Aluno> {

	public int compare(Aluno aluno1, Aluno aluno2) {

		if (aluno1.getMedia() > aluno2.getMedia())
			return 1;

		if (aluno1.getMedia() < aluno2.getMedia())
			return -1;
		return 0;
	}
}