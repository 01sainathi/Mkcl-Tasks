package com.app.daos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.models.NaturalLanguage;
import com.app.service.HomeService;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class NaturalLanguageDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeService.class);
	private ISql icrud = DALHelper.getIsql();
	public NaturalLanguage getByName(String name) throws Exception {
		
		Map<String, Object> criteria = new HashMap<>();
		criteria.put("languageName", name);
		
		List<NaturalLanguage> list = (List<NaturalLanguage>)icrud.findBy(NaturalLanguage.class,criteria);
		
		if(list.size() == 0) {
			throw new Exception("Lanuage not found");
		}
		return list.get(0);
		
	}
	
	public List<NaturalLanguage> getAllLangs() throws DALException{
		
		List<NaturalLanguage> list = icrud.findAll(NaturalLanguage.class);
		
		return list;
	}
}
