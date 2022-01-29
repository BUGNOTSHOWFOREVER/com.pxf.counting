package com.pxf.counting.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pxf.counting.dao.UserInfo;
import com.pxf.counting.service.UserloginService;
import com.pxf.counting.utill.DBUtils;
import com.pxf.counting.utill.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @className: UserloginServiceImp
 * @author: pangxiaofu
 * @description: TODO
 * @date: 2022/1/27 11:24
 * @version: 1.0
 */
@Service
@Slf4j
public class UserloginServiceImp {
    /**
     * 查询用户信息
     * @param userInfo
     * @return
     */
    public Result selectUserInfo(UserInfo userInfo){
        Result result =  new Result();
        SqlSession sqlSession = DBUtils.getSession();
        try {

            PageHelper.startPage(userInfo.getPage(), userInfo.getSize());
            UserloginService bankAccountDao = sqlSession.getMapper(UserloginService.class);
            List<UserInfo> listUserInfo = bankAccountDao.selectUserInfo(userInfo);
            PageInfo<UserInfo> pageInfo = new PageInfo(listUserInfo, 5);
            log.info("自定义查询事项总数：" + pageInfo.getTotal());
            result.setResults(listUserInfo);
            result.setTotalcount((int)pageInfo.getTotal());
            result.setMassage("事项查询成功");
        } catch (Exception e) {
            result.setMassage("事项查询失败");
            log.error("User数据查询失败" + e.getMessage() );
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    /**
     * 查询用户信息
     * @param userInfo
     * @return
     */
    public Result insertUserInfo(UserInfo userInfo){
        Result result =  new Result();
        SqlSession sqlSession = DBUtils.getSession();
        try {
            UserloginService bankAccountDao = sqlSession.getMapper(UserloginService.class);
            int acount = bankAccountDao.insertUserInfo(userInfo);
            result.setTotalcount(acount);
            result.setMassage("事项新增成功");
            sqlSession.commit();
        } catch (Exception e) {
            result.setMassage("事项新增失败");
            log.error("UserIn新增失败" + e.getMessage() );
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return result;
    }


    /**
     * 查询用户信息
     * @param userInfo
     * @return
     */
    public Result udpdateUserInfo(UserInfo userInfo){
        Result result =  new Result();
        SqlSession sqlSession = DBUtils.getSession();
        try {
            if(sqlSession == null){
                throw new Exception("获取数据库sqlSession失败");
            }
            UserloginService bankAccountDao = sqlSession.getMapper(UserloginService.class);
            if(StringUtils.isBlank(userInfo.getId())){
                result.setMassage("修改失败id不能为空");
                throw new Exception("修改失败id不能为空");
            }
            int acount = bankAccountDao.udpdateUserInfo(userInfo);
            if(acount == 0){
                result.setMassage("修改失败id不能为空");
                throw new Exception("修改失败id不能为空");
            }
            result.setTotalcount(acount);
            result.setMassage("user_info修改成功");
            sqlSession.commit();
        } catch (Exception e) {
            result.setMassage("user_info修改失败");
            log.error("user_info修改失败" + e.getMessage() );
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return result;
    }



    /**
     * 查询用户信息
     * @param userInfo
     * @return
     */
    public Result deleteUserInfo(UserInfo userInfo){
        Result result =  new Result();
        SqlSession sqlSession = DBUtils.getSession();
        try {
            if(sqlSession == null){
                throw new Exception("获取数据库sqlSession失败");
            }
            UserloginService bankAccountDao = sqlSession.getMapper(UserloginService.class);
            if(StringUtils.isBlank(userInfo.getId())){
                result.setMassage("删除失败id不能为空");
                throw new Exception("删除失败id不能为空");
            }
            int acount = bankAccountDao.deleteUserInfo(userInfo);
            if(acount == 0){
                result.setMassage("删除失败没有匹配的id");
                throw new Exception("删除失败没有匹配的id");
            }
            result.setTotalcount(acount);
            result.setMassage("user_info删除成功");
            sqlSession.commit();
        } catch (Exception e) {
            result.setMassage("user_info 删除失败");
            log.error("user_info删除失败" + e.getMessage() );
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return result;
    }
}
