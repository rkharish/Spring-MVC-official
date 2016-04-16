package com.mobile.app.dao.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.mobile.app.dao.IAuthDao;
import com.mobile.app.dao.entity.UserProfileEntity;

@Repository("AuthDao")
@Scope("singleton")
public class AuthDao implements IAuthDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@CachePut(value="spring-cache",key="#userProfile.sno")
	public String updateProfile(UserProfileEntity userProfile) {
		String sql="update  login_auth_tbl set username=?,password=?,role=?,companyName=?,email=?,city=?,title=? where sno=?";
		Object data[]=new Object[]{userProfile.getUsername(),userProfile.getPassword(),userProfile.getRole(),userProfile.getCompanyName(),userProfile.getEmail(),userProfile.getCity(),userProfile.getTitle(),userProfile.getSno()};
		jdbcTemplate.update(sql,data);
		return "update";
	}
	
	@Override
	@CacheEvict(value="spring-cache",allEntries=true)
	public UserProfileEntity addProfile(UserProfileEntity userProfile) {
		//because of photo we have to use
		//SqlLobValue
		 LobHandler lobHandler = new DefaultLobHandler();
		 SqlLobValue sqlLobValue=new SqlLobValue(userProfile.getPhoto(),lobHandler);
		 int[] dataType=new int[] { Types.VARCHAR, Types.VARCHAR,
                 Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR
                ,Types.BLOB, Types.TIMESTAMP };
		 
		String sql="insert into login_auth_tbl(username,password,role,companyName,email,city,title,photo,doe) values(?,?,?,?,?,?,?,?,?)";
		Object data[]=new Object[]{userProfile.getUsername(),userProfile.getPassword(),userProfile.getRole(),userProfile.getCompanyName(),userProfile.getEmail(),userProfile.getCity(),userProfile.getTitle(),sqlLobValue,userProfile.getDoe()};
		jdbcTemplate.update(sql,data,dataType);
		int max=jdbcTemplate.queryForInt("select max(sno) from login_auth_tbl");
		userProfile.setSno(max);
		return userProfile;
	}
	
	@Override
	public String authUser(String username,String password) {
		String message="";
		String sql="select role from login_auth_tbl where username=? and password=?";
		Object data[]=new Object[]{username,password};
		try {
			String role=(String)jdbcTemplate.queryForObject(sql, data,String.class);
			 message="success";
		}catch (Exception e) {
			 message="fail"; 
		}
		return message;
	}
	
	@Override
	public byte[] findUserImageByUserName(String username) {
		UserProfileEntity userProfile=null;
		String sql="select * from login_auth_tbl where username=?";
		Object data[]=new Object[]{username};
		try {
			 userProfile=(UserProfileEntity)jdbcTemplate.queryForObject(sql, data,new BeanPropertyRowMapper(UserProfileEntity.class));
		}catch (Exception e) {
		}
		return userProfile!=null?userProfile.getPhoto():null;
	}
	
	@Override
	@Cacheable(value="spring-cache",key="#userProfile.sno")
	public UserProfileEntity findUserProfileByPid(String uid) {
		UserProfileEntity userProfile=null;
		String sql="select * from login_auth_tbl where sno=?";
		Object data[]=new Object[]{uid};
		try {
			 userProfile=(UserProfileEntity)jdbcTemplate.queryForObject(sql, data,new BeanPropertyRowMapper(UserProfileEntity.class));
		}catch (Exception e) {
		}
		return userProfile;
	}
	
	@CacheEvict(value="spring-cache",allEntries=true)
	@Override
	public String deleteUserProfileById(String uid) {
		String sql="delete  from login_auth_tbl where sno=?";
		  int p=0;
		try {
			   p=jdbcTemplate.update(sql,new Object[]{uid});
		}catch (Exception e) {
		}
		return p>0 ? "success":"failed";
	}
	
	@Override
	@Cacheable(value="spring-cache")
	public List<UserProfileEntity> findUserProfiles() {
		System.out.println("_______________________________________________");
		System.out.println("_______________________________________________");
		System.out.println("_@)@)@)@(@((@findUserProfiles is called___________ ");
		System.out.println("_______________________________________________");
		System.out.println("_______________________________________________");
		 List<UserProfileEntity> userProfiles=null;
		String sql="select * from login_auth_tbl";
		try {
			  userProfiles=(List<UserProfileEntity>)jdbcTemplate.query(sql,new BeanPropertyRowMapper(UserProfileEntity.class));
		}catch (Exception e) {
		}
		return userProfiles;
	}

	@Override
	public UserProfileEntity findRoleByUsername(String username) {
		UserProfileEntity userProfileEntity=null;
		String sql="select * from login_auth_tbl where username=?";
		Object data[]=new Object[]{username};
		try {
			userProfileEntity=(UserProfileEntity)jdbcTemplate.queryForObject(sql, data,new BeanPropertyRowMapper(UserProfileEntity.class));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userProfileEntity;
	}

}
