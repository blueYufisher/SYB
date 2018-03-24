/**
 * 
 */
package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.Login;
import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.mybatis.model.LoginRecord;
import cn.edu.gdut.llc.mybatis.model.self.SelfUser;
import cn.edu.gdut.llc.share.mesaage.UserParam;

import java.security.Principal;
import java.util.List;

/**
 * 登录信息服务接口
 * @author cpt725
 *
 */
public interface UserService {
	/**
	 * 根据用户名获取登录信息
	 * @param username 用户名
	 * @return
	 */
	public User getUserByUsername(String username);

	/**
	 * 根据编号更新登录信息
	 * @param info
	 */
	public boolean updateUser(User user);

	/**
	 * 根据登录账号（手机、邮箱或登录名）获取登录信息
	 * @param account 手机、邮箱或登录名
	 * @return
	 */
	public User getUserByAccount(String account);

	/**
	 * 添加登录记录
	 * @param loginRecord
	 * @return
	 */
	public boolean insertLoginRecord(LoginRecord loginRecord);

	/**
	 * 根据编用户名获取登录记录
	 * @param username 用户名
	 * @return
	 */
	public List<LoginRecord> getLoginRecordByUsername(String username);

	/**
	 * 根据微信code获取登录信息
	 * @param code 微信登陆连接包含的参数code
	 * @return
	 * @throws Exception 
	 */
	public User getUserByWeixin(String code) throws Exception;

	/**
	 * 获取当前的登录账户的信息
	 * @return
	 */
	public User getCurrentUser(Principal principal);

	boolean insertUser(User user);

	List<User> getUsersByKeywords(String keywords);

	int updateUserRoles(UserParam<User> msg);

	SelfUser getUserById(Integer userId);

	int deleteUser(Integer userId);

	List<User> getAllUser();

	List<User> getAllUserExceptAdmin(Principal principal);
	
}
