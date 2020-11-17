package comparators;

import java.util.Comparator;

import entities.Aluno;

public class MediaDescComparator implements Comparator<Aluno> {

	public int compare(Aluno aluno1, Aluno aluno2) {
		if (aluno1.media() > aluno2.media())
			return -1;

		if (aluno1.media() < aluno2.media())
			return 1;
		return 0;
	}
}