package cn.easybuy.service.user;
import cn.easybuy.entity.User;
import cn.easybuy.param.UserParam;
import cn.easybuy.utils.Params;

import java.util.List;

public interface UserService {

	public void update(User user);//更新用户信息

	public User findByLoginName(String loginName);//根据ID查询用户信息

	public boolean save(User user);//新增用户信息
	
	void delete(String id);//根据用户名删除用户

	public List<User> queryUserList(UserParam userParam);

	public int queryUserCount(UserParam params);

	public User queryUserById(Integer userId);
}
