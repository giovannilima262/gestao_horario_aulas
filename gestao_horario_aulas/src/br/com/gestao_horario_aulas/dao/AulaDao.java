package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Aula;

public class AulaDao {
	private List <Aula> aulas = new ArrayList<>();
	
	public void insert(Aula aula) {
		aulas.add(aula);
	}
	
	public ArrayList<Aula> getLista() {
		return (ArrayList<Aula>) this.aulas;
	}
	
	public Aula findById(Integer id) {
		Aula aula = null;
		for(Aula a : this.aulas ) {
			if(aula.getId().equals(id)) {
				aula = a;
			}
		}
		return aula;
	}
	
	public ArrayList<Aula> findByMateria(Integer idMateria) {
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		for(Aula a : this.aulas ) {
			if(a.getMateria().getId().equals(idMateria)) {
				aulas.add(a);
			}
		}
		return aulas;
	}
	
	public ArrayList<Aula> findByProfessor(Integer idProfessor) {
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		for(Aula a : this.aulas ) {
			if(a.getProfessor().getId().equals(idProfessor)) {
				aulas.add(a);
			}
		}
		return aulas;
	}
	
	public void delete(Integer id) {
		for(Aula a : this.aulas ) {
			if(a.getId().equals(id)) {
				this.aulas.remove(a);
			}
		}
	}
}
