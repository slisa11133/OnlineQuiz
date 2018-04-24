package com.b3.dao;

import com.b3.memento.EssayMemento;

public interface EssayMementoDAO {

	public boolean checkExist(String u_id);
	
	public EssayMemento getEssayMementoByUser(String u_id);

	public void deleteEssayMementoByUser(String u_id);

	public void addEssayMemento(EssayMemento essayMemento);

}
