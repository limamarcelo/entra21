package entities;

import java.util.Comparator;

public class NameMediaComparator implements Comparator<Aluno> {

	public int compare(Aluno aluno1, Aluno aluno2) {
		int nome = aluno1.getNome().compareTo(aluno2.getNome());

		if (nome == 0) {

			if (aluno1.getMedia() > aluno2.getMedia())
				return 1;

			if (aluno1.getMedia() < aluno2.getMedia())
				return -1;

			return 0;
		} else {
			return nome;
		}
	}
}