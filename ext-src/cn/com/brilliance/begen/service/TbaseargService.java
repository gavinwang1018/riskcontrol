package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TbaseargService {

	public List<Tbasearg> init(Tbasearg tbasearg,Map queryFields);
	
	public void delete(String id);
	
	public  List<Tbasearg> getTbaseargListOfQuery(Map queryFields);
	
	public  List<Tbasearg> getTbaseargByType(Map queryFields,String simbol);
	
	public Tbasearg saveTbasearg(Tbasearg tbasearg);
	
	public  Tbasearg getTbasearg(String id);

    public Tbasearg saveAll(Tbasearg tbasearg );
	
	public void deleteAll(List<Tbasearg> tbaseargs);
}
