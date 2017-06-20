package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TroleUserService {

	public List<TroleUser> init(TroleUser troleUser,Map queryFields);
	
	public void delete(String id);
	
	public  List<TroleUser> getTroleUserListOfQuery(Map queryFields);
	
	public TroleUser saveTroleUser(TroleUser troleUser);
	
	public  TroleUser getTroleUser(String id);

    public TroleUser saveAll(TroleUser troleUser );
	
	public void deleteAll(List<TroleUser> troleUsers);
}
