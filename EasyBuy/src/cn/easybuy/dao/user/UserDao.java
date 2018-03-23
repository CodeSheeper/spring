package cn.easybuy.dao.user;

import java.sql.SQLException;
import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.User;
import cn.easybuy.param.UserParam;

/***
 * UserDao 用户业务的dao层
 * 从父类继承下的被使用的方法
 * User getById(userId);
 * Integer userDao.getRowCount(params);
 * List<User> userDao.getRowList(params);
 */
public interface UserDao extends IBaseDao {

	User findByLoginName(String loginName) throws Exception;//根据ID查询用户信息

	int save(User user) throws Exception;//新增用户信息

	void update(User user) throws Exception;//更新用户信息

	public void deleteById(String id) throws Exception;
	
	public List<User> queryUserList(UserParam params)throws Exception;
	
	public Integer queryUserCount(UserParam params) throws Exception;
	
	public User queryUserById(Integer id) throws Exception;
}
