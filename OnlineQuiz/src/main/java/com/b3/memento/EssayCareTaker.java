package com.b3.memento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.EssayMementoDAO;

@Service
@Transactional
public class EssayCareTaker {

	@Autowired
	private EssayMementoDAO essayMementoDAO;

	public boolean checkExist(String u_id) {

		return essayMementoDAO.checkExist(u_id);
	}

	@Transactional
	public EssayMemento getMemento(String u_id) {

		EssayMemento essayMemento = essayMementoDAO.getEssayMementoByUser(u_id);
		return essayMemento;
	}

	public void addMemento(EssayMemento memento) {
		essayMementoDAO.deleteEssayMementoByUser(memento.getU_id());
		essayMementoDAO.addEssayMemento(memento);
	}
	
	public void removeMemento(EssayMemento memento) {
		essayMementoDAO.deleteEssayMementoByUser(memento.getU_id());
	}

}