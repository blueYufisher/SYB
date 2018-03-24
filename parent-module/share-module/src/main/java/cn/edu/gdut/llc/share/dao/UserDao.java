/**
 * 
 */
package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.LoginRecord;
import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.mybatis.model.Weixin;
import cn.edu.gdut.llc.mybatis.model.self.SelfUser;
import cn.edu.gdut.llc.share.mesaage.UserParam;

import java.util.List;

/**
 * 登录信息持久层
 * @author cpt725
 *
 */
public interface UserDao {

	/**
	 * 根据用户名获取登录信息
	 * @param username 用户名
	 * @return
	 */
	User getUserByUsername(String username);

	/**
	 * 根据编号更新登录信息
	 * @param user
	 * @return
	 */
	User updateById(User user);

	/**
	 * 根据登录账号（手机、邮箱或登录名）获取登录信息
	 * @param account 手机、邮箱或登录名
	 * @return
	 */
	User getUserByAccount(String account);

	/**
	 * 添加登录记录
	 * @param loginRecord
	 */
	LoginRecord insertLoginRecord(LoginRecord loginRecord);

	/**
	 * 根据用户名获取登录记录
	 * @param username 用户名
	 * @return
	 */
	List<LoginRecord> getLoginRecordByUsername(String username);

	/**
	 * 根据微信openid获取微信资料
	 * @param openid
	 * @return
	 */
	Weixin getWeixinByWeixinOpenid(String openid);

	/**
	 * 插入新登录信息
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);

	/**
	 * 插入微信用户信息
	 * @param weixin
	 * @return
	 */
	Weixin insertWeixin(Weixin weixin);

	/**
	 * 更新微信用户信息
	 * @param weixin
	 * @return
	 */
	Weixin updateWeixin(Weixin weixin);

	List<User> getUsersByKeywords(String keywords);

	int deleteRoleByUserId(Integer userId);

	int addRolesForUser(UserParam<User> msg);

	SelfUser getUserById(Integer userId);

	int deleteUser(Integer userId);

	List<User> getAllUser(Integer userId);

}
