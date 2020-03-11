package study.java.dao;

import java.util.List;

import study.java.model.Tran;

public interface TranDao {
	
	public List<Tran> getTranList(String keyword);

}
